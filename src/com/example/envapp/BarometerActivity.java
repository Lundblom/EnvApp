package com.example.envapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BarometerActivity extends Activity 
{
	
	String carbon;
	String mercury;
	String radioactivity;
	
	int totalValue;
	private String companyName;
	
	public void endActivity(View v) {
		finish();
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{         
       super.onCreate(savedInstanceState);
       setContentView(R.layout.barometer);
       Bundle b = getIntent().getExtras();
       
    	   carbon = b.getString("carbon");
    	   mercury = b.getString("mercury");
    	   radioactivity = b.getString("radioactivity");
    	   companyName = b.getString("company");
    	   totalValue = (int)b.getFloat("value", 0);
       
       
       ((TextView)findViewById(R.id.companyName)).setText(companyName);
       ((TextView)findViewById(R.id.carbon)).setText("Koldioxid: " + carbon);
       ((TextView)findViewById(R.id.mercury)).setText("Kvicksilver: " + mercury);
       ((TextView)findViewById(R.id.radioactivity)).setText("Radioaktivitet: " + radioactivity);
       
       ImageView gauge = (ImageView)findViewById(R.id.barometerGauge);
       gauge.setVisibility(View.VISIBLE);
       gauge.setImageResource(R.drawable.barometer_gauge);
       
       float angle = (totalValue * 180 / 100);
       
       gauge.setRotation(angle);

       
   }
}
