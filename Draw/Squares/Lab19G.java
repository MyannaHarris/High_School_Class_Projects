// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-26-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program makes squares going from big on the left to small on
// the right and each consecutive square is 3/4 the size of the previous
// square. Then it makes squares going from big on the right to small on
// the left and each consecutive square is 3/4 the size of the previous
// square.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// g --> parameter variable used to pass the graphics
// win --> object that draws the squares
// x --> represents the x coordinates of the top left corner of the squares
// y --> represents the y coordinates of the top left corner of the squares
// size --> represents the changing size of the squares
// ***********************************************
// Lab19G.java
// 100 Version

import java.awt.*;
import java.awt.event.*;

public class Lab19G {

    public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(1000,750);
		win.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		win.show();
	}
}

class Windows extends Frame
{
    public void paint(Graphics g)
    {
    		drawSquare(g, 0, 100, 200);
    }
    
    public void drawSquare(Graphics g, int x, int y, int size)
    {
    	if(((x+size)<1000)&&(size>=4))
    	{
    		g.setColor(Color.black);
    		g.fillRect(x,y,size,size);
			drawSquare(g,(x+size+10),y,(size*3/4));
    	}
    	x = 1000-(x+size);
    	y = 750-(y+size);
    	if((x>=0)&&(size>=4))
    	{
    		g.setColor(Color.black);
    		g.fillRect(x,y,size,size);
    	}		
    }	
}