// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// listens for key presses and displays the key and it's code
// ***********************************************
// KeyTest

package com.testactivites;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

public class KeyTest extends Activity implements OnKeyListener
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Press keys (if you have some)!");
		textView.setOnKeyListener(this);
		textView.setFocusableInTouchMode(true);
		textView.requestFocus();
		setContentView(textView);
	}
	
	//listens for key presses
	public boolean onKey(View view, int keyCode, KeyEvent event)
	{
		builder.setLength(0);
		switch(event.getAction())
		{
		case KeyEvent.ACTION_DOWN:
			builder.append("down, ");
			break;
		case KeyEvent.ACTION_UP:
			builder.append("up, ");
			break;
		}
		//displays and sends to LogCat the key and its code
		builder.append(event.getKeyCode());
		builder.append(", ");
		builder.append((char) event.getUnicodeChar());
		String text = builder.toString();
		Log.d("KeyTest", text);
		textView.setText(text);
		
		return event.getKeyCode() != KeyEvent.KEYCODE_BACK;
	}
}
