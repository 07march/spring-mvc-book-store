<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Book By Id</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/book/deleteById" method="post">
    <input type="number" name="id" placeholder="author id" required>
    <button class="btn btn-danger">Delete</button>
</form>
<br>
<a href="/book/findAll"><button class="btn btn-light">Back</button></a>
</body>
</html>
