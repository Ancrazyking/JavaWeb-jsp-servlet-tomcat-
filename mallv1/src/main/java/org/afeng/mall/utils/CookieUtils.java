package org.afeng.mall.utils;

import javax.servlet.http.Cookie;

/**获取对应名的Cookie
 * @author afeng
 * @date 2018/8/24 8:14
 **/
public class CookieUtils
{

    /**
     * 遍历Cookie数组找到与Cookie名字对应的Cookie
     * @param cookies   Cookie数组
     * @param name      Cookie的名字
     * @return
     */
    public static Cookie getCookies(Cookie[] cookies, String name)
    {
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (name.equals(cookie.getName()))
                {
                    return cookie;
                }
            }
        }
        return null;
    }
}
