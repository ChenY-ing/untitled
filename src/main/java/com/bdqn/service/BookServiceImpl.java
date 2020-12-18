package com.bdqn.service;

import com.bdqn.dao.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired//先是按类型，还是按名字？
//    @Qualifier("bookDaoImpl")//指定自动装载名字
    private BookDaoImpl bookDao;
    @Transactional(propagation = Propagation.REQUIRES_NEW) //添加事务注解
    public void purchase(String username,int bid) {
        //获得书的单价
        double price = bookDao.findBookPriceById(bid);
        //更新书的库存
        bookDao.updateBookStock(bid);
        //更新用户余额
        bookDao.updateUserAccount(username,price);
    }
}
