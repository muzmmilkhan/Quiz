<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>QuizApp</title>
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
                <h1 class="text-center">Leave a feedback</h1>
            </div>
            <div class="card-body">
                <form:form method="post" action="/addfeedback" modelAttribute="feedback">
                    <div class="form-group py-2 px-4">
                        <label>You are leaving a feedback for ${quizType.getName()}</label>
                    </div>
                    <div class="form-group py-2 px-4">
                        <label>Rating</label>
                        <form:select path="rating" class="form-select">
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                        </form:select>
                    </div>
                    <div class="form-group py-2 px-4">
                        <label>Comment:</label>
                        <form:textarea path="description" class="form-control" rows="5"/>
                    </div>

                    <p class="text-center py-3"><input class="btn btn-lg btn-primary" type="submit" value="Leave feedback"></p>
                </form:form>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>