<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>servlet async support</title>
</head>
<body>
<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script>
    deferred();
    function deferred() {
        $.get('defer', function (data) {
            console.log(data);
            deferred();
        });

    }
</script>

</body>
</html>
