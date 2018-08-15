package org.afeng.utlis;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author afeng
 * @date 2018/8/15 20:42
 **/
public class JDBCUtils
{
    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    /**
     * 从属性中读取数据库信息,静态代码块
     * 类加载时执行
     */
    static
    {
        try
        {
            //创建一个属性配置对象
            Properties properties = new Properties();
            //创建文件的读入流
            /*InputStream is = new FileInputStream("./src/main/resources/jdbc.properties");*/

          /*  InputStream is = new FileInputStream("target/StuManager/WEB-INF/classes/jdbc.properties");*/
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");


            //加载
            properties.load(is);

            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection()
    {
        Connection conn = null;

        try
        {
            //加载数据库驱动
            Class.forName(driverClass);
            //获取连接
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn)
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

    /**
     * 关闭Statement声明
     *
     * @param st
     */
    public static void closeStatement(Statement st)
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

    /**
     * 关闭结果集
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs)
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

    /**
     * 释放资源
     * @param conn      数据库连接
     * @param st        声明的语句
     * @param rs        结果集
     */
    public static void release(Connection conn,Statement st,ResultSet rs){
        closeConnection(conn);
        closeResultSet(rs);
        closeStatement(st);
    }

    /**
     * 释放资源
     * @param conn   数据库连接
     * @param st     声明的语句
     */
    public static void release(Connection conn,Statement st){
        closeConnection(conn);
        closeStatement(st);
    }

}
