<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Index</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p>Welcome, ${sessionScope.user.firstName} !</p>
Information about you:
<br>
- name and surname: ${sessionScope.user.firstName} ${sessionScope.user.lastName};
<br>
- email : ${sessionScope.user.email} .
<br>
<br>
${message}
<br>
<br>
- admin page:
<a href="/admin">
    <button class="btn btn-light">click</button>.
</a>
<br>
<br>
- cabinet:
<a href="/cabinet">
    <button class="btn btn-light">click</button>.
</a>
<br>
<br>
- exit:
<a href="/user/logout">
    <button class="btn btn-light">click</button>.
</a>
</body>
</html>
