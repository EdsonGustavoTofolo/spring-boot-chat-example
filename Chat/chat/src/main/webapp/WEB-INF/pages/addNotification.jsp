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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Notification sender</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
        </ul>
    </div>
</nav>
<div class="container">
    <form action="<c:url value="/sse/add-event" />" class="form-inline">
            <div class="form-group">
                <label for="data">Notification:</label>
                <input type="text" class="form-control" name="data" id="data">
            </div>
            <button type="submit" class="btn btn-default">Send</button>
    </form>
</div>
</body>
</html>
