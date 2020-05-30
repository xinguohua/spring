package cn.tju.test;

import cn.tju.bean.Book;
import cn.tju.bean.Car;
import cn.tju.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class IOStest {
     private  ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
    private  ApplicationContext ioc2 = new ClassPathXmlApplicationContext("IOC2.xml");
    private  ApplicationContext ioc3 = new ClassPathXmlApplicationContext("IOC3.xml");
    private  ApplicationContext ioc4 = new ClassPathXmlApplicationContext("IOC4.xml");

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
    public void testx() throws SQLException {





            DataSource bean = ioc4.getBean("datasource", DataSource.class);

            System.out.println(bean.getConnection());



    }

    @Test
    public void test(){
        //这个接口代表IOC容器，先找到婚介所 相当于应用的上下文
        //当前应用的xml配置文件在ClassPath(类路径)下
        //根据spring的配置文件得到IOC容器 也就是婚介所名单

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

    @Test
    public void test11(){
        System.out.println("容器启动完成....");
		Object bean = ioc3.getBean("book");
		Object bean2 = ioc3.getBean("book");
		System.out.println(bean == bean2);
//        Object bean = ioc3.getBean("book");
//        Object bean2 = ioc3.getBean("book");
//        System.out.println(bean == bean2);

    }


    /**
     * 实验2：根据bean的类型从IOC容器中获取bean的实例★ 如果ioc容器中这个类型的bean有多个，查找就会报错
     * org.springframework.beans.factory.NoUniqueBeanDefinitionException: No
     * qualifying bean of type [com.atguigu.bean.Person] is defined: expected
     * single matching bean but found 2: person01,person02
     */
    @Test
    public void test02() {
        //根据bean的类型从IOC容器中获取bean的实例，此时注意在容器中之注册了一个对象
//         Person bean = ioc.getBean(Person.class);
//         System.out.println(bean);

         //如果这个容器中person类有多个则报错


        //替代方法 当容器中有多个bean时
//        Person bean2 = ioc.getBean("person02", Person.class);
//        System.out.println(bean2);
//
        //区别指定类名 区别就是不用类型转换
        Object bean = ioc.getBean("person02");
        System.out.println(bean);
    }
    @Test
    public void test03() {

        Object bean = ioc.getBean("person04");
        System.out.println(bean);
    }

    /**
     * 实验4：正确的为各种属性赋值 测试使用null值 、默认引用类型就是null；基本类型是默认值
     */
    @Test
    public void test04() {
        Person bean = (Person) ioc2.getBean("person01");
        System.out.println(bean);


    }

    @Test
    public void test05() {
        //取出来person对象
        Person person = (Person) ioc2.getBean("person01");
        System.out.println(person);

//        //person对象的car
//        Car car = person.getCar();
//        System.out.println("person的car" + person.getCar());
//        //ioc容器的car01对象
//        Car car01 = (Car) ioc2.getBean("car01");
//        //因为两者的关系是引用 所以相等
//        System.out.println(car01 == car);
//
//
//        //修改容器中的car01对象
//        car01.setCarName("haha ");
//        //引用关系 所以都变了
//        System.out.println("我修改了容器中的car，你的car变了没？" + car);
//        //始终相等
//        System.out.println(car01 == car);

    }


    @Test
    public void test06() {
//        Person person03 = (Person) ioc2.getBean("person03");
//        Map<String, Object> maps = person03.getMaps();
//        System.out.println(maps);
//        Person person04 = (Person) ioc2.getBean("person04");
//        System.out.println(person04.getProperties());
       Person person05 = (Person) ioc2.getBean("person05");
        Map<String, Object> maps = person05.getMaps();

        Map<String, Object> bean = (Map<String, Object>) ioc2.getBean("myMap");
        System.out.println(bean.getClass());


//        List<Book> books = person01.getBooks();
//        System.out.println(books);
//        System.out.println("================");
        /**
         * 内部bean是不能用id获取的；
         * org.springframework.beans.factory.NoSuchBeanDefinitionException:
         *  No bean named 'carInner' is defined
         */
        //Object bean = ioc.getBean("carInner");
        //System.out.println(bean);


    }

    @Test
    public void test07(){
        Person person06 = (Person) ioc2.getBean("person06");
        //查看容器中的car01对象
        Object car = ioc2.getBean("car01");
        System.out.println("容器中的car："+car);//容器中的car：Car [carName=宝马, price=900000, color=绿色]

        //查看Person对象引用的car01对象
        System.out.println("person中的car："+person06.getCar()); //person中的car：Car [carName=宝马, price=900000, color=绿色]
    }

    @Test
    public void test08(){
        //Person person08 = (Person) ioc2.getBean("person08");
        //System.out.println("person08:"+person08);
        System.out.println("=============");
        Person person09 = (Person) ioc2.getBean("person09");
        System.out.println("person09:"+person09);
    }
}
