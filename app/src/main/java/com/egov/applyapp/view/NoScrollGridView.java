package com.egov.applyapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 作者：liujingyuan on 2015/12/30 09:49
 * 邮箱：906514731@qq.com
 */
public class NoScrollGridView extends GridView {

    public NoScrollGridView(Context context) {
        super(context);
    }


    public NoScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}