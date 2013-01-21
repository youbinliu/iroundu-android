package com.happy.iroundu.activity;


import com.happy.iroundu.R;
import com.happy.iroundu.common.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class LaunchActivity extends Activity {

	private final static float fromAlpha = 0.3f;
	private final static float toAlpha = 1.0f;
	private final static long durationMillis = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final View view = View.inflate(this, R.layout.launch, null);
		setContentView(view);
		
		startAnima(this,view);		
		
	}

	private void startAnima(final Activity activity,final View view) {
		
		AlphaAnimation aa = new AlphaAnimation(fromAlpha, toAlpha);
		aa.setDuration(durationMillis);
		view.startAnimation(aa);
		
		aa.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				Controller.showHome(activity);
			}
		});
	}
	
	
	

	
}
