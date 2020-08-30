<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Author By Id</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
${message}
<br>
<br>
<a href="/author/update?id=${author.id}"><button class="btn btn-secondary">Update</button></a>
<br>
<br>
<form action="/author/delete?id=${author.id}" method="post">
    <button class="btn btn-info">Delete</button>
</form>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
