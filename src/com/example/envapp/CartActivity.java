package com.example.envapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class CartActivity extends Activity
{
	
	int cartValue;
		
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{         
       super.onCreate(savedInstanceState);
       setContentView(R.layout.shopping_cart);
       
       for(int i = 0; i < MainActivity.savedEntries.size(); i++)
    	   cartValue += MainActivity.savedEntries.get(i).value;
       if(MainActivity.savedEntries.size() != 0)
    	   cartValue /= MainActivity.savedEntries.size();
       
       ImageView gauge = (ImageView)findViewById(R.id.barometerGauge);
       gauge.setVisibility(View.VISIBLE);
       gauge.setImageResource(R.drawable.barometer_gauge);
       
       float angle = (cartValue * 180 / 100);
       
       gauge.setRotation(angle);
       
       ListAdapter adapter = new ListAdapter(this, MainActivity.savedEntries, false, this);
		
	   ((ListView)findViewById(R.id.cartListView)).setAdapter(adapter);
	   
	   
	}
	
	public void endActivity(View view)
	{
		finish();
	}
	
	
}
