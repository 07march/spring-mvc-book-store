<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Book By Id</title>
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
<a href="/book/updateTitle?id=${book.id}">
    <button class="btn btn-light">Update Title</button>
</a>
<br>
<br>
<a href="/book/updatePrice?id=${book.id}">
    <button class="btn btn-light">Update Price</button>
</a>
<br>
<br>
<form action="/book/deleteById?id=${book.id}" method="post">
    <button class="btn btn-light">Delete</button>
</form>
<form action="/basket/add?id=${book.id}" method="post">
    <button class="btn btn-light">Add to basket</button>
</form>
<a href="/admin/findAllBooks">
    <button class="btn btn-light">Back</button>
</a>
</body>
</html>
