package com.happy.iroundu;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class AppContext extends Application {
	
	private final static String TAG = "AppContext";
	
	@Override
	public void onCreate(){
		super.onCreate();
		Thread.setDefaultUncaughtExceptionHandler(new AppException());
	}
	
	public PackageInfo getPackageInfo(){
		PackageInfo info = null;
		try {
			info = getPackageManager().getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e) {
			Log.e(TAG, "PackageName not found exception");
		}
		
		if (info == null)info = new PackageInfo();
		
		return info;		
	}
}
