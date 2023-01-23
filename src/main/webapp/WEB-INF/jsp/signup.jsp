<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>QuizApp-Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<header>
    <jsp:include page="navbar.jsp"/>
</header>
<main class="container">
    <div class="p-3">
        <div class="card position-absolute top-50 start-50 translate-middle">
            <div class="card-header">
                <h1 class="text-center">Sign Up</h1>
            </div>
            <div class="card-body">
                <form:form method="post" action="/signup" modelAttribute="user">
                    <div class="form-group py-2 px-4">
                        <label>Username</label>
                        <form:input class="form-control" type="text" path="username" placeholder="Username" required="Username is required"/>
                    </div>
                    <div class="form-group py-2 px-4">
                        <label>Password</label>
                        <form:input class="form-control" type="password" path="password" placeholder="Password" required="Password is required"/>
                    </div>
                    <div class="form-group py-2 px-4">
                        <label>Email</label>
                        <form:input class="form-control" type="email" path="email" placeholder="Email" required="Email is required"/>
                    </div>
                    <p class="text-center py-3"><input class="btn btn-lg btn-primary" type="submit" value="Create Account"></p>
                </form:form>

                <p class="text-center">Already have account? <a href="/signin" >You can sign in here!</a></p>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>