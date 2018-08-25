package org.afeng.mall.service.impl;

import org.afeng.mall.dao.UserDao;
import org.afeng.mall.dao.impl.UserDaoImpl;
import org.afeng.mall.domain.User;
import org.afeng.mall.service.UserService;
import org.afeng.mall.utils.MailUtils;

import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/24 11:16
 **/
public class UserServiceImpl implements UserService
{

    UserDao userDao = new UserDaoImpl();

    @Override
    public User userLogin(User user) throws SQLException
    {
        return userDao.userLogin(user);
    }

    @Override
    public void userRegister(User user) throws SQLException
    {
        userDao.userRegister(user);
        /**
         * 注册之后发送邮件
         *这个功能按照逻辑应该是在业务逻辑成完成的
         * dao层只关心数据的操作
         * servlet层是对数据的接收与响应
         */
        try
        {
            MailUtils.sendMail(user.getEmail(),user.getCode());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public User userActive(String code) throws SQLException
    {
        return userDao.userActive(code);
    }

    @Override
    public void userUpdate(User user) throws SQLException
    {
        userDao.userUpdate(user);
    }
}
