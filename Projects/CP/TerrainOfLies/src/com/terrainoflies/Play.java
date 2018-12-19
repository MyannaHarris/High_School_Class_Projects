// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// listens for touches and counts them
// saves the number of touches if it is a new high score
// ***********************************************
// Play

package com.terrainoflies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class Play extends Activity implements OnTouchListener
{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	int numClicks = 0;
	Bitmap background;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		try
		{
			//accesses assets folder
			AssetManager assetManager = this.getAssets();
			InputStream inputStream = assetManager.open("character.png");
			background = BitmapFactory.decodeStream(inputStream);
			inputStream.close();
		}
		catch(IOException e)
		{
			//silently ignored, bad coder monkey, bad!
		}
		
		//wrapped bitmap in a BitmapDrawable object as a drawable object is 
		//needed for the setBackgroundDrawable call
		Drawable d = new BitmapDrawable(getResources(),background);
		textView.setBackgroundDrawable(d);
		textView.setText("Touch and drag (one finger only)!");
		textView.setOnTouchListener(this);
		setContentView(textView);
	}
	
	//listens for the user to touch the screen
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
		case MotionEvent.ACTION_UP:
			builder.append("up, ");
			numClicks++;
			break;
		}
		
		//writes the movement and coordinates to the LogCat
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text = builder.toString();
		Log.d("TouchTest", text);
		return true;
	}
	
	//When the activity is exited, the program first checks to see if a
	//new score was achieved
	@Override
	public void onBackPressed()
	{
		//checks if there is external storage
		String state = Environment.getExternalStorageState();
		if(!state.equals(Environment.MEDIA_MOUNTED))
		{
			textView.setText("No external storage mounted");
		}
		else
		{
			//gets path
			java.io.File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath() 
					+ java.io.File.separator + "highscores.txt");
			try
			{
				//if file exists, current high score and new score must be compared
				//else, new score is new high score
				if(textFile.length() != 0)
				{
					String text = readTextFile(textFile);
					if(text.compareTo(Integer.toString(numClicks))<0)
						writeTextFile(textFile, Integer.toString(numClicks));
				}
				else
					writeTextFile(textFile, Integer.toString(numClicks));
				
			}
			catch(IOException e)
			{
				textView.setText("Something went wrong! " + e.getMessage());
			}
		}
		finish();
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
	
	//writes the text file using IO tools like usual: buffered writer and file writer
	private void writeTextFile(File file, String text) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}
}

//An attempt to combine textview with bitmap on canvas
/*import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Play extends Activity 
{
	class RenderView extends View implements OnTouchListener
	{
		Bitmap bob565;
		Bitmap bob4444;
		Rect dst = new Rect();
		LinearLayout layout;
		TextView textView;
		StringBuilder builder = new StringBuilder();
		
		public RenderView(Context context)
		{
			super(context);
			
			try
			{
				AssetManager assetManager = context.getAssets();
				InputStream inputStream = assetManager.open("background.png");
				bob565 = BitmapFactory.decodeStream(inputStream);
				inputStream.close();
				inputStream = assetManager.open("character.png");
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.ARGB_4444;
				bob4444 = BitmapFactory.decodeStream(inputStream, null, options);
				inputStream.close();
				
				layout = new LinearLayout(context);
				textView = new TextView(context);
			}
			catch(IOException e)
			{
				//silently ignored, bad coder monkey, bad!
			}
			finally
			{
				//we should really close our input streams here
			}
		}
		
		protected void onDraw(Canvas canvas)
		{
			canvas.drawRGB(0, 0, 0);
			dst.set(50, 50, 350, 350);
			//canvas.drawBitmap(bob565,  null, dst, null);
			//canvas.drawBitmap(bob4444,  100, 100, null);
			
			textView.setVisibility(View.VISIBLE);
			textView.setText("Touch and drag (one finger only)!");
			textView.setOnTouchListener(this);
			layout.removeAllViews();
			layout.addView(textView);
			
			layout.measure(canvas.getWidth(), canvas.getHeight());
			layout.layout(0, 0, canvas.getWidth(), canvas.getHeight());
			
			layout.draw(canvas);
			invalidate();
		}
		
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
			case MotionEvent.ACTION_UP:
				builder.append("up, ");
				break;
			}
			builder.append(event.getX());
			builder.append(", ");
			builder.append(event.getY());
			String text = builder.toString();
			Log.d("TouchTest", text);
			return true;
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}
}*/