package org.afeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/20 9:30
 **/
public class GetServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("收到一个Get请求!");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + "\t" + age);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("name=" + name + ";age=" + age);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("收到一个POST请求");
        doGet(request, response);
    }


}
