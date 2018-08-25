package org.afeng.mall.service.impl;

import org.afeng.mall.dao.CategoryDao;
import org.afeng.mall.dao.impl.CategoryDaoImpl;
import org.afeng.mall.domain.Category;
import org.afeng.mall.service.CategoryService;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/25 20:01
 **/
public class CategoryServiceImpl implements CategoryService
{

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> finaAllCategory() throws Exception
    {
        return categoryDao.findAllCategory();
    }
}
