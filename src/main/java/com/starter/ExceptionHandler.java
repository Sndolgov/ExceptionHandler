package com.starter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ExceptionHandler implements MethodInterceptor
{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {
        try
        {
            return methodInvocation.proceed();
        }catch (Throwable ex){
            System.out.println("PSR не работает!!!");
            throw ex;
        }
    }
}
