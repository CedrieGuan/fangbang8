/**
 *  文件名:PingYinUtil.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人: LY.Koon<koon.lingyu@gmail.com>
 *  创建时间:2012-5-23 下午5:06:01
*//*

package com.fangbang8.client.common.util;

import java.util.ArrayList;
import java.util.Iterator;

*//**
 *
 *
 * @author LY.Koon<koon.lingyu@gmail.com>
 *
 *//*
public class PingYinUtil {
	*//** 简体中文的编码范围从B0A1（45217）一直到F7FE（63486）*//*
	private static int BEGIN = 45217;
	private static int END = 63486;

	*//** 
	 * 按照声母表示，这个表是在GB2312中的出现的第一个汉字，也就是说“啊”是代表首字母a的第一个汉字
	 * i, u, v都不做声母, 自定规则跟随前面的字母。
	 *//*
	private static char[] chartable = { '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈',
			'哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌',
			'塌', '挖', '昔', '压', '匝', };
	
	*//**
	 *  二十六个字母区间对应二十七个端点
	 * GB2312码汉字区间十进制表示
	 *//*
	private static int[] table = new int[27];
	*//**
	 * 二维数组存放所有的字母和需要分类的字符串
	 *//*
	private static String[][] erwei=new String[100][];
	
	*//** 对应首字母区间表*//*
	private static char[] initialtable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z'};
	// 初始化
	static {
		for (int i = 0; i < 26; i++) {
			table[i] = gbValue(chartable[i]);// 得到GB2312码的首字母区间端点表，十进制。
		}
		table[26] = END;// 区间表结尾
	}
	public static ArrayList<FirstAid> SortWithPinYin(ArrayList<FirstAid> at){
		String[] ssss=new String[at.size()];
		ArrayList<FirstAid> aList=new ArrayList<FirstAid>();
		Iterator<FirstAid> it=at.iterator();
		int m=0;
		while(it.hasNext()){
			FirstAid ss=it.next();
			ssss[m]=ss.getTitle();
			m++;
		}
		cnToPy(ssss);
		for(char i='A';i<='Z';i++){
			for(int j=0;j<at.size();j++){
				if(erwei[i][j]!=null&&j==0){
					FirstAid fa=new FirstAid(j, erwei[i][j]);
					aList.add(fa);
				}else if(erwei[i][j]!=null&&j>0){
					FirstAid fa=new FirstAid(j, erwei[i][j],(at.get(j-1)).getContont());
					aList.add(fa);
				}
			}
		}
		return aList;
	}
	
	public static ArrayList<HealthDiet> SortWithPinYin1(ArrayList<HealthDiet> at){
		String[] ssss=new String[at.size()];
		ArrayList<HealthDiet> aList=new ArrayList<HealthDiet>();
		Iterator<HealthDiet> it=at.iterator();
		int m=0;
		while(it.hasNext()){
			HealthDiet ss=it.next();
			ssss[m]=ss.getTitle();
			m++;
		}
		cnToPy(ssss);
		for(char i='A';i<='Z';i++){
			for(int j=0;j<at.size();j++){
				if(erwei[i][j]!=null&&j==0){
					HealthDiet fa=new HealthDiet(j, erwei[i][j]);
					aList.add(fa);
				}else if(erwei[i][j]!=null&&j>0){
					HealthDiet fa=new HealthDiet(j, erwei[i][j],(at.get(j-1)).getContent());
					aList.add(fa);
				}
			}
		}
		return aList;
	}
	
	*//**                               
	 * 
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 * @param GetPinYinList                             
	 * @return void                               
	 *//*

	public static void cnToPy(String[] s) {
		 for(int i=0;i<100&&i<26;i++){
			 erwei[initialtable[i]]=new String[s.length+1];
			 for(int j=i;j<initialtable.length;){
				 erwei[initialtable[j]][0]=String.valueOf(initialtable[i]);
				 break;
			 }
		 }
		for(int i=0;i<s.length;i++){
//			char c=Char2Initial(s[i].charAt(0));
			char c=Chinese2String.getPingYin(s[i]).charAt(0);
			erwei[c][i+1]=s[i];
		}
	}
	
	 *//**
    * 输入字符,得到他的声母,英文字母返回对应的大写字母,其他非简体汉字返回 '0'
    *
    *//*
   private static char Char2Initial(char ch) {
       // 对英文字母的处理：小写字母转换为大写，大写的直接返回
       if (ch >= 'a' && ch <= 'z')
           return (char) (ch - 'a' + 'A');
       if (ch >= 'A' && ch <= 'Z')
           return ch;

       // 对非英文字母的处理：转化为首字母，然后判断是否在码表范围内，
       // 若不是，则直接返回。
       // 若是，则在码表内的进行判断。
       int gb = gbValue(ch);// 汉字转换首字母

       if ((gb < BEGIN) || (gb > END))// 在码表区间之前，直接返回
           return 0;
       
       if(gb>=47614&&gb<48119){
    	   return 'H';
       }else if (gb>=52218&&gb<52698) {
    	   return 'T';
       }
       
       int i;
       for (i = 0; i < 26; i++) {// 判断匹配码表区间，匹配到就break,判断区间形如“[,)”
               if ((gb >= table[i]) && (gb < table[i+1]))
                   break;
       }
      
       if (gb==END) {//补上GB2312区间最右端
           i=25;
       }
       return initialtable[i]; // 在码表区间中，返回首字母
   }

	*//**
	 * 取出汉字的编码 cn 汉字
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 * @param c
	 * @return int
	 *//*
	private static int gbValue(char c) {
		 String str = new String();
	        str += c;
	        try {
	            byte[] bytes = str.getBytes("GB2312");
	            if (bytes.length < 2)
	                return 0;
	            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
	        } catch (Exception e) {
	            return 0;
	        }
	}
}
*/