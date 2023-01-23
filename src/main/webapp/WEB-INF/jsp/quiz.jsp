<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

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
    <h1 class="text-center m-4">${quizType.getName()} Quiz</h1>

    <form:form action="/result" method="post" modelAttribute="tempAnswer">
        <div class="row">
            <div class="col-3 text-center">
                <div id="list-tab" class="list-group" role="tablist">
                    <c:forEach var="i" begin="1" end="10">
                        <a
                            class="list-group-item list-group-item-action ${i == 1 ? 'active' : ''}"
                            id="question${i}-list"
                            href="#question${i}"
                            data-bs-toggle="list"
                            role="tab"
                            aria-controls="question${i}"
                        >
                            Question ${i}
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content">
                    <c:forEach begin="0" end="9" var="report" items="${reports}" varStatus="loop">
                        <div class="tab-pane fade ${loop.index == 0 ? 'show active' : ''}"
                             id="question${loop.index + 1}"
                             role="tabpanel"
                             aria-labelledby="question${loop.index+1}-list"
                        >
                            <p>${loop.index+1}. ${report.getQuestion().getDescription()}</p>
                            <c:forEach var="choice" items="${report.getQuestion().getChoice()}">
                                <div class="form-check m-3">
                                    <label class="form-check-label">
                                    <form:radiobutton path="answer${loop.index+1}" class="form-check-input" value="${choice.getDescription()}" />
                                            ${choice.getDescription()}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <p class="text-center">
            <input type="submit" class="btn btn-lg btn-primary m-3" value="Submit Quiz">
        </p>
    </form:form>

</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>