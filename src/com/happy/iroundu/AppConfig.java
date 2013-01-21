package com.happy.iroundu;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppConfig {
	
	public final static String CONF_APP_ID = "appID";
	public final static String CONF_TOKEN = "token";
	public final static String CONF_EXPIRESIN = "expiresIn";
	public final static String CONF_CHECKUP = "checkup";
	
	
	
	private static AppConfig instance = null;
	private SharedPreferences settings = null;
	
	private AppConfig(){}
	
	public AppConfig getInstance(Context context){
		if(instance == null){
			instance = new AppConfig();
			instance.settings = PreferenceManager.getDefaultSharedPreferences(context);
		}
		
		return instance;
	}
	
	
	public void set(String key, String value) {
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public void remove(String key){
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(key);
		editor.commit();
	}
	
	public String get(String key) {
		return settings.getString(key, "");
	}
	

}
