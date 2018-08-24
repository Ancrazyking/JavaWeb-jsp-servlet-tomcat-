package org.afeng.mall.dao;

import org.afeng.mall.domain.User;

import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/24 11:16
 **/
public interface UserDao
{
    User userLogin(User user)throws SQLException;

    void userRegister(User user)throws SQLException;

}
