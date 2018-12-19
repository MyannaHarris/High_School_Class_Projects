// FishGfx.java
// This is the source code file of the "FishGfx.class" file.
// This file is NOT to be altered in any way for Lab 14.

import java.awt.*;

public class FishGfx
{
	private int rowNum;
	private int colNum;
	private int length;
	private int width;
	private double time;

	private void delay(double n)
	{
		for (double k = 1; k < n; k+=0.001);
	}
   
	private Color getColor(int clr)
	{
		Color temp = Color.white;
		switch (clr)
		{
			case 1:  temp = Color.red; break;
			case 2:  temp = Color.green; break;
			case 3:  temp = Color.blue; break;
			case 4:  temp = Color.orange; break;
			case 5:  temp = Color.cyan; break;
			case 6:  temp = Color.magenta; break;
			case 7:  temp = Color.yellow; break;
			case 8:  temp = Color.pink; break;
			case 9:  temp = Color.black; break;
		}
		return temp;
	}
  
	private void drawGrid(Graphics g, int l, int w)
	{
		g.setColor(Color.lightGray);
		g.fillRect(0,0,l,w);
		g.setColor(Color.white);
		for (int row = 0; row <= w; row += 35)
			g.drawLine(0,row,l,row);
		for (int col = 0; col <= l; col += 50)
			g.drawLine(col,0,col,w);
	}

	public FishGfx(Graphics g, int rows, int cols, double td)
	{
		rowNum = rows;
		colNum = cols;
		length = colNum * 50;
		width  = rowNum * 35;
		time   = td;
		drawGrid(g,length,width);
	}

	public void drawFish(Graphics g, int row, int col, int clr, int num)
	{
		String str = String.valueOf(num);
		int x = col * 50 + 15;
		int y = row * 35 + 7;
		g.setColor(getColor(clr));
		g.fillOval(x,y,30,20);   
		Polygon tail = new Polygon();
		tail.addPoint(x,y+10);
		tail.addPoint(x-10,y);
		tail.addPoint(x-10,y+20);
		g.fillPolygon(tail);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,14));
		g.drawString(str,x+5,y+15);
		delay(time);
	}

	public void eraseFish(Graphics g, int row, int col)
	{
		int x = col * 50 + 5;
		int y = row * 35 + 7;
		g.setColor(Color.lightGray);
		g.fillRect(x,y,40,27);
		delay(time);
	}
      
}
      
