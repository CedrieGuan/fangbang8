/*
 * 文 件 名:  SystemManage.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  cKF46828
 * 修改时间:  2011-4-26
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.fangbang8.client.common.util;


import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;

/**
 * 手机管理类. 手机事件信息管理;电话、短信管理;获取版本代号;检测可用网络等
 * 
 * @author cKF46828
 * @version [版本号, 2011-4-26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SystemManage {

    private SystemManage() {
    }

    /** 拨打电话 */
    private static final String TEL_PRE = "tel:";

    /** 发送短信 */
    private static final String SMS_PRE = "smsto";

    /** 短信消息体 */
    private static final String EXTRA_SMS_BODY = "sms_body";

    /** APK文件的MIME类型 */
    private static final String MIME_APK = "application/vnd.android.package-archive";

    /**
     * <拨打电话>
     * 
     * @param context
     * @param phoneNo [参数说明]
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final void call(Context context, String phoneNo) {
        Uri uri = Uri.parse(TEL_PRE + phoneNo.trim());
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        context.startActivity(intent);
    }

    /**
     * <发送短信>
     * 
     * @param context
     * @param phoneNo
     * @param content [参数说明]
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final void sms(Context context, String phoneNo, String content) {
        Uri uri = Uri.fromParts(SMS_PRE, phoneNo.trim(), null);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(EXTRA_SMS_BODY, content.trim());
        context.startActivity(intent);
    }

    /**
     * <获取手机IMSI> <如果IMSI正常获取,则必须要是15位.(the IMEI for GSM and the MEID or ESN for
     * CDMA phones.)>
     * 
     * @return String [返回IMSI,有可能返回null]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        if (imei != null && imei.length() > 15) {
            imei = imei.substring(0, 15);
        }
        return imei;
    }

    /**
     * <获取手机号码> <如果检测到SIM卡,则正常获取手机号码>
     * 
     * @return String [返回手机号码]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final String getPhoneNum(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String phone = tm.getLine1Number();
        return phone;
    }

    /**
     * <获取手机MAC地址> <功能详细描述>
     * 
     * @return [参数说明]
     * @return String [返回MAC]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final String getMacAddress(Context context) {
        WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String mac = info.getMacAddress();
        return mac;
    }

    /**
     * <获取手机本地IP地址> <功能详细描述>
     * 
     * @throws SocketException [参数说明]
     * @return String [返回本地IP地址]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final String getLocalIpAddress() throws SocketException {
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
                .hasMoreElements();) {
            NetworkInterface info = en.nextElement();
            for (Enumeration<InetAddress> enAddr = info.getInetAddresses(); enAddr
                    .hasMoreElements();) {
                InetAddress addr = enAddr.nextElement();
                if (!addr.isLoopbackAddress()) {
                    String ip = addr.getHostAddress();
                    return ip;
                }
            }
        }
        return null;
    }

    /**
     *获取G3ESOP客户端的版本代号
     * 
     *@author lKF46824/龙云芳
     * @param context
     * @return int [VersionCode]
     * @exception throws [NameNotFoundException]
     * @see [getVersion]
     */
    public static final int getVersionCode(Context context) {

        PackageManager pm = context.getPackageManager();
        int versionCode;
        try {
            PackageInfo info = pm.getPackageInfo(context.getApplicationContext().getPackageName(),
                    0);
            versionCode = info.versionCode;
            pm.getApplicationLabel(context.getApplicationInfo());

        } catch (NameNotFoundException e) {
            e.printStackTrace();
            versionCode = 0;
        }
        return versionCode;
    }

    /**
     * 检查是否有可用网络
     * 
     * @param context
     * @return [参数说明]
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final boolean checkNetWorkStatue(Context context) {
        boolean netSataus = false;
        ConnectivityManager cwjManager = (ConnectivityManager)context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        cwjManager.getActiveNetworkInfo();
        if (cwjManager.getActiveNetworkInfo() != null) {
            netSataus = cwjManager.getActiveNetworkInfo().isAvailable();
        }
        return netSataus;
    }

    /**
     * 检查SD卡是否可用 <功能详细描述>
     * 
     * @return [参数说明]
     * @return Boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final Boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取手机内存可用空间 <功能详细描述>
     * 
     * @return [参数说明]
     * @return long [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blocksize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return blocksize * availableBlocks;
    }

    /**
     * 获取SD卡的可用空间 <功能详细描述>
     * 
     * @return [参数说明]
     * @return long [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File sdcardDir = Environment.getExternalStorageDirectory();
            StatFs statFs = new StatFs(sdcardDir.getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            return blockSize * availableBlocks;
        } else {
            return -1;
        }
    }

    /**
     * <通过Intent安装apk>
     * 
     * @param path [apk文件路径]
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final void installPackageViaIntent(Context context, String path) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(path));
        intent.setDataAndType(uri, MIME_APK);
        context.startActivity(intent);
    }

}
