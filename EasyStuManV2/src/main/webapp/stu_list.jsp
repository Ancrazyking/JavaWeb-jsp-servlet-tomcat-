<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/18
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl标签库-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表页面</title>

    <script>
        function deleteStu(stuId)
        {
            var flag = confirm("是否确认删除?");
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
                按姓名查询:<input type="text" name="stuName"/>&nbsp;
                按性别查询:<select name="stuGender">
                                <option value="">--请选择--</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                          </select>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询"/>
                &nbsp;&nbsp;&nbsp;
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

        <c:forEach items="${list}" var="stu">
            <tr align="center">
                <td>${stu.stuId}</td>
                <td>${stu.stuName}</td>
                <td>${stu.gender}</td>
                <td>${stu.phone}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.info}</td>
                <td colspan="8"><a href="edit?stuId=${stu.stuId}">更新</a>   <a href="#" onclick="deleteStu(${stu.stuId})">删除</a></td>
            </tr>
        </c:forEach>

    </table>
</form>


</body>
</html>
