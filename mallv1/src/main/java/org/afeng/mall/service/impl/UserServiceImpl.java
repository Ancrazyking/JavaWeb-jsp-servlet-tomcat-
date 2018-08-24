package org.afeng.mall.service.impl;

import org.afeng.mall.dao.UserDao;
import org.afeng.mall.dao.impl.UserDaoImpl;
import org.afeng.mall.domain.User;
import org.afeng.mall.service.UserService;

import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/24 11:16
 **/
public class UserServiceImpl implements UserService
{

    UserDao userDao = new UserDaoImpl();

    @Override
    public User UserLogin(User user) throws SQLException
    {
        return userDao.userLogin(user);
    }

    @Override
    public void userRegister(User user) throws SQLException
    {
        userDao.userRegister(user);
    }
}
