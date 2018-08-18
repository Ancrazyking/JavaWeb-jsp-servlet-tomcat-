package org.afeng.dao.datasource;

import org.afeng.utlis.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 9:10
 **/
public class MyDataSource implements DataSource
{
    /**
     * 设定数据连接池有10个连接
     *
     * @return
     * @throws SQLException
     */
    public List<Connection> list = new ArrayList<Connection>();

    public MyDataSource()
    {
        for (int i = 0; i < 10; i++)
        {
            Connection conn = JDBCUtils.getConnection();
            list.add(conn);
        }
    }

    @Override
    public Connection getConnection() throws SQLException
    {
        if (list.size() == 0)
        {
            for (int i = 0; i < 5; i++)
            {
                Connection conn = JDBCUtils.getConnection();
                list.add(conn);
            }
        }
        /**
         * 每次取出第一个建立的连接
         */
        Connection conn = list.remove(0);
        return conn;
    }
    /**
     * 用完后归还连接
     * @param conn
     */
    public void addBack(Connection conn)
    {
        list.add(conn);
    }




    @Override
    public Connection getConnection(String username, String password) throws SQLException
    {
        return null;
    }



    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException
    {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException
    {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException
    {

    }

    @Override
    public int getLoginTimeout() throws SQLException
    {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        return null;
    }
}
