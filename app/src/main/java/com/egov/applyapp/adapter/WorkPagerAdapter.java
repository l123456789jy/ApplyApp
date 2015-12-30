package com.egov.applyapp.adapter;

/**
 * 作者：liujingyuan on 2015/11/14 23:54
 * 邮箱：906514731@qq.com
 */

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.egov.applyapp.utiles.LayoutUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager适配器
 */
public class WorkPagerAdapter extends PagerAdapter {

    public LayoutUtil mlayoutUtil;
    public Context activity;
    public List<ImageView> imageViewList;
    public List<String> imageUri;
    public DisplayImageOptions options_base;

    public WorkPagerAdapter(LayoutUtil layoutUtil, Context activity, DisplayImageOptions options_base) {
        this.mlayoutUtil = layoutUtil;
        this.activity = activity;
        imageViewList = new ArrayList<>();
        this.options_base = options_base;
        imageUri=new ArrayList<>();
        imageUri.add("http://img4.imgtn.bdimg.com/it/u=128811874," +
                "840272376&fm=21&gp=0.jpg");
        imageUri.add("http://imgsrc.baidu" +
                ".com/forum/pic/item/3ac79f3df8dcd1004e9102b8728b4710b9122f1e.jpg");
        imageUri.add("http://pic1.nipic.com/2008-08-12/200881211331729_2.jpg");
        //暂时模拟3个图片
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(activity);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(imageViewList.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }
    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(imageViewList.get(arg1), 0);
        ImageLoader.getInstance().displayImage(imageUri.get(arg1), imageViewList.get(arg1), options_base);
        return imageViewList.get(arg1);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == (arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}