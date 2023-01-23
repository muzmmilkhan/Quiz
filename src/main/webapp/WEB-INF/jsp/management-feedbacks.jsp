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
        <h1 class="text-center m-4">Feedbacks</h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Quiz Type</th>
                <th scope="col">Rating</th>
                <th scope="col">Comment</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="feedback" items="${feedbacks}">
                <tr>
                    <td>${feedback.getQuizType().getName()}</td>
                    <td>${feedback.rating}</td>
                    <td>${feedback.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>