package org.afeng.mall.dao.impl;

import org.afeng.mall.dao.UserDao;
import org.afeng.mall.domain.User;
import org.afeng.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author afeng
 * @date 2018/8/24 11:16
 **/
public class UserDaoImpl implements UserDao
{
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public User userLogin(User user) throws SQLException
    {
        return queryRunner.query("select * from user  where username=? and password=?", new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
    }

    @Override
    public void userRegister(User user) throws SQLException
    {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode());
    }

    @Override
    public User userActive(String code) throws SQLException
    {
        return queryRunner.query("select * from user where code=?", new BeanHandler<>(User.class), code);
    }


    @Override
    public void userUpdate(User user) throws SQLException
    {
        String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
        /**
         * 拼接可变的参数
         */

        Object[] params = {user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getUid()};
        queryRunner.update(sql, params);

    }
}
