package org.afeng.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.afeng.dao.HeroDao;
import org.afeng.dao.impl.HeroDaoImpl;
import org.afeng.domain.HeroBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/20 20:58
 **/
public class ShowHeroServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            int campId = Integer.parseInt(request.getParameter("campId"));
            HeroDao heroDao = new HeroDaoImpl();
            List<HeroBean> list = heroDao.findHero(campId);

            String jsonStr = JSON.toJSONString(list);
            //将list集合变为json数据

            System.out.println(jsonStr);

            /**
             * 服务器响应json格式数据
             */
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonStr);

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
