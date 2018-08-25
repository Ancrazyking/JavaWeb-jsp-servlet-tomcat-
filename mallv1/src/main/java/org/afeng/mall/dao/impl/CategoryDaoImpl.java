package org.afeng.mall.dao.impl;

import org.afeng.mall.dao.CategoryDao;
import org.afeng.mall.domain.Category;
import org.afeng.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/25 20:02
 **/
public class CategoryDaoImpl implements CategoryDao
{

    QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAllCategory() throws Exception
    {
        String sql="select * from category";
        return queryRunner.query(sql,new BeanListHandler<>(Category.class));
    }
}
