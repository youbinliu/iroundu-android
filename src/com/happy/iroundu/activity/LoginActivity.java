package com.happy.iroundu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.happy.iroundu.R;
import com.happy.iroundu.common.Controller;
import com.happy.iroundu.widget.AlertDialog;
import com.happy.iroundu.widget.LoadingDialog;

public class LoginActivity extends BaseActivity {
	
	private EditText editUserName;
	private EditText editPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		bindHead(this);
		editUserName = (EditText)findViewById(R.id.login_username);
		editPassword = (EditText)findViewById(R.id.login_password);
		bindLoginAction(this);
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
		txtTitle.setText("登陆");
		
	}
	
	private void bindLoginAction(final Activity activity){
		
		Button btnLogin = (Button)findViewById(R.id.btn_login);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String userName = editUserName.getText().toString().trim();
				String password = editPassword.getText().toString().trim();
				
				AlertDialog alertDialog = new AlertDialog(activity);
				
				if("".equals(userName)){
					alertDialog.setContent("用户名不能为空");
					alertDialog.show();
					return;
				}
				
				if("".equals(password)){
					alertDialog.setContent("密码不能为空");
					alertDialog.show();
					return;
				}
				
				
				LoadingDialog ld = new LoadingDialog(activity);
				ld.setLoadText("正在登陆...");
				ld.show();
				
				
			}
		});
	}
}
