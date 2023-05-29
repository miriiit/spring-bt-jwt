<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/api/v1/auth/register">
		 <input type="text" name="firstname" value="${obj.firstname }">
		 <input type="text" name="lastname" value="${obj.lastname }">
		 
		 <input type="text" name="email" value="${obj.email }">
		 <input type="text" name="password" value="${obj.password }">
		 <input type="submit">
		</form>
		
		
		Submitted User is ${obj.firstname }  ${obj.lastname }
</body>
</html>