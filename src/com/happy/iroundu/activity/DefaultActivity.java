package com.happy.iroundu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.happy.iroundu.R;
import com.happy.iroundu.common.Controller;


public class DefaultActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		whereToGoFrom(this);
	}
	
	private void whereToGoFrom(final Activity activity){
		Button btnLogin = (Button)findViewById(R.id.main_login_btn);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Controller.showLogin(activity);
			}
		});
		
		Button btnRegister = (Button)findViewById(R.id.main_regist_btn);
		btnRegister.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Controller.showRegister(activity);
			}
		});
		
		
	}
}
