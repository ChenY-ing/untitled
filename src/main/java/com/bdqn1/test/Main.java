package com.bdqn1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-aop.xml");
        Caculate caculate= (Caculate) ctx.getBean("caculateImpl");
        caculate.add(4,5);
        caculate.div(3,0);
    }

}
