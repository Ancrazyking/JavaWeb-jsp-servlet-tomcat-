package org.afeng.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/21 13:46
 **/
public class FilterDemo3 implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("Filter03进行拦截 before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter03进行拦截 after");
    }

    @Override
    public void destroy()
    {

    }
}
