package org.afeng.mall.web.servlet;

import com.alibaba.fastjson.JSON;
import org.afeng.mall.domain.Category;
import org.afeng.mall.service.CategoryService;
import org.afeng.mall.service.impl.CategoryServiceImpl;
import org.afeng.mall.web.base.BaseServlet;

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

        List<Category> categoryList = categoryService.finaAllCategory();

        String jsonStr = JSON.toJSONString(categoryList);
/*
        request.setAttribute("categoryList",categoryList);
*/

        System.out.println(jsonStr);
        response.getWriter().print(jsonStr);
        return null;
    }

}
