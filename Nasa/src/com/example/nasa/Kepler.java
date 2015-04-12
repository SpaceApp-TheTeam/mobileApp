package com.example.nasa;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Kepler extends Activity {
	SeekBar volumeSeekbar2=null;
	private AudioManager audioManager = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kepler);
		 setVolumeControlStream(AudioManager.STREAM_MUSIC);
		  initControls();
	}
	
	private void initControls() {
		 volumeSeekbar2 = (SeekBar)findViewById(R.id.seekBar2);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		  volumeSeekbar2.setMax(audioManager
                 .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
         volumeSeekbar2.setProgress(audioManager
                 .getStreamVolume(AudioManager.STREAM_MUSIC)); 
         volumeSeekbar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
         {
             @Override
             public void onStopTrackingTouch(SeekBar arg0) 
             {
             }

             @Override
             public void onStartTrackingTouch(SeekBar arg0) 
             {
             }

             @Override
             public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) 
             {
                 audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                         progress, 0);
             }
         });
	}
	
}
