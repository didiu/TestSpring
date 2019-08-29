package com.itheima.cglib;

import com.itheima.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public Object createProxy(Object target){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param  根据指定的父类生成对象
     * @param  拦截的方法
     * @param  拦截方法的参数数组
     * @param  方法的代理对象,用于执行父类的方法
     * @return object
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect=new MyAspect();
        myAspect.checkPermissions();
        Object object=methodProxy.invokeSuper(proxy,args);
        myAspect.log();
        return object;
    }

}
