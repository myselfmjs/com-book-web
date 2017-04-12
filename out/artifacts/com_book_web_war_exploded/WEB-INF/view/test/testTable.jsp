<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title></title>
    <style type="text/css" >
        table { background:#949494; width:400px; line-height:20px;}
        td { border-right:1px solid gray; border-bottom:1px solid gray; }
    </style>
    <script src="jquery.js" type="text/javascript"></script>
    <script type="text/javascript" >
        function up(obj) {
            var objParentTR = $(obj).parent().parent();
            var prevTR = objParentTR.prev();
            if (prevTR.length > 0) {
                prevTR.insertAfter(objParentTR);
            }
        }
        function down(obj) {
            var objParentTR = $(obj).parent().parent();
            var nextTR = objParentTR.next();
            if (nextTR.length > 0) {
                nextTR.insertBefore(objParentTR);
            }
        }
    </script>
</head>
<body>
<table border="0" >
    <tr><td>1</td><td>12</td><td>13</td><td><a href="#" onclick="up(this)">上移</a>  <a href="#" onclick="down(this)">下移</a></td></tr>
    <tr><td>2</td><td>22</td><td>23</td><td><a href="#" onclick="up(this)">上移</a>  <a href="#" onclick="down(this)">下移</a></td></tr>
    <tr><td>3</td><td>32</td><td>33</td><td><a href="#" onclick="up(this)">上移</a>  <a href="#" onclick="down(this)">下移</a></td></tr>
    <tr><td>4</td><td>42</td><td>43</td><td><a href="#" onclick="up(this)">上移</a>  <a href="#" onclick="down(this)">下移</a></td></tr>
    <tr><td>5</td><td>52</td><td>53</td><td><a href="#" onclick="up(this)">上移</a>  <a href="#" onclick="down(this)">下移</a></td></tr>
</table>
</body>
</html> 