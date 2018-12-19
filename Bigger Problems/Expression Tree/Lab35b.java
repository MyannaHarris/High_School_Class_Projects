// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-30-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program traverses a binary expression tree.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab35.java

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Lab35b
{
	public static void main(String args[]) throws IOException
	{
		ExpressionNode root = ExpressionTree.createTree();

		System.out.println("Original Tree");
		System.out.println("=============");
		System.out.print("\nIn-Fix Notation:    ");
		ExpressionTree.inOrderTraverse(root);
		System.out.print("\n\nPre-Fix Notation:   ");
		ExpressionTree.preOrderTraverse(root);
		System.out.print("\n\nPost-Fix Notation:  ");
		ExpressionTree.postOrderTraverse(root);
		System.out.println("\n");

		System.out.println("This tree has "+
		    ExpressionTree.operatorCount(root)+" operators and "+
		   	ExpressionTree.numberCount(root)+" numbers, and evaluates to "+
		    ExpressionTree.evaluate(root)+"\n\n");

		ExpressionNode mirrorRoot = ExpressionTree.mirror(root);

		System.out.println("\nMirror Tree");
		System.out.println("===========");
   	System.out.print("\nIn-Fix Notation:    ");
		ExpressionTree.inOrderTraverse(mirrorRoot);
		System.out.print("\n\nPre-Fix Notation:   ");
		ExpressionTree.preOrderTraverse(mirrorRoot);
		System.out.print("\n\nPost-Fix Notation:  ");
		ExpressionTree.postOrderTraverse(mirrorRoot);
		System.out.println("\n");

		System.out.println("This tree has "+
		    ExpressionTree.operatorCount(mirrorRoot)+" operators and "+
		   	ExpressionTree.numberCount(mirrorRoot)+" numbers, and evaluates to "+
		    ExpressionTree.evaluate(mirrorRoot)+"\n");
	}
}

class ExpressionNode
{
	public ExpressionNode(double initNum, char initOpr, ExpressionNode initLeft, ExpressionNode initRight)
	{
		num = initNum;
		opr = initOpr;
		left = initLeft;
		right = initRight;
	}

	public double getNum()											{ return num; 				}
	public char getOpr()												{ return opr;					}
	public ExpressionNode getLeft()								{ return left; 				}
	public ExpressionNode getRight()							{ return right; 			}
	public void setNum(int theNewNum)							{ num = theNewNum; 		}
	public void setOpr(char theNewOpr)							{ opr = theNewOpr;			}
	public void setLeft(ExpressionNode theNewLeft)		{ left = theNewLeft; 		}
	public void setRight(ExpressionNode theNewRight)	{ right = theNewRight; 	}

	private double num;
	private char opr;
	private ExpressionNode left;
	private ExpressionNode right;

	public String toString()
	{
		if(opr == ' ')
			return String.valueOf(num);
		else
			return String.valueOf(opr);
	}
}


class ExpressionTree
{
	public static ExpressionNode createTree()
	{
		ExpressionNode n12  = new ExpressionNode(12,' ',null,null);
		ExpressionNode n6   = new ExpressionNode( 6,' ',null,null);
		ExpressionNode ndiv = new ExpressionNode( 0,'/',n12,n6);
		ExpressionNode n7   = new ExpressionNode( 7,' ',null,null);
		ExpressionNode nadd = new ExpressionNode( 0,'+',n7,ndiv);
		ExpressionNode n2   = new ExpressionNode( 2,' ',null,null);
		ExpressionNode n4   = new ExpressionNode( 4,' ',null,null);
		ExpressionNode ncar = new ExpressionNode( 0,'^',n2,n4);
		ExpressionNode n5   = new ExpressionNode( 5,' ',null,null);
		ExpressionNode nsub = new ExpressionNode( 0,'-',ncar,n5);
		ExpressionNode root = new ExpressionNode( 0,'*',nadd,nsub);
		return root;
	}


	public static void inOrderTraverse (ExpressionNode p)
	{
		if(p!=null)
		{
			if(p.getOpr() != ' ')
				System.out.print("(");
			inOrderTraverse(p.getLeft());
			System.out.print(p);
			inOrderTraverse(p.getRight());
			if(p.getOpr() != ' ')
				System.out.print(")");
		}
	}

	public static void preOrderTraverse (ExpressionNode p)
	{
		if(p!=null)
		{
			System.out.print(p);
			preOrderTraverse(p.getLeft());
			preOrderTraverse(p.getRight());
		}
	}

	public static void postOrderTraverse (ExpressionNode p)
	{
		if(p!=null)
		{
			postOrderTraverse(p.getLeft());
			postOrderTraverse(p.getRight());
			System.out.print(p);
		}
	}

	public static int numberCount (ExpressionNode p)
	{
		if(p!=null)
		{
			if(p.getOpr() == ' ')
				return 1 + numberCount(p.getLeft()) + numberCount(p.getRight());
			else
				return numberCount(p.getLeft()) + numberCount(p.getRight());
		}
		else
			return 0;
	}

	public static int operatorCount (ExpressionNode p)
	{
		if(p!=null)
		{
			if(p.getOpr() != ' ')
				return 1 + operatorCount(p.getLeft()) + operatorCount(p.getRight());
			else
				return operatorCount(p.getLeft()) + operatorCount(p.getRight());
		}
		else
			return 0;
	}

	public static double evaluate (ExpressionNode p)
	{
		if(p!=null)
		{
			switch(p.getOpr())
			{
				case '+': return evaluate(p.getLeft()) + evaluate(p.getRight());
				case '-': return evaluate(p.getLeft()) - evaluate(p.getRight());
				case '/': return evaluate(p.getLeft()) / evaluate(p.getRight());
				case '*': return evaluate(p.getLeft()) * evaluate(p.getRight());
				case '^': return Math.pow(evaluate(p.getLeft()), evaluate(p.getRight()));
				default: return p.getNum();
			}
		}
		else
			return 0;
	}

	public static ExpressionNode mirror(ExpressionNode p)
	{
		if(p!=null)
		{
			ExpressionNode t = p.getLeft();
			p.setLeft(mirror(p.getRight()));
			p.setRight(mirror(t));
		}
		return p;
	}
}

/*--------------------Configuration: <Default>--------------------
Original Tree
=============

In-Fix Notation:    ((7.0+(12.0/6.0))*((2.0^4.0)-5.0))

Pre-Fix Notation:   *+7.0/12.06.0-^2.04.05.0

Post-Fix Notation:  7.012.06.0/+2.04.0^5.0-*

This tree has 5 operators and 6 numbers, and evaluates to 99.0



Mirror Tree
===========

In-Fix Notation:    ((5.0-(4.0^2.0))*((6.0/12.0)+7.0))

Pre-Fix Notation:   *-5.0^4.02.0+/6.012.07.0

Post-Fix Notation:  5.04.02.0^-6.012.0/7.0+*

This tree has 5 operators and 6 numbers, and evaluates to -82.5


Process completed.
*/