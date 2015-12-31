package com.egov.applyapp.ui.fragment.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.egov.applyapp.R;
import com.egov.applyapp.base.BaseActivity;

/**
 * 报销的界面
 */
public class ApplyActivity extends BaseActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.open_camer_bt) Button mOpenCamerBt;


    public ApplyActivity() {
        super(R.layout.activity_apply);
    }


    @Override protected void initHead() {
        setStateBarColor(R.color.apply_tobal);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle(getString(R.string.apply));
        mToolbar.setNavigationIcon(getResources().getDrawable(
                R.drawable.actbar_home_up_indicator_white_normal));
    }


    @Override protected void initContent() {
        goBack(ApplyActivity.this, mToolbar);

    }
    @OnClick(R.id.open_camer_bt) void openCam(){


    }

    @Override protected void initLocation() {

    }


    @Override protected void initLogic() {

    }


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }
}
