package com.cheng.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-22
 */
@Component
@Aspect
public class LogAop  {
    private long currentTime = 0L;
    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.cheng.log.Log)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     *
     */
    @Before("@annotation(com.cheng.log.Log)")
    public void logBefore(){

    }
    @After("@annotation(com.cheng.log.Log)")
    public void logAfter(){

    }
    @AfterReturning("@annotation(com.cheng.log.Log)")
    public void logAfterReturn(){

    }
    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime = System.currentTimeMillis();
        result = joinPoint.proceed();
        System.out.println("around aop");
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("afterThrowing");
    }
}
