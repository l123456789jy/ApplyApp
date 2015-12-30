package com.egov.applyapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.egov.applyapp.R;
import com.egov.applyapp.utiles.LayoutUtil;

/**
 * 作者：liujingyuan on 2015/12/30 09:51
 * 邮箱：906514731@qq.com
 */
public class GridViewAdapter extends android.widget.BaseAdapter {
    LayoutUtil mLayoutUtil;


    public GridViewAdapter() {
        mLayoutUtil = new LayoutUtil();
    }


    @Override public int getCount() {
        return 8;
    }


    @Override public Object getItem(int position) {
        return null;
    }


    @Override public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(),
                    R.layout.gradview_item_item, null);
            holder.button = (Button) convertView.findViewById(R.id.bt);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        initLocation(holder);

        return convertView;
    }


    private void initLocation(ViewHolder holder) {
        mLayoutUtil.drawViewLayout(holder.button, 0.125f, 0.075f, 0f, 0.02f);
    }


    private class ViewHolder {
        Button button;
    }
}
