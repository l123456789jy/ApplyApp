package com.egov.applyapp.ui.fragment.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.egov.applyapp.R;
import com.egov.applyapp.base.BaseActivity;
import java.util.ArrayList;
import me.crosswall.photo.pick.PickConfig;

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
    @OnClick(R.id.open_camer_bt) void openPhotos(){
        new PickConfig.Builder(this)
                .pickMode(PickConfig.MODE_MULTIP_PICK)
                .maxPickSize(30)
                .spanCount(3)
                //.showGif(true)
                .checkImage(false) //default false
                .useCursorLoader(false) //default true
                .toolbarColor(R.color.colorPrimary)
                .build();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!=RESULT_OK){
            return;
        }

        if(requestCode==PickConfig.PICK_REQUEST_CODE){
            ArrayList<String> pick = data.getStringArrayListExtra(PickConfig.EXTRA_STRING_ARRAYLIST);
            Toast.makeText(this,"pick size:"+pick.size(),Toast.LENGTH_SHORT).show();
        }
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
