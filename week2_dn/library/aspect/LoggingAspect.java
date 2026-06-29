package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("Before : " + jp.getSignature().getName());
    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("After : " + jp.getSignature().getName());
    }
}