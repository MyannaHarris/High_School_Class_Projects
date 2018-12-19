package com.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class HelloWorldActivity extends Activity implements View.OnClickListener
{   
	Button button;
	int touchCount;
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        button = new Button(this);
        button.setText("Click Me!");
        button.setOnClickListener(this);
        setContentView(button);
    }
	
	public void onClick(View v)
	{
		touchCount++;
		button.setText("Clicked me " + touchCount + " time(s)");
	}
}
