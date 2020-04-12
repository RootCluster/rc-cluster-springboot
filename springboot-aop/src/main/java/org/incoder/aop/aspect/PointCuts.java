package org.incoder.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  13:59
 */
public class PointCuts {

    @Pointcut(value = "within(org.incoder.aop.controller.*)")
    public void aopDemo() {

    }
}
