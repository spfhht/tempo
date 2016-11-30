<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 페이지</title>

<link rel="shortcut icon"
	href="icon/rocket_icon.ico" type="image/x-icon" />


</head>
<body>
	<div>
		<div>
			<div id="div_login" align="right">
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
	</div>
</body>
</html>