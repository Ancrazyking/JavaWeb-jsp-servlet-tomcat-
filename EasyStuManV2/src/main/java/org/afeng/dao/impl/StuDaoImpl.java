package org.afeng.dao.impl;

import org.afeng.bean.Student;
import org.afeng.dao.StuDao;
import org.afeng.utils.JDBCUtils;
import org.afeng.utils.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 16:50
 **/
public class StuDaoImpl implements StuDao
{
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Student> findStudentByPage(int currentPage) throws Exception
    {
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception
    {
        return queryRunner.query("select * from student", new BeanListHandler<Student>(Student.class));
    }

    @Override
    public Student findStudentById(int stuId) throws Exception
    {
        return queryRunner.query("select * from student where stuid=?", new BeanHandler<>(Student.class), stuId);
    }

    /**
     * 模糊查询来做
     *
     * @param stuName
     * @param gender
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudent(String stuName, String gender) throws Exception
    {
        /**
         * 必须要加and
         */
        String sql = "select * from student where 1=1";

        List<String> list = new ArrayList<>();

        /**
         * 三种情况    名字为空,性别不为空
         *            名字不为空,性别为空
         *            名字性别都为空
         */
        //姓名模糊查询
        if (!TextUtils.isEmpty(stuName))
        {
            sql = sql + " and stuname like ?";
            list.add("%" + stuName + "%");
        }

        if (!TextUtils.isEmpty(gender))
        {
            sql = sql + " and gender=? ";
            list.add(gender);

        }

        return queryRunner.query(sql, new BeanListHandler<>(Student.class), list.toArray());
    }


    @Override
    public void insert(Student student) throws Exception
    {
        queryRunner.update("insert into student value(?,?,?,?,?,?,?)", student.getStuId(),
                student.getStuName(), student.getGender(), student.getHobby(), student.getInfo(), student.getBirthday());
    }

    @Override
    public void delete(int id) throws Exception
    {
        queryRunner.update("delete from student where id=?", id);
    }

    @Override
    public void update(Student student) throws Exception
    {
        queryRunner.update("update student  set stuname=? and gender=? and hobby=? and info=? and birthday=?  where stuid=? ",
                student.getStuName(), student.getGender(), student.getHobby(), student.getInfo(), student.getBirthday(), student.getStuId());
    }

    @Override
    public int totalRecord() throws Exception
    {
        /**
         * 获取总的记录数
         */
        Integer result=(Integer) queryRunner.query("select count(*) from student",new ScalarHandler());
        return result.intValue();
    }
}
