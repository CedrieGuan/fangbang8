/**
 *  文件名:SyncImageLoader.java
 *  版权：XiShiNet. Copyright 2012-2012,All rights reserved
 *  公司名称:广州稀世网络科技有限公司
 *  创建人: LY.Koon<koon.lingyu@gmail.com>
 *  创建时间:2012-5-7 下午3:07:56
*/

package com.fangbang8.client.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * 
 * 使用线程池。Android拥有与Java相同的ExecutorService实现，我们就来用它。
 * 线程池的基本思想还是一种对象池的思想，开辟一块内存空间，里面存放了众多(未死亡)的线程，
 * 池中线程执行调度由池管理器来处理。当有线程任务时，从池中取一个，执行完成后线程对象归池，
 * 这样可以避免反复创建线程对象所带来的性能开销，节省了系统的资源。
 * 为了避免出现同时多次下载同一幅图的问题,使用了本地缓存
 *
 * @author LY.Koon<koon.lingyu@gmail.com>
 */
public class SyncImageLoader {
	/**
	 * 判断是否允许加载，默认为true
	 */
	private boolean mAllowLoad = true;
	/**
	 * 实例化Handler对象进行多线程操作
	 */
	final Handler handler = new Handler();
	/**
	 * 图片缓存，使用软引用
	 */
	private HashMap<String, SoftReference<Drawable>> imageCache = new HashMap<String, SoftReference<Drawable>>();   
	/**
	 * 创建可重用线程为5的线程池
	 */
	private ExecutorService executorService=Executors.newFixedThreadPool(5);
	/**
	 * 线程同步的监听器
	 * 
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 */
	public interface OnImageLoadListener {
		public void onImageLoad(Integer tag, Drawable drawable);
	}
	/**
	 * 	设置为不允许加载
	 * 
	 * @return void                               
	 */
	public void lock(){
		mAllowLoad = false;
	}
	/**
	 * 设置为可以加载
	 * 
	 * @return void                               
	 */
	public void unlock(){
		mAllowLoad = true;
	}
	/**
	 * 使用线程池控制加载图片的线程
	 * 
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 * @param tag		需要设置的view标记                                
	 * @param imageUrl	图片链接地址
	 * @param listener	监听器                            
	 * @return void                               
	 * @see OnImageLoadListener
	 */
	public void loadImage(Integer tag, String imageUrl,
			OnImageLoadListener listener) {
		final OnImageLoadListener mListener = listener;
		final String mImageUrl = imageUrl;
		final Integer mtag = tag;
		
		executorService.submit(new Runnable() {
			public void run() {
					loadImage(mImageUrl, mtag, mListener);
			}
		});
	}
	/**
	 * 根据网络链接获得网络图片
	 * 
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 * @param url                             
	 * @return Drawable                               
	 * @exception/throws IOException             
	 */
	public static Drawable loadImageFromUrl(String url) throws IOException {
			URL m = new URL(url);
			InputStream i = (InputStream) m.getContent();
			Drawable d = Drawable.createFromStream(i, "src");
			return d;
	}
	/**
	 * 加载图片到图片缓存中和调用监听器
	 * 
	 * @author LY.Koon<koon.lingyu@gmail.com>
	 * @param mImageUrl                             
	 * @param mtag  
	 * @param mListener                          
	 * @return void                               
	 * @exception/throws IOException             
	 */
	private void loadImage(final String mImageUrl,final Integer mtag,final OnImageLoadListener mListener){
		if (imageCache.containsKey(mImageUrl)) {  
            SoftReference<Drawable> softReference = imageCache.get(mImageUrl);  
            final Drawable sdrawable = softReference.get();  
            if (sdrawable != null) {  
            	handler.post(new Runnable() {
    				public void run() {
    					if(mAllowLoad){
    						mListener.onImageLoad(mtag, sdrawable);
    					}
    				}
    			});
                return;  
            }  
        }  
		try {
			final Drawable mdrawable = loadImageFromUrl(mImageUrl);
			if(mdrawable != null){
                imageCache.put(mImageUrl, new SoftReference<Drawable>(mdrawable));
			}
			handler.post(new Runnable() {
				public void run() {
					if(mAllowLoad){
						mListener.onImageLoad(mtag, mdrawable);
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
