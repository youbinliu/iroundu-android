package com.happy.iroundu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;

public class AppException extends Exception implements UncaughtExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final boolean debug = false;
	private static final String logFile = "errorlog.txt";
	private static final String TAG = "AppException";
	
	public static final byte TYPE_NETWORK    = 0x01;
	public static final byte TYPE_SOCKET     = 0x02;
	public static final byte TYPE_HTTP_ERROR = 0x03;
	public static final byte TYPE_XML        = 0x04;
	public static final byte TYPE_IO         = 0x05;
	public static final byte TYPE_RUN        = 0x06;
	
	private byte type = 0x00;
	private String message = "";
	
	private Thread.UncaughtExceptionHandler ueh;
	
	public AppException(){}
	
	public AppException(Exception exception){
		super(exception);
		this.ueh     = Thread.getDefaultUncaughtExceptionHandler();
		if(debug){
			log2file(exception);
		}
	}
	
	public AppException(byte type,String message,Exception exception){
		this(exception);
		this.type    = type;
		this.message = message;
	}
	
	public byte getType(){
		return type;
	}
	
	public String getMessage(){
		return message;
	}
	
	
	
	
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if(customHandleException(ex) && ueh != null){
			ueh.uncaughtException(thread, ex);
		}		
	}
	
	private boolean customHandleException(Throwable ex){
		if(ex == null) return false;
		
		final Context context = AppManager.getInstance().currentActivity();
		
		if(context == null) return false;
		
		final String crashReport = getCrashReport(context, ex);
		
		new Thread(){
			public void run(){
				Looper.prepare();
				//TODO report to server
				Log.e(TAG, crashReport);
				Looper.loop();
			}
			
		}.start();
		
		return true;
	}
	
	public String getCrashReport(Context context,Throwable ex){
		PackageInfo pkgInfo = ((AppContext) context.getApplicationContext()).getPackageInfo();
		StringBuffer exstr = new StringBuffer();
		exstr.append("Version:"+pkgInfo.versionName+"("+pkgInfo.versionCode+")\n");
		exstr.append("Android:"+android.os.Build.VERSION.RELEASE+"("+android.os.Build.MODEL+")\n");
		exstr.append("Exception:"+ex.getMessage()+"\n");
		StackTraceElement[] elements = ex.getStackTrace();
		for (int i = 0; i < elements.length; i++) {
			exstr.append(elements[i].toString()+"\n");
		}
		return exstr.toString();
		
	}
	
	public void log2file(Exception ex){
		String savePath = "";
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			String storageState = Environment.getExternalStorageState();
			if(!Environment.MEDIA_MOUNTED.equals(storageState))return;
			
			savePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/iroundu/log/";
			File file = new File(savePath);
			if(!file.exists())file.mkdirs();
			
			savePath += logFile;
			file = new File(savePath);
			if(!file.exists())file.createNewFile();
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			pw.println(new Date().toLocaleString());
			ex.printStackTrace(pw);
			pw.close();
			fw.close();			
		} catch (Exception e) {
			Log.e(TAG,e.getMessage());
		}finally{
			if(pw != null)pw.close();
			if(fw != null)try{fw.close();}catch (IOException e) {};
		}
	}

}
