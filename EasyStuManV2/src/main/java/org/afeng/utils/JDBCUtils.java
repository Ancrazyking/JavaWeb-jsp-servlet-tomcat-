package org.afeng.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author afeng
 * @date 2018/8/18 19:11
 **/
public class JDBCUtils
{
    /**
     * 采用C3p0连接池
     */
    static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource()
    {
        return dataSource;
    }

    /**
     * 获取连接对象
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception
    {
        return dataSource.getConnection();
    }





    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs)
    {
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Connection conn, Statement st)
    {
        closeSt(st);
        closeConn(conn);
    }

    private static void closeConn(Connection conn)
    {
        try
        {
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void closeRs(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void closeSt(Statement st)
    {
        try
        {
            if (st != null)
            {
                st.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }


    
    }
    
    
    

/*    public static void main(String[] args) throws Exception
    {
        System.out.println(JDBCUtils.getConnection());
    }*/


}
