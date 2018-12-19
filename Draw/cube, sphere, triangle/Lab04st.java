// ***********************************************
// Program Identification
// Name: Myanna Harris
// Class: java
// Date: 9-21-10
// File Location: H:\My Documents\java
// ***********************************************

// ***********************************************
// Program Abstract
// this is a graphics program that draws a cube with 
// a sphere inside it and a triangle with three lines
// in the triangle that each go from a vertex to a midpoint
// on the opposite line
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// n/a
// ***********************************************
import java.awt.*;
import java.applet.*;

public class Lab04st extends Applet {

	public void paint(Graphics g)
		{
		g.drawRect(0,0,300,300);
		g.drawRect(100,100,300,300);
		g.drawLine(0,0,100,100);
		g.drawLine(300,0,400,100);
		g.drawLine(300,300,400,400);
		g.drawLine(0,300,100,400);
		
		g.drawOval(50,50,300,300);
		g.drawOval(80,50,240,300);
		g.drawOval(120,50,160,300);
		g.drawOval(160,50,80,300);
		g.drawOval(50,80,300,240);
		g.drawOval(50,120,300,160);
		g.drawOval(50,160,300,80);
		
		g.drawLine(400,600,1000,600);
		g.drawLine(400,600, 700,300);
		g.drawLine(1000,600,700,300);
		g.drawLine(700,600,700,300);
		g.drawLine(400,600,850,450);
		g.drawLine(1000,600,550,450);
    }
    
    
}