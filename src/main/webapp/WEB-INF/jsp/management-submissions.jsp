<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuizApp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header>
    <header>
        <jsp:include page="navbar.jsp"/>
    </header>
</header>
<main>
    <div class="container">
        <h1 class="text-center m-4">Submissions</h1>

        <!-- Table with Username, Quiz Type, Start, End, Grade, and Detail button -->
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Quiz Type</th>
                <th scope="col">Start</th>
                <th scope="col">End</th>
                <th scope="col">Grade</th>
                <th scope="col">Detail</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="submission" items="${submissions}" >
                <tr>
                    <td><a href="/admin/submissions/user/${submission.getUser().getId()}">${submission.getUser().getUsername()}</a></td>
                    <td><a href="/admin/submissions/type/${submission.getQuizType().getId()}">${submission.getQuizType().getName()}</a></td>
                    <td>${submission.getStartTime()}</td>
                    <td>${submission.getEndTime()}</td>
                    <td>${submission.getPass()? "Passed" : "Failed"}</td>
                    <td>
                        <a href="submissions/${submission.getId()}" class="btn btn-primary">See Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>