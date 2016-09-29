package com.hebe.recodme.db;

import com.hebe.recodme.db.annotation.Column;
import com.hebe.recodme.db.annotation.Table;

/**
 * 项目的数据表
 * Created by HebeChung on 2016/9/29.
 */
@Table(name = "ProjectType")
public class ProjectType {
    @Column
    Integer ID;

    @Column(length = 5)
    String name;






} 
