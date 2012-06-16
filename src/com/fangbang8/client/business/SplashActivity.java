package com.fangbang8.client.business;

/**
 *  文件名:com.xishinet.cuma.client.business.SplashActivity.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人:Sven Fang
 *  创建时间:2012-5-7
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.fangbang8.client.business.workbench.activity.WorkbenchActivity;
import com.fangbang8.client.common.base.BaseActivity;
import com.fangbang8.client.common.util.SystemManage;

public class SplashActivity extends BaseActivity {
	Handler handler = new Handler();
	Thread thread;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		/** 设置全屏显示 */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		startUp();
	}
	
	/**按键事件回调方法*/
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//按下返回键动作
		if (keyCode == KeyEvent.KEYCODE_BACK) {
		}
		return false;
	}
	



	/**
	 * 3秒后跳转主界面
	 * 
	 */
	private void startUp() {
		thread = new Thread(new Runnable() {
			public void run() {
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, WorkbenchActivity.class);
				startActivity(intent);
				finish();
				handler.removeCallbacks(thread);
			}
		});
		handler.postDelayed(thread, 3000);
	}



}