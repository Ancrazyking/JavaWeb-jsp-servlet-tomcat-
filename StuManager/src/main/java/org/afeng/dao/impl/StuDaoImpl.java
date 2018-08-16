package org.afeng.dao.impl;

import org.afeng.dao.StuDao;
import org.afeng.domain.Student;
import org.afeng.utlis.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/15 21:10
 **/
public class StuDaoImpl implements StuDao
{
    @Override
    public List<Student> findAll()
    {
        List<Student> stuList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            //获取连接
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM tb_student";
            //准备语句
            ps = conn.prepareStatement(sql);
            //执行sql语句获取结果集
            rs = ps.executeQuery();

            while (rs.next())
            {
                Student student = new Student();

                student.setId(rs.getInt("stuid"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAddress(rs.getString("address"));

                stuList.add(student);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.release(conn, ps, rs);
        }
        return stuList;

    }
}
