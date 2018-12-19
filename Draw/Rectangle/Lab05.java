// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-1-10
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program creates a recrtangle that is 980 by 630.
// Then it displays lines in all four of the rectangle's corners.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// width --> represents the width of the rectangle
// height --> represents the height of the rectangle
// x --> represents the changing x coordinate of the lines
// y --> represents the changing y coordinate of the lines
// ***********************************************
/**
 * @(#)Lab05.java
 *
 *
 * @author 
 * @version 1.00 2010/9/29
 */

import java.awt.*;
import java.applet.*;


public class Lab05 extends Applet
{
	public void paint(Graphics g)
	{
		int width = 980;
		int height = 630;
		g.drawRect(10,10,width,height);
		
		int x = width;
		int y = 0;
			
		for (y = 10; y<= 630; y += 10)
		{
			x = x-15;
			g.drawLine(x,640,990,y);
		}
		
		x = 0;
		for (y = 10; y<= 630; y += 10)
		{
			x = x+15;
			g.drawLine(x,640,10,y);
		}
		
		x = width;
		for (y = 10; y<= 630; y += 10)
		{
			x = x-15;
			g.drawLine(x,10,10,y);
		}
		
		x = 0;
		for (y = 10; y<= 630; y += 10)
		{
			x = x+15;
			g.drawLine(x,10,990,y);
		}
	
	}
}
