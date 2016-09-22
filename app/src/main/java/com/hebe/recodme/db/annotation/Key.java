package com.hebe.recodme.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  主键 默认 false
 * Created By HebeChung on 2016/9/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Key {
    public abstract boolean autoIncrease() default false;
} 
