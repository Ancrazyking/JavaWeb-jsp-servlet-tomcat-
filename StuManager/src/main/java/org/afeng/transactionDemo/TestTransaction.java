package org.afeng.transactionDemo;

import org.afeng.utlis.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/17 8:28
 **/
public class TestTransaction
{

    @Test
    public void testTransaction()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            conn = JDBCUtils.getConnection();
            System.out.println(conn);
            String sql1 = "UPDATE account SET money =money -? WHERE id=?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "100");
            ps.setString(2, "1");
            ps.executeUpdate();


            String a = null;
            a.length();
            String sql2 = "UPDATE account SET money=money+? WHERE id=?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, "100");
            ps.setString(2, "2");
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.release(conn, ps, rs);
        }
    }


    /**
     * 开启事务提交
     */
    @Test
    public void test2Transaction()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            System.out.println(conn);
            String sql1 = "UPDATE account SET money =money -? WHERE id=?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "100");
            ps.setString(2, "1");
            ps.executeUpdate();

            String a = null;
            a.length();
            String sql2 = "UPDATE account SET money=money+? WHERE id=?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, "100");
            ps.setString(2, "2");
            ps.executeUpdate();
            /**
             * 如果不出异常
             * commit()提交
             */
            conn.commit();
        } catch (Exception e)
        {
            try
            {
                /**
                 * 只要有一个操作出现异常
                 * 就会回滚
                 */
                conn.rollback();
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally
        {
            JDBCUtils.release(conn, ps, rs);
        }


    }

}
