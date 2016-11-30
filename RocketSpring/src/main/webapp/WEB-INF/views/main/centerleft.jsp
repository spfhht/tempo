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
		<c:when test="${empty flag }">
			<div class="mainimg">
				<p>
					<img align="left" src="images/rocket_menu.png">
				</p>
			</div>
		</c:when>
		<c:otherwise>
			<div class="mainimg">
				<p>
					<img align="left" src="images/rocket_menu.png">
				</p>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>