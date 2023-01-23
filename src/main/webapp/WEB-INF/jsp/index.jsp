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
            <jsp:include page="navbar.jsp"/>
        </header>

        <main class="container position-absolute top-50 start-50 translate-middle">
            <c:choose>
                <c:when test="${sessionScope.user.isActive.equals(true)}">
                    <h1 class="text-center">Welcome ${sessionScope.user.username}!</h1>
                    <c:choose>
                        <c:when test="${sessionScope.user.isAdmin.equals(true)}">
                            <h3 class="text-center">Please use navigation bar on the top for administration.</h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="text-center">Please select topic to take quiz.</h3>
                            <c:forEach var="type" items="${quizTypes}">
                                <p class="text-center">
                                    <a class="btn btn-lg btn-primary col-5 my-2" href="quiz/${type.id}">${type.name}</a>
                                </p>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <h1 class="text-center">Welcome ${sessionScope.user.username}!</h1>
                    <h3 class="text-center">Your account is suspended. Please contact admin.</h3>
                </c:otherwise>
            </c:choose>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="./util/script.js"></script>
    </body>
</html>