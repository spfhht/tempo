<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty sessionScope.logininfo.manager_id }">
			<div>
				<c:out value="${sessionScope.logininfo.manager_name}" />
				님 환영합니다. 
				<a href="./logout.login?flag=3">로그아웃</a> 
			</div>
		</c:when>
	</c:choose>
</body>
</html>