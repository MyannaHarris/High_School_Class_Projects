// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-14-10
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// this program draws a grid of two rows by two columns. Then
// it randomly draws 100 randomly colored lines in the top-right cell,
// 100 randomly colored 50x50 squares in the top-left cell, and 100
// randomly colored randomly sized circles in the bottom right cell.
// It also draws a 3D cube in the bottom left cell with sides of yellow,
// blue, green, and red. Nothing leaves the cells' boundaries.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// k --> represents the counter in the for loops
// x1 --> represents the beginning x coordinate of the lines
// y1 --> represents the beginning y coordinate of the lines
// x2 --> represents the ending x coordinate of the lines
// y2 --> represents the ending y coordinate of the lines
// red --> represents the random shade of red in the new random color
// green --> represents the random shade of green in the new random color
// blue --> represents the random shade of blue in the new random color
// x --> represents the x coordinate of the top left corner of the squares and circles
// y --> represents the y coordinate of the top left corner of the squares and circles
// size --> represents the random sizes of the circles
// penta --> the object of the polygon class created to draw the polygons of the 3D cube
// ***********************************************
// Lab06st.java
// 110 Version

import java.awt.*;
import java.applet.*;
import java.util.*; 

public class Lab06st extends Applet
{
	public void paint(Graphics g) 	
	{
		g.drawRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);
		
		int k, x, y, red, green, blue;
		
		Random rnd = new Random(1234);

		for (k = 1; k <= 100; k++)
		{
			int x1 = rnd.nextInt(390) + 400;
			int y1 = rnd.nextInt(290) + 10;
			int x2 = rnd.nextInt(390) + 400;
			int y2 = rnd.nextInt(290) + 10;
			red = rnd.nextInt(256);
			green = rnd.nextInt(256);
			blue = rnd.nextInt(256);
			g.setColor(new Color(red,green,blue));
			g.drawLine(x1,y1,x2,y2);
		}		

		for (k = 1; k <= 100; k++)
		{
			x = rnd.nextInt(340) + 10;
			y = rnd.nextInt(240) + 10;
			red = rnd.nextInt(256);
			green = rnd.nextInt(256);
			blue = rnd.nextInt(256);
			g.setColor(new Color(red,green,blue));
			g.fillRect(x,y,50,50);
		}

		for (k = 1; k <= 100; k++)
		{
			int size = rnd.nextInt(200);
			x = rnd.nextInt(390-size) + 400;
			y = rnd.nextInt(290-size) + 300;
			red = rnd.nextInt(256);
			green = rnd.nextInt(256);
			blue = rnd.nextInt(256);
			g.setColor(new Color(red,green,blue));
			g.drawOval(x,y,size,size);
		}
		
		Polygon penta = new Polygon();
		penta.addPoint(140,340);
		penta.addPoint(270,340);
		penta.addPoint(270,380);
		penta.addPoint(205,380);
		g.setColor(Color.yellow);
		g.fillPolygon(penta);

		penta = new Polygon();
		penta.addPoint(270,340);
		penta.addPoint(335,380);
		penta.addPoint(270,380);
		g.setColor(Color.blue);
		g.fillPolygon(penta);

		penta = new Polygon();
		penta.addPoint(140,340);
		penta.addPoint(205,380);
		penta.addPoint(205,510);
		penta.addPoint(140,470);
		g.setColor(Color.green);
		g.fillPolygon(penta);

		penta = new Polygon();
		penta.addPoint(205,380);
		penta.addPoint(335,380);
		penta.addPoint(335,510);
		penta.addPoint(205,510);
		g.setColor(Color.red);
		g.fillPolygon(penta);

	}
}