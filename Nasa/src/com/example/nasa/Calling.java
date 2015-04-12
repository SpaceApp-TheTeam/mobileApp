package com.example.nasa;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Calling extends Activity {
	SeekBar volumeSeekbar1=null;
	private AudioManager audioManager = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calling);
		  setVolumeControlStream(AudioManager.STREAM_MUSIC);
		  initControls();
	}
	private void initControls() {
		 volumeSeekbar1 = (SeekBar)findViewById(R.id.seekBar1);
         audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		  volumeSeekbar1.setMax(audioManager
                  .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
          volumeSeekbar1.setProgress(audioManager
                  .getStreamVolume(AudioManager.STREAM_MUSIC)); 
          volumeSeekbar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
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
