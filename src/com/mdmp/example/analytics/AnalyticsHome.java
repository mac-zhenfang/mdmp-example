package com.mdmp.example.analytics;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.mdmp.android.DataAgent;
import com.mdmp.example.R;
import com.mdmp.ui.BaseSinglePaneActivity;


public class AnalyticsHome extends BaseSinglePaneActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//DataAgent.setDebugMode(true);
		
//		DataAgent.setAutoLocation(true);
//		DataAgent.setSessionContinueMillis(1000);
//		DataAgent.setUpdateOnlyWifi(false);
//		DataAgent.setDefaultReportPolicy(this, ReportPolicy.BATCH_BY_INTERVAL, 5*1000);
		
		//DataAgent.updateOnlineConfig(this);
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		DataAgent.onResume(this);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		DataAgent.onPause(this);
	}
	
	/**
	 * android:onClick="onButtonClick"
	 * @param view
	 */
	public void onButtonClick(View view){
		int id = view.getId();
		if(id == R.id.umeng_example_analytics_online_config){
			
			String onlineParams= DataAgent.getConfigParams(this, "abc");//the demo param's key is 'abc'
			if(onlineParams.equals("")){
				Toast.makeText(this, "Get No Online Params", Toast.LENGTH_SHORT).show();
			}else
				Toast.makeText(this, "Online Params:"+ onlineParams, Toast.LENGTH_SHORT).show();
		}else if(id == R.id.umeng_example_analytics_event){
			
			DataAgent.onEvent(this, "click");
			DataAgent.onEvent(this, "click", "button");
			
		}else if(id == R.id.umeng_example_analytics_ekv){
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("type", "popular");
			map.put("artist", "JJLin");
			
			DataAgent.onEvent(this, "music", map);
		}else if(id == R.id.umeng_example_analytics_duration){
			
			// We need manual to compute the Events duration 
			DataAgent.onEventDuration(this, "book", 12000);
			DataAgent.onEventDuration(this, "book", "chapter1", 23000);
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("type", "popular");
			map.put("artist", "JJLin");
			
			DataAgent.onEventDuration(this, "music", map, 2330000);
	
			
		}else if(id == R.id.umeng_example_analytics_event_begin){
			//Log.i("duration", "start");
			//when the events start
			DataAgent.onEventBegin(this, "music");
			
			DataAgent.onEventBegin(this, "music", "one");
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("type", "popular");
			map.put("artist", "JJLin");
			
			DataAgent.onKVEventBegin(this, "music", map, "flag0");
			
		}else if(id == R.id.umeng_example_analytics_event_end){
			
			DataAgent.onEventEnd(this, "music");
			DataAgent.onEventEnd(this, "music", "one");	
			
			DataAgent.onKVEventEnd(this, "music", "flag0");
		}else if(id == R.id.umeng_example_analytics_make_crash){
			"123".substring(10);
		}else if(id == R.id.umeng_example_analytics_js_analytic){
			//startActivity( new Intent( this, WebviewAnalytic.class) );
		}else if(id == R.id.umeng_example_analytics_flush){
			DataAgent.flush(this);
		}
	}

	@Override
	protected Fragment onCreatePane() {
		return new AnalyticsHomeDashboardFragment();	
	}
	
	public static class AnalyticsHomeDashboardFragment extends Fragment {
		
		@Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	    }
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return inflater.inflate(R.layout.umeng_example_analytics, container,false);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			
			Hook();
			
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	///对于好多应用，会在程序中杀死 进程，这样会导致我们统计不到此时Activity结束的信息，
	///对于这种情况需要调用 'DataAgent.onKillProcess( Context )'
	///方法，保存一些页面调用的数据。正常的应用是不需要调用此方法的。
	private void Hook(){
		 AlertDialog.Builder builder = new AlertDialog.Builder( this );    
	        builder.setPositiveButton("退出应用",  
	                new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int whichButton) {  
	                    	DataAgent.onKillProcess(this);
	                    	
	                    	int pid = android.os.Process.myPid();
	            			android.os.Process.killProcess(pid);
	                    }  
	                });  
	        builder.setNeutralButton("后退一下",  
	                new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int whichButton) {  
	                        finish();
	                    }  
	                });  
	        builder.setNegativeButton("点错了",  
	                new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int whichButton) {  
	                    }  
	                });  
	        builder.show();  
	}
}