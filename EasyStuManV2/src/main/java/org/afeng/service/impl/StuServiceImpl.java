package org.afeng.service.impl;

import org.afeng.bean.Student;
import org.afeng.dao.StuDao;
import org.afeng.dao.impl.StuDaoImpl;
import org.afeng.service.StuService;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 19:22
 **/
public class StuServiceImpl implements StuService
{

    StuDao stuDao = new StuDaoImpl();
    @Override
    public List<Student> findAll() throws Exception
    {
        return stuDao.findAll();
    }

    @Override
    public List<Student> findStudent(String stuName, String gender) throws Exception
    {
        return stuDao.findStudent(stuName,gender);
    }

    @Override
    public Student findStudentById(int stuId) throws Exception
    {
        return stuDao.findStudentById(stuId);
    }

    @Override
    public void insert(Student student) throws Exception
    {
        stuDao.insert(student);
    }

    @Override
    public void delete(int stuId) throws Exception
    {
        stuDao.delete(stuId);
    }

    @Override
    public void update(Student student) throws Exception
    {
        stuDao.update(student);
    }
}
