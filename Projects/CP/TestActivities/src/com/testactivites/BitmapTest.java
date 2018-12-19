// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// reads in a png from the assets and displays it with two different configurations
// ***********************************************
// BitmapTest

package com.testactivites;

import java.io.IOException;
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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BitmapTest extends Activity
{
	class RenderView extends View
	{
		Bitmap bob565;
		Bitmap bob4444;
		Rect dst = new Rect();
		
		public RenderView(Context context)
		{
			super(context);
			
			try
			{
				//gets access to assets
				AssetManager assetManager = context.getAssets();
				InputStream inputStream = assetManager.open("bobrgb888.png");
				//png to bitmap
				bob565 = BitmapFactory.decodeStream(inputStream);
				inputStream.close();
				Log.d("BitmapText", "bobrgb888.png format: " + bob565.getConfig());
				inputStream = assetManager.open("bobargb8888.png");
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.ARGB_4444;
				bob4444 = BitmapFactory.decodeStream(inputStream, null, options);
				inputStream.close();
				Log.d("BitmapText", "bobargb8888.png format: " + bob4444.getConfig());
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
		
		//draws bitmaps to the canvas
		protected void onDraw(Canvas canvas)
		{
			canvas.drawRGB(0, 0, 0);
			dst.set(50, 50, 350, 350);
			canvas.drawBitmap(bob565,  null, dst, null);
			canvas.drawBitmap(bob4444,  100, 100, null);
			invalidate();
		}
	}
	
	//defines settings of the device
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}
}
