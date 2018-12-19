// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// Main activity that is a list that connects to the other activities
// ***********************************************
// MainActivity

package com.testactivites;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity 
{
	String tests[] = {"LifeCycleTest", "SingleTouchTest", "MultiTouchTest",
			"KeyTest", "AccelerometerTest", "AssetsTest", "ExternalStorageTest",
			"SoundPoolTest", "MediaPlayerTest", "FullScreenTest", "RenderViewTest",
			"ShapeTest", "BitmapTest", "FontTest", "SurfaceViewTest"};

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
    }

    //listens for an item to be clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) 
    {
        super.onListItemClick(list, view, position, id);
        String testName = tests[position];
        try
        {
        	//makes instance of class of the activity being opened
        	Class<?> clazz = Class.forName("com.testactivites." + testName);
        	Intent intent = new Intent(this, clazz);
        	startActivity(intent);
        }
        catch(ClassNotFoundException e)
        {
        	e.printStackTrace();
        }
    }
    
}
