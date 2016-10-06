package com.hebe.recodme;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hebe.recodme.adapter.ProjectTypeAdapter;
import com.hebe.recodme.db.dao.ProjectTypeDao;

/**
 * 添加一天的
 * Created by HebeChung on 2016/10/4.
 */
public class AddOneActivity extends BaseActivity {
    ProjectTypeAdapter adapter;

    @Override
    public void setContent() {
        setContentView(R.layout.activyt_addone);
    }

    @Override
    public void initViews() {
        GridView typeGrids = (GridView) findViewById(R.id.grid_types);
        adapter = new ProjectTypeAdapter(getBaseContext());
        typeGrids.setAdapter(adapter);
        typeGrids.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == adapterView.getAdapter().getCount() - 1) {
                    gotoAddNewProjectType();
                }
            }
        });
        initHeadBtn(R.id.btn_right, "清空数据", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTypes();
            }
        });

        setTitle("添加记录");
    }

    /***
     * 清空数据
     */
    private void clearTypes() {
        ProjectTypeDao projectTypeDao=new ProjectTypeDao(getBaseContext());
        for (int i=0;i<adapter.getCount()-1;i++){
            projectTypeDao.delete(adapter.getItem(i));
        }
        adapter.refresh();
    }


    /***
     * 跳转到新建项目的页面
     */
    private void gotoAddNewProjectType() {
        startActivityForResult(new Intent(getBaseContext(), AddOrModifyTypeActivity.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            adapter.refresh();
        }
    }
}
