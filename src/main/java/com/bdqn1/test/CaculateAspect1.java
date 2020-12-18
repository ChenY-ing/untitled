package com.bdqn1.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;


public class CaculateAspect1 {
    public void addMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("CaculateAspect1 前置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }

    public void afterMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("后置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }

    public void afterreturnMethod(JoinPoint joinPoint,Object param){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("返回通知：方法名：%s，参数列表：%s,返回值是：%s",mname, Arrays.asList(args),param));
    }

    public void afterthrowingMethod(JoinPoint joinPoint,ArithmeticException ex){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("异常通知：方法名：%s，参数列表：%s,异常信息是：%s",mname, Arrays.asList(args),ex));
    }

    public Object aroundMethod(ProceedingJoinPoint pjp){
        String mname=pjp.getSignature().getName();
        Object[] args=pjp.getArgs();
        Object result=null;
        try {
            //前置通知
            result=pjp.proceed();
            //返回通知
        } catch (Throwable throwable) {
            //异常通知
        }finally {
            //后置通知
        }
        return result;
    }

}
