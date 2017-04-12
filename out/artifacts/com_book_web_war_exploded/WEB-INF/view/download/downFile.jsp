<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/4/10
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载页面</title>

<%--<style type="text/css">
    .input-file{position:absolute; right:0; top:0; cursor: pointer; z-index:1; font-size:30em;opacity:0;filter: alpha(opacity=0)}
</style>--%>
</head>
<body>
<form action="${pageContext.request.contextPath}/downLoad/upLoad" enctype="multipart/form-data" method="post">
上传用户：<input type="text" name="name"><br/>
上传文件1：<input type="file" name="files"><br/>
上传文件2：<input type="file" name="files"><br/>
<input type="submit" value="提交">
</form>
</body>
</html>
