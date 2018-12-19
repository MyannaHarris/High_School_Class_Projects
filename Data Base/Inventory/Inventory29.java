// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 15-2-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program reads in a textfile with item inventory info
// and puts the info in a stack. Then the info is sorted into
// two stacks. One has items that need to be reordered.
// The items that need to be reordered are printed out.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// InventoryLab.java

import java.util.*;
import java.io.*;

public class Inventory29 {

    public static void main(String[] args) throws IOException
    {
    	Stack<item> Inventory = new Stack<item>(); //original inventory stack
    	Stack<item> lowInventory = new Stack<item>(); //stack of inventory that needs to be reordered
    	Stack<item> doNotOrder = new Stack<item>(); //stack of inventory that doesn't need to be reordered

    	String fileName = "inventory29st.txt"; //the name of the file being read
		String name = ""; //temporarily holds the item name being read in from the textfile
		String number = ""; //temporarily holds the UPC number being read in from the textfile
		String amount = ""; //temporarily holds the amount being read in from the textfile
		BufferedReader inStream = new BufferedReader(new FileReader(fileName));
		while(((name = inStream.readLine()) != null) && ((number = inStream.readLine()) != null) && ((amount = inStream.readLine()) != null))
		{
			item temp = new item(name,number,Integer.parseInt(amount)); //temporary object to be placed on stack
			Inventory.push(temp);
		}
		inStream.close();

		while (!Inventory.isEmpty())
		{
			item itemTemp = Inventory.pop();
			if (itemTemp.itemAmount<10)
				lowInventory.push(itemTemp);
			else
				doNotOrder.push(itemTemp);
		}

		if (!lowInventory.isEmpty())
		{
			System.out.println("Time to reorder: \n");
			while (!lowInventory.isEmpty())
			{
				System.out.println(lowInventory.pop());
			}
		}
    }
}

class item
{
	String itemName; //name of item
	String UPCnumber; //UPC number of item
	int itemAmount; //amount of item in inventory

	public item(String name, String number, int amount)
	{
		itemName = name;
		UPCnumber = number;
		itemAmount = amount;
	}

	public String toString()
	{
		return "Item: " + itemName + "\nUPC #: " + UPCnumber + "\nAmount: " + itemAmount + "\n";
	}
}

/*--------------------Configuration: <Default>--------------------
Time to reorder:

Item: Monitor
UPC #: 1234567
Amount: 5

Item: Mouse
UPC #: 3345345
Amount: 1

Item: Webcam
UPC #: 5456756
Amount: 9

Item: IP Phone
UPC #: 3523467
Amount: 6


Process completed.*/