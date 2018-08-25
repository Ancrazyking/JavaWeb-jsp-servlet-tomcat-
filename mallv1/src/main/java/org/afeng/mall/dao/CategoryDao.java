package org.afeng.mall.dao;

import org.afeng.mall.domain.Category;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/25 19:59
 **/
public interface CategoryDao
{
    List<Category> findAllCategory() throws Exception;
}
