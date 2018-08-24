package org.afeng.mall.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author afeng
 * @date 2018/8/24 8:31
 **/
public class JDBCUtils
{
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /**
     * 从线程中获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception
    {
        Connection conn = threadLocal.get();
        if (conn == null)
        {
            conn = dataSource.getConnection();
            threadLocal.set(conn);
        }
        return conn;
    }


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
     * 释放connection 连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn)
    {
        if (conn != null)
        {
            try
            {
                conn.close();
                threadLocal.remove();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        conn = null;
    }


    /**
     * 释放结果集
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
            rs = null;
        }
    }

    /**
     * 释放Statement
     *
     * @param st
     */
    public static void closeStatement(Statement st)
    {
        if (st != null)
        {
            try
            {
                st.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            st = null;
        }
    }

    /**
     * 释放资源
     *
     * @param st
     * @param rs
     */
    public static void closeResource(Statement st, ResultSet rs)
    {
        closeResultSet(rs);
        closeStatement(st);
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs)
    {
        closeResource(st, rs);
        closeConnection(conn);
    }


    /**
     * 开启事务,设置自动提交事务为false
     *
     * @throws Exception
     */
    public static void startTranscation() throws Exception
    {
        getConnection().setAutoCommit(false);
    }


    /**
     * 事务提交且释放连接
     */
    public static void commitAndCloseConnection()
    {
        Connection conn = null;
        try
        {
            conn = getConnection();
            conn.commit();
            conn.commit();
            threadLocal.remove();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    /**
     * 事务回滚且是释放资源
     */
    public static void rollbackAndCloseConnection()
    {
        Connection conn = null;
        try
        {
            conn = getConnection();
            conn.rollback();
            conn.close();
            threadLocal.remove();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
        try
        {
            System.out.println(getConnection());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
