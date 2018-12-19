// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 3-21-12
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program uses a stack class that I made with an Arraylist
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// in the program
// ***********************************************
// 100 Version
// Lab29b.java

import java.util.ArrayList;

public class Lab29b {

    public static void main (String args[])
	{
		System.out.println("Lab29b 100 Point Version\n");
		MyStack students = new MyStack();
		String student;

		System.out.println("Testing the <push> method");
		students.push("Luke Watts");
		students.push("Brian Sims");
		students.push("Mike Lewis");
		students.push("Jessie Lin");
		System.out.println();

		MyStack students2 = new MyStack(students);


		System.out.println("Testing the <peek> method");
		student = (String) students.peek();
		System.out.println(student + " is at the top of the stack");
		System.out.println();

		System.out.println("Testing the <isEmpty> and <pop> methods");
		while (!students.isEmpty())
		{
			student = (String) students.pop();
			System.out.println("Popping " + student + " from the stack");
		}

		System.out.println("\nTesting the copy constructor");
		while (!students2.isEmpty())
		{
			student = (String) students2.pop();
			System.out.println("Popping " + student + " from the stack");
		}
		System.out.println();
	}
}

class MyStack<E>
{

	private ArrayList<E> data;	//stores stack data
	private int top;				//keeps index of the stack top

	public MyStack()
	{
		data = new ArrayList<E>();
		top = -1;
	}

	public MyStack(MyStack stack)
	{
		this.data = new ArrayList<E>(stack.data);
		top = stack.getSize();
	}

	public boolean isEmpty()
	{
		return top == -1;
	}

	public int getSize()
	{
		return top;
	}

	public void push (E x)
	{
		data.add(x);
		top++;
	}

	public E pop()
	{
		int temp = top; //temporarily holds index of top
		top--;
		return data.remove(temp);

	}

	public E peek()
	{
		return data.get(top);
	}

}

/*--------------------Configuration: <Default>--------------------
Lab29b 100 Point Version

Testing the <push> method

Testing the <peek> method
Jessie Lin is at the top of the stack

Testing the <isEmpty> and <pop> methods
Popping Jessie Lin from the stack
Popping Mike Lewis from the stack
Popping Brian Sims from the stack
Popping Luke Watts from the stack

Testing the copy constructor
Popping Jessie Lin from the stack
Popping Mike Lewis from the stack
Popping Brian Sims from the stack
Popping Luke Watts from the stack


Process completed.*/