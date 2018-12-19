// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// measures and reports the acceleration exerted by gravity
// ***********************************************
// AccelerometerTest

package com.testactivites;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerTest extends Activity implements SensorEventListener
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		setContentView(textView);
		
		//gets access to sensors
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0)
		{
			textView.setText("No accelerometer installed");
		}
		else
		{
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			if(!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME))
			{
				textView.setText("Couldn't register sensor listener");
			}
		}
	}
	
	//writes accelerated values on a 3D axis to the textview
	public void onSensorChanged(SensorEvent event)
	{
		builder.setLength(0);
		builder.append("x: ");
		builder.append(event.values[0]);
		builder.append(", y: ");
		builder.append(event.values[1]);
		builder.append(", z: ");
		builder.append(event.values[2]);
		textView.setText(builder.toString());
	}
	
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		//to fully implement SensorEventListener
	}
	
	/*//Code to deal with change in orientation on different devices
	int screenRotation;
	public void onResume()
	{
		WindowManager windowMgr = 
				(WindowManager)this.getSystemService(Activity.WINDOW_SERVICE);
		//getOrientation() is deprecated in Android 8 but it's the same as getRotation(),
		//which is the rotation from the natural orientation of the device
		screenRotation = windowMgr.getDefaultDisplay().getOrientation();
	}
	
	static final int ACCELEROMETER_AXIS_SWAP[][] = 
		{{1,-1,0,1}, //ROTATION_0
		{-1,-1,1,0}, //ROTATION_90
		{-1,1,0,1}, //ROTATION_180
		{1,1,1,0}} //ROTATION_270
	public void onSensorChanged(SensorEvent event)
	{
		final int[] as = ACCELEROMETER_AXIS_SWAP[screenRotation];
		float screenX = (float)as[0] * event.values[as[2]];
		float screenY = (float)as[1] * event.values[as[3]];
		float screenZ = event.values[2];
		//use screenX, screenY, and screenZ as accelerometer values
	}*/
}
