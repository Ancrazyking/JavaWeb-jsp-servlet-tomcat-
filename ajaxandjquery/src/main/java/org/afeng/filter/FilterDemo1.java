package org.afeng.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/8/21 11:26
 **/
public class FilterDemo1 implements Filter
{
    /**
     * 服务器启动时创建
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("过滤器初始化.....");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("Filter01进行拦截 before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter01进行拦截 after");
    }
    /**
     * 服务器停止时销毁
     */
    @Override
    public void destroy()
    {
        System.out.println("过滤器销毁....");
    }
}
