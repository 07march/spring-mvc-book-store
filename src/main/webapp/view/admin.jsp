<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p>All methods:</p>
<p>- create</p>

<a href="/address"><button class="btn btn-dark">a) address</button></a>

<a href="/author"><button class="btn btn-dark">b) author</button></a>

<a href="/book"><button class="btn btn-dark">c) book</button></a>

<a href="/city"><button class="btn btn-dark">d) city</button></a>

<a href="/store"><button class="btn btn-dark">d) store</button></a>
<br>
<br>

<p>- find (update, delete)</p>

 <a href="/address/findAll"><button class="btn btn-dark"> a) addresses</button></a>
<br>
<br>
<a href="/author/findAll"><button class="btn btn-dark"> b) authors</button></a>
<br>
<br>
<a href="/admin/findAllBooks"><button class="btn btn-dark"> c) books</button></a>

<a href="/book/findByAuthorName"><button class="btn btn-dark"> (books by author name)</button></a>

<a href="/book/findAllByPrice"><button class="btn btn-dark">(books by price)</button></a>
<br>
<br>
<a href="/city/findAll"><button class="btn btn-dark"> d) cities</button></a>
<br>
<br>
<a href="/store/findAll"><button class="btn btn-dark"> e) stores</button></a>
<br>
<br>
<br>
<br>
<a href="/"><button class="btn btn-dark">Return</button></a>
</body>
</html>
