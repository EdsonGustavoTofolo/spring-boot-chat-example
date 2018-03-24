<%--
  Appication : Spring websocket chat example
  author : Yasitha Thilakaratne
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/main.css"/>"/>
</head>
<body>

<spring:url value="/process_login" var="loginUrl"/>

<div class="container login-box">

    <form action="${loginUrl}" method="post">
        <c:if test="${param.error != null}">
            <p class="login-error">
                Invalid username and password.
            </p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p class="login-error">
                You have been logged out.
            </p>
        </c:if>
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" class="form-control"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn">Log in</button>
        <a class="pull-right" href="<c:url value="/" />">Back</a>
    </form>
</div>
</body>
</html>
