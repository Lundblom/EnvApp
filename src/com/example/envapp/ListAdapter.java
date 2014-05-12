package com.example.envapp;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class ListAdapter extends android.widget.ArrayAdapter<ListEntry> 
{
	private Context context;
	private List<ListEntry> items;
	private boolean add = true;
	private Activity act;

	public ListAdapter(Context context, List<ListEntry> objects, boolean add, Activity act) {
		super(context, -1, objects);
		this.items = objects;
		this.context = context;
		this.add = add;
		this.act = act;
	}
	
	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent)
	{
		// Get the current list item
        final ListEntry item = items.get(position);
        // Get the layout for the list item
        final RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
        
        itemLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(context, BarometerActivity.class);
				
				Bundle b = new Bundle();
				
				final ListEntry item = items.get(position);
				
				b.putString("carbon", item.carbon);
				b.putString("mercury", item.mercury);
				b.putString("radioactivity", item.radioactivity);
				b.putString("company", item.companyName);
				b.putFloat("value", item.value);
				i.putExtras(b);
				
				context.startActivity(i);
				
			}
		});
        
        ImageView addButton = (ImageView)itemLayout.findViewById(R.id.addButton);
        if(add)
        {
        	addButton.setImageDrawable(context.getResources().getDrawable(R.drawable.plus));
	        addButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
					MainActivity.savedEntries.add(item);
					Toast.makeText(context, "Item added!", Toast.LENGTH_SHORT).show();
					
				}
			});
        }
        else
        {
        	addButton.setImageDrawable(context.getResources().getDrawable(R.drawable.minus));
            
        	addButton.setOnClickListener(new OnClickListener() 
        	{
				@Override
				public void onClick(View v) 
				{
					MainActivity.savedEntries.remove(position);
					act.recreate();
				}
			});
        }
        
        TextView txtLabel = (TextView)itemLayout.findViewById(R.id.companyName);
        txtLabel.setText(item.companyName);
        
        // Set the icon as defined in our list item
        ImageView imgIcon = (ImageView) itemLayout.findViewById(R.id.imgIcon);
        imgIcon.setImageBitmap(item.getPicture());
        
        TextView numberLabel = (TextView)itemLayout.findViewById(R.id.productRating);
        numberLabel.setText("" + (int)item.value + "/100");
        numberLabel.setTextColor(Color.rgb((int)(255f - 2.55f*item.value), (int)(2.55f * item.value), 0));
        
        TextView txtLabel2 = (TextView)itemLayout.findViewById(R.id.productName);
        txtLabel2.setText(item.productName);

        return itemLayout;
	}
}
