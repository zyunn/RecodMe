package com.hebe.recodme.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebe.recodme.R;
import com.hebe.recodme.db.ProjectType;
import com.hebe.recodme.db.dao.ProjectTypeDao;

import java.util.ArrayList;

/**
 * adapter 的
 * Created by HebeChung on 2016/9/30.
 */
public class ProjectTypeAdapter extends ArrayAdapter<ProjectType> {

    public ProjectTypeAdapter(Context context) {
        super(context, 0);
        projectTypeDao=new ProjectTypeDao(getContext());
        types = (ArrayList<ProjectType>) projectTypeDao.queryForAll();
        // 在末尾添加加号功能
        addNewIcon();
        addAll(types);
        notifyDataSetChanged();
    }

    /**
     * 在末尾添加加号功能
     */
    private void addNewIcon() {
        ProjectType newIcon=new ProjectType();
        newIcon.name="添加";
        newIcon.iconResId=R.mipmap.pin2;
    }

    private ArrayList<ProjectType> types;
    ProjectTypeDao projectTypeDao;


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(getContext(), R.layout.grid_types_item, null);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.txt_type);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ProjectType type = types.get(position);
        viewHolder.name.setText(type.name);
        viewHolder.icon.setImageResource(type.iconResId);
        return convertView;
    }

    private class ViewHolder {
        ImageView icon;
        TextView name;
    }


}
