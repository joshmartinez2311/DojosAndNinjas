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
<title>Ninjas Dojo Location</title>
</head>
<body>
<div class="container col-6">
	<h1><c:out value="${dojo.location}"></c:out> Location Ninjas</h1>
 		<table class="table table-hover" >
 			<thead>
 				<tr>
 					<th>First Name</th>
 					<th>Last Name</th>
 					<th>age</th>
 					<th>action</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:forEach var="ninja" items="${ninjas}">
 					<tr>
 						<td><c:out value="${ninja.firstName}"></c:out></td>
 						<td><c:out value="${ninja.lastName}"></c:out></td>
 						<td><c:out value="${ninja.age}"></c:out></td>
     					<!-- both dojo.id and ninja.id need to be pass in order to delete  -->
     					<td><a href="/ninja/delete/${dojo.id}/${ninja.id}">Delete</a></td>
     				</tr>
 				</c:forEach>
 			</tbody>
 		</table>
		<a href="/dojos/new">Go Back</a>
</div>
</body>
</html>