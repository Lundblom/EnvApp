package com.example.envapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class LoadingActivity extends Activity 
{
	
	private final long splashTime = 2000;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {         

       super.onCreate(savedInstanceState);    
       Handler mHandler=new Handler();
       mHandler.postDelayed(new Runnable() {

           @Override
           public void run() {
               startActivity(new Intent(LoadingActivity.this, MainActivity.class));  
               finish();
           }
       },splashTime);
   }

}
