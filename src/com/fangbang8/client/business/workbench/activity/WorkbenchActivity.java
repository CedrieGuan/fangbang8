package com.fangbang8.client.business.workbench.activity;

/**
 *  文件名:com.xishinet.cuma.client.businessTutorialActivity.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人:Sven Fang
 *  创建时间:2012-5-8
 */

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fangbang8.client.business.R;
import com.fangbang8.client.business.workbench.other.FirstPager;
import com.fangbang8.client.business.workbench.other.SecondPager;
import com.fangbang8.client.business.workbench.other.ThreePager;
import com.fangbang8.client.common.base.BaseActivity;

/**
 * @author Sven
 * 
 */
public class WorkbenchActivity extends BaseActivity {

	private ViewPager viewPager;
	/** vpageView里包含的界面 */
	private ArrayList<View> pageViews;
	/** 主界面 */
	private ViewGroup main;
	
	private Button btnLeft ;
	private Button btnCentre ;
	private Button btnRight ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/** 初始化UI界面 */
		initUI();
		/** 初始化底部小点 */
		setContentView(main);
		/** 设置viewpager adapter */
		viewPager.setAdapter(new HelpPageAdapter());
		/** 设置页面切换监听器r */
		viewPager.setOnPageChangeListener(new HelpPageChangeListener());
	}

	/** 初始化UI界面 */
	private void initUI() {
		
		LayoutInflater inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.wb_item, null));
		pageViews.add(inflater.inflate(R.layout.wb_item, null));
		pageViews.add(inflater.inflate(R.layout.wb_item, null));
		main = (ViewGroup) inflater.inflate(R.layout.workbench, null);
		viewPager = (ViewPager) main.findViewById(R.id.wBVP);
		btnLeft = (Button)main.findViewById(R.id.wbOneBtn);		
		btnCentre = (Button)main.findViewById(R.id.wbTwoBtn);		
		btnRight = (Button)main.findViewById(R.id.wbThreeBtn);		
		
		btnLeft.setOnClickListener(new WbOnClickListener(0));	
		btnCentre.setOnClickListener(new WbOnClickListener(1));	
		btnRight.setOnClickListener(new WbOnClickListener(2));	
		
		FirstPager.getInstance(WorkbenchActivity.this,(LinearLayout)pageViews.get(0));
		SecondPager.getInstance(WorkbenchActivity.this,(LinearLayout)pageViews.get(1));
		ThreePager.getInstance(WorkbenchActivity.this,(LinearLayout)pageViews.get(2));
				
	}



	/** ViewPagerAdapter */
	class HelpPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}
		/**
		 * 从指定的position创建page
		 * 
		 * @param container
		 *            ViewPager容器
		 * @param position
		 *            The page position to be instantiated.
		 * @return 返回指定position的page，这里不需要是一个view，也可以是其他的视图容器.
		 */
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {

		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

		@Override
		public void finishUpdate(View arg0) {
		}
	}

	/** 界面切换监听器 */
	class HelpPageChangeListener implements OnPageChangeListener {

		public void onPageScrollStateChanged(int arg0) {

		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		public void onPageSelected(int arg0) {
		}
	}
	
	class WbOnClickListener implements OnClickListener{
		private int i ;
		public WbOnClickListener(int i){
			this.i = i ;
		}
		public void onClick(View v) {		
			viewPager.setCurrentItem(i);
		}
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			System.exit(0);
		}
		return false;
	}
}