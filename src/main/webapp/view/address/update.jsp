<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/address/update" method="post">
    <input type="hidden" name="id" value="${id}">
    <input type="text" name="address" placeholder="enter new address" required>
    <button class="btn btn-link">Update</button>
</form>
<br>
<a href="/address/findAll"><button class="btn btn-light">Back</button></a>
</body>
</html>
