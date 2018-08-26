package org.afeng.mall.web.servlet;

import com.alibaba.fastjson.JSON;
import org.afeng.mall.domain.Category;
import org.afeng.mall.service.CategoryService;
import org.afeng.mall.service.impl.CategoryServiceImpl;
import org.afeng.mall.utils.JedisUtils;
import org.afeng.mall.web.base.BaseServlet;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/25 21:19
 **/
public class CategoryServlet extends BaseServlet
{

    CategoryService categoryService = new CategoryServiceImpl();

    public String findAllCategory(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");

        Jedis jedis = JedisUtils.getJedis();
        String jsonStr = jedis.get("allCategory");
        if (jsonStr == null || "".equals(jsonStr))
        {
            List<Category> categoryList = categoryService.finaAllCategory();
            jsonStr = JSON.toJSONString(categoryList);
            /**
             * 将商品的分类缓存到redis中
             */
            jedis.set("allCategory", jsonStr);
        } else
        {
            System.out.println("Redis中的缓存为:" + jsonStr);
        }

        System.out.println(jsonStr);
        response.getWriter().print(jsonStr);
        return null;
    }

}
