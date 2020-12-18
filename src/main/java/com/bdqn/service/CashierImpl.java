package com.bdqn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashierImpl implements Cashier{
    @Autowired
    private BookService bookService;
    @Transactional
    public void checkout(String uname, List<Integer> bids) {
        for(int bid:bids){
            bookService.purchase(uname,bid);
        }
    }
}
