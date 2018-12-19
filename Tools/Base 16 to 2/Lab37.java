// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 12-18-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program converts base 16 numbers to base 2 using a Map.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab37.java

import java.util.*;

public class Lab37
{
	public static void main (String args[])
	{

		String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] bin = {"0000","0001","0010","0011","0100","0101","0110","0111",
		                "1000","1001","1010","1011","1100","1101","1110","1111"};

		NumberSystems converter = new NumberSystems(hex,bin);

		Scanner input = new Scanner(System.in);

		boolean finished = false;
		do
		{
		    System.out.print("Enter a base 16 number or \"end\".  -->  ");
		    String base16num = input.nextLine();
		    if (base16num.equals("end"))
		        finished = true;
		    else if (converter.validB16(base16num))
		    {
			    String base2num = converter.getBinary(base16num);
			    System.out.println("\n" + base16num + " in hexadecimal converts to " + base2num + " in binary.\n");
  		    }
  		    else
  		    {
			    System.out.println("\nError, you did not enter a valid hexadecimal number.");
			    System.out.println("Valid hexadecimal numbers can only containt digits from 0-9 or letters from A-F.\n");
		    }
		}
		while (!finished);
	}

}


class NumberSystems
{

	private TreeMap<String, String> base;

	public NumberSystems(String[] key, String[] val)
	{
		base = new TreeMap<String, String>(); //map with base16 keys mapping to base2 values
		for(int x = 0; x < key.length; x++)
			base.put(key[x],val[x]);
	}

	public String getBinary(String base16num)
	{
		String base2num = "";

		for(int x = 0; x < base16num.length(); x++)
			base2num += base.get(Character.toString(base16num.charAt(x)));

		return base2num;
	}

	public boolean validB16(String base16num)
	{
		for(int x = 0; x < base16num.length(); x++)
		{
			if(base.get(Character.toString(base16num.charAt(x))) == null)
				return false;
		}
		return true;
	}
}

/*--------------------Configuration: <Default>--------------------
Enter a base 16 number or "end".  -->  11A2B

11A2B in hexadecimal converts to 00010001101000101011 in binary.

Enter a base 16 number or "end".  -->  ABE

ABE in hexadecimal converts to 101010111110 in binary.

Enter a base 16 number or "end".  -->  FEED98

FEED98 in hexadecimal converts to 111111101110110110011000 in binary.

Enter a base 16 number or "end".  -->  ABCDEFG

Error, you did not enter a valid hexadecimal number.
Valid hexadecimal numbers can only containt digits from 0-9 or letters from A-F.

Enter a base 16 number or "end".  -->  end

Process completed.
*/