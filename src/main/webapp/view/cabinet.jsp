<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p>Select next action:</p>
1. Update firstname:
<a href="/user/updateFirstName?email=${sessionScope.user.email}">
    <button class="btn btn-light">click</button>
</a>
<br>
<br>
2. Update lastname:
<a href="/user/updateLastName?email=${sessionScope.user.email}">
    <button class="btn btn-light">click</button>
</a>
<br>
<br>
3. Change password:
<a href="/user/updatePassword?email=${sessionScope.user.email}">
    <button class="btn btn-light">click</button>
</a>
<br>
<br>
4. Delete account:
<a href="/user/delete">
    <button class="btn btn-light">click</button>
</a>
<br>
<br>
5. Basket
<a href="/basket"><button class="btn btn-light">click</button></a>
<br>
<br>
<a href="/">
    <button class="btn btn-light">Return</button>
</a>
</body>
</html>
