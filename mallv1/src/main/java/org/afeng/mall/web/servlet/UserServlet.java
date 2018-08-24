package org.afeng.mall.web.servlet;

import org.afeng.mall.domain.User;
import org.afeng.mall.service.UserService;
import org.afeng.mall.service.impl.UserServiceImpl;
import org.afeng.mall.utils.MyBeanUtils;
import org.afeng.mall.utils.UUIDUtils;
import org.afeng.mall.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 所有的Servlet继承至BaseServelt
 *
 * @author afeng
 * @date 2018/8/24 11:25
 **/
public class UserServlet extends BaseServlet
{
    UserService userService = new UserServiceImpl();

    public String register(HttpServletRequest request, HttpServletResponse response)
    {
        return "/jsp/register.jsp";
    }


    public String userRegister(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        request.setCharacterEncoding("utf-8");
        /**
         * 遍历map获取数据,获取里面的请求参数
         */
        Map<String, String[]> map = request.getParameterMap();

        User user = new User();
        MyBeanUtils.populate(user, map);


        //为其他的属性赋值
        //生成用户随机ID
        user.setUid(UUIDUtils.getId());
        //默认用户账户处于未激活的状态
        user.setState(0);
        //用户的激活码
        user.setCode(UUIDUtils.getCode());
        System.out.println(user);
        userService.userRegister(user);
        return "";
    }

}
