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
// plays song (ogg) from assets
// ***********************************************
// MediaPlayerTest

package com.testactivites;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MediaPlayerTest extends Activity
{
	MediaPlayer mediaPlayer;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		//media player instance to play music in
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		mediaPlayer = new MediaPlayer();
		try
		{
			//access assets
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("music.ogg");
			mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			mediaPlayer.prepare();
			mediaPlayer.setLooping(true);
		}
		catch(IOException e)
		{
			textView.setText("Couldn't load music file, " + e.getMessage());
			mediaPlayer = null;
		}
	}
	
	//start playing when the activity is entered
	@Override
	protected void onResume()
	{
		super.onResume();
		if(mediaPlayer != null)
			mediaPlayer.start();
	}
	
	//pause or stop if activity is left depending on how close song is to finishing
	public void onPause()
	{
		super.onPause();
		if(mediaPlayer != null)
		{
			mediaPlayer.pause();
			if(isFinishing())
			{
				mediaPlayer.stop();
				mediaPlayer.release();
			}
		}
	}
}
