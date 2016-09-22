package com.hebe.recodme.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hebe.recodme.db.annotation.Table;

/**
 * db 建表的助手类
 * Greate By HebeChung on 2016/9/22
 */
public class TableHelper  {
    public static final String TAG="TableHelper";

    /***
     * 创建数据库表
     * @param db SQLite
     * @param clazz table name
     * @param <T>
     */
    public static <T> void  createTabble(SQLiteDatabase db,Class<T> clazz){
        String tableName="";
        if (clazz.isAnnotationPresent(Table.class)){
            Table table=(Table) clazz.getAnnotation(Table.class);
            tableName=table.name();
            debug(tableName);
        }
        StringBuilder sql=new StringBuilder("CREATE TABLE  ").append(tableName).append("(");




    }

    /***
     * 记录日志
     * @param msg
     */
    public static void debug(Object msg){
        if (msg!=null){
            Log.d(TAG,"table name:"+msg.toString());
        }


    }
}
