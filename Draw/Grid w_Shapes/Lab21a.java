// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-21-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program draws a grid with four boxes. It draws a triangle
// in the top left, a square in the top right, a circle in the
// bottom left, and an octagon in the bottom right. it uses a
// shape interface for many of the methods and an abstract class
// for other methods and variables. The output method uses
// polymorphism.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// win --> makes a window for the output
// g --> draws the graphics
// shape1, shape2, shape3, shape4 --> represents the four shape objects
// PI --> represents the number pi
// numSides --> represents the number of sides a shape has
// shapeName --> represents the name of the shape being drawn
// messageX --> represents the x coordinate of the message
// messageY --> represents the y coordinate of the message
// tri --> represents the polygon shape of the triangle
// octa --> represents the polygon shape of the octagon
// shape --> represents the passing of the shape objects
// g1 --> represents the passing of the graphics drawer
// ***********************************************
// Lab21a.java
// 100 Version

import java.util.Random;
import java.awt.*;
import java.awt.event.*;

public class Lab21a
{
	public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(800,600);
		win.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		win.show();
	}
}

class Windows extends Frame
{

	public void paint(Graphics g)
	{
		drawGrid(g);

		Square   shape1 = new Square(g);
		Triangle shape2 = new Triangle(g);
		Octagon  shape3 = new Octagon(g);
		Circle   shape4 = new Circle(g);

		output(g,shape1);
		output(g,shape2);
		output(g,shape3);
		output(g,shape4);
	}

	public void drawGrid(Graphics g)
	{
		g.drawLine(0,300,800,300);
		g.drawLine(400,0,400,600);
		g.drawString("Triangle",20,50);
		g.drawString("Square",420,50);
		g.drawString("Octagon",420,320);
		g.drawString("Circle",20,320);
	}

	public void output(Graphics g1,Shape shape)
	{
		shape.drawShape(g1);
		shape.displayNumSides(g1);
	}
}

abstract interface Shape
{
	public final double PI = Math.PI;

	public abstract void drawShape(Graphics g);

	public abstract void displayNumSides(Graphics g);

}

abstract class Shape2 implements Shape
{
	protected int numSides;

	protected String shapeName;

	protected Graphics g;

	protected int messageX, messageY;

	public void displayNumSides(Graphics g)
   {
    	g.drawString("A " + shapeName + " has " + numSides + " sides.",messageX,messageY);
   }
}

class Square extends Shape2
{
	public Square(Graphics g1)
  {
    	numSides = 4;
    	shapeName = "Square";
    	g = g1;
    	messageX = 500;
    	messageY = 250;
  }

  public void drawShape(Graphics g)
  {
    	g.fillRect(500,50,150,150);
  }
}

class Triangle extends Shape2
{
	public Triangle(Graphics g1)
  {
    	numSides = 3;
    	shapeName = "Triangle";
    	g = g1;
    	messageX = 100;
    	messageY = 250;
  }

  public void drawShape(Graphics g)
  {
    	Polygon tri = new Polygon();
		tri.addPoint(100,200);
		tri.addPoint(250,200);
		tri.addPoint(175,50);
		g.fillPolygon(tri);
  }
}

class Octagon extends Shape2
{
	public Octagon(Graphics g1)
  {
    	numSides = 8;
    	shapeName = "Octagon";
    	g = g1;
    	messageX = 500;
    	messageY = 550;
  }

  public void drawShape(Graphics g)
  {
    	Polygon octa = new Polygon();
		octa.addPoint(543,350);
		octa.addPoint(607,350);
		octa.addPoint(650,393);
		octa.addPoint(650,457);
		octa.addPoint(607,500);
		octa.addPoint(543,500);
		octa.addPoint(500,457);
		octa.addPoint(500,393);
		g.fillPolygon(octa);

  }
}

class Circle extends Shape2
{
	public Circle(Graphics g1)
  {
    	numSides = 0;
    	shapeName = "Circle";
    	g = g1;
    	messageX = 100;
    	messageY = 550;
  }

  public void drawShape(Graphics g)
  {
  		g.fillOval(100,350,150,150);
  }
}