package org.afeng.mall.web.servlet;


import org.afeng.mall.domain.Product;
import org.afeng.mall.service.ProductService;

import org.afeng.mall.service.impl.ProductServiceImpl;
import org.afeng.mall.web.base.BaseServlet;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author afeng
 * @date 2018/8/25 15:52
 **/
public class IndexServlet extends BaseServlet
{

    // CategoryService categoryService = new CategoryServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        List<Product> hotProducts = productService.findHotProducts();
        List<Product> newProducts = productService.findNewProducts();

        request.setAttribute("hotProducts", hotProducts);
        request.setAttribute("newProducts", newProducts);

        return "/jsp/index.jsp";
    }

}
