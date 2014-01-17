package com.example.simplesound;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		player = MediaPlayer.create(this, R.raw.play);
		//player.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		player = MediaPlayer.create(this, R.raw.play);
		player.start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		player.stop();
		player.release();
	}
	
	public void openFB(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(fbUrl));
		startActivity(i);
	}
	
	public void openBC(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(googleUrl));
		startActivity(i);
	}
	
	private MediaPlayer player;
	private String fbUrl = "http://www.facebook.com";
	private String googleUrl = "http://www.google.com";
}
