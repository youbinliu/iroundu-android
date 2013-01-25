package com.happy.iroundu.activity;


import com.happy.iroundu.R;
import com.happy.iroundu.common.Controller;
import com.happy.iroundu.widget.ScrollLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class WhatsnewActivity extends BaseActivity {

	//private final static String TAG = "Whatsnew";
	
	private ScrollLayout scrollLayout;
	private ImageView[] pageBg;
	private int currentItem = 0;
	private int count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whatsnew);
		
		bindScroll();
		bindStartBtn(this);
	}
	
	private void bindScroll(){
		scrollLayout = (ScrollLayout)findViewById(R.id.whatsnew_scrolllayout);
		LinearLayout pointLayout = (LinearLayout) findViewById(R.id.llayout);
		
		count = scrollLayout.getChildCount();
		pageBg = new ImageView[count];
		for(int i = 0; i< count;i++) {
			pageBg[i] = (ImageView) pointLayout.getChildAt(i);
			pageBg[i].setEnabled(true);
			pageBg[i].setTag(i);
		}
		currentItem = 0;
		pageBg[currentItem].setEnabled(false);
		
		scrollLayout.SetOnViewChangeListener(new ScrollLayout.OnViewChangeListener() {
			
			@Override
			public void OnViewChange(int position) {
				if(position < 0 || position > count -1 || currentItem == position) {
					return;
				}
				
				pageBg[currentItem].setEnabled(true);
				pageBg[position].setEnabled(false);
				currentItem = position;
			}
		});
	}
	
	private void bindStartBtn(final Activity activity){
		Button startBtn = (Button)findViewById(R.id.startBtn);
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Controller.showHome(activity);
			}
		});
	}
	
}
