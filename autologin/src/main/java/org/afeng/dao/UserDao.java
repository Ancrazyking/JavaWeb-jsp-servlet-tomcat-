package org.afeng.dao;

import org.afeng.domain.User;

/**
 * @author afeng
 * @date 2018/8/21 16:43
 **/
public interface UserDao
{

    User login(User user) throws Exception;

}
