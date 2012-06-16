package com.fangbang8.client.business.workbench.other;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

public class FirstPager extends PagerTop{
	private static FirstPager fp;
	
	public FirstPager(Activity activity, LinearLayout mainLL) {
		super(activity,mainLL);
	}
	//单例
	public static FirstPager getInstance(Activity activity,LinearLayout mainLL){
		if(fp==null){
			fp=new FirstPager(activity,mainLL);
		}
		return fp;
	}
	@Override
	public void initUI() {
		super.initUI();
		setCentreBtn(GONE);
	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
}
