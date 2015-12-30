package com.egov.applyapp.utiles;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * 作者：liujingyuan on 2015/12/30 11:41
 * 邮箱：906514731@qq.com
 */
public class WindowsUtiles {

    /**
     *  调整窗口的透明度
     * @param from  from>=0&&from<=1.0f
     * @param to  to>=0&&to<=1.0f
     * @param context  当前的activity
     */
    public static void dimBackground(final float from, final float to, Activity context) {
        final Window window = context.getWindow();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        WindowManager.LayoutParams params
                                = window.getAttributes();
                        params.alpha = (Float) animation.getAnimatedValue();
                        window.setAttributes(params);
                    }
                });
        valueAnimator.start();
    }
}
