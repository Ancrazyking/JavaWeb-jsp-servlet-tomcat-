package org.afeng.mall.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author afeng
 * @date 2018/8/23 22:02
 **/
public class MD5Utils
{
    /**
     * 使用md5的算法进行加密
     * plainText  明文
     */
    public static String md5(String plainText)
    {
        byte[] secretBytes = null;

        try
        {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("没有md5这个算法!");
        }
        /**
         * signum表示的是符号
         */
        String md5Code = new BigInteger(1, secretBytes).toString(16);

        /**
         * 如果md5生成的数字不足32位则前面补0
         */
        for (int i = 0; i < 32 - md5Code.length(); i++)
        {
            md5Code = "0" + md5Code;
        }

        return md5Code;
    }

    public static void main(String[] args)
    {
        System.out.println(md5("wangafeng"));
    }

}
