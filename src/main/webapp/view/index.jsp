<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h1>Welcome, Guest !</h1>
${message}
<br>
<br>
    <p>Sign up or Log in!</p>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <br>
    <a href="/user">
        <button class="btn btn-info">Registration</button>
    </a>
    <a href="/user/auth">
        <button class="btn btn-info">Autorization</button>
    </a>
    <a href="/book/findAll">
        <button class="btn btn-info">View all books</button>
    </a>
</body>
</html>
