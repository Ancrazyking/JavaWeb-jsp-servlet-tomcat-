package org.afeng.mall.utils;

import org.afeng.mall.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author afeng
 * @date 2018/8/24 9:20
 **/
public class MyBeanUtils
{
    /**
     * 填充数据
     *
     * @param obj
     * @param map
     */
    public static void populate(Object obj, Map<String, String[]> map)
    {

        /**
         * 由于BeanUtils将字符串转换为user对象的字段会有问题,手动向BeanUtils注册一个时间类型转换器
         * 通过反射来获取将字符串转换为对象的属性
         */
        try
        {
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateConverter, java.util.Date.class);

            BeanUtils.populate(obj, map);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * 通用泛型
     * 通过BeanUtils填充数据
     * 所有的类里面有Date字段的都可以转换
     */
    public static <T> T populate(Class<T> clazz, Map<String, String[]> map)
    {
        try
        {
            T obj = clazz.newInstance();

            DateConverter dateConverter = new DateConverter();
            dateConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateConverter, java.util.Date.class);

            BeanUtils.populate(obj, map);

            return obj;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
