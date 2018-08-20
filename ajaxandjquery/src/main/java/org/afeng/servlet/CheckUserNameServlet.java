package org.afeng.servlet;

import org.afeng.service.StuService;
import org.afeng.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/20 14:15
 **/
public class CheckUserNameServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        System.out.println("userName="+userName);
        response.setContentType("text/html;charset=utf-8");
        StuService stuService = new StuServiceImpl();
        boolean result = stuService.checkUsername(userName);
        System.out.println(result);
        if (result)
        {
            //如果result为true,设置响应值为2,表示可以使用
            response.getWriter().println(2);
        }
        else
        {
            //如果result为false,设置响应值为1,表示不可以使用
            response.getWriter().println(1);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("收到一个Post请求....");
        doGet(request, response);
    }
}
