package com.hebe.recodme.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hebe.recodme.db.DataBaseHealper;
import com.hebe.recodme.db.ProjectType;
import com.hebe.recodme.db.TableHelper;

/**
 * Created by HebeChung on 2016/9/29.
 */
public class RecodeDao {
    DataBaseHealper dataBaseHealper;
    SQLiteDatabase db;

    public RecodeDao(Context context) {
        dataBaseHealper=new DataBaseHealper(context);
        db=dataBaseHealper.getWritableDatabase();
        createTable();
    }

    public void createTable(){
        TableHelper.createTabble(db, ProjectType.class);
    }

    public void insert(){
        db.beginTransaction();
        ContentValues contentValues=new ContentValues();
       //contentValues.put(ProjectType.class);

    }


}
