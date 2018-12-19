// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-1-10
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program creates a recrtangle that is 800 by 600.
// Then it displays 20 lines from each of the rectangle's
// corners to the opposite side.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// width --> represents the width of the rectangle
// height --> represents the height of the rectangle
// y --> represents the changing y coordinate of the lines
// ***********************************************
/**
 * @(#)Lab05G.java
 *
 *
 * @author 
 * @version 1.00 2010/10/1
 * 100 version
 */


import java.awt.*;
import java.applet.*;


public class Lab05G extends Applet
{
	public void paint(Graphics g)
	{
		int width = 800;
		int height = 600;
		g.drawRect(10,10,width,height);

		int y=0;
		for(y=30; y<=610; y+=30)
			g.drawLine(10,10,810,y);
			
		for(y=30; y<=610; y+=30)
			g.drawLine(810,10,10,y);
			
		for(y=30; y<=610; y+=30)
			g.drawLine(10,610,810,y);
			
		for(y=30; y<=610; y+=30)
			g.drawLine(810,610,10,y);
	}
}
