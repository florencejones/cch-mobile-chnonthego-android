																																																															package org.grameenfoundation.cch.activity;

import java.util.ArrayList;
import java.util.Calendar;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.oppia.application.DbHelper;
import org.grameenfoundation.adapters.UpdateTargetsAdapter;
import org.grameenfoundation.cch.model.EventTargets;
import org.grameenfoundation.cch.model.LearningTargets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;

public class UpdateWeeklyTargetsActivity extends Activity implements OnChildClickListener{

	private DbHelper db;
	private Context mContext;
	 private ArrayList<EventTargets> eventTargets;
	 private ArrayList<EventTargets> coverageTargets;
	 private ArrayList<EventTargets> otherTargets;
	 private ArrayList<LearningTargets> learningTargets;
	String due_date;
	private ExpandableListView expandableListView_updates;
	private UpdateTargetsAdapter updates_adapter;
	private String[] groupItems;
	private long selected_id;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_update_targets);
	    mContext=UpdateWeeklyTargetsActivity.this;
	    db=new DbHelper(mContext);
	    Calendar c = Calendar.getInstance();
        int month=c.get(Calendar.MONTH)+1;
        Time time = new Time();
	    time.setToNow();
	    String today= String.valueOf(time.monthDay)+"-"+String.valueOf(time.month+1)+"-"+String.valueOf(time.year);
    	
   eventTargets=db.getAllEventTargets("Weekly");
 	   coverageTargets=db.getAllCoverageTargets("Weekly");
 	   learningTargets=db.getAllLearningTargets("Weekly");
 	   otherTargets=db.getAllOtherTargets("Weekly");
 	   
 	    groupItems=new String[]{"Events","Coverage","Learning","Other"};
 	    expandableListView_updates=(ExpandableListView) findViewById(R.id.expandableListView_updates);
 	    updates_adapter=new UpdateTargetsAdapter(mContext,eventTargets,
										coverageTargets,
										otherTargets,
										learningTargets,
			 							groupItems,
			 							expandableListView_updates);
 	   expandableListView_updates.setAdapter(updates_adapter);
 	  expandableListView_updates.setOnChildClickListener(this);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		String[] selected_items=updates_adapter.getChild(groupPosition, childPosition);
		if(groupPosition==0){
		
		selected_id=Long.parseLong(selected_items[7]);
		//System.out.println(selected_items[0]+" "+selected_items[1]);
		String name=selected_items[0];
		String number=selected_items[1];
		String period=selected_items[2];
		String due_date=selected_items[3];
		String status=selected_items[6];
		String startDate=selected_items[5];
		String achieved=selected_items[4];
		ArrayList<String> number_achieved=db.getForUpdateEventNumberAchieved(selected_id,period);
		Intent intent=new Intent(mContext,UpdateActivity.class);
		intent.putExtra("id",selected_id);
		intent.putExtra("name",name);
		intent.putExtra("number",number);
		intent.putExtra("period", period);
		intent.putExtra("type", "event");
		intent.putExtra("due_date", due_date);
		intent.putExtra("start_date", startDate);
		intent.putExtra("status", status);
		intent.putExtra("number_achieved", number_achieved.get(0));
		startActivity(intent);
		}else if(groupPosition==1){
			selected_id=Long.parseLong(selected_items[7]);
			//System.out.println(selected_items[0]+" "+selected_items[1]);
			String name=selected_items[0];
			String number=selected_items[1];
			String period=selected_items[2];
			String due_date=selected_items[3];
			String status=selected_items[6];
			String startDate=selected_items[5];
			String achieved=selected_items[4];
			ArrayList<String> number_achieved=db.getForUpdateCoverageNumberAchieved(selected_id,period);
			Intent intent=new Intent(mContext,UpdateActivity.class);
			intent.putExtra("id",selected_id);
			intent.putExtra("name",name);
			intent.putExtra("number",number);
			intent.putExtra("period", period);
			intent.putExtra("type", "coverage");
			intent.putExtra("due_date", due_date);
			intent.putExtra("start_date", startDate);
			intent.putExtra("status", status);
			intent.putExtra("number_achieved", number_achieved.get(0));
			startActivity(intent);
		}else if(groupPosition==2){
			selected_id=Long.parseLong(selected_items[5]);
			//System.out.println(selected_items[0]+" "+selected_items[1]);
			String name=selected_items[0];
			//String number=selected_items[1];
			String period=selected_items[1];
			String due_date=selected_items[2];
			String status=selected_items[4];
			String startDate=selected_items[3];
			//String achieved=selected_items[4];
			Intent intent=new Intent(mContext,UpdateActivity.class);
			intent.putExtra("id",selected_id);
			intent.putExtra("learning_topic",name);
			//intent.putExtra("number",number);
			intent.putExtra("period", period);
			intent.putExtra("type", "learning");
			intent.putExtra("due_date", due_date);
			intent.putExtra("start_date", startDate);
			intent.putExtra("status", status);
			//intent.putExtra("achieved", achieved);
			startActivity(intent);
		}else if(groupPosition==3){
			selected_id=Long.parseLong(selected_items[7]);
			//System.out.println(selected_items[0]+" "+selected_items[1]);
			String name=selected_items[0];
			String number=selected_items[1];
			String period=selected_items[2];
			String due_date=selected_items[3];
			String status=selected_items[6];
			String startDate=selected_items[5];
			String achieved=selected_items[4];
			ArrayList<String> number_achieved=db.getForUpdateOtherNumberAchieved(selected_id,period);
			Intent intent=new Intent(mContext,UpdateActivity.class);
			intent.putExtra("id",selected_id);
			intent.putExtra("name",name);
			intent.putExtra("number",number);
			intent.putExtra("period", period);
			intent.putExtra("type", "other");
			intent.putExtra("due_date", due_date);
			intent.putExtra("start_date", startDate);
			intent.putExtra("status", status);
			intent.putExtra("number_achieved", number_achieved.get(0));
			startActivity(intent);
		}
		return true;
	}	
	
}
