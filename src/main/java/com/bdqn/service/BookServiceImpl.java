package com.bdqn.service;

import com.bdqn.dao.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
//    @Qualifier("bookDaoImpl")//指定自动装载名字
    private BookDaoImpl bookDao;
//使用noRollBackFor={AccountException.class}来指定对哪些异常不回滚
//使用isolation 来指定隔离级别
//使用propagation 指定事务的传播方式
//使用readonly 来指定事务是否只读
//使用timeout 单位为秒 指定事务的强制回滚超时时间
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED) //添加事务注解

    public void purchase(String username,int bid) {
        //获得书的单价
        double price = bookDao.findBookPriceById(bid);
        //更新书的库存
        bookDao.updateBookStock(bid);
        //更新用户余额
        bookDao.updateUserAccount(username,price);
    }
}
