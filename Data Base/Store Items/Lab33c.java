// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 9-19-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program creates a linked list from a text file of item names,
// upc codes, and quantities in order of upc codes. It displays the list
// then asks the user if they want to delete an item and displays the resulting list.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 1000 Version
// Lab33c.java

import java.io.*;
import java.util.Scanner;

public class Lab33c
{
   public static void main(String args[])throws IOException
	{
		LinkedList itemList = new LinkedList();
		Boolean action = true;

		itemList.ReadList("inventory.txt");
		itemList.DisplayList();

		while(action)
		{
			System.out.println("");
			System.out.println("1 - Add node");
			System.out.println("2 - Delete node");
			System.out.println("3 - Display list");
			System.out.println("4 - Exit");

			System.out.println("");
			System.out.println("Enter number of choice --> ");

			Scanner sc = new Scanner(System.in); //reads user input
			String answer =  sc.nextLine();

			if(answer.equals("1"))
			{
				System.out.println("");
				System.out.println("What item would you like to add?");
				System.out.println("Name --> ");
				String name =  sc.nextLine();
				System.out.println("UPC code --> ");
				String code =  sc.nextLine();
				System.out.println("Quantity --> ");
				String quantity =  sc.nextLine();
				itemList.newNode(name, Integer.parseInt(code), Integer.parseInt(quantity));//creates new node
				itemList.DisplayList();
			}
			else if(answer.equals("2"))
			{
				System.out.println("");
				System.out.println("What item would you like to delete? (Enter UPC code)");
				String DeletedCode =  sc.nextLine();
				itemList.deleteNode(DeletedCode);
				itemList.DisplayList();
			}
			else if(answer.equals("3"))
			{
				itemList.DisplayList();
			}
			else if(answer.equals("4"))
			{
				action = false;
			}
			else
			{
				System.out.println("Not an option.");
			}
		}

	}


}

class LinkedList
{
	private ListNode front;

	public LinkedList()
	{
		front = null;
	}

	public void ReadList(String file)throws IOException
	{
		String name;//name of item
		String code;//upc code of item
		String quantity;//quantity of item

		FileReader inFile = new FileReader(file);
		BufferedReader inStream = new BufferedReader(inFile);

		while((name = inStream.readLine()) != null && (code = inStream.readLine()) != null && (quantity = inStream.readLine()) != null)
		{
			newNode(name, Integer.parseInt(code), Integer.parseInt(quantity));//creates new node
		}
	}

	public void DisplayList()
	{
		ListNode p = null;//place holder to iterate through list

		if(front != null)
		{
			System.out.println("");
			System.out.println("Item - UPC code - Quantity");
			System.out.println("");
			p = front;

			while(p.getNext() != null)
			{
				System.out.println(p);
				p = p.getNext();
			}
		}
		else
		{
			System.out.println("");
			System.out.println("No items in the list.");
		}
	}

	public void newNode(String name, int code, int quantity)
	{
		ListNode node = new ListNode(name, code, quantity, null);//creates new node
		insertNode(node);
	}

	public void insertNode(ListNode NewNode)
	{
		ListNode p = null;//place holder to iterate through list
		ListNode t1 = null;//place holder to iterate through list
		ListNode t2 = null;//place holder to iterate through list

   	p = NewNode;

		if (front == null)
		{
			front = p;
		}
		else
		{
			if (p.getCode() < front.getCode())
			{
				p.setNext(front);
  				front = p;
			}
			else
			{
  				t1 = front;
   			while (t1 != null && p.getCode() > t1.getCode())
   			{
     				t2 = t1;
     				t1 = t1.getNext();
   			}
				t2.setNext(p);
				p.setNext(t1);
  	 		}
		}
	}

	public void deleteNode(String DeletedCode)
	{
		ListNode p = null;//place holder to iterate through list
		ListNode t = null;//place holder to iterate through list
		int deletedCode = Integer.parseInt(DeletedCode);//upc code of item to be deleted
		boolean found = false;//flag to alert when item is found

		if (front != null)
		{
			p = front;

			if (p.getCode() == deletedCode)
			{
				front = p.getNext();
				found = true;
			}
			else
			{
				t = p;
				p = p.getNext();

   			while (p != null && !found)
   			{
     				if(p.getCode() == deletedCode)
     				{
     					t.setNext(p.getNext());
     					found = true;
     				}
     				else
     				{
     					t = p;
     					p = p.getNext();
     				}
   			}
			}

			if(found)
			{
				System.out.println("");
				System.out.println("Item " + p.getCode() + " - " + p + " - " + " deleted");
			}
			else
			{
				System.out.println("");
				System.out.println("Item " + DeletedCode + " not found");
			}

		}
		else
		{
			System.out.println("");
			System.out.println("No items in the list.");
		}
	}
}

class ListNode
{
	private String name;//node item name
	private int code;//node item upc code
	private int quantity;//node item quantity
	private ListNode next;//node's pointer to next item in list

	public ListNode (String initName, int initCode, int initQuantity, ListNode initNext)
	{
		name = initName;
		code = initCode;
		quantity = initQuantity;
		next = initNext;
	}

	public String getName ()
	{
		return name;
	}

	public int getCode ()
	{
		return code;
	}

	public int getQuantity ()
	{
		return quantity;
	}

	public ListNode getNext ()
	{
		return next;
	}

	public void setName (String theNewName)
	{
		name = theNewName;
	}

	public void setCode (int theNewCode)
	{
		code = theNewCode;
	}

	public void setQuantity (int theNewQuantity)
	{
		quantity = theNewQuantity;
	}

	public void setNext (ListNode theNewNext)
	{
		next = theNewNext;
	}

	public String toString ()
	{
		return this.name + " - " + this.code + " - " + this.quantity;
	}
}

/*--------------------Configuration: <Default>--------------------

Item - UPC code - Quantity

Video Cards - 702345 - 13
CPUs - 1123422 - 30
Monitor - 1234567 - 5
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32
Webcam - 5456756 - 9

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
1\
Not an option.

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
1

What item would you like to add?
Name -->
dog
UPC code -->
123
Quantity -->
5

Item - UPC code - Quantity

dog - 123 - 5
Video Cards - 702345 - 13
CPUs - 1123422 - 30
Monitor - 1234567 - 5
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32
Webcam - 5456756 - 9

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
2

What item would you like to delete? (Enter UPC code)
1234567

Item 1234567 - Monitor - 1234567 - 5 -  deleted

Item - UPC code - Quantity

dog - 123 - 5
Video Cards - 702345 - 13
CPUs - 1123422 - 30
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32
Webcam - 5456756 - 9

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
2

What item would you like to delete? (Enter UPC code)
123

Item 123 - dog - 123 - 5 -  deleted

Item - UPC code - Quantity

Video Cards - 702345 - 13
CPUs - 1123422 - 30
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32
Webcam - 5456756 - 9

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
2

What item would you like to delete? (Enter UPC code)
5456756

Item 5456756 - Webcam - 5456756 - 9 -  deleted

Item - UPC code - Quantity

Video Cards - 702345 - 13
CPUs - 1123422 - 30
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
3

Item - UPC code - Quantity

Video Cards - 702345 - 13
CPUs - 1123422 - 30
RAM - 2534533 - 22
Speakers - 2696067 - 10
Mouse - 3345345 - 1
IP Phone - 3523467 - 6
Tower - 4464564 - 32

1 - Add node
2 - Delete node
3 - Display list
4 - Exit

Enter number of choice -->
4

Process completed.*/