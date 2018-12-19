// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 11-28-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program draws 1000 circles bouncing around at random angles
// inside a window
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// g --> represents the graphics object that draws the graphics
// shape --> represents the circle object
// c, k --> represents a counter variable
// ranInc, ranBoo --> represents the random objects that create random values
// topleftX --> represents the X coordinate of the top left corner of the box
// around the circle
//	topleftY --> represents the Y coordinate of the top left corner of the box
// around the circle
//	incX --> represents the amount to incriment the X value by
//	incY --> represents the amount to incriment the Y value by
//	addX --> represents whwether to add or subtract the incriment from the X value
//	addY --> represents whwether to add or subtract the incriment from the Y value
//	diameter --> represents the diameter of each circle
//	timeDelay --> represents the length of the delay between drawing each circle
// ***********************************************
// Lab24b.java
// 100 Version

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class Lab24b
{

	public static void main(String args[])
	{
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter width: ");
		int width = scanner.nextInt ();
		System.out.print("Enter height: ");
		int height = scanner.nextInt ();
		GfxApp gfx = new GfxApp();
		gfx.setSize(width,height);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}

}



class GfxApp extends Frame
{
	public void paint(Graphics g)
	{
		int h = this.getHeight();
		int w = this.getWidth();
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter diameter: ");
		int d = scanner.nextInt ();
		g.setColor(Color.blue);
		Circle shape = new Circle(d,5,5,10000,g, h, w);
		if (shape.fit())
		{
			for (int c = 1;c<=1000;c++)
			{
				shape.drawCircle(g);
				shape.hitEdge();
			}
		}
	}
}



class Circle
{
	int topleftX;
	int topleftY;
	int incX;
	int incY;
	boolean addX = true;
	boolean addY = true;
	int diameter;
	int timeDelay;
	int winH;
	int winW;

	public Circle(int d,int iX,int iY,int delay,Graphics g, int h, int w)
	{
		diameter = d;
		incX = iX;
		incY = iY;
		timeDelay = delay;
		winH = h;
		winW = w;
		topleftX = (int)((w/2)-(diameter/2));
		topleftY = (int)((h/2)-(diameter/2));
	}

	private void delay(double n)
  	{
  		for (double k = 1; k < n; k+=0.001);
   }

   private void setTLX()
   {
   	if (addX)
			topleftX += incX;
		else
			topleftX -=incX;
   }

   private void setTLY()
   {
   	if (addY)
			topleftY += incY;
		else
			topleftY -=incY;
   }

   public void drawCircle(Graphics g)
   {
   	g.drawOval(topleftX,topleftY,diameter,diameter);
   	delay(timeDelay);
   }

   private void newData()
   {
		Random ranInc = new Random();
      incX = ranInc.nextInt(7)+5;
      incY = ranInc.nextInt(7)+5;
   }

   public void hitEdge()
   {
   	Random ranBoo = new Random();
   	if (topleftX >= (winW-(diameter+15)))
   	{
   		addX = false;
   		addY = ranBoo.nextBoolean();
   		newData();
   	}
   	else if (topleftX <= 20)
   	{
   		addX = true;
   		addY = ranBoo.nextBoolean();
   		newData();
   	}
   	else if (topleftY >= (winH-(diameter+15)))
   	{
   		addY = false;
   		addX = ranBoo.nextBoolean();
   		newData();
   	}
   	else if (topleftY <= 35)
   	{
   		addY = true;
   		addX = ranBoo.nextBoolean();
   		newData();
   	}
   	setTLX();
   	setTLY();
   }
   public boolean fit()
   {
		boolean temp = true;
		if ((winH < (3*diameter)) || (winW < (3*diameter)))
			temp = false;
		return temp;
   }
}