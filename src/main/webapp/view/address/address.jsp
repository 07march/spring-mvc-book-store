<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Address</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:form action="/address" method="post" modelAttribute="address">
    <c:input path="name" placeholder="enter new address"/>
    <c:errors path="name"/>
    <c:button class="btn btn-success">Ok</c:button>
</c:form>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
