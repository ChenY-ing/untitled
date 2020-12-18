package com.bdqn1.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)//切面优先级
@Aspect
@Component
public class MyAspect {
    @Before("com.bdqn1.test.CaculateAspect.common()")
    public void addMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("MyAspect 前置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }
}
