package org.afeng.service;

import org.afeng.bean.Student;
import java.util.List;
/**
 * @author afeng
 * @date 2018/8/18 19:21
 **/
public interface StuService
{
    /**
     * 查找所有学生
     * @return
     * @throws Exception
     */
    List<Student> findAll() throws Exception;

    /**
     * 按照姓名和性别查找学生信息
     * @param stuName
     * @param gender
     * @return
     * @throws Exception
     */
    List<Student> findStudent(String stuName,String gender )throws Exception;

    /**
     * 通过id查找学生信息
     * @param stuId
     * @return
     * @throws Exception
     */
    Student findStudentById(int stuId) throws Exception;

    /**
     * 插入增加学生信息
     * @param student
     * @throws Exception
     */
    void insert(Student student) throws Exception;

    /**
     * 删除学生信息
     * @param stuId
     * @throws Exception
     */
    void delete(int stuId) throws Exception;

    /**
     * 更新学生信息
     * @param student
     * @throws Exception
     */
    void update(Student student)throws Exception;

}
