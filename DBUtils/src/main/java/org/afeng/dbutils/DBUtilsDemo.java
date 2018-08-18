package org.afeng.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.afeng.bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/18 14:50
 **/
public class DBUtilsDemo
{
    @Test
    public void testDBUtils() throws SQLException
    {
        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

        /**
         * 插入一条记录
         */
        queryRunner.update("insert into tb_user values('3',?,?)", "root", "root");
        /**
         * 删除一条记录
         */
        queryRunner.update("delete from tb_user where id=?", "2115110216");

        /**
         * 修改一条记录
         */
        queryRunner.update("update  tb_user set password=? where id=?", "wangafeng", "3");

    }

    @Test
    public void testDBUtilsQuery() throws Exception
    {

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        final List<Student> stuList=new ArrayList<>();
        /**
         * 结果集处理器
         */
        queryRunner.query("select * from tb_student", new ResultSetHandler<Student>()
        {
            @Override
            public Student handle(ResultSet rs) throws SQLException
            {
                Student student = new Student();
                while (rs.next())
                {
                    student.setId(rs.getInt("stuid"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setGender(rs.getString("gender"));
                    student.setAddress(rs.getString("address"));
                    stuList.add(student);
                }
                return null;
            }
        });
        System.out.println(stuList);
    }
}
