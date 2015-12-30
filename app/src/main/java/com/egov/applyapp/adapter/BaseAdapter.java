package com.egov.applyapp.adapter;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.egov.applyapp.R;
import com.egov.applyapp.utiles.LayoutUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 作者：liujingyuan on 2015/12/29 11:49
 * 邮箱：906514731@qq.com
 * 父类的adapter
 */
public class BaseAdapter<T extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<T> {
    public LayoutUtil mLayoutUtil=new LayoutUtil();
    //***************图片操作
    public ImageLoader imageLoader_base;
    public ImageLoadingListener animateFirstListener_base;
    /**
     * 默认格式
     */
    public DisplayImageOptions options_base;
    /**
     * 圆图
     */
    public DisplayImageOptions options_roundness;
    //区分显示不同的条目
    public static final int IS_VIEWPAGER = 0;
    public static final int IS_GRADLEVIEW = 1;
    public static final int IS_NORMAL = 2;


    @Override public T onCreateViewHolder(ViewGroup parent, int viewType) {
        initLoder();
        return null;
    }


    @Override public void onBindViewHolder(T holder, int position) {

    }


    @Override public int getItemCount() {
        return 0;
    }
    /**
     * 初始化ImageLoader
     */
    protected void initLoder() {
        //初始化ImageLoader
        imageLoader_base = ImageLoader.getInstance();
        animateFirstListener_base = new AnimateFirstDisplayListener();
        options_base = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher) // resource or
                // drawable
                .showImageForEmptyUri(R.drawable.ic_launcher) // resource or
                // drawable
                .showImageOnFail(R.drawable.ic_launcher) // resource or drawable
                .resetViewBeforeLoading(false) // default
                //				.delayBeforeLoading(1000)	// 延时一秒加载
                .cacheInMemory(true) // default //使用缓存！
                .cacheOnDisk(true) // default
                .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();

        options_roundness = new DisplayImageOptions.Builder().cacheInMemory() // 缓存在内存中
                                                             .cacheOnDisc() // 磁盘缓存
                                                             .showImageOnLoading(R.drawable.ic_launcher) // resource or
                                                             .showImageForEmptyUri(R.drawable.ic_launcher) // resource
                                                             // or
                                                             .showImageOnFail(R.drawable.ic_launcher) // resource or
                                                             // drawable
                                                             .resetViewBeforeLoading(false) // default
                                                             //				.delayBeforeLoading(1000)
                                                             .cacheInMemory(true) // default //使用缓存！
                                                             .cacheOnDisk(true) // default
                                                             .considerExifParams(false) // default
                                                             .imageScaleType(ImageScaleType.IN_SAMPLE_INT) // default
                                                             .bitmapConfig(
                                                                     Bitmap.Config.RGB_565) // default
                                                             .displayer(new SimpleBitmapDisplayer()) // default
                                                             .displayer(new RoundedBitmapDisplayer(120))//设置图片为圆角显示！
                                                             .handler(new Handler()) // default
                                                             .build();
    }
    private static class AnimateFirstDisplayListener extends
            SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections
                .synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view,
                                      Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
}
