package com.ramsud.symc;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EatActivity extends BasePatientActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eat);
		
		mNextButton = (BootstrapButton) findViewById(R.id.eatNext);
		
		mNextButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// Get calling intent
				Intent throat_intent = getIntent();
				int throat_option = throat_intent.getIntExtra(getResources().getString(R.string.throat_pain_selected), 0);
				
				// Create new intent
				Intent medication_intent = new Intent(getApplicationContext(), MedicationActivity.class);
				medication_intent.putExtra(getResources().getString(R.string.throat_pain_selected), 
										   throat_option);
				medication_intent.putExtra(getResources().getString(R.string.eat_selected), 
										   mOptionSelected);
				
				startActivity(medication_intent);
			}
		});
		
		mThroatConditions = new BootstrapButton[3];
		mThroatConditions[0] = (BootstrapButton) findViewById(R.id.eatRadioYes);
		mThroatConditions[1] = (BootstrapButton) findViewById(R.id.eatRadioSomewhat);
		mThroatConditions[2] = (BootstrapButton) findViewById(R.id.eatRadioNo);
		
		setPatientConditionListeners();
	}
}
