// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 9-24-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program creates a linked list of polynomial terms made up of coefficients
// and degrees entered by the user. It then inputs the entered x-value and solves for y.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab33b.java

import java.io.*;
import java.util.Scanner;

public class Lab33b
{
	public static void main (String args[]) throws IOException
	{
		int XVal;
		PolyNode front = null;

		front = PolyList.enterPoly();

		XVal = PolyList.enterXVal();

		PolyList.displayPoly(front);
		PolyList.displayValue(XVal, PolyList.computePoly(XVal, front));
	}
}

class PolyList
{
	private static Scanner sc = new Scanner(System.in); //reads user input

	public static PolyNode enterPoly()
	{
		System.out.println("#####   ENTER-POLY METHOD   #####");

		int polyDegree;
		PolyNode p = null;

		polyDegree = PolyList.enterDegree();

		for(int x = polyDegree; x >= 0; x--)
		{
			PolyNode node1 = new PolyNode(PolyList.enterCoeff(x), x, p);
			p = node1;
		}

		return p;
	}

	private static int enterDegree()
	{
		System.out.println("");
		System.out.println("Enter the degree of the polynomial  ===>>   ");
		return sc.nextInt();
	}

	private static int enterCoeff(int degree)
	{
		System.out.println("");
		System.out.println("Enter coefficient for X^" + degree + " If no term exists, enter 0 ===>>  ");
		return sc.nextInt();
	}

	public static int enterXVal()
	{
		System.out.println("");
		System.out.println("#####   ENTER-XVALUE METHOD   #####");
		System.out.println("");
		System.out.println("Enter X value of the polynomial  ====>>  ");
		return sc.nextInt();
	}

	public static void displayPoly(PolyNode front)
	{
		System.out.println("");
		System.out.println("#####   DISPLAY-POLY METHOD   #####");

		PolyNode p = front;
		String polyString = "";
		boolean first = true;
		boolean normal = true;
		String node = "";

		if (p != null)
		{
			polyString += "Y = ";

			while(p != null)
			{
				node = p.toString();

				if(p.getDegree() == 0)
				{
					node = Integer.toString(p.getCoeff());
					normal = false;
				}
				else if(p.getDegree() == 1 && p.getCoeff() == 1)
				{
					node = "X";
					normal = false;
				}
				else if(p.getCoeff() == 1)
				{
					node = "X^" + p.getDegree();
					normal = false;
				}
				else if(p.getDegree() == 1)
				{
					node = p.getCoeff() + "X";
					normal = false;
				}

				if(p.getCoeff() != 0)
				{
					if(first)
					{
						polyString += node;
						first = false;
					}
					else
						polyString += " + " + node;
				}
				normal = true;
				p = p.getNext();
			}
		}
		System.out.println("");
		System.out.println(polyString);
	}

	public static int computePoly(int XVal, PolyNode front)
	{
		System.out.println("");
		System.out.println("#####   COMPUTE-POLY METHOD   #####");

		PolyNode p = front;
		int computedValue = 0;

		while(p != null)
		{
			computedValue += Math.pow(XVal,p.getDegree())*p.getCoeff();
			p = p.getNext();
		}

		return computedValue;
	}

	public static void displayValue(int XValue, int computedValue)
	{
		System.out.println("");
		System.out.println("#####   DISPLAY-VALUE METHOD   #####");

		System.out.println("");
		System.out.println("Y(" + XValue + ") = " + computedValue);
	}
}

class PolyNode
{

	private int coeff;		// coefficient of each term
	private int degree;		// degree of each term
	private PolyNode next;	// link to the next term node

	public PolyNode (int c, int d, PolyNode initNext)
	{
		coeff = c;
		degree = d;
		next = initNext;
	}

	public int getCoeff()
	{
		return coeff;
	}

	public int getDegree()
	{
		return degree;
	}

	public PolyNode getNext()
	{
		return next;
	}

	public void setCoeff (int newCoeff)
	{
		coeff = newCoeff;
	}

	public void setDegree (int newDegree)
	{
		degree = newDegree;
	}

	public void setNext (PolyNode newNext)
	{
		next = newNext;
	}

	public String toString ()
	{
		return this.coeff + "X^" + this.degree;
	}
}

/*--------------------Configuration: <Default>--------------------
#####   ENTER-POLY METHOD   #####

Enter the degree of the polynomial  ===>>
4

Enter coefficient for X^4 If no term exists, enter 0 ===>>
1

Enter coefficient for X^3 If no term exists, enter 0 ===>>
2

Enter coefficient for X^2 If no term exists, enter 0 ===>>
3

Enter coefficient for X^1 If no term exists, enter 0 ===>>
4

Enter coefficient for X^0 If no term exists, enter 0 ===>>
5

#####   ENTER-XVALUE METHOD   #####

Enter X value of the polynomial  ====>>
2

#####   DISPLAY-POLY METHOD   #####

Y = 5 + 4X + 3X^2 + 2X^3 + X^4

#####   COMPUTE-POLY METHOD   #####

#####   DISPLAY-VALUE METHOD   #####

Y(2) = 57

Process completed.

--------------------Configuration: <Default>--------------------
#####   ENTER-POLY METHOD   #####

Enter the degree of the polynomial  ===>>
4

Enter coefficient for X^4 If no term exists, enter 0 ===>>
1

Enter coefficient for X^3 If no term exists, enter 0 ===>>
0

Enter coefficient for X^2 If no term exists, enter 0 ===>>
0

Enter coefficient for X^1 If no term exists, enter 0 ===>>
0

Enter coefficient for X^0 If no term exists, enter 0 ===>>
5

#####   ENTER-XVALUE METHOD   #####

Enter X value of the polynomial  ====>>
2

#####   DISPLAY-POLY METHOD   #####

Y = 5 + X^4

#####   COMPUTE-POLY METHOD   #####

#####   DISPLAY-VALUE METHOD   #####

Y(2) = 21

Process completed.*/