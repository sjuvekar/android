package com.ramsud.multibo;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class QuestionActivity extends Activity {

	private BootstrapButton[] mMovieButtons;
	
	private BootstrapButton mNextButton;
	
	protected int mOptionSelected;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		mNextButton = (BootstrapButton) findViewById(R.id.questionSubmit);
		
		mMovieButtons = new BootstrapButton[4];
		mMovieButtons[0] = (BootstrapButton) findViewById(R.id.movie1);
		mMovieButtons[1] = (BootstrapButton) findViewById(R.id.movie2);
		mMovieButtons[2] = (BootstrapButton) findViewById(R.id.movie3);
		mMovieButtons[3] = (BootstrapButton) findViewById(R.id.movie4);
		
		setMovieListeners();
	}
	
	
	protected void setMovieListeners() {	
		for (int i = 0; i < mMovieButtons.length; i++) {
			mMovieButtons[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					for (int i = 0; i < mMovieButtons.length; i++) {
						// Check if this button is pressed
						if (((BootstrapButton)v).getId() == mMovieButtons[i].getId()) {
							mOptionSelected = i;
							mMovieButtons[i].setBootstrapType("success");
						}
						else {
							mMovieButtons[i].setBootstrapType("default");
						}
					}
					mNextButton.setEnabled(true);
				}
			});
		}
	}
}
