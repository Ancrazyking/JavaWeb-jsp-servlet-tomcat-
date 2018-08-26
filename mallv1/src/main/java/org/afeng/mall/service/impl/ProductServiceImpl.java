package org.afeng.mall.service.impl;

import org.afeng.mall.dao.ProductDao;
import org.afeng.mall.dao.impl.ProductDaoImpl;
import org.afeng.mall.domain.Product;
import org.afeng.mall.service.ProductService;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/26 15:50
 **/
public class ProductServiceImpl implements ProductService
{

    ProductDao productDao = new ProductDaoImpl();

    @Override
    public Product findProductByPid(String pid) throws Exception
    {
        return productDao.findProductByPid(pid);
    }

    @Override
    public List<Product> findHotProducts() throws Exception
    {
        return productDao.findHotProducts();
    }

    @Override
    public List<Product> findNewProducts() throws Exception
    {
        return productDao.findNewProducts();
    }
}
