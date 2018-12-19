// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-30-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program draws a square fractal using recursion
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 110-ish Version
// Lab32b.java

import java.awt.*;
import java.awt.event.*;


public class Lab32b
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

	public void paint (Graphics g)
	{
		drawSquare1(g,1024,768);
	}

	public void drawSquare1(Graphics g, int maxX, int maxY)
	{
		int x = (maxX/2)-(maxX/8);//top-left corner x-point of center box
		int y = (maxY/2)-(maxY/8);//top-left corner y-point of center box
		int length = maxX/4;//center box length is 1/4 the resolution of the window
		int width = maxY/4;//center box width is 1/4 the resolution of the window

			g.fillRect(x,y,length,width);
			//drawSquare2(g,x,y,x-length/2,y-width/2,length/2,width/2);//top left
			//drawSquare2(g,x,y,x+length,y-width/2,length/2,width/2);//top right
			//drawSquare2(g,x,y,x+length,y+width,length/2,width/2);//bottom right
			//drawSquare2(g,x,y,x-length/2,y+width,length/2,width/2);//bottom left

			// Create and start the thread1
			Thread thread1 = new BasicThread1(g, x, y, length, width);
			thread1.start();

			// Create and start the thread2
			Thread thread2 = new BasicThread2(g, x, y, length, width);
			thread2.start();

			// Create and start the thread3
			Thread thread3 = new BasicThread3(g, x, y, length, width);
			thread3.start();

			// Create and start the thread4
			Thread thread4 = new BasicThread4(g, x, y, length, width);
			thread4.start();
	}

	public void drawSquare2(Graphics g, int prevX, int prevY, int x, int y, int length, int width)
	{//graphics parameter, previous box's top-left x-point, previous box's top-left y-point,
	 //this box's top-left x-point, this box's top-left y-point, this box's length, this box's width
		//delay(200);
		g.fillRect(x,y,length,width);
		if (x<prevX && y<prevY)
		{
			drawSquare2(g,x,y,x-length/2,y-width/2,length/2,width/2);//top left
			drawSquare2(g,x,y,x+length,y-width/2,length/2,width/2);//top right
			drawSquare2(g,x,y,x-length/2,y+width,length/2,width/2);//bottom left
		}
		else if (x>prevX && y<prevY)
		{
			drawSquare2(g,x,y,x-length/2,y-width/2,length/2,width/2);//top left
			drawSquare2(g,x,y,x+length,y-width/2,length/2,width/2);//top right
			drawSquare2(g,x,y,x+length,y+width,length/2,width/2);//bottom right
		}
		else if (x>prevX && y>prevY)
		{
			drawSquare2(g,x,y,x+length,y-width/2,length/2,width/2);//top right
			drawSquare2(g,x,y,x+length,y+width,length/2,width/2);//bottom right
			drawSquare2(g,x,y,x-length/2,y+width,length/2,width/2);//bottom left
		}
		else if (x<prevX && y>prevY)
		{
			drawSquare2(g,x,y,x-length/2,y-width/2,length/2,width/2);//top left
			drawSquare2(g,x,y,x+length,y+width,length/2,width/2);//bottom right
			drawSquare2(g,x,y,x-length/2,y+width,length/2,width/2);//bottom left
		}
	}

	class BasicThread1 extends Thread
	{
		Graphics g;
		int x;
		int y;
		int length;
		int width;

		public BasicThread1(Graphics g1, int x1, int y1, int l, int w)
		{
			g = g1;
			x =x1;
			y =y1;
			length =l;
			width =w;
			System.out.println("derp");
		}
	   public void run()// This method is called when the thread runs
	   {
	   	drawSquare2(g,x,y,x-length/2,y-width/2,length/2,width/2);//top left
	   }
	}

	class BasicThread2 extends Thread
	{
		Graphics g;
		int x;
		int y;
		int length;
		int width;

		public BasicThread2(Graphics g1, int x1, int y1, int l, int w)
		{
			g = g1;
			x =x1;
			y =y1;
			length =l;
			width =w;
		}
	   public void run()// This method is called when the thread runs
	   {
	   	drawSquare2(g,x,y,x+length,y-width/2,length/2,width/2);//top right
	   }
	}

	class BasicThread3 extends Thread
	{
		Graphics g;
		int x;
		int y;
		int length;
		int width;

		public BasicThread3(Graphics g1, int x1, int y1, int l, int w)
		{
			g = g1;
			x =x1;
			y =y1;
			length =l;
			width =w;
		}
	   public void run()// This method is called when the thread runs
	   {
	   	drawSquare2(g,x,y,x+length,y+width,length/2,width/2);//bottom right
	   }
	}

	class BasicThread4 extends Thread
	{
		Graphics g;
		int x;
		int y;
		int length;
		int width;

		public BasicThread4(Graphics g1, int x1, int y1, int l, int w)
		{
			g = g1;
			x =x1;
			y =y1;
			length =l;
			width =w;
		}
	   public void run()// This method is called when the thread runs
	   {
	   	drawSquare2(g,x,y,x-length/2,y+width,length/2,width/2);//bottom left
	   }
	}

	private void delay(double n)
	{
		for (double k = 1; k < n; k+=0.001);
	}

}

