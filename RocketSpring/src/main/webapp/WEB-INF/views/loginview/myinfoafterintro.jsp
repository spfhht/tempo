<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<c:choose>
		<c:when test="${success eq 'true' }">
			<c:redirect url = "./myinfo.info"/>
		</c:when>
		<c:otherwise>
			<c:redirect url = "./myinfointro.info"/>
		</c:otherwise>
	</c:choose>
</body>
</html>