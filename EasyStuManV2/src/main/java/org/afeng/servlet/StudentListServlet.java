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
 * @date 2018/8/18 19:27
 **/
public class StudentListServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        StuService stuService=new StuServiceImpl();
        try
        {
            /**
             * 将list属性添加到会话中
             */
            List<Student> list=stuService.findAll();
            request.getSession().setAttribute("list",list);
            response.sendRedirect("stu_list.jsp");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}
