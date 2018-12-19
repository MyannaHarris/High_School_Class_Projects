// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// reads in the high score from a file in the external memory
// ***********************************************
// Highscores

package com.terrainoflies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class Highscores extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		//Checks if there is external storage which is needed to write a permanent file to
		String state = Environment.getExternalStorageState();
		if(!state.equals(Environment.MEDIA_MOUNTED))
		{
			textView.setText("No external storage mounted");
		}
		else
		{
			//gets the path to the external storage file
			java.io.File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath() 
					+ java.io.File.separator + "highscores.txt");
			try
			{
				String text = readTextFile(textFile);
				textView.setText(text);
			}
			catch(IOException e)
			{
				textView.setText("Something went wrong! " + e.getMessage());
			}
		}
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