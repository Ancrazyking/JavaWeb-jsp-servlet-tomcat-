package org.afeng.dao.impl;

import org.afeng.bean.Student;
import org.afeng.dao.StuDao;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 16:50
 **/
public class StuDaoImpl implements StuDao
{
    @Override
    public List<Student> findStudentByPage(int currentPage) throws Exception
    {
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception
    {
        return null;
    }

    @Override
    public Student findStudentById(int stuId) throws Exception
    {
        return null;
    }

    @Override
    public List<Student> findStudent(String stuName, String gender) throws Exception
    {
        return null;
    }

    @Override
    public void insert(Student student) throws Exception
    {

    }

    @Override
    public void delete(int id) throws Exception
    {

    }

    @Override
    public void update(Student student) throws Exception
    {

    }

    @Override
    public int totalRecord() throws Exception
    {
        return 0;
    }
}
