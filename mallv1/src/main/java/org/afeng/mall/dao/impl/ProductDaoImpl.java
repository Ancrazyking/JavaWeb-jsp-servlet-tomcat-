package org.afeng.mall.dao.impl;

import org.afeng.mall.dao.ProductDao;
import org.afeng.mall.domain.Product;
import org.afeng.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/26 15:51
 **/
public class ProductDaoImpl implements ProductDao
{

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public Product findProductByPid(String pid) throws Exception
    {
        Product product = queryRunner.query("select * from product where pid= ?", new BeanHandler<>(Product.class), pid);
        System.out.println(product);
        System.out.println(pid);
        return product;
    }


    @Override
    public List<Product> findHotProducts() throws Exception
    {

        String sql = "select * from product where pflag=0 and is_hot=1 order by pdate desc limit 0,9";


        return queryRunner.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findNewProducts() throws Exception
    {
        String sql = "select * from product where pflag=0 order by pdate desc limit 0,9";
        return queryRunner.query(sql, new BeanListHandler<>(Product.class));
    }
}
