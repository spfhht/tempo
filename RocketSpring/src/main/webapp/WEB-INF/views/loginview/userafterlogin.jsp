<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user-logging-in</title>
<script type="text/javascript">
	alert('환영합니다.');
</script>
</head>
<body>
	<form action="./logout.login" method = "post" enctype="application/x-www-form-urlencoded">
		<fieldset>
			<table>
				<tr>
					<td><c:out value = "${sessionScope.logininfo.m_name}"/>님 환영합니다.</td>
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
</form>이용재덜이
	
	<a href = "./myinfointro.info">회원정보수정</a>
	<a href = "./withdrawal.info">회원탈퇴</a>
	<a href = "./reservationview/tmpstart.jsp">택배예약</a>
</body>
</html>