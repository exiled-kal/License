<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	
	<title>Add Person</title>
</head>
<body>
	<h2>New Person</h2>
	<br>

	
	<form:form action="/persons/new" method="POST" modelAttribute="person">
		<p><form:errors path="firstName" /></p>
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName"/>
			
		</p>
		<p><form:errors path="lastName"/></p>
		<p>
			<form:label  path="lastName">Last Name</form:label>
			<form:input  path="lastName"/>
			
		</p>
		
		<button type="submit" class="btn btn-info">Create</button>
	</form:form>

	
  </body>
</body>
</html>