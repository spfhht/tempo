<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${empty menu }">
			<div align="left">
				<jsp:include page="./centerleft.jsp"></jsp:include>
			</div>
			<div>
				<iframe width="97%" height="600px"
					src="../loginview/myinfointro.jsp"></iframe>
			</div>
		</c:when>
		<c:when test="${menu eq 'withdrawal' }">
			<div align="left">
				<jsp:include page="./centerleft.jsp"></jsp:include>
			</div>
			<div>
				<iframe width="97%" height="600px" src="../Withdrawal.ldo"></iframe>
			</div>
		</c:when>			
	</c:choose>
</body>
</html>