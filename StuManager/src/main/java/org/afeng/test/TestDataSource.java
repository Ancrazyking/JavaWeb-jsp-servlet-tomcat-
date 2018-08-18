package org.afeng.test;


import org.afeng.dao.datasource.MyDataSource;

import java.sql.Connection;

/**
 * @author afeng
 * @date 2018/8/18 10:27
 **/
public class TestDataSource
{
    public static void main(String[] args) throws Exception
    {
        MyDataSource dataSource=new MyDataSource();
        Connection conn=dataSource.getConnection();
        System.out.println(dataSource.list.size());
        dataSource.addBack(conn);
        System.out.println(dataSource.list.size());
    }

}
