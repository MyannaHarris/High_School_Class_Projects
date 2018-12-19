// ***********************************************
// Program Identification
// Name: myanna harris
// Class: java
// Date: 5-22-13
// File Location: C:\Users\ke.myanna.harris\Dropbox\CP
// ***********************************************

// ***********************************************
// Program Abstract
// Doesn't work
// plays sound effect (ogg) from assets
// ***********************************************
// SoundPoolTest

package com.testactivites;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SoundPoolTest extends Activity implements OnTouchListener
{
	SoundPool soundPool;
	int explosionId = -1;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		
		//uses soundpool to play the sound effect in
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
		
		try
		{
			//gets access to assets
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("explosion.ogg");
			explosionId = soundPool.load(descriptor,  1);
		}
		catch(IOException e)
		{
			textView.setText("Couldn't load sound effect from asset, " + e.getMessage());
		}
	}
	
	//listens for touch and plays sound effect when a touch is read
	public boolean onTouch(View v, MotionEvent event)
	{
		if(event.getAction() == MotionEvent.ACTION_UP)
			if(explosionId != -1)
				soundPool.play(explosionId, 1, 1, 0, 0, 1);
		return true;
	}
}
