<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/angular.min.js"></c:url>'></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="ret">View All</a></li>
         <li><a href="contactus">Contact us</a></li>
          <li><a href="logout">Logout</a></li>
      </ul>
  </div>
</nav>
<!--<c:url var="storesupplier" value="savesupplier"/>-->
  <form:form id="st1" modelAttribute="Supplier" method="post" action="storesupplier">
    <form:hidden style="visibility:hidden" path="id" value="${supplier.id}" />
      <tr><td><form:label path="name">Supplier Name :</form:label></td>
               <td><form:input path="name" value="${supplier.name}"/></td>
           </tr>
               <tr><td><form:label path="address">Supplier address :</form:label></td>
               <td><form:input path="address" value="${supplier.address}"/></td>
           </tr>
                      
           
               <tr><td></td>
               <td><input type="submit" value="submit"/></td>
           </tr>
           
    
  </form:form>   
  
<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>
