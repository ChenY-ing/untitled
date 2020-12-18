package com.bdqn1.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Order(2)
@Aspect
@Component
public class CaculateAspect {
    //重用切点表达式，定义一个没有代码的1方法，加入@PointCut注释  外部引用需要；类名.方法名
    @Pointcut("execution(* *com.bdqn.test.CaculateImpl.*(..))")
    public void common(){};
    @Before("common()")
    public void addMethod(JoinPoint joinPoint){
        String mname=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println(String.format("CaculateAspect 前置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
    }

//    //后置通知 无论方法是否有异常都会执行，相当于finally块的通知，不一定能获取返回值
//    @After("common()")
//    public void afterMethod(JoinPoint joinPoint){
//        String mname=joinPoint.getSignature().getName();
//        Object[] args=joinPoint.getArgs();
//        System.out.println(String.format("后置通知：方法名：%s，参数列表：%s",mname, Arrays.asList(args)));
//    }
//
//    //返回通知可以获取方法返回值
//    @AfterReturning(value = "common()")
//    public void afterreturnMethod(JoinPoint joinPoint,Object param){
//        String mname=joinPoint.getSignature().getName();
//        Object[] args=joinPoint.getArgs();
//        System.out.println(String.format("返回通知：方法名：%s，参数列表：%s,返回值是：%s",mname, Arrays.asList(args),param));
//    }
//
//    //异常通知可以获取方法抛出的异常,可以指定特定的异常类型
//    @AfterThrowing(value = "execution(* *com.bdqn.test.CaculateImpl.*(..))",throwing = "ex")
//    public void afterreturnMethod(JoinPoint joinPoint,ArithmeticException ex){
//        String mname=joinPoint.getSignature().getName();
//        Object[] args=joinPoint.getArgs();
//        System.out.println(String.format("异常通知：方法名：%s，参数列表：%s,异常信息是：%s",mname, Arrays.asList(args),ex));
//    }

//    //环绕通知可以获取方法抛出的异常,可以指定特定的异常类型
//    @Around("execution(* *com.bdqn.test.CaculateImpl.*(..))")
//    public Object aroundMethod(ProceedingJoinPoint pjp){
//        String mname=pjp.getSignature().getName();
//        Object[] args=pjp.getArgs();
//        Object result=null;
//        try {
//            //前置通知
//            result=pjp.proceed();
//            //返回通知
//        } catch (Throwable throwable) {
//            //异常通知
//        }finally {
//            //后置通知
//        }
//        return result;
//    }

}
