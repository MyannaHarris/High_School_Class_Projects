// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// Writes text to canvas in two fonts
// ***********************************************
// FontTest

package com.testactivites;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FontTest extends Activity
{
	class RenderView extends View
	{
		Paint paint;
		Typeface font;
		Rect bounds = new Rect();
		
		//a created view to display the text in
		public RenderView(Context context)
		{
			super(context);
			paint = new Paint();
			font = Typeface.createFromAsset(context.getAssets(),  "font.ttf");
		}
		
		//draws to canvas
		protected void onDraw(Canvas canvas)
		{
			canvas.drawRGB(0, 0, 0);
			paint.setColor(Color.YELLOW);
			paint.setTypeface(font);
			paint.setTextSize(28);
			paint.setTextAlign(Paint.Align.CENTER);
			canvas.drawText("This is a test!", canvas.getWidth()/2, 100, paint);
			
			String text = "This is another test o_O";
			paint.setColor(Color.WHITE);
			paint.setTextSize(18);
			paint.setTextAlign(Paint.Align.LEFT);
			paint.getTextBounds(text, 0, text.length(), bounds);
			canvas.drawText(text, canvas.getWidth() - bounds.width(), 140, paint);
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
