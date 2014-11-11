package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MaternalEmergenciesActivity extends Activity {

	private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_maternal_emergencies);
	    listView=(ListView) findViewById(R.id.listView_postnatalCareMotherSections);
	    String[] items={"Difficulty breathing or central cyanosis ",
	    				"Shock ",
	    				"Heavy bleeding",
	    				"Convulsion, Unconscious","No symptoms"};
	    ListAdapter adapter=new ListAdapter(MaternalEmergenciesActivity.this,items);
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Intent intent;
					switch(position){
					case 0:
						intent=new Intent(MaternalEmergenciesActivity.this,TakeActionMaternalEmergenciesActivity.class);
						intent.putExtra("value","difficulty_breathing");
						startActivity(intent);
						break;
					}
				
			}
	    	
	    });
	}
	class ListAdapter extends BaseAdapter{
		Context mContext;
		String[] items;
		 public LayoutInflater minflater;
		public ListAdapter(Context c,String[] items){
			this.mContext=c;
			this.items=items;
			minflater = LayoutInflater.from(mContext);
		}
		@Override
		public int getCount() {
			return items.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if( convertView == null ){
			      
				  convertView = minflater.inflate(R.layout.listview_text_single,parent, false);
			    }
			 TextView text=(TextView) convertView.findViewById(R.id.textView_listViewText);
			 text.setText(items[position]);
			    return convertView;
		}
		
	}
}
