package com.ramsud.symc;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThroatPainActivity extends BasePatientActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_throat_pain);
		
		mNextButton = (BootstrapButton) findViewById(R.id.throatNext);
	
		mNextButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent eat_intent = new Intent(getApplicationContext(), EatActivity.class);
				eat_intent.putExtra(getResources().getString(R.string.throat_pain_selected), 
									mOptionSelected);
				startActivity(eat_intent);
			}
		});
		
		mThroatConditions = new BootstrapButton[3];
		mThroatConditions[0] = (BootstrapButton) findViewById(R.id.throatRadioControl);
		mThroatConditions[1] = (BootstrapButton) findViewById(R.id.throatRadioModerate);
		mThroatConditions[2] = (BootstrapButton) findViewById(R.id.throatRadioBad);
		
		setPatientConditionListeners();
	}
	
}
