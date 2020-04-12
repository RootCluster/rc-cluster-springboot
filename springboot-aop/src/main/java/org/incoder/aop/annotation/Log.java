package org.incoder.aop.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  13:11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
// 该自定义注解只能在方法上使用
@Target({ElementType.METHOD})
public @interface Log {

    /**
     * 日志描述，这里使用了@AliasFor 别名，由spring提供
     */
    @AliasFor("desc")
    String value() default "";

    /**
     * 日志描述
     */
    @AliasFor("value")
    String desc() default "";

    /**
     * 是否不记录日志
     */
    boolean ignore() default false;
}