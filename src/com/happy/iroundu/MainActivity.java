package com.happy.iroundu;

import com.happy.iroundu.common.Controller;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Controller.showLaunch(this);
		//Controller.showWhatsNew(this);
	}

}
