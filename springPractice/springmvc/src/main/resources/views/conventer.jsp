<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url: "convert",
            data: "1-panj",
            type: "POST",
            contentType: "application/x-wisely",
            success: function (data) {
                $("#resp").html(data);
            }
        });
    }
</script>

</body>
</html>
