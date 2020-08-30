<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Password</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/user/updatePassword" method="post">
    <input type="hidden" name="email" value="${email}">
    <input type="text" name="newPassword" placeholder="new password" required>
    <button class="btn btn-link">Update</button>
</form>
<br>
<a href="/cabinet"><button class="btn btn-light">Back</button></a>
</body>
</html>
