package org.afeng.mall.web.servlet;

import org.afeng.mall.domain.Product;
import org.afeng.mall.service.ProductService;
import org.afeng.mall.service.impl.ProductServiceImpl;
import org.afeng.mall.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author afeng
 * @date 2018/8/26 13:41
 **/
public class ProductServlet extends BaseServlet
{
    ProductService productService = new ProductServiceImpl();

    public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String pid = request.getParameter("pid");
        Product product = productService.findProductByPid(pid);
        request.setAttribute("pro", product);
        return "/jsp/product_info.jsp";
    }

}
