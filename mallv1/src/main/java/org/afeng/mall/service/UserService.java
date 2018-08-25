package org.afeng.mall.service;

import org.afeng.mall.domain.User;

import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/24 11:16
 **/
public interface UserService
{

    User userLogin(User user) throws SQLException;

    void userRegister(User user) throws SQLException;

    User userActive(String code)throws SQLException;

    void userUpdate(User user)throws SQLException;
}
