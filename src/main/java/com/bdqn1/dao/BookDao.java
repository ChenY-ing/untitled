package com.bdqn1.dao;

public interface BookDao {
    //跟距Id获得书的单价
    Double findBookPriceById(int bid);
    //更新书的库存
    void updateBookStock(int bid);
    //更新用户的账户余额
    void updateUserAccount(String usename, double price);
}
