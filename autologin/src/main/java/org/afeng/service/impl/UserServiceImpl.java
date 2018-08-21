package org.afeng.service.impl;

import org.afeng.dao.UserDao;
import org.afeng.dao.impl.UserDaoImpl;
import org.afeng.domain.User;
import org.afeng.service.UserService;

/**
 * @author afeng
 * @date 2018/8/21 16:48
 **/
public class UserServiceImpl implements UserService
{

    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) throws Exception
    {
        return userDao.login(user);
    }
}
