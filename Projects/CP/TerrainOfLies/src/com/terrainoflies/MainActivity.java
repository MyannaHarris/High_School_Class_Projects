// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// The main window that is a list of buttons
// ***********************************************
// MainActivity

package com.terrainoflies;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity 
{
	String tests[] = {"Play", "Highscores", "Help"};

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
    }

    //Goes to activity when the list item is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) 
    {
        super.onListItemClick(list, view, position, id);
        String testName = tests[position];
        try
        {
        	//creates an instance of the activity's class
        	Class<?> clazz = Class.forName("com.terrainoflies." + testName);
        	Intent intent = new Intent(this, clazz);
        	startActivity(intent);
        }
        catch(ClassNotFoundException e)
        {
        	e.printStackTrace();
        }
    }
    
}