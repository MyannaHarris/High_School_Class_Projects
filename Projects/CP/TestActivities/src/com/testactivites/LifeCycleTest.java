// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// displays explanation of the state of the activity
// ***********************************************
// LifeCycleTest

package com.testactivites;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	//sends the messages to the LogCat and displays it in the textview
	private void log(String text)
	{
		Log.d("LifeCycleTest", text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("created");
	}
	
	//when it is returned to
	@Override
	protected void onResume()
	{
		super.onResume();
		log("resumed");
	}
	
	//when it is left but not closed
	@Override
	protected void onPause()
	{
		super.onPause();
		log("paused");
		if(isFinishing())
		{
			log("finishing");
		}
	}
}