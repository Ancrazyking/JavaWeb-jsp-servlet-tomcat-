package org.afeng.mall.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author afeng
 * @date 2018/8/24 10:04
 **/
public class EncodingFilter implements Filter
{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(new MyRequest(request), response);

    }

    @Override
    public void destroy()
    {

    }
}

/**
 * 增强request的方法
 * reques获取参数的方法
 */
class MyRequest extends HttpServletRequestWrapper
{

    private HttpServletRequest request;
    private boolean flag = true;

    public MyRequest(HttpServletRequest request)
    {
        super(request);
        this.request = request;
    }

    /**
     * 用于获取用户传入的请求参数
     * 不确定是一个还是多个请求参数
     *
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name)
    {
        if (name == null || name.trim().length() == 0)
        {
            return null;
        }
        String[] values = getParameterValues(name);
        if (values == null || values.length == 0)
        {
            return null;
        }
        return values[0];
    }

    @Override
    /**
     * map{ username=[tom],password=[123],hobby=[eat,drink]}
     */
    public Map<String, String[]> getParameterMap()
    {

        /**
         * 首先判断请求方式
         * 若为post  request.setchar...(utf-8)
         * 若为get 将map中的值遍历编码就可以了
         */
        String method = request.getMethod();
        if ("post".equalsIgnoreCase(method))
        {
            try
            {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("get".equalsIgnoreCase(method))
        {
            Map<String, String[]> map = request.getParameterMap();
            if (flag)
            {
                for (String key : map.keySet())
                {
                    String[] arr = map.get(key);
                    //继续遍历数组
                    for (int i = 0; i < arr.length; i++)
                    {
                        //编码
                        try
                        {
                            arr[i] = new String(arr[i].getBytes("iso-8859-1"), "utf-8");
                        } catch (UnsupportedEncodingException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                flag = false;
            }
            //需要遍历map 修改value的每一个数据的编码

            return map;
        }

        return super.getParameterMap();
    }


    @Override
    public String[] getParameterValues(String name)
    {
        if (name == null || name.trim().length() == 0)
        {
            return null;
        }
        Map<String, String[]> map = getParameterMap();
        if (map == null || map.size() == 0)
        {
            return null;
        }
        return map.get(name);
    }
}
