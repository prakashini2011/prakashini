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
<!--<c:url var="storepizza" value="savepizza"/>-->
  <form:form id="st1" modelAttribute="Product" method="post" action="storepizza" enctype="multipart/form-data">
    <form:hidden style="visibility:hidden" path="id" value="${product.id}" />
      <tr><td><form:label path="name">product Name :</form:label></td>
               <td><form:input path="name" value="${product.Name}"/></td>
           </tr>
               <tr><td><form:label path="price">product Price :</form:label></td>
               <td><form:input path="price" value="${product.Price}"/></td>
           </tr>
           <tr><td><form:label path="description">Discription :</form:label></td>
               <td><form:input path="description" value="${product.Description}"/></td>
           </tr>
           
           <tr><td><form:label path="style">Style :</form:label></td>
               <td><form:input path="style" value="${product.Style}"/></td>
           </tr>
               <tr><td><form:label path="lifespan">lifespan :</form:label></td>
               <td><form:input path="lifespan" value="${product.lifespan}"/></td>
           </tr>
           <tr><td><form:label path="primaryMeterial">Primary Meterial :</form:label></td>
               <td><form:input path="primaryMeterial" value="${product.primaryMeterial}"/></td>
           </tr>
           </tr>
               <tr><select name="capacity">
<option value="regular">Regular</option>
<option value="medium">Medium</option>
<option value="large">Large</option>
</select>
               <td><form:input path="capacity" value="${product.capacity}"/></td>
           </tr>           
           <tr><td><form:label path="img">product Image :</form:label></td>
               <td><form:input path="img" type="file" />
               <font color="red"><form:errors path="img"></form:errors></font></td><tr>
           
           
               <tr><td></td>
               <td><input type="submit" value="submit"/></td>
           </tr>
           
                      
  </form:form>   
<%@ include file="/WEB-INF/views/footer.jsp" %>    
</body>
</html>
