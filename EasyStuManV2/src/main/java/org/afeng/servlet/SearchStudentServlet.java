package org.afeng.servlet;

import org.afeng.bean.Student;
import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * @author afeng
 * @date 2018/8/18 20:05
 **/
public class SearchStudentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        request.setCharacterEncoding("utf-8");
        StuService stuService=new StuServiceImpl();
        String stuName=request.getParameter("stuName");
        String stuGender=request.getParameter("stuGender");
        try
        {
            List<Student> list=stuService.findStudent(stuName,stuGender);
            request.getSession().setAttribute("list",list);
            /**
             * 内部请求请求转发
             */
            request.getRequestDispatcher("stu_list.jsp").forward(request,response);

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
