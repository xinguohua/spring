package edu.tju.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {


    public void bookSava(){

        System.out.println("保存了一本图书");
    }
}
