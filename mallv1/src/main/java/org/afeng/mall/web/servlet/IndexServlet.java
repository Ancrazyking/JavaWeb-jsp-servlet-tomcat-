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
 * @date 2018/8/25 15:52
 **/
public class IndexServlet extends BaseServlet
{

    // CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "/jsp/index.jsp";
    }

}
