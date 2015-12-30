package com.egov.applyapp;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.egov.applyapp.ui.fragment.SimpleFragmentPagerAdapter;
import com.egov.applyapp.utiles.LayoutUtil;
import com.egov.applyapp.utiles.ToastUtils;

/**
 * 首页
 */
public class MainActivity extends AppCompatActivity {
    int postion = 0;
    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.sliding_tabs) TabLayout mSlidingTabs;
    @InjectView(R.id.appbar) AppBarLayout mAppbar;
    @InjectView(R.id.viewpager) ViewPager mViewpager;
    @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    private SimpleFragmentPagerAdapter pagerAdapter;
    LayoutUtil mLayoutUtil = new LayoutUtil();


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 设置Logo图标
        toolbar.setLogo(R.drawable.icon_dingding);
        toolbar.setTitleTextColor(
                getResources().getColor(R.color.tabIndicatorColor));
        setSupportActionBar(toolbar);
        initCount();
    }


    /**
     * 初始化内容
     */
    private void initCount() {
        pagerAdapter = new SimpleFragmentPagerAdapter(
                getSupportFragmentManager(), this);
        mViewpager.setAdapter(pagerAdapter);
        mViewpager.setOffscreenPageLimit(pagerAdapter.getCount());
        mSlidingTabs.setupWithViewPager(mViewpager);
        //适合条目较多的模式
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
        mViewpager.setCurrentItem(0);
        for (int i = 0; i < mSlidingTabs.getTabCount(); i++) {
            TabLayout.Tab tab = mSlidingTabs.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

        mViewpager.setOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }


                    @Override public void onPageSelected(int position) {
                        postion = position;
                        //促使menu更新
                        invalidateOptionsMenu();
                        //模拟显示消息
                        if (position == 1) {
                            pagerAdapter.getImageView(position)
                                        .setVisibility(View.VISIBLE);
                        }
                        else {

                        }
                        //选中字体的效果
                        for (int i = 0;
                             i < pagerAdapter.getTextViewList().size();
                             i++) {
                            TextView mTextView
                                    = (TextView) pagerAdapter.getTextViewList()
                                                             .get(i);
                            if (i == position) {
                                mTextView.setTextColor(getResources().getColor(
                                        R.color.tabIndicatorColor));
                            }
                            else {
                                mTextView.setTextColor(getResources().getColor(
                                        R.color.tabUnselectColor));
                            }
                        }
                    }


                    @Override public void onPageScrollStateChanged(int state) {

                    }
                });
    }


    /**
     * @param menu menu
     * @return 每次更新的时候都会调用
     */
    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        //一定要清空要不然会类加按钮
        menu.clear();
        //显示消息的按钮菜单
        if (postion == 0) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        else {
            getMenuInflater().inflate(R.menu.menu_add, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ToastUtils.show("设置");
            return true;
        }
        if (id == R.id.action_edit) {
            ToastUtils.show("编辑");
            return true;
        }
        if (id == R.id.action_share) {
            ToastUtils.show("搜索");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
