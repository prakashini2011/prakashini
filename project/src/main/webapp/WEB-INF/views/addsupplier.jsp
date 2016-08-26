<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   
  <script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
           </ul>
  </div>
</nav>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addsupplier" value="addsupplier"></c:url>
   <form:form commandName="Supplier" method="post" action="storesupplier" enctype="multipart/form-data">
       <table class="table table-bordered" >
   
           
           <tr><td><form:label path="name">name :</form:label></td>
               <td><form:input path="name"/>
               <font color="red"><form:errors path="name"></form:errors></font></td>
           </tr>
            <tr><td><form:label path="address">address :</form:label></td>
               <td><form:input path="address"/>
               <font color="red"><form:errors path="address"></form:errors></font></td>
           </tr> 
             
           
           <td><input type="submit" value="add" class="btn"/></td>
           </tr>
           
           </table>
       </form:form> 
 <%@ include file="/WEB-INF/views/footer.jsp" %>
    
 </body>
  </html>