package com.example.envapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements CameraFragmentListener {

	private RelativeLayout scan;
	
	private int scanIndex = 0;
	
	public static ArrayList<ListEntry> savedEntries = new ArrayList<ListEntry>();
	
	private ArrayList<ListEntry> entries = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListAdapter adapter = new ListAdapter(this, entries, true, this);
		
		((ListView)findViewById(R.id.listView)).setAdapter(adapter);
		
		
		
		this.scan = (RelativeLayout)this.findViewById(R.id.layoutContainer);
		  this.scan.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View v)
			    {
			    	/*
			    	 * Placeholder function that simulates a working scanner.
			    	 */
			    	switch(scanIndex) {
			    	
			    	
			    	case 0:
			    		entries.add(new ListEntry("Samsung","Samsung Galaxy S3", 42, decodeSampledBitmapFromResource(getResources(), R.drawable.s3, 200, 200)));
			    		entries.get(entries.size() - 1).setEmissions("50 000 ton / år", "Kan finnas spår i fabriker", "Nej");
			    		break;
			    	case 1:
			    		entries.add(new ListEntry("Samsung","Samsung Galaxy S5", 42, decodeSampledBitmapFromResource(getResources(), R.drawable.s5, 200, 200)));
			    		entries.get(entries.size() - 1).setEmissions("50 000 ton / år", "Kan finnas spår i fabriker", "Nej");
			    		break;
			    	case 2:
			    		entries.add(new ListEntry("Apple","Iphone 5", 45, decodeSampledBitmapFromResource(getResources(), R.drawable.iphone, 200, 200)));
			    		entries.get(entries.size() - 1).setEmissions("50 ton / år", "Nej", "Nej");
			    		break;
			    	case 3:
			    		entries.add(new ListEntry("Nokia","Lumia 510", 54, decodeSampledBitmapFromResource(getResources(), R.drawable.lumia, 200, 200)));
			    		entries.get(entries.size() - 1).setEmissions("23 475 ton / år", "Nej", "Nej");
			    		break;
			    	default:
			    		
			    	}
			    	updateList();
			    	scanIndex++;
			    }
			  });
		  
		  ((ImageView)findViewById(R.id.shoppingCart)).setOnClickListener(new OnClickListener() 
		  {
				@Override
				public void onClick(View arg0) 
				{
					startActivity(new Intent(MainActivity.this, CartActivity.class)); 
				}
				  });
	}
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	
	private void updateList()
	{
		ListAdapter adapter = new ListAdapter(this, entries, true, this);
    	((ListView)findViewById(R.id.listView)).setAdapter(adapter);
	}
	
	@Override
    public void onCameraError() {
        Toast.makeText(
            this,
            "shit",
            Toast.LENGTH_SHORT
        ).show();

        finish();
    }
}
