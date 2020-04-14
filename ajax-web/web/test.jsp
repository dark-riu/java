<%--
  Created by IntelliJ IDEA.
  User: niruoqingcheng
  Date: 2020/4/9
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script type="text/javascript" src="jquer/jquery-1.8.0.js"></script>
    <script>
        $(function () {
            $("button").click(function () {
                $.ajax({
                    url:"AdminServlet",
                   type:"post",
                    dataType:"json",
                   success:function (data) {
                        alert(data);
                   }
                });
            });
        });
    </script>
</head>
<body>
<button>测试</button>
</body>
</html>
