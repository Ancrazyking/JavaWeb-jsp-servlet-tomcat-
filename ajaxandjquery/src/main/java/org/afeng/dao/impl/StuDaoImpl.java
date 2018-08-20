package org.afeng.dao.impl;

import org.afeng.dao.StuDao;
import org.afeng.domain.Student;
import org.afeng.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
/**
 * @author afeng
 * @date 2018/8/20 14:09
 **/
public class StuDaoImpl implements StuDao
{

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());


    @Override
    public boolean checkUserName(String userName)
    {
        try
        {
            List<Student> stuList=queryRunner.query("select * from student where stuname=?",new BeanListHandler<>(Student.class),userName);
            System.out.println(stuList.size());
            if(stuList.size()>0){
                return  false;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  true;
    }


}
