// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// keeps track of up to 10 touches at a time with indexes
// ***********************************************
// MultiTouchTest

package com.testactivites;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.annotation.TargetApi;

@TargetApi(5)
public class MultiTouchTest extends Activity implements OnTouchListener
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	float[] x = new float[10];
	float[] y = new float[10];
	boolean[] touched = new boolean[10];
	int[] id = new int[10];
	
	//updates what indexed touch did what
	//writes this information to the textview
	private void updateTextView()
	{
		builder.setLength(0);
		for(int i = 0; i < 10; i++)
		{
			builder.append(touched[i]);
			builder.append(", ");
			builder.append(id[i]);
			builder.append(", ");
			builder.append(x[i]);
			builder.append(", ");
			builder.append(y[i]);
			builder.append("\n");
		}
		textView.setText(builder.toString());
	}
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Touch and drag (multiple fingers supported)!");
		textView.setOnTouchListener(this);
		setContentView(textView);
		for(int i = 0; i < 10; i++)
			id[i] = -1;
		
		updateTextView();
	}
	
	//listens for touches and gives each new touch an index 
	//for up to 10 touches at a time
	public boolean onTouch(View v, MotionEvent event)
	{
		int action = event.getAction() & MotionEvent.ACTION_MASK;
		int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK)
							>> MotionEvent.ACTION_POINTER_ID_SHIFT;
		int pointerCount = event.getPointerCount();
		for(int i = 0; i < 10; i++)
		{
			if(i >= pointerCount)
			{
				touched[i] = false;
				id[i] = -1;
				continue;
			}
			if(event.getAction() != MotionEvent.ACTION_MOVE && i != pointerIndex)
			{
				//if it's an up/down/cancel/out event, mask the id to see if we should
				//process it for this touch point
				continue;
			}
			
			int pointerId = event.getPointerId(i);
			switch(action)
			{
			case MotionEvent.ACTION_DOWN:
			case MotionEvent.ACTION_POINTER_DOWN:
				touched[i] = true;
				id[i] = pointerId;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
			case MotionEvent.ACTION_OUTSIDE:
			case MotionEvent.ACTION_CANCEL:
				touched[i] = false;
				id[i] = -1;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);
				break;
			case MotionEvent.ACTION_MOVE:
				touched[i] = true;
				id[i] = pointerId;
				x[i] = (int) event.getX(i);
				y[i] = (int) event.getY(i);
				break;
			}
		}
		updateTextView();
		return true;
	}
}
