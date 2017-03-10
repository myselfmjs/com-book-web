<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/9
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<html>
<head>
    <title>haha</title>
</head>
<body style="text-align: center">
    欢迎 ${userName} 登录!!!<br>
    <input type="button" value="退出" id="btn">
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            window.location.href = "/user/deleteLogin";
        });
    });
</script>
</body>
</html>
