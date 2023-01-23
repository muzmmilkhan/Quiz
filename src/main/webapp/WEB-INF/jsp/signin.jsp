<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuizApp-Sign In</title>
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
                <h1 class="text-center">Welcome</h1>
            </div>
            <div class="card-body">
                <form method="post" action="">
                    <div class="form-group py-2 px-4">
                        <label>Username</label>
                        <input class="form-control" type="text" name="username" placeholder="Username" required/>
                    </div>
                    <div class="form-group py-2 px-4">
                        <label>Password</label>
                        <input class="form-control" type="password" name="password" placeholder="Password" required/>
                    </div>
                    <p class="text-center py-3"><button class="btn btn-lg btn-primary" type="submit">Sign In</button></p>
                </form>

                <p class="text-center">Don't have account yet? <a href="/signup" >You can sign up here!</a></p>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>