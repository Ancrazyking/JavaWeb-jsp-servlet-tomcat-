package org.afeng.filter;

import org.afeng.domain.User;
import org.afeng.service.UserService;
import org.afeng.service.impl.UserServiceImpl;
import org.afeng.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/21 21:34
 **/
public class AutoLoginFilter implements Filter
{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        //首先判断会话session中还有没有那个user属性
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User haveUser = (User) request.getSession().getAttribute("user");
        /**
         * 如果属性不是空,则放行
         */
        if (haveUser != null)
        {
            filterChain.doFilter(request, servletResponse);
        } else
        {
            /**
             * session失效了
             * 从request中获取所有的Cookie
             */
            Cookie[] cookies = request.getCookies();
            //找到指定的Cookie
            Cookie cookie = CookieUtils.getCookie(cookies, "auto_login");

            /**
             * 当用户第一次请求,
             * 放行
             */
            if (cookie == null)
            {
                filterChain.doFilter(request, servletResponse);
            } else
            {
                //不是第一次来,通过Cookie获取用户名和密码
                String value = cookie.getValue();
                String username = value.split("#")[0];
                String password = value.split("#")[1];

                User loginUser = new User();
                loginUser.setUsername(username);
                loginUser.setPassword(password);

                UserService userService = new UserServiceImpl();
                try
                {
                    User user = userService.login(loginUser);
                    request.getSession().setAttribute("user", user);

                    filterChain.doFilter(request, servletResponse);
                } catch (Exception e)
                {
                    e.printStackTrace();
                    /**
                     * 出异常的话,也需要放行,不能让用户看到空白的画面
                     */
                    filterChain.doFilter(request,servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy()
    {

    }
}
