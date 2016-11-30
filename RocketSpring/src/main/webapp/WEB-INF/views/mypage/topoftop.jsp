<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top of top</title>
</head>
<body>
	<div>
		<div align="right">
			[회원] &nbsp
			<c:out value="${sessionScope.name }" />
			님 <a href="http://localhost/KimsRocketDelivery2/mypage/main.jsp">My
				Page</a> <a href="../Logout.ldo">로그아웃</a>
		</div>
	</div>
</body>
</html>