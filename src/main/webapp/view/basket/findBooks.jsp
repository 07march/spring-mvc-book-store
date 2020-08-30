<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find Books</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p>Total price: ${total} $.</p>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book.title} ${book.author.name}</li>
        <form action="/basket/delete?id=${book.id}" method="post">
            <button class="btn btn-info">Delete</button>
        </form>
    </c:forEach>
</ul>
<br>
${param.message}
<br>
<br>
<a href="/order"><button class="btn btn-info">Create Order</button></a>
<br>
<br>
<a href="/user/findAllBooks"><button class="btn btn-info">Back</button></a>
</body>
</html>
