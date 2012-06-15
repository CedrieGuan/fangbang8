/*
 * 文 件 名:  LogUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  wKF46829
 * 修改时间:  2011-4-23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.fangbang8.client.common.util;

import android.util.Log;


/**
 * 日志类包装，方便调用
 * 
 * 
 * @author  wKF46829
 * @version  [v1.0, 2011-4-23]
 * @see  
 * @since  
 */
public class LogUtil {
    
    /**
     * 写日志
     * 
     * @param: String msg   日志的内容
     * 
     * @return void 
     * @exception throws 
     * @see 
     */
    public static void e(String tag, String msg){
        Log.e(tag,msg);
    }
    
    /**
     * 输出信息
     * 
     * @param: String msg   信息的内容
     * 
     * @return void 
     * @exception throws 
     * @see 
     */
    public static void i(String tag, String msg){
        Log.i(tag, msg);
    }
    
    /**
     * 输出警告信息
     * 
     * @param: String msg   信息的内容
     * 
     * @return void 
     * @exception throws 
     * @see 
     */
    public static void w(String tag, String msg){
        Log.w(tag, msg);
    }
}
