// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 1-11-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program solves the famous “Knight’s Tour” problem
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// knight --> represents Knight class object
// board[][] --> represents the chess board that the knight moves on
// startRow --> represents the row the knight starts in
// startCol --> represents the column the knight starts in
// rowPos --> represents the row the knight is on
//	colPos --> represents the column the knight is on
//	moves --> represents the number of moves the knight makes
//	ACCESS --> represents the matrix with the number of moves from each move
// row, col --> represents the row and column of the value in the matrix to be displayed
//	pos --> represents the least number of possible moves for the knight
// tempRow, tempCol --> represents the change in row and column when the knight moves
// rowA, colA --> represents the row and column in the ACCESS matrix
// ***********************************************
// 100 Version
// Lab26bst.java
// This is the student version of the knight's tour lab assignment.

import java.io.*;
import java.text.DecimalFormat;

public class Lab26b
{
	public static void main (String args[]) throws IOException
	{
		System.out.println("\nLab26b 100 Point Version\n");
		Knight knight = new Knight();
		knight.getStart();
		knight.solveTour();
		knight.displayBoard();
	}
}

class Knight
{
	private int board[][];			// stores the sequence of knight moves
	private int startRow;			// row location where the knight starts
	private int startCol;			// col location where the knight starts
	private int rowPos;			// current row position of the knight
	private int colPos;			// current col position of the knight
	private int moves;			// number of location visited by the knight

	//	USED WITH THE 100 POINT VERSION
	final private int ACCESS[][] =	{{0,0,0,0,0,0,0,0,0,0,0,0},
 						 						{0,0,0,0,0,0,0,0,0,0,0,0},
     					 						{0,0,2,3,4,4,4,4,3,2,0,0},
     					 						{0,0,3,4,6,6,6,6,4,3,0,0},
     					 						{0,0,4,6,8,8,8,8,6,4,0,0},
     							 				{0,0,4,6,8,8,8,8,6,4,0,0},
     							 				{0,0,4,6,8,8,8,8,6,4,0,0},
     					 						{0,0,4,6,8,8,8,8,6,4,0,0},
     					 						{0,0,3,4,6,6,6,6,4,3,0,0},
     					 						{0,0,2,3,4,4,4,4,3,2,0,0},
     					 						{0,0,0,0,0,0,0,0,0,0,0,0},
     					 						{0,0,0,0,0,0,0,0,0,0,0,0}};

	public Knight()
	// constructor used to initializes the data attributes
	{
		board = new int[8][8];
		startRow = 0;
		startCol = 0;
		rowPos = 0;
		colPos = 0;
		moves = 0;
	}


	public void getStart() throws IOException
	// input method to get starting row and col from keyboard entry
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter row start    ===>>  ");
		startRow = (Integer.parseInt(br.readLine()))-1;
		System.out.print("\nEnter col start    ===>>  ");
		startCol = (Integer.parseInt(br.readLine()))-1;
		System.out.println("");
		moves++;
		rowPos = startRow;
		colPos = startCol;
	}


	public void displayBoard()
	// displays the chessboard after the tour is concluded
	{
		DecimalFormat output = new DecimalFormat("00");
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				System.out.print(output.format(board[row][col]) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("The knight has toured " + moves + " locations.");
	}


	private boolean getMove()
	// computes the next available knight's move.  Alters RowPos and ColPos and
	// returns true if move is possible, otherwise returns false
	{
		int pos = 9;
		int tempRow = 0;
		int tempCol = 0;
		int rowA = rowPos+2;
		int colA = colPos+2;
		if(ACCESS[rowA+1][colA+2]!=0)
		{
			if (board[rowPos+1][colPos+2]==0 && ACCESS[rowA+1][colA+2]<pos)
			{
				tempRow = 1;
				tempCol = 2;
				pos = ACCESS[rowA+1][colA+2];
			}

		}
		if(ACCESS[rowA+2][colA+1]!=0)
		{
			if (board[rowPos+2][colPos+1]==0 && ACCESS[rowA+2][colA+1]<pos)
			{
				tempRow = 2;
				tempCol = 1;
				pos = ACCESS[rowA+2][colA+1];
			}
		}
		if(ACCESS[rowA+2][colA-1]!=0)
		{
			if (board[rowPos+2][colPos-1]==0 && ACCESS[rowA+2][colA-1]<pos)
			{
				tempRow = 2;
				tempCol = -1;
				pos = ACCESS[rowA+2][colA-1];
			}
		}
		if(ACCESS[rowA+1][colA-2]!=0)
		{
			if (board[rowPos+1][colPos-2]==0 && ACCESS[rowA+1][colA-2]<pos)
			{
				tempRow = 1;
				tempCol = -2;
				pos = ACCESS[rowA+1][colA-2];
			}
		}
		if(ACCESS[rowA-1][colA-2]!=0)
		{
			if (board[rowPos-1][colPos-2]==0 && ACCESS[rowA-1][colA-2]<pos)
			{
				tempRow = -1;
				tempCol = -2;
				pos = ACCESS[rowA-1][colA-2];
			}
		}
		if(ACCESS[rowA-2][colA-1]!=0)
		{
			if (board[rowPos-2][colPos-1]==0 && ACCESS[rowA-2][colA-1]<pos)
			{
				tempRow = -2;
				tempCol = -1;
				pos = ACCESS[rowA-2][colA-1];
			}
		}
		if(ACCESS[rowA-2][colA+1]!=0)
		{
			if (board[rowPos-2][colPos+1]==0 && ACCESS[rowA-2][colA+1]<pos)
			{
				tempRow = -2;
				tempCol = 1;
				pos = ACCESS[rowA-2][colA+1];
			}
		}
		if(ACCESS[rowA-1][colA+2]!=0)
		{
			if (board[rowPos-1][colPos+2]==0 && ACCESS[rowA-1][colA+2]<pos)
			{
				tempRow = -1;
				tempCol = 2;
				pos = ACCESS[rowA-1][colA+2];
			}
		}
		if (pos != 9)
		{
			rowPos+=tempRow;
			colPos+=tempCol;
			return true;
		}
		else
			return false;
	}


	public void solveTour()
	// primary method that drives the knight's tour solution
	{
		board[startRow][startCol] = moves;
		while(getMove())
		{
			moves++;
			board[rowPos][colPos] = moves;
		}
	}

}

/*--------------------Configuration: <Default>--------------------

Lab26b 100 Point Version


Enter row start    ===>>  4

Enter col start    ===>>  4

33	46	17	60	31	44	15	12
18	49	32	45	16	13	30	43
47	34	61	00	59	00	11	14
50	19	48	01	56	53	42	29
35	02	51	54	00	58	25	10
20	05	38	57	52	55	28	41
03	36	07	22	39	26	09	24
06	21	04	37	08	23	40	27

The knight has toured 61 locations.

Process completed.

--------------------Configuration: <Default>--------------------

Lab26b 100 Point Version


Enter row start    ===>>  2

Enter col start    ===>>  2

31	46	15	60	29	44	13	10
16	01	30	45	14	11	28	43
47	32	59	52	61	64	09	12
02	17	50	63	56	53	42	27
33	48	55	58	51	62	23	08
18	03	36	49	54	57	26	41
37	34	05	20	39	24	07	22
04	19	38	35	06	21	40	25

The knight has toured 64 locations.

Process completed.*/