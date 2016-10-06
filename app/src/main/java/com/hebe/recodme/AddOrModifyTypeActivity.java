package com.hebe.recodme;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.hebe.recodme.adapter.GridIconsAdapter;
import com.hebe.recodme.common.Params;
import com.hebe.recodme.db.ProjectType;
import com.hebe.recodme.db.dao.ProjectTypeDao;

/**
 * 添加或者修改分类界面
 * Created by HebeChung on 2016/10/4.
 */
public class AddOrModifyTypeActivity extends BaseActivity {
    public static final int T_ADD = 0x01;
    public static final int T_MODIFY = 0x02;

    int type;

    EditText edtName;

    ImageView edtIcon;

    GridView gridIcons;
    int mIconResId;
    int mTypeId;

    @Override
    public void setContent() {
        setContentView(R.layout.activity_addormodify_type);
    }

    @Override
    public void initViews() {
        // 设置左边的按钮返回
        setLeftBtnBack();
        edtIcon = (ImageView) findViewById(R.id.edt_icon);
        edtName = (EditText) findViewById(R.id.edt_name);
        switch (type=getIntent().getIntExtra(Params.T_ITYPE,T_ADD)) {
            case T_ADD:
                initAddViews();
                break;
            case T_MODIFY:
                initModifyViews();
                break;
        }
        gridIcons = (GridView) findViewById(R.id.grid_icons);
        gridIcons.setAdapter(new GridIconsAdapter(getBaseContext()));
        gridIcons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mIconResId = (Integer) adapterView.getAdapter().getItem(position);
                edtIcon.setImageResource(mIconResId);
            }
        });
        initHeadBtn(R.id.btn_right, "完成", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveChange();
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    /**
     * 保存信息
     */
    private void saveChange() {
        ProjectType projectType;
        ProjectTypeDao projectTypeDao = new ProjectTypeDao(getBaseContext());
        if (type == T_MODIFY) {
            projectType = projectTypeDao.query(mTypeId);
            projectType.iconResId = mIconResId;
            projectType.name = edtName.getText().toString();
            projectTypeDao.update(projectType);
        } else {
            projectType = new ProjectType();
            projectType.iconResId = mIconResId;
            projectType.name = edtName.getText().toString();
            projectTypeDao.insertProjectType(projectType);
        }
    }

    /***
     * 初始化修改页面
     */
    private void initModifyViews() {
        setTitle("修改分类");
        Intent intent = getIntent();
        edtName.setText(intent.getStringExtra(Params.T_NAME));
        edtIcon.setImageResource(intent.getIntExtra(Params.T_ICON, 0));
        mTypeId = intent.getIntExtra(Params.T_ID, 0);
    }

    /**
     * 初始化新增页面
     */
    private void initAddViews() {
        setTitle("添加分类");
    }
}
