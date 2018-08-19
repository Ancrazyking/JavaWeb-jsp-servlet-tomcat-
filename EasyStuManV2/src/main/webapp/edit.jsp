<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/18
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--通过函数判断-->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>更新学生页面</title>
</head>
<body>
<h3>更新学生页面</h3>

<form method="post" action="update">
    <input type="hidden" name="stuId" value="${stu.stuId}">
    <table border="1" width="600">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="stuName" value="${stu.stuName}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男"
                       <c:if test="${stu.gender=='男'}">checked</c:if> >男
                <input type="radio" name="gender" value="女" <c:if test="${stu.gender=='女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${stu.phone}"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="${stu.birthday}"></td>
        </tr>

        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳' )}">checked</c:if>>游泳
                <input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球' )}">checked</c:if>>篮球
                <input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(stu.hobby,'足球' )}">checked</c:if>>足球
                <input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书' )}">checked</c:if>>看书
                <input type="checkbox" name="hobby" value="写字" <c:if test="${fn:contains(stu.hobby,'写字' )}">checked</c:if>>写字
            </td>

        </tr>

        <tr>
            <td>简介</td>
            <td><textarea name="info" rows="3" cols="20">${stu.info}</textarea></td>
        </tr>

        <!--点击提交表单-->
        <tr>
            <td colspan="2"><input type="submit" value="更新"></td>
        </tr>
    </table>
</form>

</body>
</html>
