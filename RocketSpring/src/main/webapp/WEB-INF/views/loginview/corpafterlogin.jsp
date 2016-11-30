<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corp logging in</title>
</head>
<body>
		<form action="./logout.login" method = "post" enctype="application/x-www-form-urlencoded">
		<fieldset>
			<table>
				<tr>
					<td><c:out value = "${sessionScope.logininfo.c_name}"/>님 환영합니다.</td>
				</tr>
	<tr>
					<td><input type = "hidden" name = "m_group" value = "${sessionScope.logininfo.m_group }"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type = "submit" value = "로그아웃"/> </td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>