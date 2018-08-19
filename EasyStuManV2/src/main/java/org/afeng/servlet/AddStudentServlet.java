package org.afeng.servlet;

import org.afeng.bean.Student;
import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/8/19 15:16
 **/
public class AddStudentServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        request.setCharacterEncoding("utf-8");
        String stuName = request.getParameter("stuName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String hobby[] = request.getParameterValues("hobby");
        String hobbies = Arrays.toString(hobby);
        String info = request.getParameter("info");

        try
        {
            StuService stuService = new StuServiceImpl();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            Student student = new Student(0, stuName, gender, phone, hobbies, info, date);
            stuService.insert(student);
            /**
             * 添加完后数据库重查
             */
            request.getRequestDispatcher("stu_list").forward(request, response);

        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
