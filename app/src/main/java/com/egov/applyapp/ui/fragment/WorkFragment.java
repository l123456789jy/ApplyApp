package com.egov.applyapp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.egov.applyapp.R;
import com.egov.applyapp.adapter.WorkAdapter;
import com.egov.applyapp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * 工作的界面
 */
public class WorkFragment extends BaseFragment {

    @InjectView(R.id.my_recycler_view) RecyclerView mMyRecyclerView;
    @InjectView(R.id.float_bt) Button mFloatBt;

    public WorkFragment() {
        super(R.layout.fragment_ding);
    }


    @Override protected void initHead() {
    }


    @Override protected void initContent() {
        // 创建一个线性布局管理器
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(
                getActivity());
        mMyRecyclerView.setLayoutManager(mLayoutManager);//设置线性的管理器！
        //设置第二个条目的适配器模式
        WorkAdapter workAdapter = new WorkAdapter();
        mMyRecyclerView.setAdapter(workAdapter);
    }


    @Override protected void initLocation() {
    mLayoutUtil.drawViewLayout(mFloatBt,0.2f,0.1125f,0f,0f);
    }


    @Override protected void initLogic() {
    }


    @Override protected void isShow() {

    }


    @Override protected void isGone() {

    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
