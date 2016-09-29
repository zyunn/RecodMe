package com.hebe.recodme.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用ormlite 框架实现数据库操作
 * Created by HebeChung on 2016/9/29.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "RECORDER";
    public static final int VERSION = 1;

    public Map<String, Dao> daos = new HashMap<>();

    public static DBHelper instance = null;

    /**
     * 单列模式
     * @param context 上下文环境
     * @return 唯一单列
     */
    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (DBHelper.class){// 比较好的单列模式
                instance = new DBHelper(context);
            }
        }
        return instance;
    }

    /**
     * 创建数据库
     */
    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,ProjectType.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,ProjectType.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public synchronized Dao getDao(Class clazz) throws SQLException{
          Dao dao=null;


        return dao;
    }
}
