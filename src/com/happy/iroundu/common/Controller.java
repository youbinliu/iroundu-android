package com.happy.iroundu.common;

import com.happy.iroundu.activity.DefaultActivity;
import com.happy.iroundu.activity.LaunchActivity;
import com.happy.iroundu.activity.LoginActivity;
import com.happy.iroundu.activity.RegisterActivity;
import com.happy.iroundu.activity.WhatsnewActivity;

import android.app.Activity;
import android.content.Intent;
//import android.util.Log;

public class Controller {
	
	///private final static String TAG = "Controller";
	
	public static void showHome(Activity activity){
		Intent intent = new Intent(activity,DefaultActivity.class);
		activity.startActivity(intent);
		activity.finish();		
	}
	
	public static void showLaunch(Activity activity){
		Intent intent = new Intent(activity,LaunchActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
	
	public static void showWhatsNew(Activity activity){
		Intent intent = new Intent(activity,WhatsnewActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
	
	public static void showLogin(Activity activity){
		Intent intent = new Intent(activity,LoginActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
	
	public static void showRegister(Activity activity){
		Intent intent = new Intent(activity,RegisterActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
}
