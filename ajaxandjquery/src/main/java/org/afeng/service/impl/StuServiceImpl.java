package org.afeng.service.impl;

import org.afeng.dao.StuDao;
import org.afeng.dao.impl.StuDaoImpl;
import org.afeng.service.StuService;

/**
 * @author afeng
 * @date 2018/8/20 14:14
 **/
public class StuServiceImpl implements StuService
{
    StuDao stuDao = new StuDaoImpl();

    @Override
    public boolean checkUsername(String userName)
    {
        return stuDao.checkUserName(userName);
    }
}
