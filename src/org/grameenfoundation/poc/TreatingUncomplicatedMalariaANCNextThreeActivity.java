package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;
import org.digitalcampus.oppia.application.MobileLearning;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TreatingUncomplicatedMalariaANCNextThreeActivity extends BaseActivity {

	private Button button_next;
	private Long start_time;
	private Long end_time;
	private DbHelper dbh;
	private JSONObject json;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_anc_treatment_unomplicate_malaria_preg_next_3);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("ANC References: Treating UnComplicated Malaria");
	    mContext=TreatingUncomplicatedMalariaANCNextThreeActivity.this;
	    dbh=new DbHelper(TreatingUncomplicatedMalariaANCNextThreeActivity.this);
	    start_time=System.currentTimeMillis();
	    json=new JSONObject();
	    try {
			json.put("page", "ANC References: Treating UnComplicated Malaria");
			json.put("section", MobileLearning.CCH_REFERENCES);
			json.put("ver", dbh.getVersionNumber(mContext));
			json.put("battery", dbh.getBatteryStatus(mContext));
			json.put("device", dbh.getDeviceName());
			json.put("imei", dbh.getDeviceImei(mContext));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public void onBackPressed()
	{
		 end_time=System.currentTimeMillis();
		dbh.insertCCHLog("Point of Care", json.toString() , start_time.toString(), end_time.toString());
		finish();
	}
}
