package com.example.envapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ListEntry {
	
	public String companyName;
	public String productName;
	public float value;
	private Bitmap picture;
	public String carbon;
	public String mercury;
	public String radioactivity;
	
	public ListEntry(String name, String productName,  int value, Bitmap picture)
	{
		this.companyName = name;
		this.productName = productName;
		this.value = value;
		this.picture = picture;
		setEmissions("","","");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
	public void setEmissions(String carbon, String mercury, String radioactivity)  {
		this.carbon = carbon;
		this.mercury = mercury;
		this.radioactivity = radioactivity;
	}

	public Bitmap getPicture() 
	{
		return picture;
	}

}
