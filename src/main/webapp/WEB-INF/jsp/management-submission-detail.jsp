<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<main class="container">
    <div class="text-center">
        <h1>Submission Detail</h1>
    </div>

    <table class="table table-striped text-center">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Question</th>
            <th scope="col">Possible Choices</th>
            <th scope="col">User's Selection</th>
            <th scope="col">Correct Answer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" begin="0" end="9" items="${submission.getReport()}" varStatus="loop">
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${report.getQuestion().getDescription()}</td>
                <td>
                    <c:forEach var="choice" items="${report.getQuestion().getChoice()}">
                        <p>- ${choice.getDescription()}</p>
                    </c:forEach>
                <td>${report.selected}</td>
                <td>${report.answer}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>