<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/27
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.List" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align: center">
    共${page.totalPageNum}页/第${page.currentPageNum}页
    <a href="${pageContext.request.contextPath}/${page.url}&pageNum=1">首页</a>
    <a href="${pageContext.request.contextPath}/${page.url}&pageNum=${page.prePageNum}">上一页</a>
    <!--首页  上一页  1 2 3 4 5  ... 下一页  末页  [  ]前往-->
    <!--显示的页码,使用forEach变量显示的页面-->
    <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
        <a href="${pageContext.request.contextPath}/${page.url}&pageNum=${num}">${num}</a>
    </c:forEach>

    <a href="${pageContext.request.contextPath}/${page.url}&pageNum=${page.nextPageNum}">下一页</a>
    <a href="${pageContext.request.contextPath}/${page.url}&pageNum=${page.totalPageNum}">末页</a>
    <input type="text" id="inputNum" name="inputNum" size="1">
    <input type="button" value="前往" onclick="search()">


    <!--js用于对用户输入的校验-->
    <script>
        function search()
        {
            /**
             * 获取总的页数
             */
            var totalPageNum =${page.totalPageNum};
            /**
             * 获取输入框里面的值
             */
            var inputNum = document.getElementById("inputNum").value;
            var reg = /^[1-9][0-9]{0,1}$/;
            /**
             * 正则判断是否符合正则匹配的
             */
            if (!reg.test(inputNum))
            {
                alert("请输入符合规则的数字");
                return;
            }
            if (parseInt(inputNum) > parseInt(totalPageNum))
            {
                alert("输入的页数不能大于总页数");
                return;
            }
            window.location.href = "${pageContext.request.contextPath}/${page.url}&pageNum=" + inputNum;
        }
    </script>
</div>