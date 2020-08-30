<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find All Addresses</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
${message}
<ul>
    <c:forEach items="${all}" var="address">
        <a href="/address/findById?id=${address.id}"><li>${address.name}</li></a>
    </c:forEach>
</ul>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
