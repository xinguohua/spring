package tju.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tju.Inter.ICalculator;
import tju.impl.Calculatorimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



public class test {

    private ApplicationContext AOP = new ClassPathXmlApplicationContext("AOP.xml");

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
        bean.div(1, 0);
        //System.out.println(bean.getClass());


    }

}
