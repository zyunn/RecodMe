package com.hebe.recodme.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库Help 类
 * Created by HebeChung on 2016/9/29.
 */
public class DataBaseHealper extends SQLiteOpenHelper{
    public static final String DB_NAME="RECORDER";
    public static final int VERSION=1;

    public DataBaseHealper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, VERSION);
    }

    public DataBaseHealper(Context context){
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
