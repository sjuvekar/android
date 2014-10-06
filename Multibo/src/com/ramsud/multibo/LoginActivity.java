package com.ramsud.multibo;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		((BootstrapButton) findViewById(R.id.loginLoginButton)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent question_intent = new Intent(getApplicationContext(), QuestionActivity.class);
				startActivity(question_intent);
			}
		});
	}
	
}
