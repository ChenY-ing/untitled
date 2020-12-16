package com.bdqn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Tester {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }
    @Test
    public void testNonQuery(){
        DataSource ds= (DataSource) ctx.getBean("dataSource");
        String sql="insert grade value(null,?)";
        int r=jdbcTemplate.update(sql,"Y4");
        //测试
        System.out.println(r>0?"插入成功":"插入失败");
    }
}
