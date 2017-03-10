<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/9
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<%--<script src="lib/jquery/jquery.min.jsp"></script>--%>
<style type="text/css">
    .td_button{ margin-right: 20px; }

</style>

<html>
<head>
    <title>疯咯</title>
</head>
<body>
<br>
<form action="/user/doLogin">
    <table align="center" style="text-align: center" >
        <tr>
            <td>用户名:</td><td><input type="text" id="username" name="username" ></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;码:</td><td><input type="text" id="userpwd" name="password"></td>
        </tr>
        <tr >
            <td colspan="2" ><input type="submit" value="登录" id="btn" class="td_button" ><input type="button" value="重置" onclick="Reset()"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    var url = {
        login:"/user/login"
    }
    /*$(function () {
        $("#btn").click(function () {
            window.location.href = url.login;
        });
    });*/

    //重置
    function Reset() {
        window.location.href = "";
    }
</script>
</body>
</html>
