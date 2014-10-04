package com.ramsud.symc;

import java.util.Calendar;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.TimePicker;

public class MedicationActivity extends Activity {

	private BootstrapButton mFinishButton;
	private BootstrapButton[] mMedicationButtons;
	private SparseArray<Pair<Integer, Integer>> mMedicationTimes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medication);
		
		mFinishButton = (BootstrapButton) findViewById(R.id.medicationFinish);
		
		mMedicationTimes = new SparseArray<Pair<Integer,Integer>>();
		
		mMedicationButtons = new BootstrapButton[2];
		mMedicationButtons[0] = (BootstrapButton) findViewById(R.id.medicationLortab);
		mMedicationButtons[1] = (BootstrapButton) findViewById(R.id.medicationOxycortin);
		
		setMedicalConditionListener();
	}
	
	/**
	 * Open timer dialog
	 * @param b
	 */
	private void setMedicalConditionListener() {
		for (int i = 0; i < mMedicationButtons.length; i++) {
			mMedicationButtons[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					for (int i = 0; i < mMedicationButtons.length; i++) {
						if (((BootstrapButton)v).getId() == mMedicationButtons[i].getId()) {
							mMedicationButtons[i].setBootstrapType("success");
							mFinishButton.setEnabled(true);
							
							// Create fragment to pass index of button
							Bundle button_bundle = new Bundle();
							button_bundle.putInt("option", i);
							DialogFragment newFragment = new TimePickerFragment();
							newFragment.setArguments(button_bundle);
							newFragment.show(getFragmentManager(), "timePicker");
						}
					}
				}
			});
		}
		
	}
	
	
	/**
	 * Class to open time picker dialog
	 *
	 */
	private class TimePickerFragment extends DialogFragment
									 implements TimePickerDialog.OnTimeSetListener {

		private int mOption;
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
	        final Calendar c = Calendar.getInstance();
	        int hour = c.get(Calendar.HOUR_OF_DAY);
	        int minute = c.get(Calendar.MINUTE);

	        mOption = getArguments().getInt("option");
	        
	        // Create a new instance of TimePickerDialog and return it
	        TimePickerDialog ret_dialog =  new TimePickerDialog(getActivity(), this, hour, minute, 
	        													DateFormat.is24HourFormat(getActivity()));
	        ret_dialog.setTitle("When?");
	        return ret_dialog;
		}

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mMedicationTimes.put(mOption, new Pair<Integer, Integer>(hourOfDay, minute));
		}
	}
	}
