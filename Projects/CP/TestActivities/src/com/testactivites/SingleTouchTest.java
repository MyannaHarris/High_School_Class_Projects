// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// keeps track of one touch at a time
// ***********************************************
// SingleTouchTest

package com.testactivites;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SingleTouchTest extends Activity implements OnTouchListener
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Touch and drag (one finger only)!");
		textView.setOnTouchListener(this);
		setContentView(textView);
	}
	
	//listens for a touch
	public boolean onTouch(View v, MotionEvent event)
	{
		builder.setLength(0);
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			builder.append("down, ");
			break;
		case MotionEvent.ACTION_MOVE:
			builder.append("move, ");
			break;
		case MotionEvent.ACTION_CANCEL:
			builder.append("cancel, ");
			break;
		case MotionEvent.ACTION_UP:
			builder.append("up, ");
			break;
		}
		//writes the touch actions and coordinates to LogCat
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text = builder.toString();
		Log.d("TouchTest", text);
		return true;
	}
}
