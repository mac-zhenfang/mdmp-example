package com.mdmp.example.xp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mdmp.example.R;
import com.mdmp.ui.BaseSinglePaneActivity;
import com.umeng.newxp.common.ExchangeConstants;
import com.umeng.newxp.controller.ExchangeDataService;
import com.umeng.newxp.view.ExchangeViewManager;

public class WapUfpExample extends BaseSinglePaneActivity {

	/**
	 * 此id 为http://ufp.umeng.com 友盟UFP (Umeng For Publisher) 系统添加的广告位ID。
	 * 相关注册说明请咨询友盟客服。
	 */
	private static final String SLOT_ID_WAP = "40174";
	@Override
	protected Fragment onCreatePane() {
		return new WapExampleFragment();
	}
	
	public static class WapExampleFragment extends Fragment{
		Context mContext;
		
		@Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        mContext = activity;
	    }
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View root = inflater.inflate(
					R.layout.umeng_example_xp_banner_activity, container,
					false);
			
			ImageView imageview = (ImageView) root.findViewById(R.id.imageview);
			ImageView imageview2 = (ImageView) root.findViewById(R.id.imageview2);
			
//			/**
//			 * 两种方式的逻辑不同 模式1 请求数据在现实ImageView  之前 模式2 请求数据将在ImageView 点击之后
//			 */
//			//把手图片服务器提供 云端不配置图片将不显示
			new ExchangeViewManager(mContext, new ExchangeDataService(SLOT_ID_WAP))
				.addView(ExchangeConstants.type_wap_style, imageview);
//			
//			//SDK定义图片，将无视云端配置图片
			new ExchangeViewManager(mContext, new ExchangeDataService(SLOT_ID_WAP))
				.addView(ExchangeConstants.type_wap_style, imageview2,mContext.getResources().getDrawable(R.drawable.umeng_example_handler));
//			
//			

			

			return root;
		}
		
	}

}