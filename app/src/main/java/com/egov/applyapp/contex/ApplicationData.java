package com.egov.applyapp.contex;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.view.WindowManager;
import com.egov.applyapp.constance.Directory;
import com.egov.applyapp.utiles.LogUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import java.io.File;

public class ApplicationData extends Application {
    public static int screenWidth;
    public static int screenHeight;
    /**
     * 标题栏与状态栏的高度占比
     */
    public static float ScreenTitle;
    /**
     * 标题栏的高度占比
     */
    public static float ScreenTitle_title;

    public static Context context;
    /**
     * 记录播放（ID）视频的id
     */
    public static String VideId = "";
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        // 获取屏幕尺寸大小，使程序能在不同大小的手机上有更好的兼容性
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        screenHeight = wm.getDefaultDisplay().getHeight();
        context = getApplicationContext();
        initImageLoader(context);
        initLocation();
        LogUtil.e("屏幕的宽度" + screenWidth);
        LogUtil.e("屏幕的高度" + screenHeight);
    }

    private void initLocation() {

    }



    /**
     * 初始化ImageLoader
     *
     * @param context
     */
    public static void initImageLoader(Context context) {
        @SuppressWarnings("deprecation") ImageLoaderConfiguration
                config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                        .threadPoolSize(3).memoryCacheSize(getMemoryCacheSize(context))
                        .denyCacheImageMultipleSizesInMemory()
                        .discCacheFileNameGenerator(new Md5FileNameGenerator())
                        .memoryCache(new WeakMemoryCache())//这个类缓存bitmap的总大小没有限制，唯一不足的地方就是不稳定，缓存的图片容易被回收掉
                        //缓存到sd卡把图片！
                        .discCache(new UnlimitedDiscCache(new File(
                                Directory.CACHE_VIEWSIMAGE.toString())))
                        .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    /**
     * 获取缓存大小
     *
     * @param context
     * @return
     */
    private static int getMemoryCacheSize(Context context) {
        int memoryCacheSize;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            int memClass = ((ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE))
                    .getMemoryClass();
            memoryCacheSize = (memClass / 8) * 1024 * 1024; // 1/8 of app memory
            // limit
        } else {
            memoryCacheSize = 2 * 1024 * 1024;
        }
        return memoryCacheSize;
    }


}
