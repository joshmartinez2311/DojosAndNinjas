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
<title>Save Travels Home Page</title>
</head>
<body>
	<div class="container justify-content-center">
		<div class="col-4">
	 		<h1>Enroll a Ninja</h1>
	 			<form:form action="/ninja/new" method="post" modelAttribute="ninja">
	 				<div class="form-group">
	 					<form:label path="dojo">Dojo:</form:label>
	 					<form:errors path="dojo" class="text-danger"/>
	 					<form:select path="dojo" class="form-control">
	 						
	 						<c:forEach var="dojo" items="${dojos}">
	 							<option value="${dojo.id}"> <c:out value="${dojo.location}"/> </option>
	 						</c:forEach>
	 					</form:select>
	 				</div>
	 				<div class="form-group">
	 					<form:label path="firstName">First Name:</form:label>
	 					<form:errors path="firstName" class="text-danger"/>
	 					<form:input path="firstName" class="form-control"/>
	 				</div>
	 				<div class="form-group">
	 					<form:label path="lastName">Last Name:</form:label>
	 					<form:errors path="lastName" class="text-danger"/>
	 					<form:input path="lastName" class="form-control"/>
	 				</div>
	 				<div class="form-group">
	 					<form:label path="age">age:</form:label>
	 					<form:errors path="age" class="text-danger"/>
	 					<form:input path="age"  class="form-control"/>
	 				</div>
	 				<div>
	 					<input class="btn btn-primary mt-5" type="submit"/>
	 				</div>
 			</form:form>
 		</div>
 	</div>		
 </body>
</html>