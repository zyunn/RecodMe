package com.hebe.recodme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 基础activity--处理基础类别
 * Created by HebeChung on 2016/10/4.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent();
        initViews();
    }


    public abstract void setContent();

    public abstract void initViews();

    /***
     * 初始化头部的buton
     */
    protected void initHeadBtn(int resID, String str, @Nullable View.OnClickListener onClickListener) {
        if (!hasIncludeHead()) {
            return;
        }
        Button btnLeft = (Button) findViewById(resID);
        if (btnLeft != null) {
            btnLeft.setVisibility(View.VISIBLE);
            btnLeft.setText(str);
            if (onClickListener != null) {
                btnLeft.setOnClickListener(onClickListener);
            } else {
                btnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            }
        }
    }

    /**
     * 检查是否包含头部
     */
    private boolean hasIncludeHead() {
        try {
            View view = findViewById(R.id.item_head);
            return view != null;

        } catch (Exception e) {
            return false;
        }
    }

    /***
     * 设置左边是返回
     */
    protected void setLeftBtnBack() {
        initHeadBtn(R.id.btn_left, "返回", null);
    }


    /***
     * 设置标题
     */
    protected void setTitle(String title) {
        if (hasIncludeHead()) {
            TextView txtTitle = (TextView) findViewById(R.id.txt_title);
            txtTitle.setText(title);
        }
    }


}
