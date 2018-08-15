package org.afeng.dao;

/**
 * @author afeng
 * @date 2018/8/15 21:06
 **/
public interface UserDao
{
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return  true  登录成功    false   登录失败
     */
    boolean login(String userName, String password);
}
