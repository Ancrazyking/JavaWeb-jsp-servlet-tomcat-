<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/19
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表页面</title>

    <script>
        function deleteStu(stuId)
        {
            var flag = confirm("确认删除学生信息?");
            if (flag)
            {

                location.href = "delete?stuId=" + stuId;
            }
        }

    </script>
</head>
<body>
<form action="search_stu" method="post">
    <table border="1" width="1000">
        <tr>
            <td colspan="8">
                按姓名查询:<input type="text" name="stuName">
                &nbsp;
                按性别查询:<select name="gender">
                <option value="">--请选择--</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="add.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>


        <c:forEach items="${pageBean.list}" var="stu">
            <tr align="center">
                <td>${stu.stuId }</td>
                <td>${stu.stuName }</td>
                <td>${stu.gender }</td>
                <td>${stu.phone }</td>
                <td>${stu.birthday }</td>
                <td>${stu.hobby }</td>
                <td>${stu.info }</td>
                <td><a href="edit?stuId=${stu.stuId}">更新</a> <a href="#" onclick="deleteStu(${stu.stuId})">删除</a></td>

            </tr>

        </c:forEach>


        <tr>
            <td colspan="8">
                第 ${pageBean.currentPage } / ${pageBean.totalPage }
                &nbsp;&nbsp;
                每页显示${pageBean.pageSize }条 &nbsp;&nbsp;&nbsp;
                总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
                <c:if test="${pageBean.currentPage !=1 }">
                    <a href="stu_listByPage?currentPage=1">首页</a>
                    | <a href="stu_listByPage?currentPage=${pageBean.currentPage-1 }">上一页</a>
                </c:if>

                <c:forEach begin="1" end="${pageBean.totalPage }" var="i">
                    <c:if test="${pageBean.currentPage == i }">
                        ${i }
                    </c:if>
                    <c:if test="${pageBean.currentPage != i }">
                        <a href="stu_listByPage?currentPage=${i }">${i }</a>
                    </c:if>

                </c:forEach>

                <c:if test="${pageBean.currentPage !=pageBean.totalPage }">
                    <a href="stu_listByPage?currentPage=${pageBean.currentPage+1 }">下一页</a> |
                    <a href="stu_listByPage?currentPage=${pageBean.totalPage }">尾页</a>
                </c:if>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
