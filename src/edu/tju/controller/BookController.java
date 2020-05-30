package edu.tju.controller;


import edu.tju.dao.BookDao;
import edu.tju.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller()
//@Scope(value="prototype")
public class BookController {



    //自动为属性这个赋值
    @Autowired
    private BookService bookService;
    @Override
    public String toString() {
        return "aaaaaa";
    }

    public void bookSava(){
        bookService.bookSava();
        System.out.println("controller正在调用service....");
    }

    /**
     * 方法上有@Autowired的话
     * 1)这个方法上也会在bean创建的时候运行
     * 2）这个方法上的每一个参数都会自动注入值
     * @param bookDao1
     * @param bookService
     */
    @Autowired
    public void hahaha(@Qualifier("bookDaoEx") BookDao bookDao1, BookService bookService){
        System.out.println("spring 运行了这个方法。。。。"+bookDao1+"====="+bookService);

    }
}
