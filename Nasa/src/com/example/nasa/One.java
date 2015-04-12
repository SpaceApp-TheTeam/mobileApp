package com.example.nasa;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class One extends Activity {
LinearLayout l1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		l1=(LinearLayout)findViewById(R.id.linear1);
		l1.setBackgroundColor(Color.BLACK);
	}
}
