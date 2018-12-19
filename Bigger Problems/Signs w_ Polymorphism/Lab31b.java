// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program makes draws 4 trafic signs using polymorphism
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 110-ish Version
// Lab31.java

import java.awt.*;
import java.applet.*;


public class Lab31b extends Applet
{
	public void paint(Graphics g)
	{
		StopSign stop1        = new StopSign(g,100,100,100,300);
		StopSign stop2        = new StopSign(g,100,225,400,300);
		OldYieldSign yield1   = new OldYieldSign(g,125,350, 75,325);
		OldYieldSign yield2   = new OldYieldSign(g,125,475,475,275);
		NoParkingSign noPark1 = new NoParkingSign(g,100,600,100,300);  // 100 & 110 Point Version Only
		NoParkingSign noPark2 = new NoParkingSign(g,100,725,400,300);  // 100 & 110 Point Version Only
		RRCrossingSign rrx1   = new RRCrossingSign(g,100,850,100,300); // 110 Point Version Only
		RRCrossingSign rrx2   = new RRCrossingSign(g,100,900,550,200); // 110 Point Version Only

		drawTrafficSign(stop1);
		drawTrafficSign(stop2);
		drawTrafficSign(yield1);
		drawTrafficSign(yield2);
		drawTrafficSign(noPark1);   // 100 & 110 Point Version Only
		drawTrafficSign(noPark2);   // 100 & 110 Point Version Only
		drawTrafficSign(rrx1);      // 110 Point Version Only
		drawTrafficSign(rrx2);		 // 110 Point Version Only
	}

	public void drawTrafficSign(Sign type)
	{
		type.drawPole();
		type.drawShape();
		type.drawText();
	}
}



class RegPolygon
{
	public RegPolygon(Graphics g, int radius, int centerX, int centerY, int sides, Color fillColor, double offset)
	{
		double twoPI  = 2 * Math.PI;
		int xCoord[]  = new int[sides];
		int yCoord[]  = new int[sides];

		g.setColor(fillColor);
		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides - offset) * radius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides - offset) * radius) + centerY;
		}
		g.fillPolygon(xCoord,yCoord,sides);
	}
}






abstract interface Sign
{
	abstract public void drawShape();

	abstract public void drawPole();

	abstract public void drawText();
}



abstract class TrafficSign implements Sign
{
	protected Graphics g;
	protected int centerX, centerY;
	protected int height;

	public TrafficSign(Graphics g1, int x, int y, int h)
	{
		g = g1;
		centerX = x;
		centerY = y;
		height = h;
	}

	public void drawPole()
	{
		g.setColor(Color.black);
		g.fillRect(centerX-7,centerY,15,height);
	}

	abstract public void drawShape();

	abstract public void drawText();
}



class StopSign extends TrafficSign
{
	protected Graphics g;
	protected int centerX, centerY;
	protected int radius;

	public StopSign(Graphics g1, int r, int x, int y, int height)
	{
		super(g1, x, y, height);
		g = g1;
		centerX = x;
		centerY = y;
		radius = r;
	}

	public void drawShape()
	{
		RegPolygon rp = new RegPolygon(g,radius,centerX,centerY, 8, Color.red, Math.PI/8);
	}

	public void drawText()
	{
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.drawString("STOP",centerX-(5*radius/8), centerY+20);
	}
}

class OldYieldSign extends TrafficSign
{
	protected Graphics g;
	protected int centerX, centerY;
	protected int radius;

	public OldYieldSign(Graphics g1, int r, int x, int y, int height)
	{
		super(g1, x, y, height);
		g = g1;
		centerX = x;
		centerY = y;
		radius = r;
	}

	public void drawShape()
	{
		RegPolygon rp = new RegPolygon(g,radius,centerX,centerY, 3, Color.yellow, Math.PI/6);
	}

	public void drawText()
	{
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,40));
		g.drawString("YIELD",centerX-(11*radius/24), centerY);
	}
}

class NoParkingSign extends TrafficSign
{
	protected Graphics g;
	protected int centerX, centerY;
	protected int radius;

	public NoParkingSign(Graphics g1, int r, int x, int y, int height)
	{
		super(g1, x, y, height);
		g = g1;
		centerX = x;
		centerY = y;
		radius = r;
	}

	public void drawShape()
	{
		RegPolygon rp = new RegPolygon(g,radius,centerX,centerY, 360, Color.red, Math.PI/360);
		RegPolygon inside = new RegPolygon(g,radius-30,centerX,centerY, 360, Color.white, Math.PI/360);
	}

	public void drawText()
	{
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.PLAIN,140));
		g.drawString("P",centerX-(9*radius/24), centerY+50);
		g.setColor(Color.red);
		Polygon rec = new Polygon();
		rec.addPoint((int)(centerX+radius*Math.cos(Math.PI*5/6)),(int)(centerY+radius*Math.sin(Math.PI*5/6)));
		rec.addPoint((int)(centerX+radius*Math.cos(Math.PI*3/4)),(int)(centerY+radius*Math.sin(Math.PI*3/4)));
		rec.addPoint((int)(centerX+radius*Math.cos(-Math.PI/6)),(int)(centerY+radius*Math.sin(-Math.PI/6)));
		rec.addPoint((int)(centerX+radius*Math.cos(-Math.PI/4)),(int)(centerY+radius*Math.sin(-Math.PI/4)));
		g.fillPolygon(rec);
	}
}

class RRCrossingSign extends TrafficSign
{
	protected Graphics g;
	protected int centerX, centerY;
	protected int radius;

	public RRCrossingSign(Graphics g1, int r, int x, int y, int height)
	{
		super(g1, x, y, height);
		g = g1;
		centerX = x;
		centerY = y;
		radius = r;
	}

	public void drawShape()
	{
		Polygon rec = new Polygon();
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(Math.PI*19/24)),(int)(centerY+radius*Math.sin(Math.PI*19/24)));
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(Math.PI*17/24)+1),(int)Math.round(centerY+radius*Math.sin(Math.PI*17/24)));
		rec.addPoint((int) Math.round(centerX+(radius*23/120)*Math.cos(Math.PI/2)),(int)Math.round(centerY+(radius*23/120)*Math.sin(Math.PI/2)));
		rec.addPoint((int) (centerX+radius*Math.cos(Math.PI*7/24)),(int)(centerY+radius*Math.sin(Math.PI*7/24)));
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(Math.PI*5/24)),(int)(centerY+radius*Math.sin(Math.PI*5/24)));
		rec.addPoint((int) Math.round(centerX+(radius*23/120)*Math.cos(0)),(int)Math.round(centerY+(radius*23/120)*Math.sin(0)));
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(-Math.PI*5/24)+1),(int)Math.round(centerY+radius*Math.sin(-Math.PI*5/24)));
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(-Math.PI*7/24)),(int)(centerY+radius*Math.sin(-Math.PI*7/24)));
		rec.addPoint((int) Math.round(centerX+(radius*23/120)*Math.cos(-Math.PI/2)),(int)Math.round(centerY+(radius*23/120)*Math.sin(-Math.PI/2)));
		rec.addPoint((int) Math.round(centerX+radius*Math.cos(-Math.PI*17/24)),(int)(centerY+radius*Math.sin(-Math.PI*17/24)));
		rec.addPoint((int) (centerX+radius*Math.cos(-Math.PI*19/24)),(int)(centerY+radius*Math.sin(-Math.PI*19/24)));
		rec.addPoint((int) Math.round(centerX+(radius*23/120)*Math.cos(-Math.PI)),(int)Math.round(centerY+(radius*23/120)*Math.sin(-Math.PI)));
		g.setColor(Color.white);
		g.fillPolygon(rec);
		g.setColor(Color.black);
		g.drawPolygon(rec);
	}

	public void drawText()
	{
		int lgth = (int) Math.sqrt((((int) Math.round(centerX+radius*Math.cos(Math.PI*19/24)))-((int) Math.round(centerX+radius*Math.cos(-Math.PI*7/24))))
						 + (((int)(centerY+radius*Math.sin(Math.PI*19/24)))-(int)(centerY+radius*Math.sin(-Math.PI*7/24))));
		int space = (int)lgth/8;

		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.PLAIN,15));
				g.drawString("A",centerX, centerY);
		g.drawString("R",((int) Math.round(centerX+radius*Math.cos(Math.PI*19/24)))/*+space*/, ((int) Math.round(centerX+radius*Math.cos(-Math.PI*7/24))))/*-space*/;
		/*g.drawString("A",centerX, centerY);
		g.drawString("I",centerX, centerY);
		g.drawString("L",centerX, centerY);
		g.drawString("R",centerX, centerY);
		g.drawString("O",centerX, centerY);
		g.drawString("A",centerX, centerY);
		g.drawString("D",centerX, centerY);

		g.drawString("C",centerX, centerY);
		g.drawString("R",centerX, centerY);
		g.drawString("O",centerX, centerY);
		g.drawString("S",centerX, centerY);
		g.drawString("S",centerX, centerY);
		g.drawString("I",centerX, centerY);
		g.drawString("N",centerX, centerY);
		g.drawString("G",centerX, centerY);*/
	}
}