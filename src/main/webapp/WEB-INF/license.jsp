<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>Add License</title>
</head>
<body class="pl-5 pt-3">
	<h4 class="display-4"><u>New License</u></h4>
	<br>
	
	<form:form action="/license/new" method="POST" modelAttribute="license">
	
		<p>
			<form:label path="person">Person</form:label>
			<form:select path="person">
				<c:forEach items="${persons}" var="person" >
					<form:option value="${person}"> ${person.firstName} ${person.lastName} </form:option>
				</c:forEach>
			
			</form:select>
		</p>
		<p><form:errors path="state" /></p>
		<p>
			<form:label  path="state">State</form:label>
			<form:input  path="state"/>
		</p>
		<p><form:errors path="expiration_date"/></p>
		<p>
			<form:label path="expiration_date">Expiration Date</form:label>
			<form:input type="date"  path="expiration_date"/>
		</p>
			<input type=hidden value=0 name=number>

		
		<button type="submit">Create</button>
	</form:form>
  </body>
</body>
</html>