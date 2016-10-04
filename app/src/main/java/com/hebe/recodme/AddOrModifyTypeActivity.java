package com.hebe.recodme;

import android.content.Intent;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.hebe.recodme.common.Params;

/**
 * 添加或者修改分类界面
 * Created by HebeChung on 2016/10/4.
 */
public class AddOrModifyTypeActivity extends BaseActivity{
    public static final int T_ADD=0x01;
    public static final int T_MODIFY=0x02;

    int type=T_ADD;

    EditText edtName;

    ImageView edtIcon;

    GridView  gridIcons;

    @Override
    public void setContent() {
        setContentView(R.layout.activity_addormodify_type);
    }

    @Override
    public void initViews() {
        // 设置左边的按钮返回
        setLeftBtnBack();
        edtIcon= (ImageView) findViewById(R.id.edt_icon);
        edtName=(EditText)findViewById(R.id.edt_name);
        switch (type){
            case T_ADD:
                initAddViews();
                break;
            case T_MODIFY:
                initModifyViews();
                break;
        }
        gridIcons=(GridView)findViewById(R.id.grid_icons);
       // gridIcons.setAdapter(new );
        // todo  添加addone 页面

    }

    /***
     * 初始化修改页面
     */
    private void initModifyViews() {
        setTitle("修改分类");
        Intent intent=getIntent();
        edtName.setText(intent.getStringExtra(Params.T_NAME));
        edtIcon.setImageResource(intent.getIntExtra(Params.t_ICON,0));
    }

    /**
     * 初始化新增页面
     */
    private void initAddViews() {
        setTitle("添加分类");
    }
}
