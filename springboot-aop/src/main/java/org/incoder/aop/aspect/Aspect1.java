package org.incoder.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  13:59
 */
@Component
@Aspect
public class Aspect1 {

    @Before(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect1] before advise");
    }

    @Around(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Aspect1] around advise 1");
        Object object = joinPoint.proceed();
        System.out.println("[Aspect1] around advise2");
        return object;
    }

    @AfterReturning(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect1] afterReturning advise");
    }

    @AfterThrowing(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect1] afterThrowing advise");
    }

    @After(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect1] after advise");
    }
}