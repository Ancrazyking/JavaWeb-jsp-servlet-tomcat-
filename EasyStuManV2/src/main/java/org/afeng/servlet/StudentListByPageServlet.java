package org.afeng.servlet;

import org.afeng.bean.PageBean;
import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/19 19:53
 **/
public class StudentListByPageServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取需要显示的页码数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        //根据指定的页数,获取数据
        StuService stuService = new StuServiceImpl();
        try
        {
            PageBean pageBean = stuService.findStudentByPage(currentPage);
            request.setAttribute("pageBean", pageBean);

            //跳转界面
            request.getRequestDispatcher("stu_list_page.jsp").forward(request,response);

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
