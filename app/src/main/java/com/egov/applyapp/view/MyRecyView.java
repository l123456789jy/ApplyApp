package com.egov.applyapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 作者：liujingyuan on 2015/12/29 17:23
 * 邮箱：906514731@qq.com
 */
public class MyRecyView extends RecyclerView {

    public MyRecyView(Context context) {
        super(context);
    }


    public MyRecyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public MyRecyView(Context context,
                      @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
