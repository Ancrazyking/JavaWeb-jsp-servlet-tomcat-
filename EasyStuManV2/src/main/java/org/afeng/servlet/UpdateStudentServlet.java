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
 * @date 2018/8/19 11:23
 **/
public class UpdateStudentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");

        try
        {
            /**
             * 从页面获取对应的参数
             */
            int stuId = Integer.parseInt(request.getParameter("stuId"));
            String name = request.getParameter("stuName");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String info = request.getParameter("info");
            /**
             * hobby是可以多选的
             */
            String hobby[] = request.getParameterValues("hobby");
            /**
             * 将字符串数组转化为一个字符串
             */
            String hobbies = Arrays.toString(hobby);

            /**
             * 格式化日期字符串
             */
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);

            Student student = new Student(stuId, name, gender, phone, hobbies, info, date);


            /**
             * 调用服务层保存到数据库
             */
            StuService stuService = new StuServiceImpl();
            stuService.update(student);

            /**
             * 重新到stu_list处理请求
             */
            request.getRequestDispatcher("stu_list").forward(request, response);
            //response.sendRedirect("stu_list");
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
