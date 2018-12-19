/**
 * @(#)cool.java
 *
 *
 * @author 
 * @version 1.00 2011/2/4
 */

import java.util.*; 
import java.applet.Applet;
import java.awt.*;

public class cool extends Applet
{
int startX,startY,endX,endY;
		
	public void paint(Graphics g)
	{
		g.drawLine(startX,startY,endX,endY);
	}		

	public boolean mouseDown(Event e, int x, int y)
	{
		startX = x;
		startY = y;
		return true;
	}
	
	public boolean mouseDrag(Event e, int x, int y)
	{
		endX = x;
		endY = y;
		repaint();
		return true;
	}	
		
	public void update(Graphics g)
	{
		paint(g);
	}
}