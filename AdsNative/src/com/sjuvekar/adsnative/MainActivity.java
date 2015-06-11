package com.sjuvekar.adsnative;

import com.adsnative.android.sdk.story.FailureMessage;
import com.adsnative.android.sdk.story.OnSponsoredStoryListener;
import com.adsnative.android.sdk.story.SponsoredStory;
import com.adsnative.android.sdk.story.SponsoredStoryController;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private RelativeLayout mMainLayout;
	private RelativeLayout mParent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mMainLayout = (RelativeLayout) findViewById(R.id.my_sponsored_story_layout);
		mParent = (RelativeLayout) findViewById(R.id.my_parent_layout);
		
		final SponsoredStoryController sponsoredStoryController = new SponsoredStoryController(getBaseContext());
		sponsoredStoryController.fetchSponsoredStory("KhVSjS_gskK3u73HGs3LqMX6n3jTros7k7V4nuEy");
		sponsoredStoryController.setOnSponsoredStoryListener(new OnSponsoredStoryListener() 
		{	
			@Override
			public void onSponsoredStory(SponsoredStory sponsoredStory) {
				Log.e("AdsNative", "Loaded Story");
				View view = sponsoredStoryController.getSponsoredStoryView(sponsoredStory);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                mMainLayout.addView(view, layoutParams);
			}

			@Override
			public void onFailure(FailureMessage failureMessage) {
				if (failureMessage != null)
					Log.e("AdsNative", failureMessage.getMessage());
				else
					Log.e("AdsNative", "Null Failure Msg");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
