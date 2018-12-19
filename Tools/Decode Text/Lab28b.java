// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 15-2-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program decodes 4 lines of text read froma textfile
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab28b.java

import java.io.*;
import java.util.Scanner;

public class Lab28b
{
	public static void main (String args[]) throws IOException
	{
		Decode topSecret = new Decode();
		topSecret.readFromFile();
		topSecret.displayEncodedText();
		topSecret.enterKey();
		topSecret.decodeText();
		topSecret.displayOriginalText();
	}
}

class Decode
{
	private String line1, line2, line3, line4;
	private String codeLine1, codeLine2, codeLine3, codeLine4;
	private String key;

	public Decode()
	{
		codeLine1 = line1 = codeLine2 = line2 = codeLine3 = line3 = codeLine4 = line4 = "";
	}

	public void displayOriginalText()
	{
		System.out.println("The original uncoded message is:\n");
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
		System.out.println();
	}

	public void enterKey()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter key --> ");
		// For the 100-point version, the "key" is a word.
		key = input.nextLine();
	}

	public String decodeLine(String encodeLine)
	{
		String codeU = ""; //the code that is being uncoded
		int diff = 0; //the difference between the key and 65
		int dummy = 0; //the temporary holder for the ASC value
		for(int x=0; x<encodeLine.length();x++)//cycles through the encoded line's characters
		{
			diff = (((int)key.charAt(x%key.length()))-65);
			dummy =(((int)encodeLine.charAt(x))-diff);
			if(dummy<32)
					dummy+=96;
			codeU+= (char)dummy;
		}
		return codeU;
	}

	public void decodeText()
	{
		System.out.println("\nDecoding the Text\n");
		line1 = decodeLine(codeLine1);
		line2 = decodeLine(codeLine2);
		line3 = decodeLine(codeLine3);
		line4 = decodeLine(codeLine4);
	}

	public void displayEncodedText()
	{
		System.out.println("The ENCODED message is:\n");
		System.out.println(codeLine1);
		System.out.println(codeLine2);
		System.out.println(codeLine3);
		System.out.println(codeLine4);
		System.out.println();
	}

	public void readFromFile() throws IOException
	{
		BufferedReader inStream = new BufferedReader(new FileReader("code.dat"));
		System.out.println("Loading coded message\n");
		codeLine1=inStream.readLine();
		codeLine2=inStream.readLine();
		codeLine3=inStream.readLine();
		codeLine4=inStream.readLine();
		inStream.close();
	}
}

/*--------------------Configuration: <Default>--------------------
Loading coded message

The ENCODED message is:

W'( y}fw8(o{l#&'&lp(d// op(fw-tk,kk${|
x~1a,r~|1ct}fz8(o!tg/{yuos#&' dK
W}1w{}os8th!kn//ya (d// op(fw-tk,KRddU
x~1a,r~|1ct}fz8(o!tg/{yuos#&' d:

Enter key --> PYRAMID

Decoding the Text

The original uncoded message is:

How much wood would a wood chuck chuck
if a wood chuck would chuck wood?
He would chuck what a wood chuck COULD
if a wood chuck would chuck wood.


Process completed.*/