package cn.tju.test;

import cn.tju.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOStest {

    /*****
     * 存在的几个问题
     * 1）src 源码包开始的路径，称为类路径的开始 因为src是源码包 所有文件都将进入类路径/bin或者/classes 这两者称为类路径
     * 2)同理resources root 也是类路径  也就是所有源码包的东西都会被合并放在类路径里面
     * 3）web 项目的类路径 /WEB-INF/classes中
     *
     * 注意先导包在创建配置文件
     *
     * 注意细节
     * 1）ApplicationContext 接口 看实现类 两个 图1=========
     * 2）给容器中注册一个组件，我们也从容器中按照id 拿到了这个组件的对象？
     *      组件的创建工作，是容器完成的
     *  3）person对象是什么时候创建好的？
     *  在容器创建的时候就好了，容器只要一启动，容器中所注册的所有对象都将创建好
     *   ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
     *   4）同一个组件在IOC容器中是单实例的，容器启动完成都已经创建好了
     * 5) 容器中没有这个组件获取组件？报异常org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'person03' is defined
     *  6) 容器中<property></property>标签是怎么赋值的呢？IOC容器在创建这个组件对象的时候，会利用setter方法为javaBean的属性进行赋值
     *  7）javaBean的属性名是由什么决定的？getter/setter方法是属性名；set去掉后面那一串字母小写就是属性名；
     *      并不是由类的成员变量private String Name;决定的
     *      因此所有getter/setter都自动生成
     */

    /**
     * 从容器中拿到这个组件
     */
    @Test
    public void test(){
        //这个接口代表IOC容器，先找到婚介所 相当于应用的上下文
        //当前应用的xml配置文件在ClassPath(类路径)下
        //根据spring的配置文件得到IOC容器 也就是婚介所名单
        ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
        System.out.println("容器启动完成");


        //容器帮我们创建好了对象 取得对象
        Person bean = (Person)ioc.getBean("person01");

        //拿两次相同的对象
        Person bean2 = (Person)ioc.getBean("person01");
        System.out.println(bean==bean2);//true //也就是同一个对象（组件）在ioc上只有一份

        System.out.println("====================");
        //Person bean3= (Person)ioc.getBean("person03");

        System.out.println(bean);
    }
}
