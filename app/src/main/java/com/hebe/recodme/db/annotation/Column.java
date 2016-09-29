package com.hebe.recodme.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 列
 * Created By HebeChung on 2016/9/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**column name**/
    public abstract  String  name() default "";
    /**column 类型**/
    public abstract  String  type()  default  "";
    /**是否有分格符**/
    public abstract boolean splitStr() default true;
    /**column 长度**/
    public abstract int length() default 0;
} 
