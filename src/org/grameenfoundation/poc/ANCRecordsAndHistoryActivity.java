package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ANCRecordsAndHistoryActivity extends BaseActivity {

	private Button button_yes;
	private Button button_no;
	private Long start_time;
	private Long end_time;
	private DbHelper dbh;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_anc_records_and_history);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("ANC Diagnostic: Records & History");
	    start_time=System.currentTimeMillis();
	    mContext=ANCRecordsAndHistoryActivity.this;
	    dbh=new DbHelper(mContext);
	    button_yes=(Button) findViewById(R.id.button_yes);
	    button_no=(Button) findViewById(R.id.button_no);
	    
	    button_yes.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mContext,ANCRecordsAndHistoryAnswerActivity.class);
				intent.putExtra("value", "yes");
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
			}
	    	
	    });
	    
	    button_no.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mContext,ANCRecordsAndHistoryAnswerActivity.class);
				intent.putExtra("value", "no");
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
			}
	    	
	    });
	}
	public void onBackPressed()
	{
		end_time=System.currentTimeMillis();
		dbh.insertCCHLog("Point of Care", "ANC Diagnostic: Records & History", start_time.toString(), end_time.toString());
		finish();
	}

}