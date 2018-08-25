package org.afeng.mall.service;

import org.afeng.mall.domain.Category;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/25 19:57
 **/
public interface CategoryService
{
    List<Category> finaAllCategory() throws Exception;

}
