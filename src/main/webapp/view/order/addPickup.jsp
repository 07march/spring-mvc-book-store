<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pickup</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="/order/add/pickup" method="post">
    <select name="name" required>
        <option disabled selected>Choose a store</option>
        <c:forEach items="${stores}" var="store">
            <option value="${store.name}">
                ${store.name}
            </option>
        </c:forEach>
    </select>
    <button class="btn btn-light">Create</button>
</form>
<a href="/order"><button class="btn btn-light">Back</button></a>
</body>
</html>
