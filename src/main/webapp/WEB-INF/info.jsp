<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"
	import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>Profile</title>
</head>
<body>
	<h1>
		<c:out value="${license.person.firstName}" />
		<c:out value="${license.person.lastName}" />
	</h1>
	<br>
	<br>

	<p>
		License Number:
		<c:out value="${license.number}" />
	</p>
	<p>
		State:
		<c:out value="${license.state}" />
	</p>
	<p>
		Expiration Date:
		<c:out value="${date}" />
	</p>


</body>
</body>
</html>