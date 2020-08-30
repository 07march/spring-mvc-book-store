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
<a href="/book/findAll">
    <button class="btn btn-light">Back</button>
</a>
</body>
</html>
