package org.afeng.utils;

import javax.servlet.http.Cookie;

/**
 * @author afeng
 * @date 2018/8/21 21:06
 **/
public class CookieUtils
{
    public static Cookie getCookie(Cookie[] cookies, String name)
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
