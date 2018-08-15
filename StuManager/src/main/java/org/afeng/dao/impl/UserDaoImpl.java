package org.afeng.dao.impl;

import jdk.nashorn.internal.scripts.JD;
import org.afeng.dao.UserDao;
import org.afeng.utlis.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author afeng
 * @date 2018/8/15 21:11
 **/
public class UserDaoImpl implements UserDao
{

    @Override
    public boolean login(String userName, String password)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            //获取连接对象
            conn = JDBCUtils.getConnection();


            String sql = "SELECT * FROM tb_user WHERE username=? AND password=?";

            //创建ps对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);

            //执行sql语句
            rs = ps.executeQuery();

            //如果能成功找到记录,则表明有这个用户
            return rs.next();

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            /**
             * 释放所有资源
             */
            JDBCUtils.release(conn, ps, rs);
        }
        return false;
    }
}
