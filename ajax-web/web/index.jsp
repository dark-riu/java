<%--
  Created by IntelliJ IDEA.
  User: niruoqingcheng
  Date: 2020/4/7
  Time: 17:40
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
    <title>$Title$</title>
    <script>
        var xmlhttp=null;
        function checkeName() {
            if(window.XMLHttpRequest){
                xmlhttp=new XMLHttpRequest();
            }else if(window.ActiveXObject()){
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            if(xmlhttp){
                xmlhttp.onreadystatechange=myStateChange;
                var  username=document.getElementById("username").value;
                xmlhttp.open("get","UserServlet?username="+username,true)
                xmlhttp.send(null);
            }else {
                alert("创建XMLHttpRequest 对象失败")
            }
        }
        function myStateChange() {
            if(xmlhttp.readyState==4){  //4表示服务端返回的数据
                if(xmlhttp.status==200){ //200 服务端返回的状态码
                    alert(xmlhttp.responseText);//服务端返回的响应正文
                    alert(xmlhttp.statusText); //状态描述
                    alert(xmlhttp.status);
                }

            }
        }
    </script>
</head>
<body>
<form action="UserServlet" method="post">
    <input id="username" name="username" onblur="checkeName()">
    <input name="password">
    <input type="submit" value="注册">
</form>
</body>
${msg}
</html>
