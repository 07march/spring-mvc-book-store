<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Address By Id</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
${message}
<br>
<br>
<a href="/address/update?id=${address.id}"><button class="btn btn-secondary">Update</button></a>
<br>
<br>
<form action="/address/delete?address=${address.name}" method="post">
    <button class="btn btn-danger">Delete</button>
</form>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
