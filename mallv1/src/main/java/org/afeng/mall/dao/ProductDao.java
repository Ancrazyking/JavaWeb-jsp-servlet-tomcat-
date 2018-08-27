package org.afeng.mall.dao;

import org.afeng.mall.domain.Product;
import org.afeng.mall.utils.PageModel;

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

    List<Product> findProductsByCid(String cid,int startIndex,int pageSize)throws Exception;

    int findTotalRecords(String cid)throws Exception;

}
