package com.lin.blog.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lin945
 * @date 2021/1/15 15:23
 * @description
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    /**
     * controller切入点
     *
     */
    @Pointcut("execution(public * com.lin.blog.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestInfo requestInfo = new RequestInfo(url, ip, classMethod, args);
        log.info("request:{}", requestInfo);
    }

    @After("log()")
    public void doAfter() {
        log.info("");
    }

    @AfterReturning(returning = "o", pointcut = "log()")
    public void doAfterReturn(Object o) {
        log.info("result:{}", o);
    }

    @Data
    @AllArgsConstructor
    private class RequestInfo {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
