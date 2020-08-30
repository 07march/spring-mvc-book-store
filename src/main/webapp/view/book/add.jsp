<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:form action="/book" method="post" modelAttribute="book">
    <c:input path="price" placeholder="price"/>
    <c:errors path="price"/>
    <c:select path="author">

        <c:option value="Author" disabled="true"/>

        <j:forEach items="${author}" var="author">
            <c:option value="${author.name}">${author.name}</c:option>
        </j:forEach>
    </c:select>

    <c:input path="title" placeholder="title"/>
    <c:errors path="title"/>
    <c:input path="description" placeholder="description"/>
    <c:errors path="description"/>
    <c:button class="btn btn-success">Add</c:button>
    </c:form>
<br>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
