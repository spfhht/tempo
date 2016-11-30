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
	<c:choose>
		<c:when test="${empty sessionScope.logininfo.m_id }">
			<div>
				<div align="right">
					<a href="./usermain?menu=join">회원가입</a> <a href="./user.login">로그인</a>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.logininfo.m_group == '0' }">
			<div>
				<div align="right">
				[
					<c:out value="${sessionScope.logininfo.m_name }" />
					]님  <a
						href="./logout.login?flag=0">로그아웃</a>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.logininfo.m_group == '1' }">
			<div>
				<div align="right">
					[회원] &nbsp
					<c:out value="${sessionScope.logininfo.m_name }" />
					님 <a href="usermain?menu=myinfo">My Page</a> <a
						href="./logout.login?flag=1">로그아웃</a>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.logininfo.m_group == '2' }">
			<div>
				<div align="right">
					[회사] &nbsp
					<c:out value="${sessionScope.logininfo.c_name }" />
					님 <a href="./logout.login?flag=2">로그아웃</a>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.logininfo.m_group == '3'  }">
			<div>
				<div align="right">
					[회사 관리자] &nbsp
					<c:out value="${sessionScope.logininfo.manager_name }" />
					님 <a href="./logout.login?flag=3">로그아웃</a>
				</div>
			</div>
		</c:when>
	</c:choose>
</body>
</html>