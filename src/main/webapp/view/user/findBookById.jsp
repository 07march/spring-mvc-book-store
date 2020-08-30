<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find book by User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
Book: ${book.title} ;
<br>
<br>
- author: ${book.author.name} ;
<br>
- price: ${book.price.toString()} $;
<br>
- description: ${book.description} .
<br>
<br>
<form action="/basket/add?id=${book.id}" method="post">
    <button class="btn btn-light">Add to basket</button>
</form>
<a href="/user/findAllBooks">
    <button class="btn btn-light">Back</button>
</a>
</body>
</html>
