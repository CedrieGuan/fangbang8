/**
 *  文件名:com.xishinet.cuma.client.common.baseBaseAcitivity.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人:Sven Fang
 *  创建时间:2012-5-8
 */
package com.fangbang8.client.common.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

/**
 * @author Sven
 * 
 */
public class BaseActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		/** 禁止横屏切换 */
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	/**
	 * 
	 * onConfigurationChanged
	 * 
	 * the package:android.content.res.Configuration.
	 * 
	 * @param newConfig
	 *            , The new device configuration.
	 *            当设备配置信息有改动（比如屏幕方向的改变，实体键盘的推开或合上等）时，
	 *            并且如果此时有activity正在运行，系统会调用这个函数。
	 *            注意：onConfigurationChanged只会监测应用程序在AnroidMainifest.xml中通过
	 *            android:configChanges="xxxx"指定的配置类型的改动；
	 *            而对于其他配置的更改，则系统会onDestroy()当前Activity，然后重启一个新的Activity实例。
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
	}

}
