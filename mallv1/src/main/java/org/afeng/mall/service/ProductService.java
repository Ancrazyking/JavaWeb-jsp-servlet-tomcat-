package org.afeng.mall.service;

import org.afeng.mall.domain.Product;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/26 15:48
 **/
public interface ProductService
{

    Product findProductByPid(String pid) throws Exception;


    List<Product> findHotProducts() throws Exception;

    List<Product> findNewProducts()throws Exception;
}
