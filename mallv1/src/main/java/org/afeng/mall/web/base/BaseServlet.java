package org.afeng.mall.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author afeng
 * @date 2018/8/24 9:41
 **/
public class BaseServlet extends HttpServlet
{


    /**
     * BaseServlet继承了HttpServlet,重写service方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String method = request.getParameter("method");

        if (null == method || "".equals(method) || method.trim().equals(""))
        {
            method = "execute";
        }

        /**
         * 此处的this代表的是子类的对象
         * 子类或通过执行请求时会通过service()方法进行处理
         */
        Class clazz = this.getClass();

        try
        {
            Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if (md != null)
            {
                String jspPath = (String) md.invoke(this, request, response);
                if (jspPath != null)
                {
                    request.getRequestDispatcher(jspPath).forward(request, response);
                }

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return null;
    }

}
