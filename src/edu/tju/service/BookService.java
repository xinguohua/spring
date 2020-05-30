package edu.tju.service;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import edu.tju.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Qualifier("bookDaoEx")
    @Autowired
    private BookDao bookDao1;
    public void bookSava(){
        bookDao1.bookSava();
        System.out.println("service正在调用dao ....");
    }
}
