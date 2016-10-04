package com.hebe.recodme.db.dao;

import android.content.Context;

import com.hebe.recodme.db.DBHelper;
import com.hebe.recodme.db.ProjectType;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义ProjectTypeDao
 * Created by HebeChung on 2016/9/30.
 */
public class ProjectTypeDao {

    private Dao<ProjectType,Integer> projectTypeDao;

    public ProjectTypeDao(Context context) {
        DBHelper dbHelper = DBHelper.getInstance(context);
        try {
            projectTypeDao= dbHelper.getDao(ProjectType.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加项目type
     * @param projectType
     */
    public void insertProjectType(ProjectType projectType){
        try {
            projectTypeDao.create(projectType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量添加数据
     * @param datas
     */
    public void insertProjectTypes(ArrayList<ProjectType> datas){
        try {
            projectTypeDao.create(datas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除数据
     * @param projectType
     */
    public void delete(ProjectType projectType){
        try {
            projectTypeDao.delete(projectType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询--按ID 查
     * @param id
     */
   public ProjectType query(int id){
       ProjectType projectType=null;
       try {
           projectType=projectTypeDao.queryForId(id);
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return projectType;
   }

    /**
     * 查询所有 数据
     *
     */
    public List<ProjectType> queryForAll(){
        List<ProjectType> datas=new ArrayList<>();
        try {
            datas=projectTypeDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;

    }


}
