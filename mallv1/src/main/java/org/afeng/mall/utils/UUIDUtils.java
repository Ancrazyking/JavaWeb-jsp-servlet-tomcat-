package org.afeng.mall.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author afeng
 * @date 2018/8/23 16:58
 * <p>
 * <p>
 * <p>
 * 工具类,随机生成id
 **/
public class UUIDUtils
{

    /**
     * 默认生成32位ID,,带下划线
     * @return
     */
    public static String getId()
    {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    /**
     * 生成64位ID
     * @return
     */
    public static String getUUID64(){
        return getId()+getId();
    }

    /**
     * 生成32位随机码
     * @return
     */
    public static String getCode(){
        return getId();
    }


    @Test
    public void test()
    {
        System.out.println(getCode());
    }

}
