<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/4/10
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/lib/jquery/jquery-3.0.0.min.js"></script>
<html>
<head>
    <title>文件下载一览</title>
</head>
<body>

<table>
    <tr><th >下载一览</th></tr>
    <c:forEach var="row" varStatus="i" items="${file}">
        <tr><td>${row.name}</td><td><a href="javascript:void (0)" onclick="checkFile('${row.id}')">下载</a></td></tr>
    </c:forEach>

</table>
<iframe id="frmDownload" height="0" width="0" frameborder="0"></iframe>
</body>

<script type="application/javascript">
    var $contextPath = "${contextPath}";
    function joinUrl(url){return $contextPath + url;}//拼接链接
    var urls = {
        listUrl: joinUrl('/downLoad/list'),
        checkUrl: joinUrl('/downLoad/checkFile'),
        downloadUrl:joinUrl('/downLoad/download'),
        delFile:joinUrl('/downLoad/delFile')
    };
    function checkFile(id) {
        $.ajax({
            type: 'post',
            /*async:true,*/
            url:urls.checkUrl,
            data:{'id':id},
            dataType:'json',
            success: function (data) {
                if(data.code != 0){
                    alert(data.msg);
                }else {
                    console.log(data.code);
                    $("#frmDownload").attr("src", urls.downloadUrl + "?id="+id);
                }
            },
            error:function(data){
                console.log("error");
                console.log(data);
            }
        });
    }
</script>
</html>
