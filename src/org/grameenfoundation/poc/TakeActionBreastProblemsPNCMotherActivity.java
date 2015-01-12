package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TakeActionBreastProblemsPNCMotherActivity extends BaseActivity {
	private Context mContext;
	private DbHelper dbh;
	private Long start_time;
	private Long end_time;
	private String take_action_category;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    mContext=TakeActionBreastProblemsPNCMotherActivity.this;
	    dbh=new DbHelper(mContext);
	    start_time=System.currentTimeMillis();
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("PNC Mother Diagnostic: Breast Problems");
	    Bundle extras = getIntent().getExtras(); 
	    if (extras != null) {
	          take_action_category= extras.getString("value");
	        }
	        if(take_action_category.equals("mastitis")){
	        	   setContentView(R.layout.activity_mastitis_pnc_mother);
	        	   TextView click_here=(TextView) findViewById(R.id.textView_clickHere);
	               click_here.setOnClickListener(new OnClickListener(){

	   				@Override
	   				public void onClick(View v) {
	   					Intent intent=new Intent(mContext,BreastProblemsCounsellingActivity.class);
	   					startActivity(intent);
	   					
	   				}
	               	
	               });
	        }else if(take_action_category.equals("breast_engorgment")){
	        	 setContentView(R.layout.activity_breast_engorgment_pnc_mother);
	        	 TextView click_here=(TextView) findViewById(R.id.textView_clickHere);
	             click_here.setOnClickListener(new OnClickListener(){

	     			@Override
	     			public void onClick(View v) {
	     				Intent intent=new Intent(mContext,BreastProblemsCounsellingActivity.class);
	     				startActivity(intent);
	     				
	     			}
	             	
	             });
	             TextView click_here_too=(TextView) findViewById(R.id.textView_clickHereToo);
	             click_here_too.setOnClickListener(new OnClickListener(){

	     			@Override
	     			public void onClick(View v) {
	     				Intent intent=new Intent(mContext,InfantFeedingMenuActivity.class);
	     				startActivity(intent);
	     				
	     			}
	             	
	             });
	        }else if(take_action_category.equals("cracked_nipples")){
	        	 setContentView(R.layout.activity_cracked_nipples_pnc_mother);
	        	 TextView click_here=(TextView) findViewById(R.id.textView_clickHere);
	             click_here.setOnClickListener(new OnClickListener(){

	     			@Override
	     			public void onClick(View v) {
	     				Intent intent=new Intent(mContext,BreastProblemsCounsellingActivity.class);
	     				startActivity(intent);
	     				
	     			}
	             	
	             });
	             TextView click_here_too=(TextView) findViewById(R.id.textView_clickHereToo);
	             click_here_too.setOnClickListener(new OnClickListener(){

	     			@Override
	     			public void onClick(View v) {
	     				Intent intent=new Intent(mContext,InfantFeedingMenuActivity.class);
	     				startActivity(intent);
	     				
	     			}
	             	
	             });
	        }else if(take_action_category.equals("no_problems")){
	        	 setContentView(R.layout.activity_no_breast_problems_pnc_mother);
	        	 TextView click_here=(TextView) findViewById(R.id.textView_clickHere);
	             click_here.setOnClickListener(new OnClickListener(){

	     			@Override
	     			public void onClick(View v) {
	     				Intent intent=new Intent(mContext,PostnatalCareCounsellingTopicsActivity.class);
	     				startActivity(intent);
	     				
	     			}
	             	
	             });
	        }
	    
	}
	
		public void onBackPressed()
		{
			end_time=System.currentTimeMillis();
		    System.out.println("Start: " +start_time.toString()+"  "+"End: "+end_time.toString());
			dbh.insertCCHLog("Point of Care", "PNC Mother Diagnostic: Breast Problems", start_time.toString(), end_time.toString());
			finish();
		}
	
}
