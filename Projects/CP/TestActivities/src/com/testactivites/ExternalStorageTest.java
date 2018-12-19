// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// writes to and reads from external storage
// ***********************************************
// ExternalStorageTest

package com.testactivites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class ExternalStorageTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		//checks if there is external storage
		String state = Environment.getExternalStorageState();
		if(!state.equals(Environment.MEDIA_MOUNTED))
		{
			textView.setText("No external storage mounted");
		}
		else
		{
			//gets path
			java.io.File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath() 
					+ java.io.File.separator + "text.txt");
			try
			{
				writeTextFile(textFile, "This is a test. Roger");
				String text = readTextFile(textFile);
				textView.setText(text);
				if(!textFile.delete())
				{
					textView.setText("Couldn't remove temporary file");
				}
			}
			catch(IOException e)
			{
				textView.setText("Something went wrong! " + e.getMessage());
			}
		}
	}
	
	//writes the text file using IO tools like usual: buffered writer and file writer
	private void writeTextFile(File file, String text) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}
	
	//reads in the text file using IO tools like usual: buffered reader and file reader
	private String readTextFile(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder text = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null)
		{
			text.append(line);
			text.append("\n");
		}
		reader.close();
		return text.toString();
	}
}
