package com.example.tskillsurv;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Question5  extends  Activity implements OnItemSelectedListener{
	 Spinner sp;
	   String[] mg=new String[]{
		   		 "-Select-","0","1","2","3","4","5"}; 
	   SQLiteDatabase sqldb5;
	  	final String database_name = "quest55.db";
	      final String table_name = "My_Quesmy55";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.quest5);
	sp = (Spinner)findViewById(R.id.spinn5);
    ArrayAdapter<String> Adp1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mg);
    Adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    try{
	     sqldb5 = openOrCreateDatabase(database_name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
		   sqldb5.execSQL("CREATE TABLE IF NOT EXISTS "+table_name+"(Name TEXT PRIMARY KEY NOT NULL, Grade TEXT)");
		   sp.setOnItemSelectedListener(this);
	     }
	     catch(Exception ex){}  
    sp.setAdapter(Adp1);
	
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Intent back=getIntent();
		Bundle bundle1=back.getExtras();
	    String ss = bundle1.getString("name");
		
		String stt = (String)sp.getItemAtPosition(sp.getSelectedItemPosition());	
		 if(stt=="-Select-"){Toast.makeText(getApplicationContext(), "Data save", Toast.LENGTH_LONG);}
		 else{
		  sqldb5.execSQL("INSERT INTO "+ table_name+ "(Name,Grade) VALUES ('"+ss+"','"+stt+"')");
		
		  Toast.makeText(getApplicationContext(), "Data save"+ss+""+stt, Toast.LENGTH_LONG);
		 }
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
