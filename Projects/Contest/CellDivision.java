/**
 * @(#)CellDivision.java
 *
 *
 * @author
 * @version 1.00 2013/2/4
 */

import java.util.Scanner;
import java.lang.Character;
import java.io.*;

public class CellDivision
{
    public static void main (String args[])
	 {
	 	String cell1 = "";
	 	String cell2 = "";
	 	int number;
	 	boolean check = true;

		while (check)
		{
			System.out.println("Enter: operation, cell");
		 	Scanner sc = new Scanner(System.in);
	     	String s = sc.nextLine();

	     	switch(s.charAt(0))
	     	{
	     		case 'A': cell1 = s.substring(6);
	     					number = Integer.parseInt(((Character)(s.charAt(3))).toString());
	     					String t = "";
	     					if(number < 4)
	     						t = cell1.substring(number,8-number);
	     					System.out.println(cell1.substring(0,number) + sort(cell1.substring(0,number)) + t);
	     			break;
	     		case 'D': cell1 = s.substring(8);
	     					String c1 = sort(cell1.substring(0,4));
	     					System.out.println(c1 + c1);
	     					String c2 = sort(cell1.substring(4));
	     					System.out.println(c2 + c2);
	     			break;
	     		case 'S': cell1 = s.substring(11);
	     					number = Integer.parseInt(((Character)(s.charAt(8))).toString());
	     					System.out.println(cell1.substring(number) + sort(cell1.substring(8-number)));
	     			break;
	     		case 'U': cell1 = s.substring(7, 15);
	     					cell2 = s.substring(17);
	     					System.out.println(sort(cell1.substring(4,8)) + sort(cell2.substring(0,4)));
	     			break;
	     		case 'I': cell1 = s.substring(11, 19);
	     					cell2 = s.substring(21);
	     					System.out.println(sort(cell1.substring(0, 2)+cell1.substring(6, 8)) + sort(cell2.substring(0, 2)+cell2.substring(6, 8)));
	     			break;
	     	}

	     	System.out.println("Enter 'Stop' to end program else hit enter");
	     	s = sc.nextLine();
	     	if(s.equals("Stop"))
	     		check = false;
		}
    }

    public static String sort(String temp)
    {
    	boolean flag = true;
    	char[] letters = temp.toCharArray();

    	while(flag)
    	{
    		flag = false;
			for(int x = 0; x<letters.length-1; x++)
			{
				if(letters[x] > letters[x+1])
				{
					char t = letters[x];
					letters[x] = letters[x+1];
					letters[x+1] = t;
					flag = true;
				}
			}
    	}

		temp = "";
    	for(int x = 0; x<letters.length; x++)
    		temp += letters[x];

    	return temp;
    }
}