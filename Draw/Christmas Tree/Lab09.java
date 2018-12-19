// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 11-30-10
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// this program uses inheritance and composition to make a christmas tree
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// h --> represents the height of the entire tree
// height --> represents a certain section of the entire tree's height
// tri --> represents a copy of the Polygon class to make the tree sections
// size --> represents the size of the christmas decorations
// star --> represents a copy of the Polygon class to make a star
// p --> represents a copy of the presents class to make the presents
// d --> represents a copy of the decorations class to make the decorations
// ***********************************************
// Lab09.java
// 100 Version

import java.awt.*;
import java.applet.*;
import java.util.Random;

public class Lab09 extends Applet{

    public void paint(Graphics g)
   	{
   		int h = 100;
   		ChristmasTree t = new ChristmasTree(g, h);
   		
    }
    
    
}

class Tree
{
	public Tree(Graphics g, int h)
	{
		int height = h/4;
		
		g.setColor(new Color(96,57,19));
		g.fillRect(490,390,10,height);
		
		g.setColor(Color.green);
		Polygon tri = new Polygon();
		tri.addPoint(520,390);
		tri.addPoint(470,390);
		tri.addPoint(480,390-height);
		tri.addPoint(510,390-height);
		g.fillPolygon(tri);
		
		tri = new Polygon();
		tri.addPoint(515,390-height);
		tri.addPoint(475,390-height);
		tri.addPoint(485,390-2*height);
		tri.addPoint(505,390-2*height);
		g.fillPolygon(tri);
		
		tri = new Polygon();
		tri.addPoint(480,390-2*height);
		tri.addPoint(510,390-2*height);
		tri.addPoint(495,390-3*height);
		g.fillPolygon(tri);
	}
}

class presents
{
	public presents(Graphics g, int h)
	{
		int height = h/4;
		g.setColor(Color.red);
		g.fillRect(470,400,20,height);
		g.setColor(Color.yellow);
		g.fillRect(478,400,5,height);
		g.fillRect(476,395,7,5);
		
		g.setColor(Color.blue);
		g.fillRect(500,405,20,height);
		g.setColor(Color.pink);
		g.fillRect(508,405,5,height);
		g.fillRect(506,400,7,5);
		
		g.setColor(Color.green);
		g.fillRect(485,410,25,height);
		g.setColor(Color.orange);
		g.fillRect(495,410,5,height);
		g.fillRect(493,405,7,5);
	}
}

class decorations
{
	public decorations(Graphics g, int h)
	{
		int height = 3 * (h/4);
		
		g.setColor(Color.yellow);
		Polygon star = new Polygon();
		star.addPoint(495, 390 - height);
		star.addPoint(490,(390-height)+3);
		star.addPoint(492,(390-height)-2);
		star.addPoint(488,(390-height)-5);
		star.addPoint(493,(390-height)-5);
		star.addPoint(495,(390-height)-9);
		star.addPoint(497,(390-height)-5);
		star.addPoint(502,(390-height)-5);
		star.addPoint(498,(390-height)-2);
		star.addPoint(500,(390-height)+3);
		g.fillPolygon(star);
		
		int size = h/8;
		height = h/4;
		g.setColor(Color.red);
		g.fillOval(480,390-height+size,size,size);
		g.fillOval(490,390-height+size,size,size);
		g.fillOval(500,390-height+size,size,size);
		
		g.fillOval(485,390-(2*height)+size,size,size);
		g.fillOval(495,390-(2*height)+size,size,size);
		
		g.fillOval(490,390-(3*height)+size,size,size);
	}
}

class ChristmasTree extends Tree
{
	private presents p;
	private decorations d;
	
	public ChristmasTree(Graphics g, int h)
	{
		super(g, h);
		p = new presents(g, h);
		d = new decorations(g, h);
	}
}