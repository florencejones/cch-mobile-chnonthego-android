package org.grameenfoundation.poc;

import org.digitalcampus.mobile.learningGF.R;
import org.digitalcampus.mobile.learningGF.R.id;
import org.digitalcampus.oppia.application.DbHelper;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TreatingDiarrhoeaActivity extends BaseActivity {
	private Long start_time;
	private Long end_time;
	private DbHelper dbh;
	private TextView amount;
	private EditText editText_weight;
	private Button button_calculate;
	private ImageView image;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_treating_diarrhoea);
	    getActionBar().setTitle("Point of Care");
	    getActionBar().setSubtitle("PNC Counselling: Treating Diarrhoea");
	    dbh=new DbHelper(TreatingDiarrhoeaActivity.this);
	    start_time=System.currentTimeMillis();
	    amount=(TextView) findViewById(R.id.textView_amount);
	    editText_weight=(EditText) findViewById(R.id.editText_weight);
	    button_calculate=(Button) findViewById(R.id.button_calculate);
	    image=(ImageView) findViewById(R.id.imageView1);
	    button_calculate.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String weight=editText_weight.getText().toString();
				if(weight.equals("")){
					editText_weight.requestFocus();
					editText_weight.setError("Enter a value!");
				}else{
				 double ors_amount_given=Double.valueOf(weight)*75;
				 amount.setText("ORS amount= "+String.valueOf(ors_amount_given));
				}
			}
	    	
	    });
	    
	    
      	 image.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				final Dialog nagDialog = new Dialog(TreatingDiarrhoeaActivity.this);
	            nagDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); 
	            nagDialog.setCancelable(false);
	            nagDialog.setContentView(R.layout.image_view_dialog);
	            ImageButton btnClose = (ImageButton)nagDialog.findViewById(R.id.imageButton_close);
	            ImageView ivPreview = (ImageView)nagDialog.findViewById(R.id.imageView_largerImage);
	            ivPreview.setImageResource(R.drawable.treating_diarrhoea_weight_chart);

	            btnClose.setOnClickListener(new OnClickListener() {
	                @Override
	                public void onClick(View arg0) {

	                    nagDialog.dismiss();
	                }
	            });
	            nagDialog.show();
				
			}
	    	
	    });
	   
	}
	public void onBackPressed()
	{
		 end_time=System.currentTimeMillis();
		dbh.insertCCHLog("Point of Care", "PNC Counselling: Treating Diarrhoea" , start_time.toString(), end_time.toString());
		finish();
	}
}
