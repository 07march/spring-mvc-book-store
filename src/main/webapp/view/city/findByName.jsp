<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find City By Name</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/city/findByName" name="city">
    <input type="text" name="name" placeholder="enter city" required>
    <button class="btn btn-info">Find</button>
</form>
${message}
<br>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
