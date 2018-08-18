package org.afeng.dao;

import org.afeng.bean.Student;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 16:48
 **/
public interface StuDao
{
    int PAGE_SIZE = 5;


    /**
     * 查询当页的学生数据
     *
     * @param currentPage
     * @return
     * @throws Exception
     */
    List<Student> findStudentByPage(int currentPage) throws Exception;

    /**
     * 查询所有学生
     *
     * @return
     * @throws Exception
     */
    List<Student> findAll() throws Exception;


    /**
     * 根据id查询单个学生信息
     *
     * @param stuId
     * @return
     * @throws Exception
     */
    Student findStudentById(int stuId) throws Exception;

    /**
     * 根据学生姓名 性别 或者姓名和性别
     * 查询符合条件的学生的信息
     *
     * @param stuName
     * @param gender
     * @return
     * @throws Exception
     */
    List<Student> findStudent(String stuName, String gender) throws Exception;

    /**
     * 添加学生信息
     *
     * @param student
     * @throws Exception
     */
    void insert(Student student) throws Exception;

    /**
     * 根据id删除学生
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     * 更新学生信息
     *
     * @param student
     * @throws Exception
     */
    void update(Student student) throws Exception;

    /**
     * 查询总的学生记录数
     *
     * @return
     * @throws Exception
     */
    int totalRecord() throws Exception;

}
