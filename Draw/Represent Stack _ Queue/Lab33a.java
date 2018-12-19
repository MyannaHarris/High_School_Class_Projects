// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 9-10-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program draws a graphic representation of a stack linked list and a queue linked list
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab33a.java

import java.awt.*;
import java.awt.event.*;


public class Lab33a
{
	public static void main(String args[])
	{
		GfxApp gfx = new GfxApp();
		gfx.setSize(1000,750);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}


class GfxApp extends Frame
{

	private int td = 1500;		// time delay to slow down graphics display

	public void paint (Graphics g)
	{
		g.setFont(new Font("ARIAL",Font.BOLD,28));
		g.drawString("LAB 33A 80/100 POINT VERSION",300,60);
		g.setFont(new Font("ARIAL",Font.BOLD,20));
		g.drawString("DRAWING A LINKED LIST AS A STACK",50,215);
		g.drawString("DRAWING A LINKED LIST AS A QUEUE",50,415);
		drawStack(g);
		drawQueue(g);
	}

	public void drawStack(Graphics g)
	{
		g.setFont(new Font("ARIAL",Font.BOLD,20));

		GfxNode node1 = new GfxNode(g,750,200,'P',0,td); //first node that will be on bottom of stack
		node1.enterData(g,'A',0);
		node1.drawNull(g,0);
		node1.drawPointer(g,'T',2,0);

		GfxNode node2 = new GfxNode(g,700,200,'P',0,td);
		node2.enterData(g,'B',0);
		node2.drawNull(g,0);
		node1.drawPointer(g,'P',1,9);
		node1.drawPointer(g,'T',2,9);
		node2.drawPointer(g,'T',2,0);

		node2.drawNull(g,9);
		node2.drawLink(g,node1,0);

		GfxNode node3 = new GfxNode(g,650,200,'P',0,td);
		node3.enterData(g,'C',0);
		node3.drawNull(g,0);
		node2.drawPointer(g,'P',1,9);
		node2.drawPointer(g,'T',2,9);
		node3.drawPointer(g,'T',2,0);

		node3.drawNull(g,9);
		node3.drawLink(g,node2,0);

		GfxNode node4 = new GfxNode(g,600,200,'P',0,td);
		node4.enterData(g,'D',0);
		node4.drawNull(g,0);
		node3.drawPointer(g,'P',1,9);
		node3.drawPointer(g,'T',2,9);
		node4.drawPointer(g,'T',2,0);

		node4.drawNull(g,9);
		node4.drawLink(g,node3,0);

		GfxNode node5 = new GfxNode(g,550,200,'P',0,td);
		node5.enterData(g,'E',0);
		node5.drawNull(g,0);
		node4.drawPointer(g,'P',1,9);
		node4.drawPointer(g,'T',2,9);
		node5.drawPointer(g,'T',2,0);

		node5.drawNull(g,9);
		node5.drawLink(g,node4,0);

		GfxNode node6 = new GfxNode(g,500,200,'P',0,td); //last node that will be on the top of the stack
		node6.enterData(g,'F',0);
		node6.drawNull(g,0);
		node5.drawPointer(g,'P',1,9);
		node5.drawPointer(g,'T',2,9);
		node6.drawPointer(g,'T',2,0);

		node6.drawNull(g,9);
		node6.drawLink(g,node5,0);

		node6.drawPointer(g,'T',2,9);
	}

	public void drawQueue(Graphics g)
	{
		g.setFont(new Font("ARIAL",Font.BOLD,20));

		GfxNode node1 = new GfxNode(g,500,400,'F',0,td); //first node that will be at the front of the stack
		node1.enterData(g,'A',0);
		node1.drawNull(g,0);
		node1.drawPointer(g,'T',2,0);

		GfxNode node2 = new GfxNode(g,550,400,'P',0,td);
		node2.enterData(g,'B',0);
		node2.drawNull(g,0);
		node1.drawPointer(g,'T',2,9);
		node2.drawPointer(g,'T',2,0);

		node1.drawNull(g,9);
		node1.drawLink(g,node2,0);

		GfxNode node3 = new GfxNode(g,600,400,'P',0,td);
		node3.enterData(g,'C',0);
		node3.drawNull(g,0);
		node2.drawPointer(g,'P',1,9);
		node2.drawPointer(g,'T',2,9);
		node3.drawPointer(g,'T',2,0);

		node2.drawNull(g,9);
		node2.drawLink(g,node3,0);

		GfxNode node4 = new GfxNode(g,650,400,'P',0,td);
		node4.enterData(g,'D',0);
		node4.drawNull(g,0);
		node3.drawPointer(g,'P',1,9);
		node3.drawPointer(g,'T',2,9);
		node4.drawPointer(g,'T',2,0);

		node3.drawNull(g,9);
		node3.drawLink(g,node4,0);

		GfxNode node5 = new GfxNode(g,700,400,'P',0,td);
		node5.enterData(g,'E',0);
		node5.drawNull(g,0);
		node4.drawPointer(g,'P',1,9);
		node4.drawPointer(g,'T',2,9);
		node5.drawPointer(g,'T',2,0);

		node4.drawNull(g,9);
		node4.drawLink(g,node5,0);

		GfxNode node6 = new GfxNode(g,750,400,'P',0,td); //last node that will be at the back of the stack
		node6.enterData(g,'F',0);
		node6.drawNull(g,0);
		node5.drawPointer(g,'P',1,9);
		node5.drawPointer(g,'T',2,9);
		node6.drawPointer(g,'T',2,0);

		node5.drawNull(g,9);
		node5.drawLink(g,node6,0);

		node6.drawPointer(g,'T',2,9);
	}

}