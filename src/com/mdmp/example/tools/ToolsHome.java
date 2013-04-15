package com.mdmp.example.tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mdmp.example.UmengHome;
import com.mdmp.ui.BaseSinglePaneActivity;

public class ToolsHome extends BaseSinglePaneActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected Fragment onCreatePane() {
		return new UmengHome.UmengHomeDashboardFragment();
	}
}