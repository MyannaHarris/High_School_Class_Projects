// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 4-16-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program makes a screen saver of bouncing blue balls.
// It gets the number of balls shown on the screen at a time
// and the diameter of the balls from the user.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab30.java

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.JOptionPane;


public class Lab30
{
	public static void main(String args[])
	{
		int circleCount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of circles for the screen saver."));//user enters number of circles to be shown at a time
		int circleSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the diameter of the circle.")); //user enters diameter of circles
		GfxApp gfx = new GfxApp(circleCount,circleSize);
		gfx.setSize(800,600);
		gfx.addWindowListener(new WindowAdapter() {public void
			windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}


class GfxApp extends Frame
{

	private int circleCount, circleSize;

	public GfxApp(int circleC,int circleS)
	{
		circleCount = circleC; //user given number of circles
		circleSize  = circleS; //user giver diameter of circles
	}


	class Coord
	{
		private int xPos;
		private int yPos;

		public Coord(int x, int y)
		{
			xPos = x;
			yPos = y;
		}
	}

	public void paint(Graphics g)
	{
		int incX = 5;
		int incY = 5;
		int diameter = circleSize;
		int timeDelay = 10;
		MyQueue circles = new MyQueue(); //queue to hold the top-left corner coordinates of the old circles
		Circle c = new Circle(g,diameter,incX,incY,timeDelay);
		circles.add(new Coord(c.getTLX(),c.getTLY())); //anonymous object to save old circles

		for (int k = 1; k <= 2000; k++)
		{
			c.drawCircle(g);
			circles.add(new Coord(c.getTLX(),c.getTLY())); //anonymous object to save old circles
			c.hitEdge();
			if (k >= circleCount)
			{
				Coord temp = (Coord)circles.remove(); //temp object to hold old circle to be erased
				c.eraseCircle(g,temp.xPos,temp.yPos);
			}
		}
	}
}



class Circle
{
	private int tlX;		// top-left X coordinate
	private int tlY;		// top-left Y coordinate
	private int incX;		// increment movement of X coordinate
	private int incY;		// increment movement of Y coordinate
	private boolean addX;	// flag to determine add/subtract of increment for X
	private boolean addY;	// flag to determine add/subtract of increment for Y
	private int size;		// diameter of the circle
	private int timeDelay;	// time delay until next circle is drawn

	public Circle(Graphics g, int s, int x, int y, int td)
	{
		incX = x;
		incY = y;
		size = s;
		addX = true;
		addY = false;
		tlX = 400;
		tlY = 300;
		timeDelay = td;
	}

	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}

	public void drawCircle(Graphics g)
	{
		Random rand = new Random();
		float R = rand.nextFloat();
		float G = rand.nextFloat();
		float B = rand.nextFloat();
		g.setColor(new Color(R, G, B));
		g.drawOval(tlX,tlY,size,size);
		delay(timeDelay);
		if (addX)
			tlX+=incX;
		else
			tlX-=incX;
		if (addY)
			tlY+=incY;
		else
			tlY-=incY;
	}


	public void newData()
	{
		incX = (int) Math.round(Math.random() * 7 + 5);
		incY = (int) Math.round(Math.random() * 7 + 5);
	}

	public void hitEdge()
	{
		boolean flag = false;
		if (tlX < incX)
		{
			addX = true;
			flag = true;
		}
		if (tlX > 800 - (size + incX))
		{
			addX = false;
			flag = true;
		}
		if (tlY < incY + 30)  // The +30 is due to the fact that the title bar covers the top 30 pixels of the window
		{
			addY = true;
			flag = true;
		}
		if (tlY > 600 - (size + incY))
		{
			addY = false;
			flag = true;
		}
		if (flag)
			newData();
	}

	public void eraseCircle(Graphics g, int x, int y)
	// erases the circle, which is drawn with top-left coordinate at (x,y)
	{
		g.setColor(Color.white);
		g.drawOval(x,y,size,size);
	}

	public int getTLX()
	// returns the value of the top-left corner X-value of the current circle drawn
	{
		return tlX;
	}

	public int getTLY()
	// returns the value of the top-left corner Y-value of the current circle drawn
	{
		return tlY;
	}
}

class MyQueue<E>
{
	private ArrayList<E> data;		// stores queue data
	private int front;					// keeps index of the queue front

	public MyQueue()
	// Initializes an empty queue object.
	{
		data = new ArrayList<E>();
		front = 0;
	}

	public boolean isEmpty()
	// Returns true if data is empty, false otherwise
	{
		return data.size() == 0;
	}

	public void add(E x)
	// Adds variable x to the back of the queue
	{
		data.add(x);
	}

	public E remove()
	// Returns and removes the front element from the queue
	{
		return data.remove(front);
	}

	public E peek()
	// Returns the front element from the queue without removal
	{
		return data.get(front);
	}
}