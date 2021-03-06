package org.afeng.servlet;

import org.afeng.dao.StuDao;
import org.afeng.dao.UserDao;
import org.afeng.dao.impl.StuDaoImpl;
import org.afeng.dao.impl.UserDaoImpl;
import org.afeng.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * @author afeng
 * @date 2018/8/15 21:16
 **/
public class LoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //post提交有可能有中文,需要处理乱码
        request.setCharacterEncoding("utf-8");
        //打印输出流需要有中文,需要处理乱码
        response.setContentType("text/html;charset=utf-8");

        /**
         * 获取表单中的信息
         */
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        /**
         * dao层判断登录
         */
        UserDao userDao = new UserDaoImpl();
        boolean result = userDao.login(userName, password);
        if (result)
        {
            StuDao stuDao=new StuDaoImpl();
            List<Student> list=stuDao.findAll();

            //把集合存储到作用域中  session存储
            request.getSession().setAttribute("list",list);

            response.sendRedirect("stu_list.jsp");
        } else
        {
            response.getWriter().write("登录失败!");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
