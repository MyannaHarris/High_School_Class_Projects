// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 11-15-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program draws six polygons from the top left corner to the
// bottom right corner. It draws a triangle then on until it draws
// an octagon.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// g --> represents the graphics object that draws the graphics
// s,d --> counter variables
// shape --> represents the RegPoly object
// centerX, centX --> represents x coordinate of center point of polygon
// centerY, centY --> represents y coordinate of center point of polygon
// radius, r --> represents the radius of the polygon
// points, p --> represents the number of points that the polygon has
// Xcoordinates --> represents the x coordinates of the points of the polygons
// Ycoordinates --> represents the y coordinates of the points of the polygons
// penta--> represents the Polygon object that draws the polygons
// t --> represents the number of radians for each certain point
// radianChange --> represents number of radians between the points on
// a unit circle
// ***********************************************
// Lab24.java
// 100 Version

import java.awt.*;
import java.awt.event.*;


public class Lab24
{
	public static void main(String args[])
	{
		GfxApp gfx = new GfxApp();
		gfx.setSize(900,700);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}


class GfxApp extends Frame
{
	public void paint(Graphics g)
	{
		for (int s=3, d=1; s<=8; s++, d++)
		{
			RegPoly shape = new RegPoly(125*d,100*d,60,s, g);
		}
	}
}

class RegPoly
{
	private int centerX;
	private int centerY;
	private int radius;
	private int points;
	private int Xcoordinates;
	private int Ycoordinates;

	public RegPoly(int centx,int centy,int r, int p, Graphics g)
	{
		centerX = centx;
		centerY = centy;
		radius = r;
		points = p;
		drawPoly(g);
	}

	public void drawPoly(Graphics g)
	{
		Polygon penta = new Polygon();
		g.setColor(Color.blue);

		double radianChange = (double)(Math.toRadians(360/(points)));
		double t = 0;

		for (int count=1; count<=points; count++)
		{
			if (t>=0 && t<=90)
			{
				Xcoordinates = (int)(centerX - (radius*Math.cos(t)));
				Ycoordinates = (int)(centerY - (radius*Math.sin(t)));
				penta.addPoint(Xcoordinates,Ycoordinates);
			}
			else if (t>90 && t<=180)
			{
				Xcoordinates = (int)(centerX + (radius*Math.cos(t)));
				Ycoordinates = (int)(centerY - (radius*Math.sin(t)));
				penta.addPoint(Xcoordinates,Ycoordinates);
			}
			else if (t>180 && t<=270)
			{
				Xcoordinates = (int)(centerX + (radius*Math.cos(t)));
				Ycoordinates = (int)(centerY + (radius*Math.sin(t)));
				penta.addPoint(Xcoordinates,Ycoordinates);
			}
			else if (t>270 && t<=360)
			{
				Xcoordinates = (int)(centerX - (radius*Math.cos(t)));
				Ycoordinates = (int)(centerY + (radius*Math.sin(t)));
				penta.addPoint(Xcoordinates,Ycoordinates);
			}
			t = count*radianChange;
		}
		g.fillPolygon(penta);
	}
}