package org.afeng.utils;

/**
 * @author afeng
 * @date 2018/8/18 19:19
 **/
public class TextUtils
{
    /**
     * 判断一个字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(CharSequence s){
        return s==null || s.length()==0;
    }
}
