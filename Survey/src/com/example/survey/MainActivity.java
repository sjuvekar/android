package com.example.survey;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mName;
	private EditText mPhone;
	private EditText mEmail;
	private EditText mComment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mName = (EditText)findViewById(R.id.name);
		mPhone = (EditText)findViewById(R.id.phone);
		mEmail = (EditText)findViewById(R.id.email);
		mComment = (EditText)findViewById(R.id.comment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void showToast(String txt) {
		Toast.makeText(this.getApplicationContext(), txt, Toast.LENGTH_LONG).show();
	}
	
	public void processForm(View button) {
		String name = mName.getText().toString();
		String phone = mPhone.getText().toString();
		String email = mEmail.getText().toString();
		String comment = mComment.getText().toString();
		
		// General Data sending 
		/*
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_TEXT, comment);
		startActivity(i);
		*/
		 // Send sms
		/*
		Intent in = new Intent(Intent.ACTION_VIEW);
		in.setData(Uri.parse("sms:" + phone));
		in.putExtra("sms_body", comment);
		startActivity(in);
		*/
		
		// Send email
		Intent ie = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
		ie.putExtra(Intent.EXTRA_SUBJECT, "Hello World");
		ie.putExtra(Intent.EXTRA_TEXT, comment);
		Intent chooser = Intent.createChooser(ie, "Email app?");
		try {
			startActivity(chooser);
		} catch(Exception e) {
			Log.e("parseForm", "Could not send email");
		}
		
		/*
		int emailPos = email.indexOf("@");
		if (emailPos == -1) {
			showToast("Invalid email!");
			mEmail.requestFocus();
			return;
		}
		if (comment.length() == 0) {
			showToast("Write comment");
			return;
		}
		
		String userName = email.substring(0, emailPos);
		//button.setVisibility(View.INVISIBLE);
		showToast("Hi " + userName);
		
		Animation btnAnim = AnimationUtils.makeOutAnimation(this, true);
		button.startAnimation(btnAnim);
		*/
	}

}
