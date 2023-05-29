<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="addGround">
		 <input type="text" name="id">
		 <input type="text" name="name">
		 <input type="submit">
		</form>
		
		
		Submitted Ground is ${obj.name }  ${obj.id }
</body>
</html>