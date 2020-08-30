<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book Price</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/book/updatePrice" method="post">
    <input type="hidden" name="id" value="${id}">
    <input type="number" name="price" placeholder="new price" required>
    <button class="btn btn-link">Update</button>
</form>
<br>
<a href="/admin/findAllBooks"><button class="btn btn-light">Back</button></a>
</body>
</html>
