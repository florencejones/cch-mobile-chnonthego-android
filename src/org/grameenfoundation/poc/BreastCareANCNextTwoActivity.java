package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BreastCareANCNextTwoActivity extends BaseActivity {

	private Context mContext;
	private DbHelper dbh;
	private Long start_time;
	private Long end_time;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_anc_things_to_remember);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("ANC Counselling: Breastfeeding & Breast Care");
	    mContext=BreastCareANCNextTwoActivity.this;
	    dbh=new DbHelper(mContext);
	    start_time=System.currentTimeMillis();
	   
	}
	public void onBackPressed()
	{
	    end_time=System.currentTimeMillis();
		dbh.insertCCHLog("Point of Care", "ANC Counselling: Breastfeeding & Breast Care", start_time.toString(), end_time.toString());
		finish();
	}
}
