package com.bdqn.dao;

import com.bdqn.exception.AccountException;
import com.bdqn.exception.BookStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Double findBookPriceById(int bid) {
        String sql="select price from mybook.book where bookId=?";
        return jdbcTemplate.queryForObject(sql,Double.class,bid);
    }

    public void updateBookStock(int bid) {
        //检查库存是否足够
        String sql1="select stock from mybook.book_stock where bookId=?";
        int r = jdbcTemplate.queryForObject(sql1, Integer.class, bid);
        if (r==0){
            throw new BookStockException("库存不足");
        }

        String sql="update mybook.book_stock set stock=stock-1 where bookId=?";
        jdbcTemplate.update(sql,bid);
    }

    public void updateUserAccount(String usename, double price) {
        //检查账户余额是否足够
        String sql1="select balance from mybook.account where username=?";
        double r = jdbcTemplate.queryForObject(sql1, Integer.class, usename);
        if (r<price){
            throw new AccountException("余额不足");
        }

        String sql="update mybook.account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,usename);
    }

}
