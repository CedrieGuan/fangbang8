/**
 *  文件名:HotLineRecordAdapter.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人: LY.Koon<koon.lingyu@gmail.com>
 *  创建时间:2012-5-24 下午6:20:46
 */

package com.fangbang8.client.business.workbench.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fangbang8.client.business.R;
import com.fangbang8.client.entity.CheckScores;

/**
 * @author LY.Koon<koon.lingyu@gmail.com> 咨询历史记录adapter
 */
public class CheckScoresAdapter extends BaseAdapter {

	private LayoutInflater qhInflater;
	private ArrayList<CheckScores> css;

	/**
	 * 
	 */
	public CheckScoresAdapter(Context context, ArrayList<CheckScores> css) {
		qhInflater = LayoutInflater.from(context);
		this.css = css;
	}

	public int getCount() {
		return css.size();
	}

	public Object getItem(int position) {
		return css.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		CheckScores cs = css.get(position);
		convertView = qhInflater.inflate(R.layout.img_title_item, null);
		TextView tvTitle = (TextView) convertView.findViewById(R.id.imgTitleItemTV);
		ImageView imgImg = (ImageView) convertView.findViewById(R.id.imgTitleItemImg);
		tvTitle.setText(cs.getTitle());
		convertView.setTag(position);
		return convertView;
	}

}
