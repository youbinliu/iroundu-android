package com.happy.iroundu;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

public class AppManage extends Stack<Activity> {

	private static final long serialVersionUID = 1L;
	
	private static AppManage instance = new AppManage();
	
	public static AppManage getInstance(){
		return instance;
	}
	
	
	public Activity currentActivity(){
		return instance.lastElement();		
	}
	
	public void destroyActivity(Activity activity){
		
		if(activity != null){
			instance.remove(activity);
			activity.finish();
			activity = null;
		}
	}
	
	public void destroyCurrent(){
		Activity activity = instance.lastElement();
		destroyActivity(activity);
	}
	
	public void destroyAll(){
		for (int i = 0; i < instance.size(); i++) {
			destroyActivity(instance.get(i));
		}		
	}
	
	public void exit(Context context){
		try {
			destroyAll();
			ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
			activityManager.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {}
	}
	
}
