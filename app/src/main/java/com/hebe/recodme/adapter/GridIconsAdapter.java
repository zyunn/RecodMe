package com.hebe.recodme.adapter;


import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * 所有ICON图标的也面的adapter
 * Created by HebeChung on 2016/10/4.
 */
public class GridIconsAdapter extends ArrayAdapter<Integer> {


    public GridIconsAdapter(Context context) {
        super(context, 0);
        //todo 获取整个图片文件夹内容
        //getContext().getApplicationContext().getResources().getIntArray()

    }


}
