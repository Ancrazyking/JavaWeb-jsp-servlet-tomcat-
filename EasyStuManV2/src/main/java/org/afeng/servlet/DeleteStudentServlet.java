package org.afeng.servlet;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/19 13:11
 **/
public class DeleteStudentServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


        StuService stuService = new StuServiceImpl();
        try
        {
            int stuId = Integer.parseInt(request.getParameter("stuId"));
            stuService.delete(stuId);
            request.getRequestDispatcher("stu_list").forward(request,response);
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
