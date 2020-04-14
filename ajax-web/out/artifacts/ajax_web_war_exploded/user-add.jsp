<%--
  Created by IntelliJ IDEA.
  User: niruoqingcheng
  Date: 2020/4/7
  Time: 18:35
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
            /*  $("#username").blur(function () {
                  $.get("UserServlet",{username:$("#username").val()},function (msg) {
                      $("#username_msg").html(msg);
                  });
              });*/
            $("#username").blur(function () {
                $.ajax({
                    url: "UserServlet",
                    type: "POST",
                    data: {username: $("#username").val(), password: 123},
                    success: function (data) {
                        $("#username_msg").html(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<input id="username" name="username" onblur="checkeName()"> <label id="username_msg"></label>
<input name="password">
<input type="submit" value="注册">
</body>
</html>
