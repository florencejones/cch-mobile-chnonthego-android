package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;

import android.app.Activity;
import android.os.Bundle;

public class ImmunisationScheduleActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_immunisation_schedule);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("PNC Counselling");
	}

}