<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>SSE Demo</title>
</head>
<div id="msgFrompPush"></div>

<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script>
    if (!!window.EventSource) {
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message', function (e) {
            s += e.data + "<br/>";
            $("#msgFrompPush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("连接打开");
        }, false);

        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(e.readyState);
            }

        }, false);
    } else {
        console.log("您的浏览器不支持 SSE");
    }
</script>
</body>
</html>
