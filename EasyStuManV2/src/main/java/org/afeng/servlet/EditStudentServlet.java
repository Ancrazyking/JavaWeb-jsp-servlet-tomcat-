package org.afeng.servlet;

import org.afeng.bean.Student;
import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/19 10:59
 **/
public class EditStudentServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            /**
             * 获取传入的参数stuId
             */
            int stuId = Integer.parseInt(request.getParameter("stuId"));

            StuService stuService = new StuServiceImpl();
            Student stu = stuService.findStudentById(stuId);

            /**
             * 设置stu属性
             */
            request.setAttribute("stu",stu);

            /**
             * 内部请求转发
             */
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}
