// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 4-22-11
// File Location: H:\My Documents\java\
// ***********************************************

// ***********************************************
// Program Abstract
// It outputs a list of students, their age and gpa. Then it calculates
// the average age and average gpa and outputs them along with the number
// of students there are. Then it creates a passing file and puts the names
// and information of the students with at least a 2.0 gpa. Then it creates
// an honors file and puts the names and information of the students with
// at least a 3.75 gpa.
// ***********************************************

// ***********************************************
// Program Variable Dictionary
// f1 --> the alias used for the students file it reads in
// f2 --> the alias for the passing file it creates
// f3 --> the alias for the honors file it creates
// name --> student name read in
// age --> student age read in
// gpa --> student gpa read in
// meanAge --> the average age
// meanGPA --> the average gpa
// inFile --> the file reader that reads the student file
// inStream --> the buffered reader that reads lines from the student file
// outFile2, outFile3 --> the file writter that writes to the passing(2) and honors(3) files
// outStream2, outStream3 --> the buffered writter that writes lines to the passing(2) and honors(3) files
// ***********************************************
// Lab17.java
// 110 Version

import java.io.*;
import java.text.DecimalFormat;

public class Lab17 {

    public static void main (String args[]) throws IOException 
    {
    	System.out.println("\nLab17 -- The Student Records File Program\n");
		DecimalFormat output = new DecimalFormat("00.000");
		File f1 = new File("students.dat");
		File f2 = new File("passing.dat");
		File f3 = new File("honors.dat");
		String name = "";
		String age = "";
		String gpa = "";
		double meanAge = 0.0;
		double meanGPA = 0.0;
		int count = 0;
		f2.delete();
		f3.delete();
		
		
		if (f1.exists())
		{
			FileReader inFile = new FileReader(f1);
			BufferedReader inStream = new BufferedReader(inFile);
			FileWriter outFile2 = new FileWriter(f2);
			BufferedWriter outStream2 = new BufferedWriter(outFile2);
			FileWriter outFile3 = new FileWriter(f3);
			BufferedWriter outStream3 = new BufferedWriter(outFile3);
			while(((name = inStream.readLine()) != null) &&
				((age = inStream.readLine()) != null) &&
				((gpa = inStream.readLine()) != null))
			{
			System.out.println("Name: " + name);
			System.out.println("Age:  " + age);
			System.out.println("GPA:  " + gpa);
			System.out.println();
			meanAge += Integer.parseInt(age);
			meanGPA += Double.parseDouble(gpa);
			count += 1;
			
			
			if ((Double.parseDouble(gpa))>=2.0)	
				{
					outStream2.write(name);
					outStream2.newLine();	
					outStream2.write(age);
					outStream2.newLine();	
					outStream2.write(gpa);
					outStream2.newLine();	
				}
			if ((Double.parseDouble(gpa))>=3.75)	
				{
					outStream3.write(name);
					outStream3.newLine();	
					outStream3.write(age);
					outStream3.newLine();	
					outStream3.write(gpa);
					outStream3.newLine();	
				}				
			}
			inStream.close();
			outStream2.close();
			outStream3.close();    
			meanAge = meanAge/count;
			meanGPA = meanGPA/count;
			System.out.println("Total students records: " + count);
			System.out.println("Average student age:    " + output.format(meanAge));
			System.out.println("Average student GPA:    " + output.format(meanGPA));
		}
		else
		{
			System.out.println(f1.getName() + " does not exist");
		}
		System.out.println();
    }
    
    
}

/*--------------------Configuration: <Default>--------------------

Lab17 -- The Student Records File Program

Name: Bart Reagor
Age:  27
GPA:  2.075

Name: Kristyn Reckner
Age:  19
GPA:  3.225

Name: Paul Reiman
Age:  41
GPA:  4.000

Name: Andy Reitinger
Age:  20
GPA:  3.525

Name: William Reynolds
Age:  50
GPA:  3.375

Name: William Robbins
Age:  34
GPA:  2.875

Name: Brian Roberts
Age:  23
GPA:  3.175

Name: Lauri Robertson
Age:  19
GPA:  2.925

Name: Richardson Robinson
Age:  26
GPA:  3.210

Name: Laurie Rosemberg
Age:  45
GPA:  4.000

Name: Barbara Salsa
Age:  18
GPA:  3.000

Name: Lori Salbury
Age:  23
GPA:  3.455

Name: Ann Seaborn
Age:  56
GPA:  1.785

Name: Diane Simcox
Age:  32
GPA:  2.175

Name: Kevin Sims
Age:  67
GPA:  3.235

Name: Michael Ward
Age:  19
GPA:  3.451

Name: Cheryl willis
Age:  37
GPA:  3.576

Name: Tracy Springer
Age:  41
GPA:  2.305

Name: Mary Pridgen
Age:  19
GPA:  1.957

Name: Steven Johnson
Age:  34
GPA:  0.785

Name: Nancy Barone
Age:  25
GPA:  2.975

Name: Tom Tooch
Age:  26
GPA:  1.456

Name: Patti Skinner
Age:  47
GPA:  2.743

Name: Diana Rockel
Age:  56
GPA:  3.456

Name: Michelle Ritter 
Age:  25
GPA:  4.000

Name: Mali Cozart
Age:  16
GPA:  2.345

Name: Mike Bruun
Age:  19
GPA:  1.783

Name: Todd Deans
Age:  22
GPA:  2.023

Name: Laura Collins
Age:  30
GPA:  3.999

Name: Debbie Mozart
Age:  40
GPA:  2.999

Name: Gordon Collins
Age:  25
GPA:  3.100

Name: Susan Craft
Age:  29
GPA:  3.754

Name: Vance Brawner
Age:  31
GPA:  3.678

Total students records: 33
Average student age:    31.545
Average student GPA:    02.922


Process completed.*/