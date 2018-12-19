// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-14-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program makes stack, queue, set, and ordered list data
// structures with static arrays
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab31.java
import java.util.Random;

public class Lab31a
{
	public static void main(String args[])
	{
		System.out.println("\nLab31 100 Point Version\n");
		MyList list1 = new MyStack(100);
		MyList list2 = new MyQueue(100);
		MyList list3 = new MySet(100);
		MyList list4 = new MyOrdList(100);
		Random rnd = new Random(12345);
		for (int k = 1; k <= 20; k++)
		{
			int rndInt = rnd.nextInt(20) + 10;
			addData(list1,rndInt);
			addData(list2,rndInt);
			addData(list3,rndInt);
			addData(list4,rndInt);
		}
		showData(list1,list2,list3,list4);
		System.out.println();

		for (int k = 1; k <= 5; k++)
		{
			removeData(list1);
			removeData(list2);
			removeData(list3);
			removeData(list4);
		}
		showData(list1,list2,list3,list4);
		System.out.println();
	}

	public static void addData(MyList type,int x)
	{
		type.add(x);
	}

	public static void showData(MyList type1, MyList type2,MyList type3, MyList type4)
	{
		System.out.println(type1);
		System.out.println(type2);
		System.out.println(type3);
		System.out.println(type4);
	}

	public static void removeData(MyList type)
	{
		type.remove();
	}
}

abstract interface MyList
{
	public abstract void add(int x);

	public abstract int remove();

	public abstract boolean isEmpty();

	public abstract int getSize();
}

class MyStack implements MyList
{
	private int stack[];//stack static array
	private int size;//number of data pieces in data structure

	public MyStack(int c)
	{
		stack = new int[c];
		size = 0;
	}

	public void add(int x)
	{
		if(!isEmpty())
			for(int a = size;a>0;a--)
				stack[a] = stack[a-1];
		stack[0] = x;
		size++;
	}

	public int remove()
	{
		int temp = stack[0];//temp holder for removed piece of data
		if(size>1)
			for(int a = 1;a<size;a++)
				stack[a-1] = stack[a];
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if (size>0)
			return false;
		else
			return true;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output = "[";//holds string to be outputted as it is formatted
		output += stack[0];
		for(int a = 1;a<size;a++)
			output += "," + stack[a];
		output += "]";
		return output;
	}
}

class MyQueue implements MyList
{
	private int queue[];//queue static array
	private int size;//number of data pieces in data structure

	public MyQueue(int c)
	{
		queue = new int[c];
		size = 0;
	}

	public void add(int x)
	{
		queue[size] = x;
		size++;
	}

	public int remove()
	{
		int temp = queue[0];//temp holder for removed piece of data
		if(!isEmpty())
			for(int a = 1;a<size;a++)
				queue[a-1] = queue[a];
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if (size>0)
			return false;
		else
			return true;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output = "[";//holds string to be outputted as it is formatted
		output += queue[0];
		for(int a = 1;a<size;a++)
			output += "," + queue[a];
		output += "]";
		return output;
	}
}

class MySet implements MyList
{
	private int set[];//set static array
	private int size;//number of data pieces in data structure

	public MySet(int c)
	{
		set = new int[c];
		size = 0;
	}

	public void add(int x)
	{
		boolean copy = false;
		if (!isEmpty())
		{
			for(int a = 0;a<size;a++)
				if (set[a]==x)
					copy = true;
		}
		if(copy == false)
		{
			set[size] = x;
			size++;
		}
	}

	public int remove()
	{
		int temp = set[0];//temp holder for removed piece of data
		if(!isEmpty())
			for(int a = 1;a<size;a++)
				set[a-1] = set[a];
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if (size>0)
			return false;
		else
			return true;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output = "[";//holds string to be outputted as it is formatted
		output += set[0];
		for(int a = 1;a<size;a++)
			output += "," + set[a];
		output += "]";
		return output;
	}
}

class MyOrdList implements MyList
{
	private int ordList[];//ordered list static array
	private int size;//number of data pieces in data structure

	public MyOrdList(int c)
	{
		ordList = new int[c];
		size = 0;
	}

	public void add(int x)
	{
		boolean greater = false;
		int greaterIndex = 0;
		int a = 0;
		if (!isEmpty())
		{
			while (!greater && a<size)
			{
				if (ordList[a]>x)
				{
					greater = true;
					greaterIndex = a;
				}
				else
					a++;
			}
		}
		if(greater == true)
		{
			for(int b = size;b>=a;b--)
			{
				ordList[b+1] = ordList[b];
			}

			ordList[a] = x;
			size++;
		}
		else
		{
			ordList[size] = x;
			size++;
		}
	}

	public int remove()
	{
		int temp = ordList[0];//temp holder for removed piece of data
		if(!isEmpty())
			for(int a = 1;a<size;a++)
				ordList[a-1] = ordList[a];
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if (size>0)
			return false;
		else
			return true;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output = "[";//holds string to be outputted as it is formatted
		output += ordList[0];
		for(int a = 1;a<size;a++)
			output += "," + ordList[a];
		output += "]";
		return output;
	}
}

/*--------------------Configuration: <Default>--------------------

Lab31 100 Point Version

[25,22,13,17,14,22,16,20,12,27,19,11,12,25,14,25,18,11,10,21]
[21,10,11,18,25,14,25,12,11,19,27,12,20,16,22,14,17,13,22,25]
[21,10,11,18,25,14,12,19,27,20,16,22,17,13]
[10,11,11,12,12,13,14,14,16,17,18,19,20,21,22,22,25,25,25,27]

[22,16,20,12,27,19,11,12,25,14,25,18,11,10,21]
[14,25,12,11,19,27,12,20,16,22,14,17,13,22,25]
[14,12,19,27,20,16,22,17,13]
[13,14,14,16,17,18,19,20,21,22,22,25,25,25,27]


Process completed.*/