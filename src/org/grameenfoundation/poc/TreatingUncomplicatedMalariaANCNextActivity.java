package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TreatingUncomplicatedMalariaANCNextActivity extends Activity {

	private Button button_next;
	private Long start_time;
	private Long end_time;
	private DbHelper dbh;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_anc_treatment_unomplicate_malaria_preg_next);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("ANC References: Treating UnComplicated Malaria");
	    dbh=new DbHelper(TreatingUncomplicatedMalariaANCNextActivity.this);
	    start_time=System.currentTimeMillis();
	    button_next=(Button) findViewById(R.id.button_next);
	    button_next.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
			Intent intent=new Intent(TreatingUncomplicatedMalariaANCNextActivity.this,TreatingUncomplicatedMalariaANCNextTwoActivity.class);
			startActivity(intent);
			}
	    	
	    });
		}
	public void onBackPressed()
	{
		 end_time=System.currentTimeMillis();
		dbh.insertCCHLog("Point of Care", "ANC References: Treating UnComplicated Malaria" , start_time.toString(), end_time.toString());
		finish();
	}
}
