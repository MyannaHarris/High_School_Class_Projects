/**
 * @(#)ChessQueen.java
 *
 *
 * @author
 * @version 1.00 2013/3/11
 */

import java.util.*;
import java.lang.Math;

public class ChessQueen
{

    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner( System.in );

    	String[] inputString = new String[5];

    	for(int q = 0; q < 5; q++)
    	{
    		inputString[q] = scanner.nextLine();
    	}

		int xFinal = 0;
		int yFinal = 0;

		for(int t = 0; t < 5; t++)
		{
	    	int input = 1;

	    	boolean possible = false;

	    	ArrayList<Integer> x = new ArrayList<Integer>();
	    	ArrayList<Integer> y = new ArrayList<Integer>();

	    	boolean addX = true;

	    	int pieces = -1;

			for(int c = 0; c <= (inputString[t].length()-7); c+=3)
	    	{
	    		input = Integer.parseInt(String.valueOf(inputString[t].charAt(c)));

	    		if(addX)
	    		{
	    			x.add(input);
	    			addX = false;
	    		}
	    		else
	    		{
	    			y.add(input);
	    			addX = true;
	    		}

	    		pieces++;
	    	}

	    	boolean done = false;

	    	int[] xArray = sortArray(x);
	    	int[] yArray = sortArray(y);

	    	int xCoord = xArray[0];
	    	int yCoord = yArray[0];

	    	int[] failures = new int[xArray.length];

	    	boolean fail = false;

	    	while(!done)
	    	{
	    		int p = 0;
	    		int f = 0;

	    		while(p < xArray.length)
	    		{
    				if(xCoord != x.get(p) && yCoord != y.get(p))
	    			{
	    				failures[f] = p;
	    				f++;
	    				fail = true;
	    			}

	    			p++;

	    			if(p > (xArray.length-1) && !fail)
	    			{
	    				xFinal = xCoord;
	    				yFinal = yCoord;
	    			}
	    		}

				if(fail)
				{
					fail = false;
		    		p = 0;

		    		while(p < xArray.length && failures[p] < xArray.length && !fail)
		    		{
		    			if(Math.abs(xCoord - x.get(failures[p])) != Math.abs(yCoord - y.get(failures[p])))
		    				fail = true;
		    			else
		    				p++;

		    			if((p >= xArray.length || failures[p] >= xArray.length) && !fail)
		    			{
		    				done = true;
		    				possible = true;

		    				xFinal = xCoord;
		    				yFinal = yCoord;
		    			}
			    	}
				}

		    	xCoord++;
		    	yCoord++;
		    	if(xCoord > 8 || yCoord > 8)
		    		done = true;
			}

			if(possible == false)
	    		System.out.println("None");
		   else
		   	System.out.println("(" + xFinal + "," + yFinal + ")");
	    }
    }

    public static int[] sortArray(ArrayList<Integer> a)
    {
    	int[] temp = new int[a.size()];

    	for(int z = 0; z <= (temp.length-1); z++)
    	{
    		temp[z] = (a.get(z)).intValue();
    	}

    	Arrays.sort(temp);

    	return temp;
    }
}