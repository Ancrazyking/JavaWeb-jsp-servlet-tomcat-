package org.afeng.dao.impl;

import com.mysql.jdbc.JDBC4CallableStatement;
import org.afeng.dao.UserDao;
import org.afeng.domain.User;
import org.afeng.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


/**
 * @author afeng
 * @date 2018/8/21 16:43
 **/
public class UserDaoImpl implements UserDao
{

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public User login(User user) throws Exception
    {
        return queryRunner.query("select * from tb_user where username=? and password=?",
                new BeanHandler<>(User.class),user.getUsername(),user.getPassword());
    }
}
