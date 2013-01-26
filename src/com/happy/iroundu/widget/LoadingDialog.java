package com.happy.iroundu.widget;

import com.happy.iroundu.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class LoadingDialog extends Dialog {

	private Context mContext;
	private LayoutInflater inflater;
	private TextView loadtext;

	public LoadingDialog(Context context) {
		super(context,R.style.loading_dialog);
		this.mContext = context;
		
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.loadingdialog, null);
		loadtext = (TextView) layout.findViewById(R.id.loading_text);
		setContentView(layout);
	}

	public void setLoadText(String content){
		loadtext.setText(content);
	}
}