package com.hebe.recodme.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import com.hebe.hebelibrary.CommonUtil;
import com.hebe.recodme.db.annotation.Column;
import com.hebe.recodme.db.annotation.Key;
import com.hebe.recodme.db.annotation.Table;

import java.lang.reflect.Field;
import java.sql.Blob;

/**
 * db 建表的助手类
 * Create By HebeChung on 2016/9/22
 */
public class TableHelper {
    public static final String TAG = "TableHelper";

    /***
     * 创建数据库表
     *
     * @param db    SQLite
     * @param clazz table name
     */
    public static <T> void createTabble(SQLiteDatabase db, Class<T> clazz) {
        String tableName = "";
        if (clazz.isAnnotationPresent(Table.class)) {
            Table table = (Table) clazz.getAnnotation(Table.class);
            tableName = table.name();
            debug(tableName);
        }
        StringBuilder sb = new StringBuilder("CREATE TABLE  ").append(tableName).append("(");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            debug(field.getName());

            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnType = column.type();
                String columnName = column.name();
                int columnLength = column.length();
                Class<?> fieldType = field.getType();

                if (TextUtils.isEmpty(columnType)) {
                    columnType = getColumnType(fieldType);
                }

                if (TextUtils.isEmpty(columnName)) {
                    if (column.splitStr()) {// 驼峰命名
                        columnName = CommonUtil.getSplitString(field.getName());
                    } else {
                        columnName = field.getName();
                    }

                }

                sb.append(columnName).append(" ").append(columnType);

                if (columnLength > 0) {
                    sb.append("(").append(columnLength).append(")");
                }

                if (field.isAnnotationPresent(Key.class)) {
                    Key key = field.getAnnotation(Key.class);
                    sb.append(" primary key");
                    boolean autoIncrease = key.autoIncrease();
                    if (autoIncrease
                            && (fieldType == Integer.TYPE || fieldType == Integer.class)) {
                        sb.append(" autoincrement");
                    }
                }

                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append(")");

        String sql = sb.toString();

        debug("sql:" + sql);
        db.execSQL(sql);
    }

    /**
     * 取得字段类型
     */
    private static String getColumnType(Class<?> fieldType) {
        if (String.class == fieldType) {
            return "TEXT";
        }
        if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
            return "INTEGER";
        }
        if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
            return "BIGINT";
        }
        if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
            return "FLOAT";
        }
        if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
            return "INT";
        }
        if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
            return "DOUBLE";
        }
        if (Blob.class == fieldType) {
            return "BLOB";
        }
        if (java.util.Date.class == fieldType) {
            return "BIGINT";
        }
        if (java.sql.Date.class == fieldType) {
            return "BIGINT";
        }
        return "TEXT";
    }

    /**
     * 删除数据表格
     * @param db db
     * @param table 要删除的table
     */

    public static <T> void dropTable(SQLiteDatabase db, Class<T> table) {
        String tableName = "";
        if (table.isAnnotationPresent(Table.class)) {
            Table dropTable = table.getAnnotation(Table.class);
            tableName = dropTable.name();
        }
        StringBuilder sql = new StringBuilder("DROP TABLE IF EXISTS").append(tableName);
        db.execSQL(sql.toString());

    }



    /***
     * 记录日志
     */
    public static void debug(Object msg) {
        if (msg != null) {
            Log.d(TAG, "table name:" + msg.toString());
        }


    }
}
