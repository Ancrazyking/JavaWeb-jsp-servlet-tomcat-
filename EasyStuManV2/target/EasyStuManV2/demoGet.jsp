<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/20
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

        function ajaxFunction()
        {
            var xmlHttp;
            try
            { // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            }
            catch (e)
            {
                try
                {// Internet Explorer
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e)
                {
                    try
                    {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e)
                    {
                    }
                }
            }

            return xmlHttp;
        }

        //执行get请求
        function get()
        {

            //1. 创建xmlhttprequest 对象
            var request = ajaxFunction();

            //2. 发送请求。
            // http://localhost:8080/day16/demo01.jsp
            //http://localhost:8080/day16/DemoServlet01

            /*
                参数一： 请求类型  GET or  POST
                参数二： 请求的路径
                参数三： 是否异步， true  or false

            */
//		request.open("GET" ,"/day16/DemoServlet01" ,true );
            request.open("GET", "getServlet?name=aa&age=18", true);
            request.send();
        }

        //执行get请求
        function get()
        {

            //1. 创建xmlhttprequest 对象
            var request = ajaxFunction();

            //2. 发送请求
            request.open("GET", "getServlet?name=aa&age=18", true);

            //3. 获取响应数据 注册监听的意思。  一会准备的状态发生了改变，那么就执行 = 号右边的方法
            request.onreadystatechange = function () {

                //前半段表示 已经能够正常处理。  再判断状态码是否是200
                if (request.readyState == 4 && request.status == 200)
                {
                    //弹出响应的信息
                    alert(request.responseText);
                }
            }
            request.send();
        }

    </script>

</head>
<body>

<h3><a href="" onclick="get()">使用Ajax方式发送Get请求</a></h3>

</body>
</html>