/**
 * Myanna Harris
 *RandomAccessFile
 *2/27/13
 */

//contains all file-oriented classes and methods
import java.io.*;
import java.util.Scanner;

public class FileSorter {

    public static void main( String[] args ) throws IOException
    {
    	new FileSorter();
    }

    public FileSorter() throws IOException
    {
		RandomAccessFile ranFile = new RandomAccessFile("Items.dat","rw");
		create(ranFile);
		System.out.println("--- Records before sorting ---");
		display(ranFile);
		sort(ranFile);
		System.out.println("--- Records after sorting ---");
		display(ranFile);
		ranFile.close();
    }

    class Item // inner class simulates "records"
    {
    	//Contains fields that will written to and read from RAFile
    	String brand; //(2 bytes per character)
    	String type;
    	int barcode; //UUID (4 bytes)
    	String size;
    	double price; //(8 bytes)
    	String RentSale; //(2 bytes)

		final static int NameLength = 10;
    	final static int RecordSize = (10*2)*4 + 12; //constant used to calculate SEEK value

    	//Writes one record into ranFile, which must already be open
    	//IOExceptions are detected and reported
    	void writeToFile(RandomAccessFile ranFile, long recordNum)
    	{
    		try
    		{
    			ranFile.seek(recordNum * RecordSize);
    			ranFile.writeChars(setLength(brand, NameLength));
    			ranFile.writeChars(setLength(type, NameLength));
    			ranFile.writeInt(barcode);
    			ranFile.writeChars(setLength(size, NameLength));
    			ranFile.writeDouble(price);
    			ranFile.writeChars(setLength(RentSale, NameLength));
    		}
    		catch(IOException exc)
    		{
    			System.out.println("While writing " + exc.toString());
    		}
    	}

    	//Forces length of string to a specific value
    	//Necessary before writing into a random-access file
    	String setLength(String s, int len)
    	{
    		StringBuffer sb = new StringBuffer(s);
    		sb.setLength(len);
    		return sb.toString();
    	}

    	//Reads 1 record from ranFile, which must slready be open
 		//Reads each field - use TRIM to remove padding spaces
 		//IOExceptions are detected and reported
    	void readFromFile(RandomAccessFile ranFile, long recordNum)
    	{
    		try
    		{
    			ranFile.seek(recordNum * RecordSize);
    			StringBuffer nameBuffer = new StringBuffer(Item.NameLength);
    			nameBuffer.setLength(NameLength);

    			for(int c = 0; c < NameLength; c++)
    			{
    				nameBuffer.setCharAt(c, ranFile.readChar());
    			}
    			brand = nameBuffer.toString().trim();

    			for(int c = 0; c < NameLength; c++)
    			{
    				nameBuffer.setCharAt(c, ranFile.readChar());
    			}
    			type = nameBuffer.toString().trim();

    			barcode = ranFile.readInt();

    			for(int c = 0; c < NameLength; c++)
    			{
    				nameBuffer.setCharAt(c, ranFile.readChar());
    			}
    			size = nameBuffer.toString().trim();

    			price = ranFile.readDouble();

    			for(int c = 0; c < NameLength; c++)
    			{
    				nameBuffer.setCharAt(c, ranFile.readChar());
    			}
    			RentSale = nameBuffer.toString().trim();
    		}
    		catch(IOException exc)
    		{
				System.out.println("While reading record # " + recordNum);
				System.out.println(exc.toString());
    		}
    	}
    } //end of Item class

    //Puts records into ranFile, which must already be open
    void create(RandomAccessFile ranFile) throws IOException
    {
    	Item thisRec = new Item();
    	 Scanner scanner = new Scanner( System.in );

    	for (int c = 0; c < 2; c++)
    	{
    		System.out.print( "brand \n type \n barcode \n size \n price \n RentSale \n" );
    		thisRec.brand = scanner.nextLine();
    		thisRec.type = scanner.nextLine();
    		thisRec.barcode = Integer.parseInt(scanner.nextLine());
    		thisRec.size = scanner.nextLine();
    		thisRec.price = Double.parseDouble(scanner.nextLine());
    		thisRec.RentSale = scanner.nextLine();
    		thisRec.writeToFile(ranFile, c);
    	}
    }

    //Reads all records from ranFile and prints the fields
    void display(RandomAccessFile ranFile)
    {
    	try
    	{
    		long recordCount = ranFile.length() / Item.RecordSize;
    		Item thisRec = new Item();
    		for(int c = 0; c < recordCount; c++)
    		{
    			thisRec.readFromFile(ranFile, c);
    			System.out.println(thisRec.brand);
	    		System.out.println(thisRec.type);
	    		System.out.println(thisRec.barcode);
	    		System.out.println(thisRec.size);
	    		System.out.println(thisRec.price);
	    		System.out.println(thisRec.RentSale);
    		}
    	}
    	catch(IOException exc)
    	{
    		System.out.println(exc.toString());
    	}
    }

    //Bubble sort ranFile, sorting name fields in ascending order
    void sort(RandomAccessFile ranFile)
    {
    	try
    	{
    		long recordCount = ranFile.length() / Item.RecordSize;
    		Item thisRec = new Item();
    		Item nextRec = new Item();
    		for(int pass = 0; pass < recordCount; pass++)
    		{
    			for(int pos = 0; pos < recordCount-1; pos++)
    			{
    				thisRec.readFromFile(ranFile, pos);
    				nextRec.readFromFile(ranFile, pos+1);
    				if(thisRec.brand.compareTo(nextRec.brand)>0)
    				{
    					nextRec.writeToFile(ranFile, pos);
    					thisRec.writeToFile(ranFile, pos+1);
    				}
    			}
    		}
    	}
    	catch(IOException exc)
    	{
    		System.out.println(exc.toString());
    	}
    }
}

/*--------------------Configuration: <Default>--------------------
brand
 type
 barcode
 size
 price
 RentSale
K2
Snowboard
10101010
143
34.00
S
brand
 type
 barcode
 size
 price
 RentSale
Atomic
Snowboard
71827364
155
54.00
S
--- Records before sorting ---
K2
Snowboard
10101010
143
34.0
S
Atomic
Snowboard
71827364
155
54.0
S
--- Records after sorting ---
Atomic
Snowboard
71827364
155
54.0
S
K2
Snowboard
10101010
143
34.0
S

Process completed.*/