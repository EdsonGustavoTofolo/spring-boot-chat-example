<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
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
      <a class="navbar-brand" href="#">Web Socket Samples</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
    </ul>
  </div>
</nav>

<div class="container">
  <h2>Web Socket Samples</h2>
  <ul class="list-group">
    <li class="list-group-item"><a href="<c:url value="/web-sock" />">Plain Web Socket: Group broadcast chat</a> </li>
    <li class="list-group-item"><a href="<c:url value="/chatbot" />">Web Socket Stomp JS Chat : Group broadcast chat</a> </li>
    <li class="list-group-item"><a href="<c:url value="/msg-forward/chatbot" />">Web Socket Stomp JS Chat : User to user chat</a> </li>
    <li class="list-group-item"><a href="<c:url value="/sse/add-notification" />">EventSource, SseEmitter Add Notification</a> </li>
    <li class="list-group-item"><a href="<c:url value="/sse/get-notification" />">EventSource, SseEmitter get Notification</a> </li>
  </ul>
</div>
</body>
</html>
