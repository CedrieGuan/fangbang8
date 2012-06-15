package com.fangbang8.client.common.util;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;

/**
 * 字符串操�?<功能详细描述>
 * @author cKF46828
 * @version [版本�? 2011-7-5]
 * @see [相关�?方法]
 * @since [产品/模块版本]
 */
public class StringUtil{

	private StringUtil() {
	}

	/**
	 * 获取字典字符串中的value <功能详细描述>
	 * @param 输入的字典字符串
	 * @return [参数说明]字符串中的�?
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类�?�?方法、类#成员]
	 */
	public static final String getFirstValue(String mString) {
		if (mString != null && mString.length() >= 1 && mString.contains("#")) {
			String[] strings = mString.split("#");
			return strings[0];
		} else {
			return "";
		}
	}

	/**
	 * 获取字典字符串中的value <功能详细描述>
	 * 
	 * @param 输入的字典字符串
	 * @return [参数说明]字符串中的�?
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类�?�?方法、类#成员]
	 */
	public static final String dictToValue(String mString) {
		if (mString != null && mString.length() >= 1 && mString.contains("#")) {
			String[] strings = mString.split("#");
			return strings[1];
		} else {
			return "";
		}
	}

	/**
	 * 获取字典字符串中的ID <功能详细描述>
	 * 
	 * @param 输入的字典字符串
	 * @return [参数说明]字符串中的ID
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类�?�?方法、类#成员]
	 */
	public static final String dictToID(String mString) {
		if (mString != null && mString.length() >= 1 && mString.contains("#")) {
			String[] strings = mString.split("#");
			return strings[0];
		} else {
			return "";
		}
	}

	/**
	 * MD5加密 <功能详细描述>
	 * 
	 * @param 输入的需要加密的字符串
	 * @return MD5加密好的字符串
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类�?�?方法、类#成员]
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	
	/**验证邮箱格式*/
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**Get string from string resources file*/
	public static String localString(Context context,int sId){
		return context.getResources().getString(sId);
	}
	
	
	/**车辆品牌和系列信息*/
	public static String[][] brandAndSerice(){
		String[][] bas=new String[6][10];
		bas[0][0]="奥迪";
		bas[0][1]="奥迪A5";
		bas[0][2]="奥迪R8";
		bas[0][3]="奥迪S5";
		bas[0][4]="奥迪TT";
		bas[0][5]="奥迪RS4";
		bas[0][6]="奥迪S8";
		bas[0][7]="奥迪A4 Allroad";
		bas[0][8]="奥迪Q3";
		bas[0][9]="奥迪Quattro";
		bas[1][0]="宝马";
		bas[1][1]="宝马M5";
		bas[1][2]="宝马X1";
		bas[1][3]="宝马X3";
		bas[1][4]="宝马X5";
		bas[1][5]="宝马Z4";
		bas[1][6]="宝马i3";
		bas[1][7]="宝马Vision";
		bas[1][8]="宝马i8";
		bas[1][9]="宝马1系";
		bas[2][0]="长城";
		bas[2][1]="酷熊";
		bas[2][2]="凌傲";
		bas[2][3]="炫丽";
		bas[2][4]="长城C30";
		bas[2][5]="长城C50";
		bas[2][6]="长城V80";
		bas[2][7]="哈弗H3";
		bas[2][8]="哈弗H5";
		bas[2][9]="哈弗M4";
		bas[3][0]="大众";
		bas[3][1]="宝来";
		bas[3][2]="高尔夫";
		bas[3][3]="捷达";
		bas[3][4]="大众Polo";
		bas[3][5]="朗逸";
		bas[3][6]="桑塔纳";
		bas[3][7]="甲壳虫";
		bas[3][8]="途锐";
		bas[3][9]="大众Variant";
		bas[4][0]="丰田";
		bas[4][1]="威驰";
		bas[4][2]="皇冠";
		bas[4][3]="雅力士";
		bas[4][4]="凯美瑞";
		bas[4][5]="埃尔法Alphard";
		bas[4][6]="红杉";
		bas[4][7]="丰田Verso";
		bas[4][8]="杰路驰Zelas";
		bas[4][9]="塞纳";
		bas[5][0]="马自达";
		bas[5][1]="马自达6";
		bas[5][2]="马自达2劲翔";
		bas[5][3]="马自达MX-5";
		bas[5][4]="马自达3(进口)";
		bas[5][5]="马自达CX-7";
		bas[5][6]="马自达3星骋";
		bas[5][7]="睿翼";
		bas[5][8]="马自达8";
		bas[5][9]="马自达RX8";
		return bas;
	}
	
	public static String[][] carPlate(){
		String[][] cps=new String[42][33];
		
		cps[0][0]="京";
		cps[0][1]="A";
		cps[0][2]="B";
		cps[0][3]="C";
		cps[0][4]="E";
		cps[0][5]="F";
		cps[0][6]="G";
		cps[0][7]="H";
		cps[0][8]="V";
		
		cps[1][0]="沪";
		cps[1][1]="A";
		cps[1][2]="B";
		cps[1][3]="C";
		cps[1][4]="D";

		cps[2][0]="渝";
		cps[2][1]="A";
		cps[2][2]="B";
		cps[2][3]="C";
		cps[2][4]="F";
		cps[2][5]="G";
		cps[2][6]="H";
		
		cps[3][0]="津";
		cps[3][1]="A";
		cps[3][2]="B";
		cps[3][3]="C";
		cps[3][4]="E";
		
		cps[4][0]="藏";
		cps[4][1]="A";
		cps[4][2]="B";
		cps[4][3]="C";
		cps[4][4]="D";
		cps[4][5]="E";
		cps[4][6]="F";
		cps[4][7]="G";
		cps[4][8]="H";
		cps[4][9]="J";
		
		cps[5][0]="川";
		cps[5][1]="A";
		cps[5][2]="B";
		cps[5][3]="C";
		cps[5][4]="D";
		cps[5][5]="E";
		cps[5][6]="F";
		cps[5][7]="H";
		cps[5][8]="J";
		cps[5][9]="K";
		cps[5][10]="L";
		cps[5][11]="M";
		cps[5][12]="Q";
		cps[5][13]="R";
		cps[5][14]="S";
		cps[5][15]="T";
		cps[5][16]="U";
		cps[5][17]="V";
		cps[5][18]="W";
		cps[5][19]="X";
		cps[5][20]="Y";
		cps[5][21]="Z";
		
		cps[6][0]="鄂";
		cps[6][1]="A";
		cps[6][2]="B";
		cps[6][3]="C";
		cps[6][4]="D";
		cps[6][5]="E";
		cps[6][6]="F";
		cps[6][7]="G";
		cps[6][8]="H";
		cps[6][9]="J";
		cps[6][10]="K";
		cps[6][11]="L";
		cps[6][12]="M";
		cps[6][13]="N";
		cps[6][14]="P";
		cps[6][15]="Q";
		cps[6][16]="R";
		cps[6][17]="S";
		
		cps[7][0]="甘";
		cps[7][1]="A";
		cps[7][2]="B";
		cps[7][3]="C";
		cps[7][4]="D";
		cps[7][5]="E";
		cps[7][6]="F";
		cps[7][7]="G";
		cps[7][8]="H";
		cps[7][9]="J";
		cps[7][10]="K";
		cps[7][11]="L";
		cps[7][12]="M";
		cps[7][13]="N";
		cps[7][14]="P";
		
		cps[8][0]="赣";
		cps[8][1]="A";
		cps[8][2]="B";
		cps[8][3]="C";
		cps[8][4]="D";
		cps[8][5]="E";
		cps[8][6]="F";
		cps[8][7]="G";
		cps[8][8]="H";
		cps[8][9]="J";
		cps[8][10]="K";
		cps[8][11]="L";
		cps[8][12]="M";
		
		cps[9][0]="贵";
		cps[9][1]="A";
		cps[9][2]="B";
		cps[9][3]="C";
		cps[9][4]="D";
		cps[9][5]="E";
		cps[9][6]="F";
		cps[9][7]="G";
		cps[9][8]="H";
		cps[9][9]="J";
		
		cps[10][0]="桂";
		cps[10][1]="A";
		cps[10][2]="B";
		cps[10][3]="C";
		cps[10][4]="D";
		cps[10][5]="E";
		cps[10][6]="F";
		cps[10][7]="G";
		cps[10][8]="H";
		cps[10][9]="J";
		cps[10][10]="K";
		cps[10][11]="L";
		cps[10][12]="M";
		cps[10][13]="N";
		cps[10][14]="P";
		cps[10][15]="R";
		
		cps[11][0]="黑";
		cps[11][1]="A";
		cps[11][2]="B";
		cps[11][3]="C";
		cps[11][4]="D";
		cps[11][5]="E";
		cps[11][6]="F";
		cps[11][7]="G";
		cps[11][8]="H";
		cps[11][9]="J";
		cps[11][10]="K";
		cps[11][11]="L";
		cps[11][12]="M";
		cps[11][13]="N";
		cps[11][14]="P";
		cps[11][15]="R";
		
		cps[12][0]="吉";
		cps[12][1]="A";
		cps[12][2]="B";
		cps[12][3]="C";
		cps[12][4]="D";
		cps[12][5]="E";
		cps[12][6]="F";
		cps[12][7]="G";
		cps[12][8]="H";
		cps[12][9]="J";
		
		cps[13][0]="冀";
		cps[13][1]="A";
		cps[13][2]="B";
		cps[13][3]="C";
		cps[13][4]="D";
		cps[13][5]="E";
		cps[13][6]="F";
		cps[13][7]="G";
		cps[13][8]="H";
		cps[13][9]="J";
		cps[13][10]="R";
		cps[13][11]="T";
		
		cps[14][0]="晋";
		cps[14][1]="A";
		cps[14][2]="B";
		cps[14][3]="C";
		cps[14][4]="D";
		cps[14][5]="E";
		cps[14][6]="F";
		cps[14][7]="H";
		cps[14][8]="J";
		cps[14][9]="K";
		cps[14][10]="L";
		cps[14][11]="M";
		
		cps[15][0]="辽";
		cps[15][1]="A";
		cps[15][2]="B";
		cps[15][3]="C";
		cps[15][4]="D";
		cps[15][5]="E";
		cps[15][6]="F";
		cps[15][7]="G";
		cps[15][8]="H";
		cps[15][9]="J";
		cps[15][10]="K";
		cps[15][11]="L";
		cps[15][12]="M";
		cps[15][13]="N";
		cps[15][14]="P";
		cps[15][15]="V";
		
		cps[16][0]="鲁";
		cps[16][1]="A";
		cps[16][2]="B";
		cps[16][3]="C";
		cps[16][4]="D";
		cps[16][5]="E";
		cps[16][6]="F";
		cps[16][7]="G";
		cps[16][8]="H";
		cps[16][9]="J";
		cps[16][10]="K";
		cps[16][11]="L";
		cps[16][12]="M";
		cps[16][13]="N";
		cps[16][14]="P";
		cps[16][15]="Q";
		cps[16][16]="R";
		cps[16][17]="S";
		cps[16][18]="U";
		cps[16][19]="V";
		
		cps[17][0]="蒙";
		cps[17][1]="A";
		cps[17][2]="B";
		cps[17][3]="C";
		cps[17][4]="D";
		cps[17][5]="E";
		cps[17][6]="F";
		cps[17][7]="G";
		cps[17][8]="H";
		cps[17][9]="J";
		cps[17][10]="K";
		cps[17][11]="L";
		cps[17][12]="M";
		
		cps[18][0]="闽";
		cps[18][1]="A";
		cps[18][2]="B";
		cps[18][3]="C";
		cps[18][4]="D";
		cps[18][5]="E";
		cps[18][6]="F";
		cps[18][7]="G";
		cps[18][8]="H";
		cps[18][9]="J";
		cps[18][10]="K";
		
		cps[19][0]="宁";
		cps[19][1]="A";
		cps[19][2]="B";
		cps[19][3]="C";
		cps[19][4]="D";
		
		cps[20][0]="青";
		cps[20][1]="A";
		cps[20][2]="B";
		cps[20][3]="C";
		cps[20][4]="D";
		cps[20][5]="E";
		cps[20][6]="F";
		cps[20][7]="G";
		cps[20][8]="H";
		
		cps[21][0]="琼";
		cps[21][1]="A";
		cps[21][2]="B";
		cps[21][3]="C";
		cps[21][4]="E";
		
		cps[22][0]="陕";
		cps[22][1]="A";
		cps[22][2]="B";
		cps[22][3]="C";
		cps[22][4]="D";
		cps[22][5]="E";
		cps[22][6]="F";
		cps[22][7]="G";
		cps[22][8]="H";
		cps[22][9]="J";
		cps[22][10]="K";
		cps[22][11]="U";
		cps[22][12]="V";
		
		cps[23][0]="苏";
		cps[23][1]="A";
		cps[23][2]="B";
		cps[23][3]="C";
		cps[23][4]="D";
		cps[23][5]="E";
		cps[23][6]="F";
		cps[23][7]="G";
		cps[23][8]="H";
		cps[23][9]="J";
		cps[23][10]="K";
		cps[23][11]="L";
		cps[23][12]="M";
		cps[23][13]="N";
		
		cps[24][0]="皖";
		cps[24][1]="A";
		cps[24][2]="B";
		cps[24][3]="C";
		cps[24][4]="D";
		cps[24][5]="E";
		cps[24][6]="F";
		cps[24][7]="G";
		cps[24][8]="H";
		cps[24][9]="J";
		cps[24][10]="K";
		cps[24][11]="L";
		cps[24][12]="M";
		cps[24][13]="N";
		cps[24][14]="P";
		cps[24][15]="Q";
		cps[24][16]="R";
		cps[24][17]="S";
		
		cps[25][0]="湘";
		cps[25][1]="A";
		cps[25][2]="B";
		cps[25][3]="C";
		cps[25][4]="D";
		cps[25][5]="E";
		cps[25][6]="F";
		cps[25][7]="G";
		cps[25][8]="H";
		cps[25][9]="J";
		cps[25][10]="K";
		cps[25][11]="L";
		cps[25][12]="M";
		cps[25][13]="N";
		cps[25][14]="U";
		
		cps[26][0]="新";
		cps[26][1]="A";
		cps[26][2]="B";
		cps[26][3]="C";
		cps[26][4]="D";
		cps[26][5]="E";
		cps[26][6]="F";
		cps[26][7]="G";
		cps[26][8]="H";
		cps[26][9]="J";
		cps[26][10]="K";
		cps[26][11]="L";
		cps[26][12]="M";
		cps[26][13]="N";
		cps[26][14]="P";
		cps[26][15]="Q";
		cps[26][16]="R";
		
		cps[27][0]="豫";
		cps[27][1]="A";
		cps[27][2]="B";
		cps[27][3]="C";
		cps[27][4]="D";
		cps[27][5]="E";
		cps[27][6]="F";
		cps[27][7]="G";
		cps[27][8]="H";
		cps[27][9]="J";
		cps[27][10]="K";
		cps[27][11]="L";
		cps[27][12]="M";
		cps[27][13]="N";
		cps[27][14]="P";
		cps[27][15]="Q";
		cps[27][16]="R";
		cps[27][17]="S";
		cps[27][18]="U";
		
		cps[28][0]="粤";
		cps[28][1]="A";
		cps[28][2]="B";
		cps[28][3]="C";
		cps[28][4]="D";
		cps[28][5]="E";
		cps[28][6]="F";
		cps[28][7]="G";
		cps[28][8]="H";
		cps[28][9]="J";
		cps[28][10]="K";
		cps[28][11]="L";
		cps[28][12]="M";
		cps[28][13]="N";
		cps[28][14]="P";
		cps[28][15]="Q";
		cps[28][16]="R";
		cps[28][17]="S";
		cps[28][18]="T";
		cps[28][19]="U";
		cps[28][20]="V";
		cps[28][21]="W";
		cps[28][22]="X";
		cps[28][23]="Y";
		cps[28][24]="Z";
		
		cps[29][0]="云";
		cps[29][1]="A";
		cps[29][2]="B";
		cps[29][3]="C";
		cps[29][4]="D";
		cps[29][5]="E";
		cps[29][6]="F";
		cps[29][7]="G";
		cps[29][8]="H";
		cps[29][9]="J";
		cps[29][10]="K";
		cps[29][11]="L";
		cps[29][12]="M";
		cps[29][13]="N";
		cps[29][14]="P";
		cps[29][15]="Q";
		cps[29][16]="R";
		cps[29][17]="S";
		
		cps[30][0]="浙";
		cps[30][1]="A";
		cps[30][2]="B";
		cps[30][3]="C";
		cps[30][4]="D";
		cps[30][5]="E";
		cps[30][6]="F";
		cps[30][7]="G";
		cps[30][8]="H";
		cps[30][9]="J";
		cps[30][10]="K";
		cps[30][11]="L";
		
		cps[31][0]="军";
		cps[31][1]="A";
		cps[31][2]="B";
		cps[31][3]="C";
		cps[31][4]="D";
		cps[31][5]="E";
		cps[31][6]="F";
		cps[31][7]="G";
		cps[31][8]="K";
		cps[31][9]="M";
		cps[31][10]="O";
		cps[31][11]="R";
		cps[31][12]="T";
		cps[31][13]="V";
		
		cps[32][0]="空";
		cps[32][1]="A";
		cps[32][2]="B";
		cps[32][3]="C";
		cps[32][4]="D";
		cps[32][5]="E";
		cps[32][6]="F";
		cps[32][7]="G";
		cps[32][8]="K";
		cps[32][9]="L";
		cps[32][10]="M";
		cps[32][11]="N";
		cps[32][12]="O";
		cps[32][13]="R";
		cps[32][14]="V";
		cps[32][15]="Z";
		
		cps[33][0]="海";
		cps[33][1]="A";
		cps[33][2]="B";
		cps[33][3]="C";
		cps[33][4]="D";
		cps[33][5]="E";
		cps[33][6]="F";
		cps[33][7]="G";
		cps[33][10]="L";
		cps[33][11]="O";
		cps[33][12]="R";
		
		cps[34][0]="南";
		cps[34][1]="A";
		cps[34][2]="B";
		cps[34][3]="C";
		cps[34][4]="D";
		cps[34][5]="K";
		cps[34][6]="M";
		cps[34][7]="N";
		cps[34][8]="O";
		cps[34][9]="R";
		cps[34][10]="V";
		cps[34][11]="Y";
		
		cps[35][0]="北";
		cps[35][1]="A";
		cps[35][2]="B";
		cps[35][3]="C";
		cps[35][4]="D";
		cps[35][5]="K";
		cps[35][6]="M";
		cps[35][7]="N";
		cps[35][8]="O";
		cps[35][9]="R";
		cps[35][10]="V";
		cps[35][11]="Y";
		
		cps[36][0]="广";
		cps[36][1]="A";
		cps[36][2]="B";
		cps[36][3]="C";
		cps[36][4]="D";
		cps[36][5]="J";
		cps[36][6]="K";
		cps[36][7]="M";
		cps[36][8]="N";
		cps[36][9]="O";
		cps[36][10]="R";
		cps[36][11]="S";
		cps[36][12]="U";
		cps[36][13]="V";
		cps[36][14]="Y";
		
		cps[37][0]="沈";
		cps[37][1]="A";
		cps[37][2]="B";
		cps[37][3]="C";
		cps[37][4]="D";
		cps[37][5]="K";
		cps[37][6]="M";
		cps[37][7]="N";
		cps[37][8]="O";
		cps[37][9]="R";
		cps[37][10]="V";
		cps[37][11]="Y";
		
		cps[38][0]="济";
		cps[38][1]="A";
		cps[38][2]="B";
		cps[38][3]="C";
		cps[38][4]="D";
		cps[38][5]="K";
		cps[38][6]="M";
		cps[38][7]="N";
		cps[38][8]="O";
		cps[38][9]="R";
		cps[38][10]="V";
		cps[38][11]="Y";
		
		cps[39][0]="兰";
		cps[39][1]="A";
		cps[39][2]="B";
		cps[39][3]="C";
		cps[39][4]="D";
		cps[39][5]="K";
		cps[39][6]="M";
		cps[39][7]="N";
		cps[39][8]="O";
		cps[39][9]="R";
		cps[39][10]="V";
		cps[39][11]="Y";
		
		cps[40][0]="成";
		cps[40][1]="A";
		cps[40][2]="B";
		cps[40][3]="C";
		cps[40][4]="D";
		cps[40][5]="K";
		cps[40][6]="M";
		cps[40][7]="N";
		cps[40][8]="O";
		cps[40][9]="R";
		cps[40][10]="V";
		cps[40][11]="Y";
		
		cps[41][0]="WJ";
		for(int i=1;i<=32;i++){
			cps[41][i]=DateUtil.impleDay(i);
		}
		return cps;
	}

	/** 得到省市二级数组 */
	public static String[][] provinceAndCity() {
		String[][] ss = new String[36][21];
		ss[0][0] = "保密";
		ss[1][0] = "北京";;
		ss[2][0] = "上海";
		ss[3][0] = "广州";
		ss[4][0] = "深圳";
		ss[5][0] = "重庆";

		ss[6][0] = "天津";	
		ss[7][0] = "河北";
		ss[7][1] = "石家庄";
		ss[7][2] = "邯郸";
		ss[7][3] = "邢台";
		ss[7][4] = "保定";
		ss[7][5] = "张家口";
		ss[7][6] = "承德";
		ss[7][7] = "秦皇岛";
		ss[7][8] = "唐山";
		ss[7][9] = "沧州";
		ss[7][10] = "廊坊";
		ss[7][11] = "衡水";

		ss[8][0] = "河南";
		ss[8][1] = "开封";
		ss[8][2] = "洛阳";
		ss[8][3] = "平顶山";
		ss[8][4] = "焦作";
		ss[8][5] = "鹤壁";
		ss[8][6] = "新乡";
		ss[8][7] = "安阳";
		ss[8][8] = "濮阳";
		ss[8][9] = "许昌";
		ss[8][10] = "漯河";
		ss[8][11] = "三门峡";
		ss[8][12] = "南阳";
		ss[8][13] = "商丘";
		ss[8][14] = "周口";
		ss[8][15] = "驻马店";
		ss[8][16] = "信阳";
		ss[8][17] = "济源";
		ss[8][18] = "郑州";
		
		ss[9][0] = "云南";
		ss[9][1] = "昆明";
		ss[9][2] = "玉溪";
		ss[9][3] = "邵通";
		ss[9][4] = "普洱";
		ss[9][5] = "临沧";
		ss[9][6] = "保山";
		ss[9][7] = "丽江";
		ss[9][8] = "文山";
		ss[9][9] = "红河";
		ss[9][10] = "西双版纳";
		ss[9][11] = "楚雄";
		ss[9][12] = "大理";
		ss[9][13] = "德宏";
		ss[9][14] = "怒江";
		ss[9][15] = "迪庆";

		ss[10][0] = "辽宁";
		ss[10][1] = "沈阳";
		ss[10][2] = "鞍山";
		ss[10][3] = "抚顺";
		ss[10][4] = "本溪";
		ss[10][5] = "丹东";
		ss[10][6] = "锦州";
		ss[10][7] = "葫芦岛";
		ss[10][8] = "营口";
		ss[10][9] = "盘锦";
		ss[10][10] = "阜新";
		ss[10][11] = "辽阳";
		ss[10][12] = "铁岭";
		ss[10][13] = "朝阳";
		ss[10][14] = "海城";

		ss[11][0] = "黑龙江";
		ss[11][1] = "哈尔滨";
		ss[11][2] = "齐齐哈尔";
		ss[11][3] = "鹤岗";
		ss[11][4] = "双鸭山";
		ss[11][5] = "鸡西";
		ss[11][6] = "大庆";
		ss[11][7] = "伊春";
		ss[11][8] = "牡丹江";
		ss[11][9] = "佳木斯";
		ss[11][10] = "七台河";
		ss[11][11] = "黑河";
		ss[11][12] = "绥化";
		ss[11][13] = "大兴安岭";
		ss[11][14] = "铁力";
		ss[11][15] = "北安";
		
		ss[12][0] = "湖南";
		ss[12][1] = "长沙";
		ss[12][2] = "株洲";
		ss[12][3] = "湘潭";
		ss[12][4] = "韶山";
		ss[12][5] = "衡阳";
		ss[12][6] = "岳阳";
		ss[12][7] = "常德";
		ss[12][8] = "张家界";
		ss[12][9] = "郴州";
		ss[12][10] = "益阳";
		ss[12][11] = "永州";
		ss[12][12] = "怀化";
		ss[12][13] = "娄底";
		ss[12][14] = "湘西";
		ss[12][15] = "耒阳";

		ss[13][0] = "安徽";
		ss[13][1] = "铜陵";
		ss[13][2] = "合肥";
		ss[13][3] = "淮南";
		ss[13][4] = "淮北";
		ss[13][5] = "芜湖";
		ss[13][6] = "蚌埠";
		ss[13][7] = "马鞍山";
		ss[13][8] = "当涂县";
		ss[13][9] = "安庆";
		ss[13][10] = "黄山";
		ss[13][11] = "滁州";
		ss[13][12] = "阜阳";
		ss[13][13] = "毫州";
		ss[13][14] = "宿州";
		ss[13][15] = "池州";
		ss[13][16] = "六安";
		ss[13][17] = "宣城";
		ss[13][18] = "凤阳县";
		
		ss[14][0] = "山东";
		ss[14][1] = "济南";
		ss[14][2] = "淄博";
		ss[14][3] = "枣庄";
		ss[14][4] = "东营";
		ss[14][5] = "潍坊";
		ss[14][6] = "烟台";
		ss[14][7] = "威海";
		ss[14][8] = "莱芜";
		ss[14][9] = "德州";
		ss[14][10] = "临沂";
		ss[14][11] = "聊城";
		ss[14][12] = "滨州";
		ss[14][13] = "菏泽";
		ss[14][14] = "日照";
		ss[14][15] = "泰安";
		ss[14][16] = "济宁";
		
		ss[15][0] = "新疆";
		ss[15][1] = "乌鲁木齐";
		ss[15][2] = "克拉玛依";
		ss[15][3] = "石河子";
		ss[15][4] = "吐鲁番";
		ss[15][5] = "哈密";
		ss[15][6] = "和田";
		ss[15][7] = "阿克苏";
		ss[15][8] = "喀什";
		ss[15][9] = "克孜勒苏";
		ss[15][10] = "巴音郭楞";
		ss[15][11] = "昌吉";
		ss[15][12] = "塔城";
		ss[15][13] = "阿勒泰";
		ss[15][14] = "五家渠";

		ss[16][0] = "江苏";
		ss[16][1] = "南京";
		ss[16][2] = "无锡";
		ss[16][3] = "徐州";
		ss[16][4] = "常州";
		ss[16][5] = "苏州";
		ss[16][6] = "南通";
		ss[16][7] = "连云港";
		ss[16][8] = "淮安";
		ss[16][9] = "盐城";
		ss[16][10] = "扬州";
		ss[16][11] = "镇江";
		ss[16][12] = "泰州";
		ss[16][13] = "宿迁";
		
		ss[17][0] = "浙江";
		ss[17][1] = "杭州";
		ss[17][2] = "宁波";
		ss[17][3] = "温州";
		ss[17][4] = "嘉兴";
		ss[17][5] = "湖州";
		ss[17][6] = "绍兴";
		ss[17][7] = "金华";
		ss[17][8] = "衢州";
		ss[17][9] = "舟山";
		ss[17][10] = "台州";
		ss[17][11] = "丽水";

		ss[18][0] = "江西";
		ss[18][1] = "南昌";
		ss[18][2] = "景德镇";
		ss[18][3] = "萍乡";
		ss[18][4] = "九江";
		ss[18][5] = "新余";
		ss[18][6] = "鹰潭";
		ss[18][7] = "赣州";
		ss[18][8] = "吉安";
		ss[18][9] = "宜春";
		ss[18][10] = "抚州";
		ss[18][11] = "上饶";

		ss[19][0] = "湖北";
		ss[19][1] = "武汉";
		ss[19][2] = "黄石";
		ss[19][3] = "十堰";
		ss[19][4] = "宜昌";
		ss[19][5] = "襄樊";
		ss[19][6] = "荆门";
		ss[19][7] = "孝感";
		ss[19][8] = "荆州";
		ss[19][9] = "黄冈";
		ss[19][10] = "咸宁";
		ss[19][11] = "随州";
		ss[19][12] = "恩施";

		ss[20][0] = "广西";
		ss[20][1] = "南宁";
		ss[20][2] = "柳州";
		ss[20][3] = "桂林";
		ss[20][4] = "梧州";
		ss[20][5] = "北海";
		ss[20][6] = "防城巷";
		ss[20][7] = "钦州";
		ss[20][8] = "贵港";
		ss[20][9] = "玉林";
		ss[20][10] = "百色";
		ss[20][11] = "贺州";
		ss[20][12] = "河池";
		ss[20][13] = "南宁";
		ss[20][14] = "柳州";

		ss[21][0] = "甘肃";
		ss[21][1] = "兰州";
		ss[21][2] = "嘉峪关";
		ss[21][3] = "金昌";
		ss[21][4] = "白银";
		ss[21][5] = "天水";
		ss[21][6] = "武威";
		ss[21][7] = "张掖";
		ss[21][8] = "平凉";
		ss[21][9] = "酒泉";
		ss[21][10] = "庆阳";
		ss[21][11] = "定西";
		ss[21][12] = "陇南";
		ss[21][13] = "甘南";
		ss[21][14] = "临夏州";
		ss[21][15] = "临夏";

		ss[22][0] = "山西";
		ss[22][1] = "太原";
		ss[22][2] = "大同";
		ss[22][3] = "阳泉";
		ss[22][4] = "晋城";
		ss[22][5] = "朔州";
		ss[22][6] = "晋中";
		ss[22][7] = "忻州";
		ss[22][8] = "吕梁";
		ss[22][9] = "临汾";
		ss[22][10] = "运城";
		ss[22][11] = "长治";

		ss[23][0] = "内蒙古";
		ss[23][1] = "呼和浩特";
		ss[23][2] = "包头";
		ss[23][3] = "乌海";
		ss[23][4] = "赤峰";
		ss[23][5] = "乌兰察布";
		ss[23][6] = "锡林郭勒";
		ss[23][7] = "呼伦贝尔";
		ss[23][8] = "哲里木盟";
		ss[23][9] = "鄂尔多斯";
		ss[23][10] = "巴彦淖尔";
		ss[23][11] = "阿拉善";
		ss[23][12] = "兴安盟";
		ss[23][13] = "通辽";

		ss[24][0] = "陕西";
		ss[24][1] = "西安";
		ss[24][2] = "铜川";
		ss[24][3] = "宝鸡";
		ss[24][4] = "咸阳";
		ss[24][5] = "渭南";
		ss[24][6] = "延安";
		ss[24][7] = "汉中";
		ss[24][8] = "榆林";
		ss[24][9] = "商洛";
		ss[24][10] = "安康";

		ss[25][0] = "吉林";
		ss[25][1] = "长春";
		ss[25][2] = "吉林";
		ss[25][3] = "四平";
		ss[25][4] = "通化";
		ss[25][5] = "白山";
		ss[25][6] = "松原";
		ss[25][7] = "白城";
		ss[25][8] = "延边";
		ss[25][9] = "公主岭";
		ss[25][10] = "辽源";
		ss[25][11] = "珲春";

		ss[26][0] = "福建";
		ss[26][1] = "福州";
		ss[26][2] = "厦门";
		ss[26][3] = "三明";
		ss[26][4] = "莆田";
		ss[26][5] = "泉州";
		ss[26][6] = "漳州";
		ss[26][7] = "南平";
		ss[26][8] = "龙岩";
		ss[26][9] = "宁德";

		ss[27][0] = "贵州";
		ss[27][1] = "贵阳";
		ss[27][2] = "六盆水";
		ss[27][3] = "遵义";
		ss[27][4] = "铜仁";
		ss[27][5] = "毕节";
		ss[27][6] = "安顺";
		ss[27][7] = "黔西";
		ss[27][8] = "黔东";
		ss[27][9] = "黔南";

		ss[28][0] = "广东";
		ss[28][1] = "广州";
		ss[28][2] = "珠海";
		ss[28][3] = "汕头";
		ss[28][4] = "韶关";
		ss[28][5] = "河源";
		ss[28][6] = "梅州";
		ss[28][7] = "惠州";
		ss[28][8] = "汕尾";
		ss[28][9] = "东莞";
		ss[28][10] = "中山";
		ss[28][11] = "江门";
		ss[28][12] = "佛山";
		ss[28][13] = "阳江";
		ss[28][14] = "湛江";
		ss[28][15] = "茂名";
		ss[28][16] = "肇庆";
		ss[28][17] = "云浮";
		ss[28][18] = "清远";
		ss[28][19] = "潮州";
		ss[28][20] = "揭阳";

		ss[29][0] = "西藏";
		ss[29][1] = "拉萨";
		ss[29][2] = "那曲";
		ss[29][3] = "山南";
		ss[29][4] = "昌都";
		ss[29][5] = "日喀则";
		ss[29][6] = "阿里";
		ss[29][7] = "林芝";

		ss[30][0] = "四川";
		ss[30][1] = "成都";
		ss[30][2] = "自贡";
		ss[30][3] = "攀枝花";
		ss[30][4] = "泸州";
		ss[30][5] = "绵阳";
		ss[30][6] = "德阳";
		ss[30][7] = "广元";
		ss[30][8] = "遂宁";
		ss[30][9] = "内江";
		ss[30][10] = "乐山";
		ss[30][11] = "宜宾";
		ss[30][12] = "广安";
		ss[30][13] = "南充";
		ss[30][14] = "达州";
		ss[30][15] = "巴中";
		ss[30][16] = "雅安";
		ss[30][17] = "眉山";
		ss[30][18] = "资阳";
		ss[30][19] = "阿呗";
		ss[30][20] = "竿子";

		ss[31][0] = "宁夏";
		ss[31][1] = "银川";
		ss[31][2] = "石嘴山";
		ss[31][3] = "吴忠";
		ss[31][4] = "固原";
		ss[31][5] = "中卫";

		ss[32][0] = "海南";
		ss[32][1] = "海口";
		ss[32][2] = "詹州";
		ss[32][3] = "琼海";
		ss[32][4] = "万宁";
		ss[32][5] = "东方";
		ss[32][6] = "文昌";
		ss[32][7] = "五指山";
		ss[32][8] = "临高县";
		ss[32][9] = "安定县";
		ss[32][10] = "屯昌县";
		ss[32][11] = "昌江";
		ss[32][12] = "白沙";
		ss[32][13] = "琼中";
		ss[32][14] = "黎水";
		ss[32][15] = "保亭";
		ss[32][16] = "乐东";

		ss[33][0] = "台湾";
		ss[34][0] = "香港";
		ss[35][0] = "澳门";
		return ss;
	}
}