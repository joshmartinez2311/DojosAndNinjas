<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Dojos And Ninjas Home Page</title>
</head>
<body>
	<div class="container">
 		<h1>All Dojo Locations</h1>
 		<table class="table table-hover" >
 			<thead>
 				<tr>
 					<th>Dojos</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:forEach var="dojo" items="${dojos}">
 					<tr>
 						<!--  use <c:url/> tag to create a hyperlink -->
 						<td><a href="<c:url value='/dojos/${dojo.id}'/>"><c:out value="${dojo.location}"></c:out></a></td>
     				</tr>
 				</c:forEach>
 			</tbody>
 		</table>
 		
 		<div class="container">
 			<h1>Add a Dojo</h1>
 			<form:form action="/dojos" method="post" modelAttribute="dojo">
 				<div class="form-group">
 					<form:label path="location"> Name:</form:label>
 					<form:errors path="location" class="text-danger"/>
 					<form:input path="location" class="form-control"/>
 				</div>
 				<div>
 					<button class="btn btn-success mt-5" type="submit">Create a Dojo</button>
 					
 				</div>
 			</form:form>
 			<a href="/ninja" class="btn btn-success mt-5">Create a Ninja</a>
 		</div>
	</div>











</body>
</html>