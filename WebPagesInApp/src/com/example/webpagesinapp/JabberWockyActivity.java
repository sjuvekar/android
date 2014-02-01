package com.example.webpagesinapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class JabberWockyActivity extends Activity {

	private WebView webView;
	private MediaPlayer mediaPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabber_wocky);
		
		webView = (WebView)findViewById(R.id.JabberWockyView);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.loadUrl("file:///android_asset/jabberwocky.html");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabber_wocky, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Create MediaPlayer
		mediaPlayer = MediaPlayer.create(this, R.raw.play);
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mediaPlayer.stop();
		mediaPlayer.release();
		
	}
	/**
	 * Open Wikipedia in browser
	 * @param v
	 */
	public void openWiki(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
		startActivity(i);
	}
	
	/**
	 * Replace contents of webview by picture
	 * @param v
	 */
	public void openPicture(View v) {
		webView.loadUrl("file:///android_asset/jabberwocky.jpg");
	}
}
