package com.egov.applyapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.egov.applyapp.R;
import com.egov.applyapp.base.BaseFragment;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * 消息的界面
 */
public class MessageFragment extends BaseFragment {

    @InjectView(R.id.action_c) FloatingActionButton mActionC;
    @InjectView(R.id.action_a) FloatingActionButton mActionA;
    @InjectView(R.id.action_b) FloatingActionButton mActionB;
    @InjectView(R.id.multiple_actions) FloatingActionsMenu mMultipleActions;


    public MessageFragment() {
        super(R.layout.fragment_message);
    }


    @Override protected void initHead() {
    }


    @Override protected void initContent() {

    }


    @Override protected void initLocation() {

    }


    @Override protected void initLogic() {

    }


    @Override protected void isShow() {

    }


    @Override protected void isGone() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container,
                savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
