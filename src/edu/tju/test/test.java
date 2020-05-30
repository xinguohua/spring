package edu.tju.test;

import edu.tju.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
     ApplicationContext IOC5 = null;
            @Autowired
            BookController  bookController;

    /**
     * 使用spring的单元测试
     * 1）导包 ：spring 单元测试包spring test
             <dependency>
                <groupId>org.springframework</groupId>
                 <artifactId>spring-test</artifactId>
                 <version>4.0.0.RELEASE</version>
             </dependency>
     * 2)使用注解来指定Spring配置文件的位置
     * 原来 private ApplicationContext IOC5 = new ClassPathXmlApplicationContext("ApplicationContext.xml");
     * 使用的话是 BookController bookController = IOC5.getBean(BookController.class);
     * 现在直接导入注解指定配置文件，和spring单元测试模块
     * @Autowired
        BookController  bookController; //自动注入即可
     * 现在使用注解
     * @ContextConfiguration(locations = "classpath:ApplicationContext.xml")//使用它来指定配置文件的位置
        public class test {
     * 3）指定用那种驱动进行单元测试，默认是junit 用spring的单元测试模块
     * @RunWith(SpringJUnit4ClassRunner.class) //使用spring的单元测试模块 来执行标了@Test注解的测试方法
        public class test {
     */
    @Test
    public void test(){
//        BookController bookController = IOC5.getBean(BookController.class);
        bookController.bookSava();




    }

}
