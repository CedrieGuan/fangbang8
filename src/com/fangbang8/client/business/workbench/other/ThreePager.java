package com.fangbang8.client.business.workbench.other;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

public class ThreePager extends PagerTop{
private static ThreePager fp;
	
	public ThreePager(Activity activity, LinearLayout mainLL) {
		super(activity,mainLL);
	}
	
	//单例
	public static ThreePager getInstance(Activity activity,LinearLayout mainLL){
		if(fp==null){
			fp=new ThreePager(activity,mainLL);
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
