// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 3-9-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// it makes fish in a grid in a spiral square patern counter clock-wise
// counting from 1 to 100 and changing color. It erases them AFter
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// count --> counts the fish
// clr --> changes the color of the fish
// ar --> keeps track of row number when going across to make the box smaller progressively
// ac --> keeps track of column number when going across to make the box smaller progressively
// dr --> keeps track of row number when going down to make the box smaller progressively
// dc --> keeps track of column number when going down to make the box smaller progressively
// grow --> keeps track of length limits that are getting bigger
// shrink --> keeps track of length limits that are getting smaller
// row --> represents the row of where the fish is
// col --> represents the column of where the fish is
// ***********************************************
// Lab14G.java
// 110 Version

import java.awt.*;

public class Lab14G extends java.applet.Applet
{

    public void paint(Graphics g) 
    {
    	FishGfx fish = new FishGfx(g,20,20,2000);
    	int count = 1;
          int clr = 1;
          int ar = 0;
          int ac = 0;
          int dr = 19;
          int dc = 19;
          int grow = 20;
          int shrink = 0;
          while (count <=400)
          {
	          for (int row = ar, col = ac; row < grow; row++) 
	          {
	          		fish.drawFish(g,row,col,clr,count);
	          		count++;	
	          }
	          if (clr==9)
	          	clr=1;
	          else
	          	clr++;
	          for (int row = dr, col = ac+1; col < grow; col++)
	          {
	          		fish.drawFish(g,row,col,clr,count);
	          		count++;
	          }
	          if (clr==9)
	          	clr=1;
	          else
	          	clr++;
	          for (int row = dr-1, col = dc; row >= shrink; row--)
	          {
	          		fish.drawFish(g,row,col,clr,count);
	          		count++;	
	          }
	          if (clr==9)
	          	clr=1;
	          else
	          	clr++;
	          for (int row = ar, col = dc-1; col >= shrink + 1; col--) 
	          {
	          		fish.drawFish(g,row,col,clr,count);
	          		count++;	
	          }
	          if (clr==9)
	          	clr=1;
	          else
	          	clr++;
	          ar++;
	          ac++;
	          dr--;
	          dc--;
	          grow--;
	          shrink++;  
          }
          
          count = 1;
          ar = 0;
          ac = 0;
          dr = 19;
          dc = 19;
          grow = 20;
          shrink = 0;
          while (count <=400)
          {
	          for (int row = ar, col = ac; row < grow; row++) 
	          {
	          		fish.eraseFish(g,row,col);
	          		count++;
	          }
	          for (int row = dr, col = ac+1; col < grow; col++)
	          {
	          		fish.eraseFish(g,row,col);
	          		count++;
	          }
	      	  for (int row = dr-1, col = dc; row >= shrink; row--)
	          {
	          		fish.eraseFish(g,row,col);
	          		count++;	
	          }
	          for (int row = ar, col = dc-1; col >= shrink + 1; col--)  
	          {
	          		fish.eraseFish(g,row,col);
	          		count++;	
	          }
	          ar++;
	          ac++;
	          dr--;
	          dc--;
	          grow--;
	          shrink++;  
          }
    }
    
    
}