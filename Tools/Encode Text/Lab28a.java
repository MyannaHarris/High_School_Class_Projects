// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 15-2-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program encodes 4 lines of text and writes them to a text file
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab28a.java

import java.io.*;
import java.util.Scanner;

public class Lab28a
{
	public static void main (String args[]) throws IOException
	{
		String line1 = "How much wood would a wood chuck chuck";
		String line2 = "if a wood chuck would chuck wood?";
		String line3 = "He would chuck what a wood chuck COULD";
		String line4 = "if a wood chuck would chuck wood.";

		Encode topSecret = new Encode(line1, line2, line3, line4);
		topSecret.displayOriginalText();
		topSecret.enterKey();
		topSecret.encodeText();
		topSecret.displayEncodedText();
		topSecret.writeToFile();
	}
}



class Encode
{
	private String line1, line2, line3, line4;
	private String codeLine1, codeLine2, codeLine3, codeLine4;
	private String key;

	public Encode(String ln1, String ln2, String ln3, String ln4)
	{
		codeLine1 = line1 = ln1;
		codeLine2 = line2 = ln2;
		codeLine3 = line3 = ln3;
		codeLine4 = line4 = ln4;
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

	public String encodeLine(String line)
	{
		String codeB = ""; //the line od code as it is being built
		int dummy = 0; //the temporary holder for the ASC value
		int k = 0; //cycles through the key's characters
		for(int x=0; x<line.length();x++) //cycles through the line's characters
		{
			if(key.length()==k)
				k = 0;
			dummy = ((int)line.charAt(x)+(int)key.charAt(k));
			while(dummy>127)
			{
				dummy-=95;
			}
			while(dummy<32)
			{
				dummy+=95;
			}
			codeB+=(char)dummy;
			k++;
		}
		return codeB;
	}

	public void encodeText()
	{
		System.out.println("\nEncoding the Text\n");
		codeLine1 = encodeLine(line1);
		codeLine2 = encodeLine(line2);
		codeLine3 = encodeLine(line3);
		codeLine4 = encodeLine(line4);
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

	public void writeToFile() throws IOException
	{
		BufferedWriter outStream = new BufferedWriter(new FileWriter("code.dat"));
		System.out.println("Saving coded message\n");
		outStream.write(codeLine1);
		outStream.newLine();
		outStream.write(codeLine2);
		outStream.newLine();
		outStream.write(codeLine3);
		outStream.newLine();
		outStream.write(codeLine4);
		outStream.close();
	}
}

/*--------------------Configuration: <Default>--------------------
The original uncoded message is:

How much wood would a wood chuck chuck
if a wood chuck would chuck wood?
He would chuck what a wood chuck COULD
if a wood chuck would chuck wood.

Enter key --> PYRAMID

Encoding the Text

The ENCODED message is:

9ija[_HYyjQ]NdhihNRiFpqbQRiHYoVMmMMf]^
Z`rCmaT`^rEV_H\yjQcVIp][WQUdhibF-
9_rY]_QUyVJcMPpq[CbiFpqbQRiHYoVMm-4FF7
Z`rCmaT`^rEV_H\yjQcVIp][WQUdhibF{

Saving coded message


Process completed.
*/