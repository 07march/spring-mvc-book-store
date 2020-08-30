<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add City</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:form action="/city" method="post" modelAttribute="city">
    <c:input path="name" placeholder="enter new city"/>
    <c:errors path="name"/>
    <c:button class="btn btn-success">Add</c:button>
</c:form>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
