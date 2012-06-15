/**
 *  文件名:JSONParserUtil.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人:Administrator
 *  创建时间:2012 下午2:58:23
 */
package com.fangbang8.client.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * JSON解析的工具类
 * @author 黄升福
 *
 */
public class JSONParserUtil {
	
	/**
	 * 获取JSON的键值列表
	 * 1.获取全部键
	 * 2.根据键列表中的键获取键值
	 * @param jsonString:需解析的JSON字符串
	 */
	public static HashMap<String, String> getAllSimpleAttr(String jsonString) {
		HashMap<String, String> simpleAttr = new HashMap<String, String>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			//获取所有JSON的键值
			Iterator iterator = jsonObject.keys();
			//遍历JSON的键，获取该键下的值
			while (iterator.hasNext()) {
				String keyString = (String) iterator.next();
				String valueString = jsonObject.getString(keyString);
				simpleAttr.put(keyString, valueString);
			}// end of while iterator

		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}// end of try-catch

		return simpleAttr;
	}//end of getAllSimpleAttr
	
	/**
	 * 根据某个键获取JSON字符串中的相应值,若某键的值为一集合返回JSON集合的字符串
	 * 1.创建根据JSON数据字符串创建JSON对象
	 * 2.根据JSON数据中某个键获取JSON字符串信息
	 * 
	 * @param jsonStr 需解析的字符串
	 * @param key 需解析的键
	 * @return 
	 */
	public static String getJsonString(String jsonStr, String key){
		String jsonValue = null;
		
		try{
			JSONObject jsonObject = new JSONObject(jsonStr);
			jsonValue = jsonObject.getString(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return jsonValue;
	}//end of getJsonString method
	
	/**
	 * 根据某个键获取JSON字符串中的相应值
	 * 1.创建根据JSON数据字符串创建JSON对象
	 * 2.根据JSON数据中某个键获取JSON整形值信息
	 * 
	 * @param jsonStr 需解析的字符串
	 * @param key 需解析的键
	 * @return 
	 */
	public static int getJsonInt(String jsonStr, String key){
		int jsonValue = 0;
		
		try{
			JSONObject jsonObject = new JSONObject(jsonStr);
			jsonValue = jsonObject.getInt(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return jsonValue;
	}//end of getJsonString method
	
	/**
	 * 根据某个键获取JSON字符串中的相应值
	 * 1.创建根据JSON数据字符串创建JSON对象
	 * 2.根据JSON数据中某个键获取JSON整形值信息
	 * 
	 * @param jsonStr 需解析的字符串
	 * @param key 需解析的键
	 * @return 
	 */
	public static long getJsonLong(String jsonStr, String key){
		long jsonValue = 0;
		
		try{
			JSONObject jsonObject = new JSONObject(jsonStr);
			jsonValue = jsonObject.getInt(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return jsonValue;
	}//end of getJsonString method
	
	
	/**
	 * 根据某个键获取JSON字符串中的相应值
	 * 1.创建根据JSON数据字符串创建JSON对象
	 * 2.根据JSON数据中某个键获取JSON字符串信息
	 * 
	 * @param jsonStr 需解析的字符串
	 * @param key 需解析的键
	 * @return 
	 */
	public static ArrayList<String> getJsonArray(String jsonStr, String key){
		ArrayList<String> al_jsonArray = new ArrayList<String>(); 
		
		try{
			JSONObject jsonObject = new JSONObject(jsonStr);
			JSONArray jsonArray = jsonObject.getJSONArray(key);
			for(int i=0;i<jsonArray.length();i++){ 
				al_jsonArray.add(jsonArray.getString(i));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}//end of try-catch
		
		return al_jsonArray;
	}//end of getJsonArray method
}
