package com.kolin.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记注解，标记为【推荐的】类或者写法
 * @Author jingkeling
 * @Date 2018/4/14 19:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    /*
    @Retention 注解作用范围
     */

    String value() default "";
}
