package com.hebe.recodme.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 项目的数据表
 * Created by HebeChung on 2016/9/29.
 */
@DatabaseTable
public class ProjectType implements Serializable {
    @DatabaseField(generatedId = true)
    public int ID;

    /**
     * 编码
     */
    @DatabaseField
    public String code;

    /**
     * 名称
     */
    @DatabaseField
    public String name;

    /**
     * 图标
     */
    @DatabaseField
    public int iconResId;


} 
