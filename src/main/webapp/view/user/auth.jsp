<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Autorization</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:form action="/user/auth" method="post" modelAttribute="user">
    <c:input path="email" placeholder="email"/>
    <c:input path="password" placeholder="password"/>
    <c:button class="btn btn-success">Autorization</c:button>
</c:form>
${message}
<br>
<br>
<a href="/"><button class="btn btn-light">Start page</button></a>
</body>
</html>
