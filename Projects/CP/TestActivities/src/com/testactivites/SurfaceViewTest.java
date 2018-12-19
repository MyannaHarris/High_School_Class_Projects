// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// creates a "surface view" that is run on a thread that can be paused
// when an interrupt is received
// ***********************************************
// SurfaceViewTest

package com.testactivites;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

public class SurfaceViewTest extends Activity
{
	FastRenderView renderView;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//FastRenderView is a self-created class that creates a
		//view that can be quickly updated
		renderView = new FastRenderView(this);
		setContentView(renderView);
	}
	
	//resume when activity is entered
	protected void onResume()
	{
		super.onResume();
		renderView.resume();
	}
	
	//paused when activity is left
	protected void onPause()
	{
		super.onPause();
		renderView.pause();
	}
	
	//self-created class that runs on a thread
	class FastRenderView extends SurfaceView implements Runnable
	{
		Thread renderThread = null;
		SurfaceHolder holder;
		volatile boolean running = false;
		
		public FastRenderView(Context context)
		{
			super(context);
			holder = getHolder();
		}
		
		//starts thread (from where it left off if it was paused)
		public void resume()
		{
			running = true;
			renderThread = new Thread(this);
			renderThread.start();
		}
		
		//draws to the canvas continuously "rendering" the view
		public void run()
		{
			while(running)
			{
				if(!holder.getSurface().isValid())
					continue;
				Canvas canvas = holder.lockCanvas();
				canvas.drawRGB(255, 0, 0);
				holder.unlockCanvasAndPost(canvas);
			}
		}
		
		//pauses the thread when activity is left
		public void pause()
		{
			running = false;
			while(true)
			{
				try
				{
					renderThread.join();
					return;
				}
				catch(InterruptedException e)
				{
					//retry
				}
			}
		}
	}
}
