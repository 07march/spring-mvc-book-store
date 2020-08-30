<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Store</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:form action="/store" method="post" modelAttribute="store">
    <c:input path="name" placeholder="enter store name"/>
    <c:errors path="name"/>

    <select name="addressId">
        <option selected disabled>Address</option>
        <j:forEach items="${addresses}" var="address">
            <option value="${address.id}">${address.name}</option>
        </j:forEach>
    </select>

    <select name="cityId">
        <option selected disabled>City</option>
        <j:forEach items="${city}" var="city">
            <option value="${city.id}">${city.name}</option>
        </j:forEach>
    </select>
    <button class="btn btn-success">Add</button>
</c:form>
<br>
<a href="/admin">
    <button class="btn btn-light">Back</button>
</a>
</body>
</html>
