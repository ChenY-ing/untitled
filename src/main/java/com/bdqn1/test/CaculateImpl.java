package com.bdqn1.test;

import org.springframework.stereotype.Component;

@Component
public class CaculateImpl implements Caculate {
   public int add(int a,int b){
       return a+b;
   }
    public int sub(int a,int b){
        return a-b;
    }
    public int mul(int a,int b){
        return a*b;
    }
    public double div(int a,int b){
        return a/b;
    }
}
