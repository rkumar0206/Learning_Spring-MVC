<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		
		<!-- Here Spring will call student.setFirstName() -->
		
		First name: <form:input path="firstName"/>
		
		<br><br>
		
		Last name: <form:input path="lastName"/>
		
		<br><br>
		
		<form:select path="country">
		
		<!-- 
		
			<form:option value="India" label = "India"/>
			<form:option value="France" label = "France"/>
			<form:option value="Germany" label = "Germany"/>
			<form:option value="Brazil" label = "Brazil"/>
			
		 -->
			
			<!-- Setting the values using the java class -->
			
			<form:options items="${student.countryOptions}"/>
			
		</form:select>
		
		<br><br>
		
		Favorite Language <br>
		
		<!-- Here Spring will call student.setFavoriteLanguage() -->
		
		<form:radiobutton path="favoriteLanguage" value="Java"/>Java
		<form:radiobutton path="favoriteLanguage" value="C#"/>C# 
		<form:radiobutton path="favoriteLanguage" value="PHP"/>PHP
		<form:radiobutton path="favoriteLanguage" value="Ruby"/>Ruby
		
		
		<br><br>

		Operating systems : <br>
		
		<form:checkbox path="operatingSystems" value="Linux"/>Linux
		<form:checkbox path="operatingSystems" value="MS Windows"/>MS Windows
		<form:checkbox path="operatingSystems" value="Mac OS"/>Mac OS

		<br><br>
		
		<input type="submit" value="Submit"/>
		
	</form:form>

</body>
</html>