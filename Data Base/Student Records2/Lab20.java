// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 10-5-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// This program imports a list of students names, their ages, their ID,
// and their gpa. Then it sorts them by gpa. Then the user inputs
// info for a new student and that is put, sorted, into the list.
// Then it deletes the failing students. Then checks the newstudents
// index and compares the top 3 students and finally empties the
// ArrayList
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// List() --> a List class object
// input --> represents the user inputing at the keyboard
// name --> represents a students name
// id --> represents a students id number
// gpa --> represents a students gpa
// age --> represents a students age
// student --> ArrayList of Person objects
// newKid --> represents a new student that's a Person object
// k, p, q, x --> represents a counter variable
// dummy --> represents a temporary holder
// found --> represents if what is being looked for is found or not
// n --> represents the size of the students
// in1, in2 --> represents the divided student ArrayList
// ***********************************************
// Lab20.java
// 110 Version

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Lab20
{
	public static void main(String args[]) throws IOException
	{
		List studentArray = new List();
		studentArray.getList();
		studentArray.checkIfEmpty();
		studentArray.pause();

		studentArray.display("UNSORTED LIST OF STUDENTS");
		studentArray.pause();

		studentArray.gpaSort();
		studentArray.display("STUDENTS SORTED IN DESCENDING ORDER BY GPA");
		studentArray.pause();

		Person thisPerson = getPerson();
		studentArray.insert(thisPerson);

		studentArray.display("STUDENTS SORTED BY GPA WITH NEW STUDENT ADDED");
		studentArray.pause();

		studentArray.removeFailing();

		studentArray.display("STUDENTS SORTED BY GPA WITH FAILING STUDENTS REMOVED");
		studentArray.pause();

		int index = studentArray.search(thisPerson);
		if (index == -1)
		    System.out.println(thisPerson.name + " is not in the list.\n");
		else
			System.out.println(thisPerson.name + " is in the list at index "+index+".\n");

		studentArray.compareTop3();
		studentArray.removeAll();
		studentArray.checkIfEmpty();
	}

	public static Person getPerson()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter name:  -->  ");
		String name =  input.nextLine();
		System.out.print("Enter id:    -->  ");
		int id = input.nextInt();
		System.out.print("Enter age:   -->  ");
		int age = input.nextInt();
		System.out.print("Enter gpa:   -->  ");
		double gpa = input.nextDouble();
		return new Person(name,id,age,gpa);

	}
}


class Person
{
	public String name;
	public int id;
	public int age;
	public double gpa;

	Person(String n, int ID, int a,double g)
	{
		name = n;
		id = ID;
		age = a;
		gpa = g;
	}

	public String toString()
	{
		return "Name: " + name + "\nID#:  " + id + "\nAge:  " + age + "\nGPA:  " + gpa + "\n";
	}

	public boolean equals(Person temp)
	{
		return this.gpa == temp.gpa && this.age == temp.age;
	}
}

class List
{
	private ArrayList<Person> student = new ArrayList<Person>();	// stores array elements

	public List()
	{

	}

	public void getList() throws IOException
	{
		// It will read in the information from the file, and put the information into the ArrayList.

		FileReader inFile = new FileReader("students2.dat");
		BufferedReader inStream = new BufferedReader(inFile);
		String s1,s2,s3,s4;
		int age, id;
		double gpa;
		while( ((s1 = inStream.readLine()) != null) &&
			   ((s2 = inStream.readLine()) != null) &&
			   ((s3 = inStream.readLine()) != null) &&
			   ((s4 = inStream.readLine()) != null) )
		{
			String name = s1;
			id = Integer.parseInt(s2);
			age = Integer.parseInt(s3);
			gpa = Double.parseDouble(s4);

			Person newKid = new Person(name,id,age,gpa);

			student.add(newKid);
		}
		inStream.close();
	}


	public void display(String listInfo)
	{
		// This method requires that the toString method of the person class is written
		System.out.println("\nDISPLAYING "+ listInfo);
		System.out.println();

		for (int k = 0; k < student.size(); k++)
			System.out.println(student.get(k));
	}

	public void pause()
	{
		Scanner input = new Scanner(System.in);
		String dummy;
		System.out.println("\nPress <Enter> to continue.");
		dummy = input.nextLine();
	}

	private void swap(int x, int y)
	{
		Person dummy;
		dummy = student.get(x);
		student.set(x,student.get(y));
		student.set(y,dummy);
	}

	public void gpaSort()
	{
		// NOTE: This method is provided for you,
		//       but it will not work if you have not written the swap method

		for (int p = 1; p < student.size(); p++)
			for (int q = 0; q < student.size()-p; q++)
			{
				Person thisOne = (Person) student.get(q);
				Person nextOne = (Person) student.get(q+1);
				if (thisOne.gpa < nextOne.gpa)
					swap(q,q+1);
			}
	}

	public int search(Person thisPerson)
	{
		int x = 0;
		boolean found = false;
		while ((x<student.size())&&(!found))
		{
			if (thisPerson.equals(student.get(x)))
				found = true;
			else
				x++;
		}
		if (found == true)
		 	return x;
		else
			return -1;
	}

	public void insert(Person newStudent)
	{
		// precondition: The student list is not empty

		// NOTE: The 110 point version requires that the new student is inserted into
		//       its proper position in an ArrayList sorted by GPA in decending order.
		//	     All other versions, simply require that the new student is inserted
		//       at the beginning of the list.

		if (!student.isEmpty())
		{
			int x = 0;
			boolean found = false;
			if (!student.isEmpty())
			{
			while ((x<(student.size()-1)) && (!found))
			{
				Person temp = student.get(x);
				if (temp.gpa < newStudent.gpa)
				{
					found = true;
				}
				else
					x++;
			}
			student.add(x,newStudent);
			}
		}
	}

	public void removeFailing()
	{
		// HINT: Remember, the list will be sorted in DECENDING order.
		int x = 0;
		while (x<student.size())
		{
			if((student.get(x)).gpa<2)
				student.remove(x);
			else
				x++;
		}
	}

	public void removeAll()
	{
		student.clear();
	}

	public void compareTop3()
	{
		// NOTE: This method is provided for you,
		//       but it will not work if you have not written the equals method of the Person class.

		Person first, second, third;
		first  = (Person) student.get(0);
		second = (Person) student.get(1);
		third  = (Person) student.get(2);

		if (first.equals(second))
		    System.out.println(first.name+" and "+second.name+" are equal.\n");
		if (first.equals(third))
		    System.out.println(first.name+" and "+third.name+" are equal.\n");
		if (third.equals(second))
		    System.out.println(third.name+" and "+second.name+" are equal.\n");
	}

	public void checkIfEmpty()
	{
		 if (student.isEmpty())
		 	System.out.println("This list is empty.");
		 else
		 	System.out.println("This list is not empty.");
	}
}

/*--------------------Configuration: <Default>--------------------
This list is not empty.

Press <Enter> to continue.


DISPLAYING UNSORTED LIST OF STUDENTS

Name: Bart Reagor
ID#:  123456
Age:  27
GPA:  2.075

Name: Kristyn Reckner
ID#:  234567
Age:  19
GPA:  3.225

Name: Paul Reiman
ID#:  345678
Age:  45
GPA:  4.0

Name: Andy Reitinger
ID#:  456789
Age:  20
GPA:  3.525

Name: William Reynolds
ID#:  567890
Age:  50
GPA:  3.375

Name: William Robbins
ID#:  460064
Age:  34
GPA:  2.875

Name: Brian Roberts
ID#:  811811
Age:  23
GPA:  3.175

Name: Lauri Robertson
ID#:  119010
Age:  19
GPA:  2.925

Name: Richardson Robinson
ID#:  203203
Age:  26
GPA:  3.21

Name: Laurie Rosemberg
ID#:  976976
Age:  45
GPA:  4.0

Name: Barbara Salsa
ID#:  777777
Age:  18
GPA:  3.0

Name: Lori Salbury
ID#:  212121
Age:  23
GPA:  3.455

Name: Ann Seaborn
ID#:  313131
Age:  56
GPA:  1.785

Name: Diane Simcox
ID#:  987654
Age:  32
GPA:  2.175

Name: Kevin Sims
ID#:  876543
Age:  67
GPA:  3.235

Name: Michael Ward
ID#:  765432
Age:  19
GPA:  3.451

Name: Cheryl Willis
ID#:  654321
Age:  37
GPA:  3.576

Name: Tracy Springer
ID#:  334213
Age:  41
GPA:  2.305

Name: Mary Pridgen
ID#:  567765
Age:  19
GPA:  1.957

Name: Steven Johnson
ID#:  681968
Age:  34
GPA:  0.785

Name: Nancy Barone
ID#:  911072
Age:  25
GPA:  2.975

Name: Tom Tooch
ID#:  751977
Age:  26
GPA:  1.456

Name: Patti Skinner
ID#:  671983
Age:  47
GPA:  2.743

Name: Diana Rockel
ID#:  429067
Age:  56
GPA:  3.456

Name: Michelle Ritter
ID#:  491967
Age:  25
GPA:  4.0

Name: Mali Cozart
ID#:  720097
Age:  16
GPA:  2.345

Name: Mike Bruun
ID#:  321456
Age:  19
GPA:  1.783

Name: Todd Deans
ID#:  654789
Age:  22
GPA:  2.023

Name: Laura Collins
ID#:  876890
Age:  30
GPA:  3.999

Name: Debbie Mozart
ID#:  342517
Age:  40
GPA:  2.999

Name: Gordon Collins
ID#:  545632
Age:  25
GPA:  3.1

Name: Susan Craft
ID#:  551212
Age:  29
GPA:  3.754

Name: Vance Brawner
ID#:  662323
Age:  31
GPA:  3.678


Press <Enter> to continue.


DISPLAYING STUDENTS SORTED IN DESCENDING ORDER BY GPA

Name: Paul Reiman
ID#:  345678
Age:  45
GPA:  4.0

Name: Laurie Rosemberg
ID#:  976976
Age:  45
GPA:  4.0

Name: Michelle Ritter
ID#:  491967
Age:  25
GPA:  4.0

Name: Laura Collins
ID#:  876890
Age:  30
GPA:  3.999

Name: Susan Craft
ID#:  551212
Age:  29
GPA:  3.754

Name: Vance Brawner
ID#:  662323
Age:  31
GPA:  3.678

Name: Cheryl Willis
ID#:  654321
Age:  37
GPA:  3.576

Name: Andy Reitinger
ID#:  456789
Age:  20
GPA:  3.525

Name: Diana Rockel
ID#:  429067
Age:  56
GPA:  3.456

Name: Lori Salbury
ID#:  212121
Age:  23
GPA:  3.455

Name: Michael Ward
ID#:  765432
Age:  19
GPA:  3.451

Name: William Reynolds
ID#:  567890
Age:  50
GPA:  3.375

Name: Kevin Sims
ID#:  876543
Age:  67
GPA:  3.235

Name: Kristyn Reckner
ID#:  234567
Age:  19
GPA:  3.225

Name: Richardson Robinson
ID#:  203203
Age:  26
GPA:  3.21

Name: Brian Roberts
ID#:  811811
Age:  23
GPA:  3.175

Name: Gordon Collins
ID#:  545632
Age:  25
GPA:  3.1

Name: Barbara Salsa
ID#:  777777
Age:  18
GPA:  3.0

Name: Debbie Mozart
ID#:  342517
Age:  40
GPA:  2.999

Name: Nancy Barone
ID#:  911072
Age:  25
GPA:  2.975

Name: Lauri Robertson
ID#:  119010
Age:  19
GPA:  2.925

Name: William Robbins
ID#:  460064
Age:  34
GPA:  2.875

Name: Patti Skinner
ID#:  671983
Age:  47
GPA:  2.743

Name: Mali Cozart
ID#:  720097
Age:  16
GPA:  2.345

Name: Tracy Springer
ID#:  334213
Age:  41
GPA:  2.305

Name: Diane Simcox
ID#:  987654
Age:  32
GPA:  2.175

Name: Bart Reagor
ID#:  123456
Age:  27
GPA:  2.075

Name: Todd Deans
ID#:  654789
Age:  22
GPA:  2.023

Name: Mary Pridgen
ID#:  567765
Age:  19
GPA:  1.957

Name: Ann Seaborn
ID#:  313131
Age:  56
GPA:  1.785

Name: Mike Bruun
ID#:  321456
Age:  19
GPA:  1.783

Name: Tom Tooch
ID#:  751977
Age:  26
GPA:  1.456

Name: Steven Johnson
ID#:  681968
Age:  34
GPA:  0.785


Press <Enter> to continue.


Enter name:  -->  j
Enter id:    -->  123
Enter age:   -->  3
Enter gpa:   -->  1.5

DISPLAYING STUDENTS SORTED BY GPA WITH NEW STUDENT ADDED

Name: Paul Reiman
ID#:  345678
Age:  45
GPA:  4.0

Name: Laurie Rosemberg
ID#:  976976
Age:  45
GPA:  4.0

Name: Michelle Ritter
ID#:  491967
Age:  25
GPA:  4.0

Name: Laura Collins
ID#:  876890
Age:  30
GPA:  3.999

Name: Susan Craft
ID#:  551212
Age:  29
GPA:  3.754

Name: Vance Brawner
ID#:  662323
Age:  31
GPA:  3.678

Name: Cheryl Willis
ID#:  654321
Age:  37
GPA:  3.576

Name: Andy Reitinger
ID#:  456789
Age:  20
GPA:  3.525

Name: Diana Rockel
ID#:  429067
Age:  56
GPA:  3.456

Name: Lori Salbury
ID#:  212121
Age:  23
GPA:  3.455

Name: Michael Ward
ID#:  765432
Age:  19
GPA:  3.451

Name: William Reynolds
ID#:  567890
Age:  50
GPA:  3.375

Name: Kevin Sims
ID#:  876543
Age:  67
GPA:  3.235

Name: Kristyn Reckner
ID#:  234567
Age:  19
GPA:  3.225

Name: Richardson Robinson
ID#:  203203
Age:  26
GPA:  3.21

Name: Brian Roberts
ID#:  811811
Age:  23
GPA:  3.175

Name: Gordon Collins
ID#:  545632
Age:  25
GPA:  3.1

Name: Barbara Salsa
ID#:  777777
Age:  18
GPA:  3.0

Name: Debbie Mozart
ID#:  342517
Age:  40
GPA:  2.999

Name: Nancy Barone
ID#:  911072
Age:  25
GPA:  2.975

Name: Lauri Robertson
ID#:  119010
Age:  19
GPA:  2.925

Name: William Robbins
ID#:  460064
Age:  34
GPA:  2.875

Name: Patti Skinner
ID#:  671983
Age:  47
GPA:  2.743

Name: Mali Cozart
ID#:  720097
Age:  16
GPA:  2.345

Name: Tracy Springer
ID#:  334213
Age:  41
GPA:  2.305

Name: Diane Simcox
ID#:  987654
Age:  32
GPA:  2.175

Name: Bart Reagor
ID#:  123456
Age:  27
GPA:  2.075

Name: Todd Deans
ID#:  654789
Age:  22
GPA:  2.023

Name: Mary Pridgen
ID#:  567765
Age:  19
GPA:  1.957

Name: Ann Seaborn
ID#:  313131
Age:  56
GPA:  1.785

Name: Mike Bruun
ID#:  321456
Age:  19
GPA:  1.783

Name: j
ID#:  123
Age:  3
GPA:  1.5

Name: Tom Tooch
ID#:  751977
Age:  26
GPA:  1.456

Name: Steven Johnson
ID#:  681968
Age:  34
GPA:  0.785


Press <Enter> to continue.


DISPLAYING STUDENTS SORTED BY GPA WITH FAILING STUDENTS REMOVED

Name: Paul Reiman
ID#:  345678
Age:  45
GPA:  4.0

Name: Laurie Rosemberg
ID#:  976976
Age:  45
GPA:  4.0

Name: Michelle Ritter
ID#:  491967
Age:  25
GPA:  4.0

Name: Laura Collins
ID#:  876890
Age:  30
GPA:  3.999

Name: Susan Craft
ID#:  551212
Age:  29
GPA:  3.754

Name: Vance Brawner
ID#:  662323
Age:  31
GPA:  3.678

Name: Cheryl Willis
ID#:  654321
Age:  37
GPA:  3.576

Name: Andy Reitinger
ID#:  456789
Age:  20
GPA:  3.525


Name: Diana Rockel
ID#:  429067
Age:  56
GPA:  3.456

Name: Lori Salbury
ID#:  212121
Age:  23
GPA:  3.455

Name: Michael Ward
ID#:  765432
Age:  19
GPA:  3.451

Name: William Reynolds
ID#:  567890
Age:  50
GPA:  3.375

Name: Kevin Sims
ID#:  876543
Age:  67
GPA:  3.235

Name: Kristyn Reckner
ID#:  234567
Age:  19
GPA:  3.225

Name: Richardson Robinson
ID#:  203203
Age:  26
GPA:  3.21

Name: Brian Roberts
ID#:  811811
Age:  23
GPA:  3.175

Name: Gordon Collins
ID#:  545632
Age:  25
GPA:  3.1

Name: Barbara Salsa
ID#:  777777
Age:  18
GPA:  3.0

Name: Debbie Mozart
ID#:  342517
Age:  40
GPA:  2.999

Name: Nancy Barone
ID#:  911072
Age:  25
GPA:  2.975

Name: Lauri Robertson
ID#:  119010
Age:  19
GPA:  2.925

Name: William Robbins
ID#:  460064
Age:  34
GPA:  2.875

Name: Patti Skinner
ID#:  671983
Age:  47
GPA:  2.743

Name: Mali Cozart
ID#:  720097
Age:  16
GPA:  2.345

Name: Tracy Springer
ID#:  334213
Age:  41
GPA:  2.305

Name: Diane Simcox
ID#:  987654
Age:  32
GPA:  2.175

Name: Bart Reagor
ID#:  123456
Age:  27
GPA:  2.075

Name: Todd Deans
ID#:  654789
Age:  22
GPA:  2.023


Press <Enter> to continue.

j is not in the list.

Paul Reiman and Laurie Rosemberg are equal.

This list is empty.

Process completed.*/
