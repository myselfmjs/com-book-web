<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/9
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>--%>
<script type="text/javascript" src="/lib/jquery/jquery-3.0.0.min.js"></script>
<style>
    .td{background: red}
</style>
<html>
<head>
    <title>haha</title>
</head>
<body style="text-align: center">
    欢迎 ${userName} 登录!!!<br>
    <input type="button" value="退出" id="btn"><br>
    <input type="button" value="button" id="button"><br>
    <input type="button" value="button" ><br>
    <input type="button" value="button" ><br>

    <br><br><br>
<table align="center" border="1px">
    <th colspan="2">不包括子元素或文本的空元素</th>
    <tr><td>11</td><td>12</td></tr>
    <tr><td>21</td><td>22</td></tr>
    <tr><td></td><td>32</td></tr>
    <tr><td>41</td><td></td></tr>
</table>

   <p>1</p>
    <p>2</p>
    <p>3</p>
    <p>4</p>
    <p>5</p>

<script type="text/javascript">

    $(function () {
        //退出
        $("#btn").click(function () {
            window.location.href = "/user/deleteLogin";

        });
        //匹配没有子元素或文本空的元素
        $('td:empty').addClass("td");

        //clone 自己
        $("#button").click(function () {
            $(this).clone(true).insertAfter(this);
        });

        $('p').bind({
            click:function () {
                console.log($(this).text());
            },
           /* mouseover:function () {
                console.log($(this).text());
            }*/
        });
    });

</script>
</body>
</html>
