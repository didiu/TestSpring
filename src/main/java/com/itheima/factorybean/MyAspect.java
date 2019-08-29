package com.itheima.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor  {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        checkPermissions();
        Object pbj=methodInvocation.proceed();
        log();
        return pbj;
    }

    private void log() {
        System.out.println("1212");
    }

    private void checkPermissions() {
        System.out.println("11".split(" ").length);
    }


}
