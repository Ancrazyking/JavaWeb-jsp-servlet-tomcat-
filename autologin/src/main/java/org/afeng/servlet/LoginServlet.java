package org.afeng.servlet;

import org.afeng.domain.User;
import org.afeng.service.UserService;
import org.afeng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/21 16:51
 **/
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String autoLogin = request.getParameter("auto_login");
        System.out.println(userName + "\t" + passWord + "\t" + autoLogin);
        try
        {
            User loginUser = new User();
            loginUser.setUsername(userName);
            loginUser.setPassword(passWord);
            UserService userService = new UserServiceImpl();
            User user = userService.login(loginUser);

            if (user == null)
            {
               // response.getWriter().write("登录失败,请重新登录!");
                request.getRequestDispatcher("login.html").forward(request, response);
            } else
            {
                //如果用户选择了自动登录的按钮,即自动登录
                if("on".equals(autoLogin)){

                    Cookie cookie=new Cookie("auto_login",userName+"#"+passWord);
                    cookie.setMaxAge(60*60);
                    cookie.setPath(request.getContextPath());
                    //添加Cookie
                    response.addCookie(cookie);
                }

                request.getSession().setAttribute("user",user);
                response.sendRedirect("index.jsp");
            }

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
