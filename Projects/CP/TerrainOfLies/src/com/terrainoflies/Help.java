// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// The help screen
// Reads in the directions from a text file in the assets folder
// ***********************************************
// Help

package com.terrainoflies;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		//AssetManager gets your code access to the files in the assets folder
		AssetManager assetManager = getAssets();
		InputStream inputStream = null;
		try
		{
			inputStream = assetManager.open("help.txt");
			String text = loadTextFile(inputStream);
			textView.setText(text);
		}
		catch(IOException e)
		{
			textView.setText("Couldn't load file");
		}
		finally
		{
			if(inputStream != null)
				try
				{
					inputStream.close();
				}
				catch(IOException e)
				{
					textView.setText("Couldn't close file");
				}
		}
	}
	
	//reads in the text file by concatenating the bytes to make a string
	public String loadTextFile(InputStream inputStream) throws IOException
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] bytes = new byte[4096];
		int len = 0;
		while((len = inputStream.read(bytes)) > 0)
			byteStream.write(bytes, 0, len);
		return new String(byteStream.toByteArray(), "UTF8");
	}
}