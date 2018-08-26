package org.afeng.mall.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author afeng
 * @date 2018/8/24 8:20
 **/
public class JedisUtils
{
    private static JedisPoolConfig config;
    private static JedisPool pool;

    static
    {
        config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(2);
        pool = new JedisPool(config, "192.168.25.135", 6379);
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Jedis getJedis()
    {
        return pool.getResource();
    }


    /**
     * 释放连接
     *
     * @param jedis
     */
    public static void closeJedis(Jedis jedis)
    {
        jedis.close();
    }


    public static void main(String[] args)
    {
/*
        System.out.println(getJedis());
*/
        Jedis j = JedisUtils.getJedis();
        String jsonStr = "hello,redis";
        j.set("jsonStr", jsonStr);

        System.out.println(j.get("jsonStr"));

        closeJedis(j);
    }
}
