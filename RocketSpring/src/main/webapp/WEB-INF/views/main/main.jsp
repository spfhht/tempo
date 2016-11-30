<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>김정은의 로켓배송!!</title>
<style type="text/css">
#div_root {
	margin: auto;
	width: 100%;
	padding: 0px;
}

#div_login {
	position: relative;
	top: 20%;
	height: 20px;
	float: left;
	width: 100%;
	top: 10%;
}

#div_menu {
	position: relative;
	top: 20%;
	height: 200px;
	float: left;
	width: 100%;
}

#div_con {
	position: relative;
	top: 200%;
	height: 500px;
	float: left;
	width: 100%;
}

#div_footer {
	position: absolute;
	bottom: 0px;
}
</style>
<c:choose>
	<c:when test="${empty flag }">
		<link rel="shortcut icon" href="icon/rocket_icon.ico"
			type="image/x-icon" />
	</c:when>
	<c:otherwise>
		<link rel="shortcut icon" href="icon/rocket_icon.ico"
			type="image/x-icon" />
	</c:otherwise>
</c:choose>
</head>
<body>
			<div id="div_root" style="position: absolute;">
				<div id="div_login">
					<jsp:include page="./topoftop.jsp"></jsp:include>
				</div>
				<div id="div_menu">
					<jsp:include page="./top.jsp"></jsp:include>
				</div>
				<div id="div_con">
					<jsp:include page="./center.jsp"></jsp:include>
				</div>
				<div id="div_footer">
					<jsp:include page="./footer.jsp"></jsp:include>
				</div>
			</div>
</body>
</html>