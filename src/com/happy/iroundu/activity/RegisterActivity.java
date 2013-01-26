package com.happy.iroundu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.happy.iroundu.R;
import com.happy.iroundu.common.Controller;

public class RegisterActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		bindHead(this);
	}
	
	private void bindHead(final Activity activity){
		
		Button btnBack = (Button)findViewById(R.id.head_back);
		btnBack.setText("返回");
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Controller.showHome(activity);
			}
		});
		
		TextView txtTitle = (TextView)findViewById(R.id.head_title);
		txtTitle.setText("注册");
		
	}
}
