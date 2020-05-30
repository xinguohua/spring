package edu.tju.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoEx extends  BookDao{
    @Override
    public void bookSava() {
        System.out.println("zzzz");
    }
}
