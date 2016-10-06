package com.hebe.recodme.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 所有ICON图标的也面的adapter
 * Created by HebeChung on 2016/10/4.
 */
public class GridIconsAdapter extends ArrayAdapter<Integer> {
    private Context mContext;


    public GridIconsAdapter(Context context) {
        super(context, 0);
        this.mContext = context;
        generateAllIconsId();

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = new ImageView(mContext);
            convertView.setLayoutParams(new LayoutParams(64, 64));
        }
        ((ImageView) convertView).setImageResource(getItem(position));
        return convertView;
    }

    /***
     * 生成所有图片ID
     */
    private void generateAllIconsId() {
        String[] iconNames = getAllIconNames();
        if (iconNames == null || iconNames.length < 0) {
            return;
        }
        ArrayList<Integer> resIds = new ArrayList<>();
        for (String iconName : iconNames) {
            resIds.add(mContext.getResources().getIdentifier(iconName, "mipmap", "com.hebe.recodme"));
        }
        addAll(resIds);
    }

    /**
     * 读取所有图片名称
     */
    private String[] getAllIconNames() {
        BufferedReader br;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            InputStream is = getContext().getAssets().open("default.txt");
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line).append(";");
            }
            return sb.toString().split(";");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
