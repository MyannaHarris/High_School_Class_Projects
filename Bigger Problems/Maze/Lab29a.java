// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 3-19-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program reads in a textfile then makes a random maze
// then tries to solve it
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab29a.java

import java.util.*;

public class Lab29a
{
	public static void main(String args[])
	{
		System.out.println("\nLab 29a 80/100 Point Version\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter random starting seed  ===>>  ");
		int seed = input.nextInt();

		Maze maze = new Maze(seed);
		maze.displayMaze();
		maze.solveMaze();
		maze.displayMaze();
		maze.mazeSolution();
	}
}


class Maze
{

	private char mat[][];				// 2d character array that stores the maze display
	private Coord currentMove;		// object that stores current maze position
	private Stack visitStack;			// stack that stores location that have been visited


	class Coord
	// Coord is a class that stores a single maze location.
	{
		private int rPos; //row position
		private int cPos; //column position
		public Coord (int r, int c) 		{ rPos = r; cPos = c; }
		public boolean isFree() 			{ return (rPos == 0 && cPos == 0); }
		public void setPos(int r, int c) 	{ rPos+= r; cPos+= c; }
	}


	public Maze(int seed)
	// constructor which generates the random maze, random starting location
	// and initializes Maze class values.  If the random value equals 0 the maze
	// store an 'X' otherwise it store an 'O' in the maze.
	{
		Random random = new Random(seed); //random start coordinates
		int startRow, startCol; //the start position
		mat = new char[12][12]; //the maze
		for (int r = 0; r < 12; r++)
			for (int c = 0; c < 12; c++)
			{
				if (r == 0 || c == 0 || r == 11 || c == 11)
					mat[r][c] = 'X';
				else
				{
					int rndInt = random.nextInt(2);
					if (rndInt == 0)
						mat[r][c] = 'X';
					else
						mat[r][c] = 'O';
				}
			}
		mat[0][0] = 'O';
		startRow = random.nextInt(12);
		startCol = 11;
		mat[startRow][startCol] = '.';
		visitStack = new Stack();
		currentMove = new Coord(startRow,startCol);
		visitStack.push(currentMove);
	}


	void displayMaze()
	// displays the current maze configuration
	{
		System.out.println("\nRANDOM MAZE DISPLAY\n");
		for (int r = 0; r < 12; r++)
		{
			for (int c = 0; c < 12; c++)
				System.out.print(mat[r][c] + "  ");
			System.out.println();
		}
		System.out.println();
		pause();
	}


	public void solveMaze()
	// This methods solves the maze with private helper method <getMove>.
	// A loop is needed to repeat getting new moves until either a maze solution
	// is found or it is determined that there is no way out off the maze.
	{
		System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
		while (!currentMove.isFree() && !visitStack.isEmpty())
		{
			if(getMove())
			{
				mat[currentMove.rPos][currentMove.cPos] = '.';
				visitStack.push(new Coord(currentMove.rPos,currentMove.cPos));
			}
			else
				currentMove = (Coord)visitStack.pop();

		}
	}


	public void mazeSolution()
	// Short method to display the result of the maze solution
	{
		if (currentMove.isFree())
			System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
		else
			System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
	}


	private boolean inBounds(int r, int c)
	// This method determines if a coordinate position is inbounds or not
	{
			if (r+currentMove.rPos >= 12 || c+currentMove.cPos >= 12)
				return false;
			else
				return true;
	}


	private boolean getMove()
	// This method checks eight possible positions in a counter-clock wise manner
	// starting with the (-1,0) position.  If a position is found the method returns
	// true and the currentMove coordinates are altered to the new position
	{
		if (inBounds(-1,0) && mat[currentMove.rPos-1][currentMove.cPos] == 'O')
		{
			currentMove.setPos(-1,0);
			return true;
		}
		else if (inBounds(-1,1) && mat[currentMove.rPos-1][currentMove.cPos+1] == 'O')
		{
			currentMove.setPos(-1,1);
			return true;
		}
		else if (inBounds(0,1) && mat[currentMove.rPos][currentMove.cPos+1] == 'O')
		{
			currentMove.setPos(0,1);
			return true;
		}
		else if (inBounds(1,1) && mat[currentMove.rPos+1][currentMove.cPos+1] == 'O')
		{
			currentMove.setPos(1,1);
			return true;
		}
		else if (inBounds(1,0) && mat[currentMove.rPos+1][currentMove.cPos] == 'O')
		{
			currentMove.setPos(1,0);
			return true;
		}
		else if (inBounds(1,-1) && mat[currentMove.rPos+1][currentMove.cPos-1] == 'O')
		{
			currentMove.setPos(1,-1);
			return true;
		}
		else if (inBounds(0,-1) && mat[currentMove.rPos][currentMove.cPos-1] == 'O')
		{
			currentMove.setPos(0,-1);
			return true;
		}
		else if (inBounds(-1,-1) && mat[currentMove.rPos-1][currentMove.cPos-1] == 'O')
		{
			currentMove.setPos(-1,-1);
			return true;
		}
		else
			return false;
	}

	private void pause()
	{
		Scanner input = new Scanner(System.in);
		String dummy;
		System.out.print("\nPress <Enter> to continue  ===>>  ");
		dummy = input.nextLine();
	}


}

/*--------------------Configuration: <Default>--------------------

Lab 29a 80/100 Point Version

Enter random starting seed  ===>>  100

RANDOM MAZE DISPLAY

O  X  X  X  X  X  X  X  X  X  X  X
X  O  O  X  O  O  X  O  X  O  O  X
X  O  X  X  X  X  X  O  O  O  X  X
X  X  X  O  O  O  X  X  X  X  X  X
X  O  O  O  X  O  O  X  O  X  X  X
X  X  O  X  O  O  X  O  O  X  X  X
X  X  O  X  O  X  O  X  X  X  O  .
X  X  O  O  O  X  O  O  X  O  O  X
X  O  O  X  O  X  O  O  O  O  X  X
X  X  X  O  X  X  X  X  X  O  X  X
X  O  O  X  X  O  O  X  X  X  X  X
X  X  X  X  X  X  X  X  X  X  X  X


Press <Enter> to continue  ===>>

>>>>>   WORKING  ....  SOLVING MAZE   <<<<<


RANDOM MAZE DISPLAY

O  X  X  X  X  X  X  X  X  X  X  X
X  O  O  X  O  O  X  O  X  O  O  X
X  O  X  X  X  X  X  O  O  O  X  X
X  X  X  .  .  .  X  X  X  X  X  X
X  .  .  .  X  .  .  X  .  X  X  X
X  X  .  X  .  .  X  .  .  X  X  X
X  X  .  X  .  X  .  X  X  X  .  .
X  X  .  .  .  X  .  .  X  .  .  X
X  .  .  X  .  X  .  .  .  .  X  X
X  X  X  .  X  X  X  X  X  .  X  X
X  .  .  X  X  O  O  X  X  X  X  X
X  X  X  X  X  X  X  X  X  X  X  X


Press <Enter> to continue  ===>>

THE MAZE HAS NO SOLUTION.


Process completed.

--------------------Configuration: <Default>--------------------

Lab 29a 80/100 Point Version

Enter random starting seed  ===>>  25

RANDOM MAZE DISPLAY

O  X  X  X  X  X  X  X  X  X  X  X
X  O  O  X  O  O  X  X  X  X  X  X
X  O  O  X  O  X  O  X  O  O  O  X
X  X  X  O  O  X  X  O  O  O  X  X
X  X  X  X  O  O  O  O  O  X  O  X
X  X  X  X  O  O  O  X  X  X  X  X
X  O  X  O  X  X  O  X  O  X  O  X
X  X  X  X  X  O  O  X  X  X  O  X
X  X  X  O  O  X  X  O  O  X  O  X
X  O  X  X  O  O  O  X  O  O  O  X
X  X  X  X  X  O  O  X  O  X  O  .
X  X  X  X  X  X  X  X  X  X  X  X


Press <Enter> to continue  ===>>

>>>>>   WORKING  ....  SOLVING MAZE   <<<<<


RANDOM MAZE DISPLAY

.  X  X  X  X  X  X  X  X  X  X  X
X  .  .  X  .  .  X  X  X  X  X  X
X  .  .  X  .  X  .  X  .  .  .  X
X  X  X  .  .  X  X  .  .  .  X  X
X  X  X  X  .  .  .  .  .  X  .  X
X  X  X  X  .  .  .  X  X  X  X  X
X  O  X  O  X  X  .  X  O  X  .  X
X  X  X  X  X  .  O  X  X  X  .  X
X  X  X  O  .  X  X  .  .  X  .  X
X  O  X  X  .  .  .  X  .  .  .  X
X  X  X  X  X  .  .  X  .  X  .  .
X  X  X  X  X  X  X  X  X  X  X  X


Press <Enter> to continue  ===>>

THE MAZE HAS A SOLUTION.


Process completed.*/