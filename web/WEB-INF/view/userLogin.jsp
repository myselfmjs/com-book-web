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
   /* html,body,div,h2,p{margin: 0;padding: 0;}
    html{font: 1em Arial, Helvetica, sans-serif;color: #444;}
    a{color: #0087f1;}
    p{margin-bottom: 5px;}
    #container{margin: 0 auto;width: 600px;}
    #container h2{font-size: 20px;color: #0087f1;}
    #wrap{position: relative;padding: 10px;overflow: hidden;}
    #gradient{width: 100%;height: 35px;background:repeat-x;position: absolute;bottom: 0;left: 0;}
    #read-more{padding: 5px;border-top: 4px double red;background: #fff;color: #333;}
    #read-more a{padding-right: 22px;background:no-repeat 100% 50%;font-weight: bold;text-decoration: none;}
    #read-more a:hover{color: red;}*/
</style>
<html>
<head>
    <title>haha</title>
</head>
<body style="text-align: center">
    欢迎 ${userName} 登录!!!<br>
    <input type="button" value="退出" id="btn"><br>
    <input type="button" value="查询" id="search" onclick="search()">
    <br>  <br>  <br>


    <%--<div id="container">
        <h1>jQuery 控制段落文字展开折叠，点击查看更多的功能</h1>
        <h2>About Billabong</h2>
        <div id="wrap">
            <div>
                <p>Gordon developed his own stitching technique, which made the garments more durable, cost effective and less labor intensive. He employed machinists, moved the operation into a factory, set up a distribution network and sponsored a team of renowned Australian surfers. The business thrived.</p>
                <p>Since those beginnings, Billabong has expanded its product range to include boardsport products such as wetsuits, watches, surfboards, snowboard outerwear and skateboarding apparel.</p>
            </div>
            <div id="gradient"></div>
        </div>
        <div id="read-more"></div>
    </div>--%>

<script type="text/javascript">

    $(function () {
        //退出
        $("#btn").click(function () {
            window.location.href = "/user/deleteLogin";
        });
    });

    //查询
    function search() {
        $.ajax({
            type: 'post',
           /* async:false,*/
            url:"/user/index",
            data:{"id":"1"},
            dataType:"JSON",
            success: function (data) {
                alert(data.code);
                console.log(data);
                console.log("one two three");
            },
            error:function(data){
                console.log("error");
                console.log(data);
                console.log(JSON.stringify(data))
            }
        });
    }

   /* $(function(){
        var slideHeight = 75; // px
        var defHeight = $('#wrap').height();
        if(defHeight >= slideHeight){
            $('#wrap').css('height' , slideHeight + 'px');
            $('#read-more').append('<a href="#">点击查看更多。。</a>');
            $('#read-more a').click(function(){
                var curHeight = $('#wrap').height();
                if(curHeight == slideHeight){
                    $('#wrap').animate({
                        height: defHeight
                    }, "normal");
                    $('#read-more a').html('点击隐藏');
                    $('#gradient').fadeOut();
                }else{
                    $('#wrap').animate({
                        height: slideHeight
                    }, "normal");
                    $('#read-more a').html('点击查看更多。。');
                    $('#gradient').fadeIn();
                }
                return false;
            });
        }
    });*/
</script>
</body>
</html>
