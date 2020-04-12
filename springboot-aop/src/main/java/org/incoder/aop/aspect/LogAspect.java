package org.incoder.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.incoder.aop.annotation.Log;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  13:12
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 设置切入点
     */
    @Pointcut("execution(* org.incoder.aop.controller.*.*(..))")
    public void pointcut() {

    }

    /**
     * 切面方法，记录日志
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("暂不支持非方法注解");
        }

        //调用实际方法
        // ProceedingJoinPoint：用于环绕通知，使用proceed()方法来执行目标方法
        Object object = joinPoint.proceed();

        //获取执行的方法
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //判断是否包含了 无需记录日志的方法
        Log logAnnotation = AnnotationUtils.getAnnotation(method, Log.class);
        if (logAnnotation != null && logAnnotation.ignore()) {
            return object;
        }
        if (logAnnotation != null) {
            log.info("log注解描述：{}", logAnnotation.desc());
        }

        // 开始时间
        long beginTime = System.currentTimeMillis();

        //利用RequestContextHolder获取request对象
        ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        // URI获取
        String uri = requestAttr.getRequest().getRequestURI();
        log.info("开始计时：{}  URI：{}", new Date(), uri);

        //访问目标方法的参数 可动态改变参数值
        Object[] args = joinPoint.getArgs();

        //方法名获取
        String methodName = joinPoint.getSignature().getName();
        log.info("请求方法：{}  请求参数：{} ", methodName, Arrays.toString(args));

        //可能在反向代理请求进来时，获取的IP存在不正确行 这里直接摘抄一段来自网上获取ip的代码
        log.info("请求ip：{}", getIpAddr(requestAttr.getRequest()));

        // 结束时间
        long endTime = System.currentTimeMillis();

        log.info("结束计时: {},  URI: {},耗时：{}", new Date(), uri, endTime - beginTime);

        //模拟异常
        //System.out.println(1/0);
        return object;
    }

    @AfterReturning(value = "pointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterReturning advise");
    }

    /**
     * 指定拦截器规则；也可直接使用within(@org.springframework.web.bind.annotation.RestController *)
     * 这样简单点 可以通用
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e) {
        log.error("切面发生了异常：", e);
        //这里可以做个统一异常处理
        //自定义一个异常 包装后排除
        //throw new AopException("xxx);
    }

    /**
     * 转至：https://my.oschina.net/u/994081/blog/185982
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if ("127.0.0.1".equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        log.error("获取ip异常：{}", e.getMessage());
                        e.printStackTrace();
                    }
                    ipAddress = inet != null ? inet.getHostAddress() : null;
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) {
                // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }

}
