package com.tju.test;

import com.tju.Inter.ICalculator;
import com.tju.proxy.CaculatorProxy;
import com.tju.impl.Calculatorimpl;
import org.junit.Test;

import java.util.Arrays;

public class test {

    @Test
    public void test(){
        ICalculator calculator =new Calculatorimpl();
        calculator.add(1,2);
        calculator.div(2,1);
        System.out.println("====================");

        //如果是拿到了这个对象的代理对象；代理对象执行加减乘除;
        ICalculator proxy = CaculatorProxy.getProxy(calculator);

        //com.sun.proxy.$Proxy2也是实现了Calculator接口
        //代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        proxy.add(2, 1);
        proxy.div(2, 1);

    }
}
