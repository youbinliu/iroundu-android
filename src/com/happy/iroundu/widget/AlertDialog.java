package com.happy.iroundu.widget;

import com.happy.iroundu.AppManager;
import com.happy.iroundu.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class AlertDialog extends Dialog {

	private Context mContext;
	private LayoutInflater inflater;
	private TextView title;
	private TextView content;
	private Button btnSure;

	public AlertDialog(Context context) {
		super(context,R.style.pop_dialog);
		this.mContext = context;
		
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.alertdialog,null);		
		setContentView(layout);
		
		adjustWidth();		
		
		title = (TextView)findViewById(R.id.alert_title);
		content = (TextView)findViewById(R.id.alert_content);
		btnSure = (Button)findViewById(R.id.btn_sure);
		
		bindBtnSure(this);
	}
	
	private void adjustWidth(){
		WindowManager m = AppManager.getInstance().currentActivity().getWindowManager();
	    Display d = m.getDefaultDisplay(); 
	    WindowManager.LayoutParams p = getWindow().getAttributes();
	    p.width = (int) (d.getWidth() * 0.65); 
	    getWindow().setAttributes(p);
	}

	public void setTitle(String title){
		this.title.setText(title);
	}
	
	public void setContent(String content){
		this.content.setText(content);
	}
	
	public void setTitleAndContent(String title,String content){
		setTitle(title);
		setContent(content);
	}
	
	private void bindBtnSure(final AlertDialog alertDialog){
		btnSure.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				alertDialog.hide();
			}
		});
	}
}