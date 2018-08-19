package org.afeng.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/8/18 16:30
 **/
public class Student implements Serializable
{
    private int stuId;
    private String stuName;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;


    public Student()
    {

    }

    public Student(int stuId, String stuName, String gender, String phone, String hobby, String info, Date birthday)
    {
        this.stuId = stuId;
        this.stuName = stuName;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", hobby='" + hobby + '\'' +
                ", info='" + info + '\'' +
                ", birthday=" + birthday +
                '}';
    }


    public int getStuId()
    {
        return stuId;
    }

    public void setStuId(int stuId)
    {
        this.stuId = stuId;
    }

    public String getStuName()
    {
        return stuName;
    }

    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

}
