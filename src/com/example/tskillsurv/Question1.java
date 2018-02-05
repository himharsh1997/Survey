package com.example.tskillsurv;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.*;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Canvas;
import android.graphics.Color;
import android.widget.LinearLayout;

 

public class Question1 extends Activity implements OnItemSelectedListener{
    Spinner sp;
    LinearLayout linearChart;
    String[] mg=new String[]{
   		 "-Select-","C","Java","Javascript","Python"}; 
    SQLiteDatabase sqldb1;
   	final String database_name = "quest11.db";
       final String table_name = "My_Quesmy";
       private RelativeLayout mainLayout;
       private PieChart mChart;
       // we're going to display pie chart for smartphones martket shares
       private float[] yData = { 5, 10, 15, 30, 40 };
       private String[] xData = { "Sony", "Huawei", "LG", "Apple", "Samsung" };
      
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.quest1);
	   
	    sp = (Spinner)findViewById(R.id.spinn1);
	    ArrayAdapter<String> Adp1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mg);
	    Adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	     sp.setAdapter(Adp1);
	     try{
	     sqldb1 = openOrCreateDatabase(database_name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
		   sqldb1.execSQL("CREATE TABLE IF NOT EXISTS "+table_name+"(Name TEXT PRIMARY KEY NOT NULL, Lang TEXT)");
		 
		   sp.setOnItemSelectedListener(this);
		  
	     }
	     catch(Exception ex){Toast.makeText(getApplicationContext(), "Data save", Toast.LENGTH_SHORT);}
	      
	}    
	


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		// TODO Auto-generated method stub
		Intent back=getIntent();
		Bundle bundle1=back.getExtras();
	    String ss = bundle1.getString("name");
		
		String stt = (String)sp.getItemAtPosition(sp.getSelectedItemPosition());	
		 if(stt=="-Select-"){Toast.makeText(getApplicationContext(), "Data save", Toast.LENGTH_LONG);}
		 else{
		  sqldb1.execSQL("INSERT INTO "+ table_name+ "(Name,Lang) VALUES ('"+ss+"','"+stt+"')");
			Log.v("Name", "name"+ss+"lang"+stt);
		  Toast.makeText(getApplicationContext(), "Data save"+ss+""+stt, Toast.LENGTH_LONG);
		 }
	}

	





	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	}
 