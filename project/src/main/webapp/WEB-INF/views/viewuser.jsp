<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
   <body>
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
            <li><a href="contactus">Contact us</a></li>
      <li><a href="logout">Logout</a></li>
          </ul>
  </div>
</nav>
 <h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
      <div class="container">
            <table class="table table-hover table-bordered">
            <tr><td rowspan="5">
            <img src='<x:url value="/resources/images/${Product.image}"/>'/></td></tr>
            <tr><td>${Product.id}</td></tr>
            <tr><td>${Product.name}</td></tr>
            <tr><td>${Product.price}</td></tr>
            <tr><td>${Product.description}</td></tr>
            </table>
      </div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
   </body>
</html>