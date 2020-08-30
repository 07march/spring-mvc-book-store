<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find By Author Name</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<br>
${message}
<br>
<form action="/book/findByAuthorName">
    <input type="text" name="name" placeholder="name" required>
    <ul style="list-style: decimal">
        <c:forEach items="${byAuthorName}" var="book">
            <li>${book.title}</li>
            <li>${book.price}</li>
            <li>${book.description}</li>
        </c:forEach>
    </ul>
    <button class="btn btn-info">Find</button>
</form>
<a href="/admin"><button class="btn btn-light">Back</button></a>
</body>
</html>
