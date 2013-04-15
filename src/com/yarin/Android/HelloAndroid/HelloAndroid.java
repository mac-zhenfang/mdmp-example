package com.yarin.Android.HelloAndroid;

import com.mdmp.android.DataAgent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HelloAndroid extends Activity
{
	private static final String	TAG	= "HelloAndroid";


	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.v(TAG, "VERBOSE");
		Log.d(TAG, "DEBUG");
		Log.i(TAG, "INFO");
		Log.w(TAG, "WARN");
		Log.e(TAG, "ERROR");
		setContentView(R.layout.main);
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		DataAgent.onResume(this, "Johnny");
	}
	
	
}
