<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="nav justify-content-center p-3">
    <c:choose>
        <c:when test="${sessionScope.user.isAdmin.equals(true)}">
            <li class="nav-item">
                <a class="nav-link" href="/admin/users">Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/quizzes">Quizzes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/submissions">Submissions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/feedbacks">Feedbacks</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-item">
                <a class="nav-link" href="/">Quiz</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about">About</a>
            </li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.user != null}">
            <li class="nav-item">
                <a class="nav-link" href="/signout">Sign Out</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-item">
                <a class="nav-link" href="signin">Sign In</a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>