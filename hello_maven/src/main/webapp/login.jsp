<%--
  Created by IntelliJ IDEA.
  User: Luobogan
  Date: 2021/6/20
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new jsp</title>
</head>
<script typet="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script>
    // 原生JS方式发送AJAX请求
    function run() {
        // 1.核心对象
        var xmlhttp;

        //2.判断浏览器类型
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }

        //3.建立连接
        /* 规定请求的类型、URL 以及是否异步处理请求。
           method：请求的类型；GET 或 POST
           url：文件在服务器上的位置
           async：true（异步）或 false（同步）
        */
        xmlhttp.open("GET","/login?username=tom",true);

        //4.发送请求
        xmlhttp.send();

        //5.获取响应结果
        /*
        readyState
        存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
        0: 请求未初始化
        1: 服务器连接已建立
        2: 请求已接收
        3: 请求处理中
        4: 请求已完成，且响应已就绪

        status
        200: "OK"
        404: 未找到页面
        */
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                let text = xmlhttp.responseText;
                alert("响应结果：" + text);
            }
        }
    }

    // 采用JQuery进行异步GET请求
    function run2() {
        var url = "/login";
        var data = {username:"jack"};

        $.get(url,data,function (param){
            alert("GET异步请求 响应成功：" + param)
        },"text")
    }

    // 采用JQuery进行异步POST请求
    function run3() {
        var url = "/login";
        var data = {username:"lucy"};

        $.post(url,data,function (param){
            alert("POST异步请求 响应成功：" + param)
        },"text")
    }

    // 采用AJAX进行异步请求
    function run4() {

        $.ajax({
            url:"/login",
            async:true,
            data:{username:"giao"},
            type:"GET", // 请求方式
            dataType:"text", // 返回数据的数据类型

            success:function (param) {
                alert("响应成功!" + param);
            },
            error:function (param) {
                alert("响应失败!" + param);
            }
        });

    }

</script>
<body>
    <input type="button" value="原生JS发送异步请求" onclick="run()"><br>
    局部刷新 <label>
        <input type="text">
    </label>
    <br>

    <input type="button" value="JQuery发送异步GET请求run2" onclick="run2()"><br>
    <br>

    <br>
    <input type="button" value="JQuery发送异步POST请求run3" onclick="run3()"><br>

    <br>
    <input type="button" value="AJAX发送异步POST请求run4" onclick="run4()"><br>
</body>
</html>
