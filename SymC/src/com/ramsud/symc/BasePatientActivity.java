package com.ramsud.symc;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.view.View;

public class BasePatientActivity extends Activity {

	protected BootstrapButton mNextButton;
	
	protected BootstrapButton mThroatConditions[];
	
	protected int mOptionSelected;
	
	protected void setPatientConditionListeners() {	
		for (int i = 0; i < mThroatConditions.length; i++) {
			mThroatConditions[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					for (int i = 0; i < mThroatConditions.length; i++) {
						// Check if this button is pressed
						if (((BootstrapButton)v).getId() == mThroatConditions[i].getId()) {
							mOptionSelected = i;
							mThroatConditions[i].setBootstrapType("success");
						}
						else {
							mThroatConditions[i].setBootstrapType("default");
						}
					}
					mNextButton.setEnabled(true);
				}
			});
		}
	}
}
