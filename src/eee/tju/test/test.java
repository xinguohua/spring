package eee.tju.test;

import eee.tju.impl.Calculatorimpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

    private ApplicationContext AOP = new ClassPathXmlApplicationContext("AOPXML.xml");

    @Test
    public void test(){
//        ICalculator bean = AOP.getBean(ICalculator.class);
//        System.out.println(bean.getClass());
//        int add = bean.add(1, 2);
//        System.out.println(add);

        //没有接口就是本类类型
        //class tju.impl.Calculatorimpl$$EnhancerByCGLIB$$77d4c258
        //cglib帮我们创建好的代理对象
        Calculatorimpl bean = (Calculatorimpl) AOP.getBean("calculatorimpl");
        bean.div(1, 1);
        //System.out.println(bean.getClass());


    }

}
