package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FeedingFrequencyActivity extends Activity {

	private Button button_next;
	private DbHelper dbh;
	private Long start_time;
	private Long end_time;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_feeding_frequency);
	    dbh=new DbHelper(FeedingFrequencyActivity.this);
	    start_time=System.currentTimeMillis();
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("PNC Counselling: Feeding Frequency");
	    button_next=(Button) findViewById(R.id.button_next);
	    button_next.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
			Intent intent=new Intent(FeedingFrequencyActivity.this,InfantFeedingNextActivity.class);
			intent.putExtra("value", "feeding_frequency");
			startActivity(intent);
			}
	    	
	    });
	}
	public void onBackPressed()
	{
	    end_time=System.currentTimeMillis();
	    System.out.println("Start: " +start_time.toString()+"  "+"End: "+end_time.toString());
		dbh.insertCCHLog("Point of Care", "PNC Counselling Feeding Frequency", start_time.toString(), end_time.toString());
		finish();
	}
}
