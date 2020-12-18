package com.bdqn1.service.impl;

import com.bdqn1.service.BookService;
import com.bdqn1.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CashierImpl implements Cashier {
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void checkout(String uname, List<Integer> bids) {
        for(int bid:bids){
            bookService.purchase(uname,bid);
        }
    }
}
