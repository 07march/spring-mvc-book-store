<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find User By Id</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/user/findById">
    <input type="number" name="id" placeholder="id" required>
    <button class="btn btn-info">Find</button>
</form>
${message}
<br>
<br>
<a href="/"><button class="btn btn-light">Start page</button></a>
</body>
</html>
