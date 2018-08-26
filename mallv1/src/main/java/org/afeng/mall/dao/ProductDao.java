package org.afeng.mall.dao;

import org.afeng.mall.domain.Product;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/26 15:50
 **/
public interface ProductDao
{
    Product findProductByPid(String pid) throws Exception;


    List<Product> findHotProducts()throws Exception;

    List<Product> findNewProducts()throws Exception;
}
