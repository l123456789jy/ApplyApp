package com.egov.applyapp.ui.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.egov.applyapp.R;
import com.egov.applyapp.utiles.LayoutUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liujingyuan on 2015/8/31 11:21
 * 邮箱：906514731@qq.com
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "消息", "DING", "工作", "联系人"};
    private Context context;
    LayoutUtil mLayoutUtil=new LayoutUtil();
    List<ImageView> mImageViewList=new ArrayList<>();
    List<TextView> mTextViewList=new ArrayList<>();
    private int[] imageResId = {
            R.drawable.alm_cmail_mail_icon_unread,
            R.drawable.alm_cmail_mail_icon_unread,
            R.drawable.alm_cmail_mail_icon_unread,
            R.drawable.alm_cmail_mail_icon_unread
    };

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override public Fragment getItem(int position) {
        switch (position) {
            //消息
            case 0:
                MessageFragment messageFragment = new MessageFragment();
                return messageFragment;
            //DING
            case 1:
                DingFragment dingFragment = new DingFragment();
                return dingFragment;
            //工作
            case 2:
                WorkFragment workFragment = new WorkFragment();
                return workFragment;
            //联系人
            case 3:
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;
        }
        return null;
    }


    @Override public int getCount() {
        return tabTitles.length;
    }


    @Override public CharSequence getPageTitle(int position) {
      //  return tabTitles[position];
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        // Replace blank spaces with image icon
        SpannableString sb = new SpannableString("   " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv= (TextView) view.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        mLayoutUtil.drawViewLayout(img,0.027f,0.0156f,0f,0f);
        mImageViewList.add(img);
        mTextViewList.add(tv);
        return view;
    }


    /**
     *返回imageview
     * @param postion  postion
     * @return  ImageView
     */
    public ImageView getImageView(int postion){

        return  mImageViewList.get(postion);
    }
    /**
     *TextView
     * @param postion  postion
     * @return  ImageView
     */
    public List getTextViewList(){
        return  mTextViewList;
    }
}
