/*
 * 文 件 名:  FileUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  cKF46828
 * 修改时间:  2011-7-4
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.fangbang8.client.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import android.content.Context;

/**
 * 文件操作相关
 * <功能详细描述>
 * 
 * @author  cKF46828
 * @version  [版本号, 2011-7-4]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class FileUtil {
    private final static String TAG = "FileUtil";
    /**
     * 取得文件的大小
     * <功能详细描述>
     * @param mFile
     * @return
     * @throws IOException [参数说明]
     * 
     * @return long [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final long getFileSize(File mFile) throws IOException{
        FileInputStream file = null;
        try {
            file = new FileInputStream(mFile);
            return file.available();
        } catch (FileNotFoundException e) {
            LogUtil.i(TAG, "找不到所指文件！");
        } 
        return -1;
    }
    
    /**
     * 拷贝文件到某文件夹
     * <功能详细描述>
     * @param source 源文件
     * @param destination 目标文件夹
     * @throws Exception [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final void copyFile(File source, File destination) throws Exception{
        int length = 2097152;
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination+File.separator+source.getName());
        byte[] buffer = new byte[length];
        int ins;  
        while ((ins = in.read(buffer))!= -1) {
            out.write(buffer, 0, ins);
        }
        in.close();
        out.flush();
        out.close();
    }
    
    /**
     * <拷贝Assets下的文件到程序私有空间>
     * 
     * @param context
     * @param source
     * @return String [返回类型说明]
     * @throws IOException
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final String copyAssetFileToInternal(Context context, String source)
            throws IOException {
        int length = 8192;
        InputStream in = context.getAssets().open(source);
        OutputStream out = context.openFileOutput(source, Context.MODE_WORLD_READABLE);
        byte[] buffer = new byte[length];
        int ins;
        while ((ins = in.read(buffer)) != -1) {
            out.write(buffer, 0, ins);
        }
        in.close();
        out.flush();
        out.close();
        return (context.getFileStreamPath(source)).getAbsolutePath();
    }
    
    /**
     * <删除私有空间里边的文件>
     * 
     * @param name
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static final boolean deleteInternalFile(String name) {
        File file = new File(name);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /**
     * 读取属性文件
     * <功能详细描述>
     * @param inputStream
     * @return
     * @throws IOException [参数说明]
     * 
     * @return Properties [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static Properties getProperties(InputStream inputStream) throws IOException{
        Properties p = new Properties();
        p.load(inputStream);
        return p;
    }
    
    /**
     * 根据附件路径文件返回文件名
     * <功能详细描述>
     * @param string
     * @return [参数说明]
     * 
     * @return String [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getPathName(String string){
        String show = null;
        File file = new File(string);
        show = file.getName().toString();
        return show;
    }
}
