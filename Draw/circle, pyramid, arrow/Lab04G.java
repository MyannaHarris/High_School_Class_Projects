// ***********************************************
// Program Identification
// Name: Myanna Harris
// Class: java
// Date: 9-23-10
// File Location: H:\My Documents\java
// ***********************************************

// ***********************************************
// Program Abstract
// The program draws a pyramid in the top left corner
// and a target with blck, white, blue, red, and yellow
// rings and an arrow hitting the bullseye in the target.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// n/a
// ***********************************************
// Lab04Gst.java
// Student starting version of the Lab04 assignment.
// 110 version


import java.awt.*;
import java.applet.*;


public class Lab04G extends Applet
{

	public void paint(Graphics g){
		g.drawLine(100,400,500,400);
		g.drawLine(100,400,350,100);
		g.drawLine(500,400,350,100);
		g.drawLine(500,400,600,250);
		g.drawLine(350,100,600,250);
		
		g.setColor(Color.black);
		g.fillOval(700,100,500,500);
		g.setColor(Color.white);
		g.fillOval(750,150,400,400);
		g.setColor(Color.blue);
		g.fillOval(800,200,300,300);
		g.setColor(Color.red);
		g.fillOval(850,250,200,200);
		g.setColor(Color.yellow);
		g.fillOval(900,300,100,100);
		
		g.setColor(Color.black);
		g.drawLine(1075,510,1045,500);
		g.drawLine(1050,535,1045,500);
		g.drawLine(1045,500,950,350);
		g.drawLine(950,350,965,360);
		g.drawLine(950,350,952,365);
	}
	
 }
   