package com.hebe.recodme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hebe.recodme.adapter.ProjectTypeAdapter;

/**
 * 添加一天的
 * Created by HebeChung on 2016/10/4.
 */
public class AddOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activyt_addone);
        GridView typeGrids= (GridView) findViewById(R.id.grid_types);
        typeGrids.setAdapter(new ProjectTypeAdapter(getBaseContext()));
        typeGrids.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==adapterView.getAdapter().getCount()){
                    //去新添加页码
                    gotoAddNewProjectType();
                }
            }
        });
    }

    /***
     * 跳转到新建项目的页码
     */
    private void gotoAddNewProjectType() {
        //todo 跳转到新添加项目的页面

    }
}
