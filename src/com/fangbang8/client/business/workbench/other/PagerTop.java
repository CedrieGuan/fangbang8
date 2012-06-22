package com.fangbang8.client.business.workbench.other;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fangbang8.client.business.R;

public abstract class PagerTop implements OnClickListener{
	public static boolean SHOW = true ;
	public static boolean GONE = false ;
	protected Activity activity ;
	protected LinearLayout mainLL ;
	protected Button btnLeft ;
	protected Button btnCentre ;
	protected Button btnRight ;
	
	LayoutInflater inflater;
	public PagerTop(Activity activity,LinearLayout mainLL){
		this.activity=activity;
		this.mainLL=mainLL;
		 initUI();
		 initData();
	}
	//初始化UI
	public void initUI(){
		inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mainLL.addView(inflater.inflate(R.layout.viewpager_top_button, null));
		btnLeft = (Button)mainLL.findViewById(R.id.vpTopLeftBtn);
		btnCentre = (Button)mainLL.findViewById(R.id.vpTopCentreBtn);
		btnRight = (Button)mainLL.findViewById(R.id.vpTopRightBtn); 
		btnLeft.setOnClickListener(this);
		btnCentre.setOnClickListener(this);
		btnRight.setOnClickListener(this);
	}
	
	protected abstract void initData();
	//添加组件
	protected void addView(int layout){
		mainLL.addView(inflater.inflate(layout, null));
	}

	//设置centre按钮可不可见
	public void setCentreBtn(boolean isShow){
		if(isShow){
			btnCentre.setVisibility(View.VISIBLE);
		}else{
			btnCentre.setVisibility(View.GONE);
		}
	}
	protected View findViewById(int id) {
		return mainLL.findViewById(id);
	}
	protected void setLeft(){}
	protected void setCentre(){}
	protected void setRight(){}

	public void onClick(View v) {
		btnLeft.setBackgroundResource(R.drawable.archives_toggle_whiteleft);
		btnCentre.setBackgroundResource(R.drawable.archives_toggle_centerwhite);
		btnRight.setBackgroundResource(R.drawable.archives_toggle_rightwhite);
		btnLeft.setClickable(true);
		btnCentre.setClickable(true);
		btnRight.setClickable(true);
		switch (v.getId()) {
		case R.id.vpTopLeftBtn:
			btnLeft.setBackgroundResource(R.drawable.archives_toggle_redleft);
			btnLeft.setClickable(false);
			setLeft();
			break;
		case R.id.vpTopCentreBtn:
			btnCentre.setBackgroundResource(R.drawable.archives_toggle_centerred);
			btnCentre.setClickable(false);
			setCentre();
			break;
		case R.id.vpTopRightBtn:
			btnRight.setBackgroundResource(R.drawable.archives_toggle_redright);
			btnRight.setClickable(false);
			setRight();
			break;

		default:
			break;
		}
	}
}
