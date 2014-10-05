package com.ramsud.symc;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		final BootstrapButton login_button = (BootstrapButton) findViewById(R.id.loginLoginButton);
		login_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Authenticate();
			}
		});
		
		final BootstrapButton signup_button = (BootstrapButton) findViewById(R.id.signupSignupButton);
		signup_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Authenticate();
			}
		});
	}
	
	private void Authenticate() {
		Intent graph_intent = new Intent(getApplicationContext(), GraphActivity.class);
		startActivity(graph_intent);
	}
}
