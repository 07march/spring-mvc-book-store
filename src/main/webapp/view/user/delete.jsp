<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p>Are you sure? Enter email to confirm:</p>
<form action="/user/delete" method="post">
    <input type="text" name="email" placeholder="email">
    <button class="btn btn-danger">Yes</button>
</form>
<br>
<a href="/"><button class="btn btn-light">No</button></a>
</body>
</html>
