<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<form action="./pwdchangedo.info" method ="post" enctype="application/x-www-form-urlencoded">
	<fieldset>
		<table>		
				<tr>
					<td> 비밀번호 : </td>
					<td> <input type = "password"  name ="pwd" required/></td>
				</tr>
				<tr>
					<td> 비밀번호 확인 : </td>
					<td> <input type = "password"  name = "confirm_pwd" required/></td>
				</tr>
				<tr>
					<td><input type = "submit" value = "비밀번호 변경하기"></td>
				</tr>
		</table>
	</fieldset>
	</form>
</body>
</html>