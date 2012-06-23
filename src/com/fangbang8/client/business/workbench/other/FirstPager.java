package com.fangbang8.client.business.workbench.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.fangbang8.client.business.R;

public class FirstPager extends PagerTop {
	// 对象
	private static FirstPager fp;
	// 数据listview
	private ListView lvData;

	public FirstPager(Activity activity, LinearLayout mainLL) {
		super(activity, mainLL);
	}

	// 单例
	public static FirstPager getInstance(Activity activity, LinearLayout mainLL) {
		if (fp == null) {
			fp = new FirstPager(activity, mainLL);
		}
		return fp;
	}

	@Override
	public void initUI() {
		super.initUI();
		setCentreBtn(GONE);
		addView(R.layout.data_listview);
		lvData = (ListView) findViewById(R.id.dateLV);
	}

	@Override
	protected void initData() {
	
		
	}
	
	
	@Override
	protected void setLeft() {
		super.setLeft();
	}

	@Override
	protected void setRight() {
		super.setRight();
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
}
