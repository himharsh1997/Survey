package com.example.tskillsurv;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class TMSurvActivity extends Activity implements OnClickListener {
	
	
	
    Button bt1,bt2,bt3,bt4,bt5;
	EditText edname;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tmsurv);
	   bt1 = (Button)findViewById(R.id.button1);
	   bt2=(Button)findViewById(R.id.button2);
	   bt3=(Button)findViewById(R.id.button3);
	   bt4=(Button)findViewById(R.id.button4);
	   bt5=(Button)findViewById(R.id.button5);
	   edname = (EditText)findViewById(R.id.Name);
	   bt1.setOnClickListener(this);
	   bt2.setOnClickListener(this);
	   bt3.setOnClickListener(this);
	   bt4.setOnClickListener(this);
	   bt5.setOnClickListener(this);
	   
	}

	@Override
	public void onClick(View vv) {
		// TODO Auto-generated method stub
		switch (vv.getId()) {
		case R.id.button1:
	    Intent int1 = new Intent(TMSurvActivity.this,Question1.class);	
	    Bundle bun1 = new Bundle();
	     bun1.putString("name", edname.getText().toString());
	     int1.putExtras(bun1);
	    startActivity(int1);
		break; 
        
		case R.id.button2:
			Intent int2 = new Intent(TMSurvActivity.this,Question2.class);	
			Bundle bun2 = new Bundle();
		     bun2.putString("name", edname.getText().toString());
		     int2.putExtras(bun2);
			startActivity(int2);	
			break;
        case R.id.button3:
        	Intent int3 = new Intent(TMSurvActivity.this,Question3.class);	
        	Bundle bun3 = new Bundle();
   	        bun3.putString("name", edname.getText().toString());
   	       int3.putExtras(bun3);
        	startActivity(int3); 
        	break;	 
        case R.id.button4:
        	Intent int4 = new Intent(TMSurvActivity.this,Question4.class);	
        	Bundle bun4 = new Bundle();
   	        bun4.putString("name", edname.getText().toString());
   	        int4.putExtras(bun4);
        	startActivity(int4);
        	break;	
        case R.id.button5:
        	Intent int5 = new Intent(TMSurvActivity.this,Question5.class);	
        	Bundle bun = new Bundle();
   	        bun.putString("name", edname.getText().toString());
   	        int5.putExtras(bun);
        	startActivity(int5);
        	break;	
		}
	}

}
