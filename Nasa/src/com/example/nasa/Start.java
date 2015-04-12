package com.example.nasa;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;

public class Start extends Activity {
ListView list;
MediaPlayer mediaplayer0=null;
MediaPlayer mediaplayer2=null;
MediaPlayer mediaplayer3=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
	
		final MediaPlayer mediaplayer0=MediaPlayer.create(this,R.raw.conversation);
		final MediaPlayer mediaplayer2=MediaPlayer.create(this,R.raw.kepler_star);
		final MediaPlayer mediaplayer3=MediaPlayer.create(this,R.raw.launch1);
		list=(ListView)findViewById(R.id.listView1);
		String[] array={"Calling on the space","launch","Kepler"};
		Integer[] arrayint={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		/*ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
				R.layout.mylist,R.id.item
				,array);*/
		CustomListAdapter custom=new CustomListAdapter(this, array, arrayint);
		list.setAdapter(custom);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			
				switch(position){
				case 0:
					Intent i0=new Intent(Start.this,Calling.class);
					startActivity(i0);
				
				
		          mediaplayer0.start();
		          if( mediaplayer3.isPlaying())
		          {
		          mediaplayer3.pause();
		          }
		          if(mediaplayer2.isPlaying())
		          {
	              mediaplayer2.pause();
					}
		          
					break;
				case 1:
					Intent i2=new Intent(Start.this,Launch.class);
					startActivity(i2);
                      mediaplayer3.start();
					if(mediaplayer0.isPlaying())
					 {mediaplayer0.pause();}
					if(mediaplayer2.isPlaying())
					 {mediaplayer2.pause();}
		
				break;
				case 2:
					Intent i3=new Intent(Start.this,Kepler.class);
					startActivity(i3);
				mediaplayer2.start();
					if(mediaplayer0.isPlaying())
					{ mediaplayer0.pause();}
					if( mediaplayer3.isPlaying()){
					 mediaplayer3.pause();
					}
					break;
				}
			}
		});
	}
}
