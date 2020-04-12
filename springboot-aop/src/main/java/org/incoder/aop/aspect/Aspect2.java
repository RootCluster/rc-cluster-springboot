package org.incoder.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  14:04
 */
@Component
@Aspect
public class Aspect2 {

    @Before(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect2] before advise");
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
        System.out.println("[Aspect2] afterReturning advise");
    }

    @AfterThrowing(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterThrowing advise");
    }

    @After(value = "org.incoder.aop.aspect.PointCuts.aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect2] after advise");
    }
}
