
// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 12-19-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program uses an arraylist to make a matrix class object act like a matrix.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// m1, m2, m3 --> represents matrix objects
// r, c --> represents row and column counters
// list, temp --> represents an arraylist of numbers
// listSize --> represents the length of the list
// numRows --> represents the number of rows in the matrix
//	numCols --> represents the number of columns in the matrix
//	index --> represents the index of the value needed
//	value --> represents the value to be assigned to the list index's
// x --> represents a counter variable
// ***********************************************
// Lab26a.java
// 100 Version

import java.util.ArrayList;


public class Lab26a
{
	public static void main(String args[])
	{
		System.out.println("\nLAB24A 100-POINT VERSION\n");

		Matrix m1 = new Matrix();
		m1.displayMatrix("Matrix m1 Default Display");
		System.out.println();

		Matrix m2 = new Matrix(3,5);
		int count = 100;
		for (int r = 0; r < m2.getRows(); r++)
		{
			for (int c = 0; c < m2.getCols(); c++)
			{
				m2.setValue(r,c,count);
				count++;
			}
		}
		m2.displayMatrix("Matrix m2 3 X 5 Consecutive Integers Display");
		System.out.println();

		m2.resize(4,4);
		m2.displayMatrix("Matrix m2 After 4 X 4 Resizing Display");
		System.out.println();

		Matrix m3 = new Matrix(3,3,100);
		m3.displayMatrix("Matrix m3 3 X 3 Initialized to 100 Display");
		System.out.println();
	}

}


class Matrix
{
	private ArrayList<Integer> list;	// one-dimensional array stores matrix values
	private int listSize;		// total number of elements in the matrix
	private int numRows;	// number of rows in the matrix
	private int numCols;		// number of cols in the matrix

	public Matrix()
	{
		numRows = 0;
		numCols = 0;
		listSize = 0;
		list = new ArrayList<Integer>();
	}

	public Matrix(int r, int c)
	{
		numRows = r;
		numCols = c;
		listSize = numRows*numCols;
		list = new ArrayList<Integer>();
		for (int x = 0; x < listSize; x++)
			list.add(0);
	}

	public Matrix(int r, int c, int value)
	{
		numRows = r;
		numCols = c;
		listSize = numRows*numCols;
		list = new ArrayList<Integer>();
		for (int x = 0; x < listSize; x++)
			list.add(value);
	}

	public int getRows()
	{
		return numRows;
	}

	public int getCols()
	{
		return numCols;
	}

	public int getSize()
	{
		return listSize;
	}

	public int getValue(int r, int c)
	{
		int index = (r*numCols)+ c;
		return list.get(index);
	}

	public void setValue(int r, int c, int value)
	{
		int index = (r*numCols)+ c;
		list.set(index, value);
	}

	public void displayMatrix(String str)
	{
		System.out.println(str);
		if (list.isEmpty())
			System.out.println("Matrix has no elements");
		else
			for (int r = 0; r < numRows; r++)
			{
				for (int c = 0; c < numCols; c++)
				{
					System.out.print(getValue(r,c) + "  ");
				}
				System.out.println();
			}
	}

	public void resize(int rows, int cols)
	{
		int tempRows = rows;
		int tempCols = cols;
		if (numRows < rows)
			tempRows = this.numRows;
		if (numCols < cols)
			tempCols = this.numCols;
		if (!list.isEmpty())
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int r = 0; r < tempRows; r++)
		{
			for (int c = 0; c < tempCols; c++)
			{
				temp.add(getValue(r,c));
			}
		}
		numRows = rows;
		numCols = cols;
		listSize = numRows*numCols;
		list.clear();
		for (int x = 0; x < temp.size(); x++)
			list.add(temp.get(x));
		for (int x = temp.size(); x < listSize; x++)
			list.add(0);
		}
	}
}

/*--------------------Configuration: <Default>--------------------

LAB24A 100-POINT VERSION

Matrix m1 Default Display
Matrix has no elements

Matrix m2 3 X 5 Consecutive Integers Display
100  101  102  103  104
105  106  107  108  109
110  111  112  113  114

Matrix m2 After 4 X 4 Resizing Display
100  101  102  103
105  106  107  108
110  111  112  113
0  0  0  0

Matrix m3 3 X 3 Initialized to 100 Display
100  100  100
100  100  100
100  100  100


Process completed.*/