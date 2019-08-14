package com.pawan.springdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

    @Pointcut("execution(* com.pawan.springdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.pawan.springdemo.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* com.pawan.springdemo.controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
    public void appFlow(){}

    @Before("appFlow()")
    public void beforeAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("========> in @Before : calling method: "+methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            System.out.println("====>argument : "+arg);
        }
    }

    @AfterReturning(
            pointcut = "appFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinpoint,Object theResult){
           String method = joinpoint.getSignature().toShortString();

        System.out.println("=====>in @After Returning : from method : "+method);

        System.out.println("======>result : "+theResult);
    }

}
