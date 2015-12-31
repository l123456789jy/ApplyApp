package com.egov.applyapp.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import com.egov.applyapp.R;
import com.egov.applyapp.contex.ApplicationData;
import com.egov.applyapp.utiles.LogUtil;
import com.egov.applyapp.view.NoScrollGridView;
import me.relex.circleindicator.CircleIndicator;

/**
 * 作者：liujingyuan on 2015/12/29 13:42
 * 邮箱：906514731@qq.com
 * 工作页面的适配器
 */
public class WorkAdapter extends BaseAdapter<WorkAdapter.ItemViewHolder> {
    private final FragmentActivity activity;
    WorkPagerAdapter mworkPagerAdapter;


    public WorkAdapter(FragmentActivity activity) {
        this.activity=activity;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        super.onCreateViewHolder(parent, viewType);
        View view = null;
        LogUtil.e("viewType" + viewType);
        //代表是头部的viewpager
        if (viewType == IS_VIEWPAGER) {
            view = View.inflate(parent.getContext(), R.layout.work_pager_item,
                    null);
        }
        if (viewType == IS_GRADLEVIEW) {
            view = View.inflate(parent.getContext(), R.layout.gradview_item,
                    null);
        }
        if (viewType == IS_NORMAL) {
            view = View.inflate(parent.getContext(), R.layout.work_pager_items,
                    null);
        }

        return new ItemViewHolder(view, viewType);//创建一个viewholder,然后将view传递进来！
    }


    @Override public int getItemViewType(int position) {
        super.getItemViewType(position);
        //这里区分显示不同的view
        LogUtil.e("position" + position);
        //代表是头部的viewpager
        if (position == IS_VIEWPAGER) {
            return IS_VIEWPAGER;
        }
        if (position == IS_GRADLEVIEW) {
            return IS_GRADLEVIEW;
        }
        if (position == IS_NORMAL) {
            return IS_NORMAL;
        }
        else {
            return super.getItemViewType(position);
        }
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        //获取显示的不同的type
        int itemViewType = holder.getItemViewType();
        super.onBindViewHolder(holder, position);
        //代表是头部的viewpager
        if (itemViewType == IS_VIEWPAGER) {
            mworkPagerAdapter = new WorkPagerAdapter(mLayoutUtil,
                    ApplicationData.context, options_base);
            holder.mAutoScrollViewPager.setAdapter(mworkPagerAdapter);
            //开启自动滚动
            holder.mAutoScrollViewPager.startAutoScroll();
            holder.indicator.setViewPager(holder.mAutoScrollViewPager);
            mLayoutUtil.drawViewLayout(holder.indicator, 0f, 0f, 0.8f, 0.185f);
            holder.mAutoScrollViewPager.setOnPageChangeListener(
                    new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        }


                        @Override public void onPageSelected(int position) {

                        }


                        @Override
                        public void onPageScrollStateChanged(int state) {
                        }
                    });
            //代表是gradview形式
        }
        if (itemViewType == IS_GRADLEVIEW) {
            GridViewAdapter mWorkAGraddapter = new GridViewAdapter();
            holder.mGridView.setAdapter(mWorkAGraddapter);

        }if (itemViewType == IS_NORMAL){
            mLayoutUtil.drawViewLayout(holder.add_rl,0f,0.068f,0f,0.02f);
            //添加应用
            holder.add_rl.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                }
            });
        }
    }


    @Override public int getItemCount() {
        return 3;
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        AutoScrollViewPager mAutoScrollViewPager;
        CircleIndicator indicator;
        NoScrollGridView mGridView;
        RelativeLayout rl;
        RelativeLayout add_rl;
        TextView tv;


        public ItemViewHolder(View itemView, int viewType) {
            super(itemView);
            //代表是头部的viewpager
            if (viewType == IS_VIEWPAGER) {
                mAutoScrollViewPager
                        = (AutoScrollViewPager) itemView.findViewById(
                        R.id.convenientBanner);
                indicator = (CircleIndicator) itemView.findViewById(
                        R.id.indicator);
                tv = (TextView) itemView.findViewById(R.id.tv);
                //代表中间recyview的布局
            }
            if (viewType == IS_GRADLEVIEW) {
                mGridView = (NoScrollGridView) itemView.findViewById(
                        R.id.listview_item_gridview);
                rl = (RelativeLayout) itemView.findViewById(R.id.rl);
            }
            if (viewType == IS_NORMAL) {
                add_rl = (RelativeLayout) itemView.findViewById(R.id.add_rl);
            }
        }
    }
}
