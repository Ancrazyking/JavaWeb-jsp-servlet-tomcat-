package org.afeng.dao;

import org.afeng.domain.Student;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/15 21:05
 **/
public interface StuDao
{

    /**
     * 查找所有学生信息
     * @return  List集合
     */
    List<Student> findAll();

}
