<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/order/add/delivery" method="post">
    <input type="text" name="address" placeholder="Address" required>
    <button class="btn btn-light">Create</button>
</form>
<a href="/order"><button class="btn btn-light">Back</button></a>
</body>
</html>
