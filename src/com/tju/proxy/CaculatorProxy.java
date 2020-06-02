package com.tju.proxy;

import com.tju.Inter.ICalculator;
import com.tju.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CaculatorProxy {
    public static ICalculator getProxy(ICalculator calculator) {

        //Proxy为目标对象创建代理对象；
        ClassLoader loader=calculator.getClass().getClassLoader();


        Class<?>[] interfaces =calculator.getClass().getInterfaces();

        InvocationHandler h= new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 利用反射执行目标方法
                //目标方法执行后的返回值
                //System.out.println("这是动态代理将要帮你执行方法...");
                Object result = null;
                try {
                    LogUtils.logStart(method, args);
                    result = method.invoke(calculator, args);
                    LogUtils.logReturn(method, result);
                } catch (Exception e) {
                    LogUtils.logException(method,e);
                }finally{
                    LogUtils.logEnd(method);

                }

                //返回值必须返回出去外界才能拿到真正执行后的返回值
                return result;
            }
        };


        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (ICalculator)proxy;
    }
}
