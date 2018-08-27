package org.afeng.mall.service;

import org.afeng.mall.domain.Product;
import org.afeng.mall.utils.PageModel;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/26 15:48
 **/
public interface ProductService
{

    Product findProductByPid(String pid) throws Exception;


    List<Product> findHotProducts() throws Exception;

    List<Product> findNewProducts() throws Exception;

    PageModel<Product> findProductsWithCidAndPage(String cid, int currentPageNum) throws Exception;
}
