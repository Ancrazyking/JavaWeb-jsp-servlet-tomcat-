package org.afeng.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author afeng
 * @date 2018/8/18 10:48
 **/
public class C3P0Demo
{
    @Test
    public void testC3P0() throws Exception
    {

        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库连接信息
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost/stu");
        dataSource.setUser("root");
        dataSource.setPassword("wangafeng");
        /**
         * 获得连接的对象
         */
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
        String sql = "SELECT * FROM tb_user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("username") + "\t" +
                    rs.getString("password"));
        }
        conn.close();
    }

    /**
     * 默认加载src/resources资源的c3p0-config.xml文件
     * @throws Exception
     */
    @Test
    public void testC3p0ByXML() throws Exception
    {
        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
        String sql = "SELECT * FROM tb_user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("username") + "\t" +
                    rs.getString("password"));
        }
        conn.close();
    }
}
