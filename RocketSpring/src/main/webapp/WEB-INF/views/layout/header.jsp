<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css_test/header.css">
</head>
<body>
	<div id="header-container">
		<div id="header-left" class="layout">
			<a href="http://localhost/KimsRocketDelivery2/main/main.jsp"
				title="로켓배송 메인화면으로 가기"><img src="images/logo.jpg"
				alt="로켓배송 사이트 로고" /></a>
		</div>
		<div id="header-center" class="layout">
			<h1>김정은의 로켓 배송</h1>
		</div>
		<div id="header-right" class="layout">
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<div>
						<div align="right">
							<a href="#">회원가입</a> <a href="../loginview/userlogin.jsp">로그인</a>
						</div>
					</div>
				</c:when>
				<c:when test="${sessionScope.group == 0 }">
					<div>
						<div align="right">
							[
							<c:out value="${sessionScope.name }" />
							]님 <a href="../loginview/userafterlogin.jsp">My Page</a> <a
								href="../Logout.ldo?flag=1">로그아웃</a>
						</div>
					</div>
				</c:when>
				<c:when test="${sessionScope.group == 1 }">
					<div>
						<div align="right">
							[회원] &nbsp
							<c:out value="${sessionScope.name }" />
							님 <a href="../loginview/userafterlogin.jsp">My Page</a> <a
								href="../Logout.ldo">로그아웃</a>
						</div>
					</div>
				</c:when>
				<c:when test="${sessionScope.group == 2 }">
					<div>
						<div align="right">
							[회사] &nbsp
							<c:out value="${sessionScope.name }" />
							님 <a href="../Logout.ldo?flag=1">로그아웃</a>
						</div>
					</div>
				</c:when>
				<c:when test="${sessionScope.group == 3 }">
					<div>
						<div align="right">
							[회사 관리자] &nbsp
							<c:out value="${sessionScope.name }" />
							님 <a href="../Logout.ldo?flag=1">로그아웃</a>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>

