package com.fangbang8.client.business.workbench.other;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

public class SecondPager extends PagerTop{
private static SecondPager fp;
	
	public SecondPager(Activity activity, LinearLayout mainLL) {
		super(activity,mainLL);
	}
	//单例
	public static SecondPager getInstance(Activity activity,LinearLayout mainLL){
		if(fp==null){
			fp=new SecondPager(activity,mainLL);
		}
		return fp;
	}
	@Override
	public void initUI() {
		super.initUI();
		setCentreBtn(SHOW);
		
	}
	@Override
	protected void initData() {
		
	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
}
