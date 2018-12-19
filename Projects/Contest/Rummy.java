/**
 * @(#)Rummy.java
 *
 *
 * @author
 * @version 1.00 2013/4/12
 */

import java.util.Scanner;

public class Rummy
{
    public static void main(String args[])
    {
    	boolean gameOver = false;
    	boolean run1 = false;
    	boolean run2 = false;
    	boolean set1 = false;
    	boolean set2 = false;

    	String[] hand = new String[7];
    	String[] deck = new String[5];

    	Scanner scanner = new Scanner( System.in );

    	System.out.println("Enter cards in hand");
    	String handTemp = scanner.nextLine();
    	hand = handTemp.split(", ");

    	System.out.println("Enter cards in deck on separate lines");
    	for(int x = 0; x < 5; x++)
    		deck[x] = scanner.nextLine();


    }
}