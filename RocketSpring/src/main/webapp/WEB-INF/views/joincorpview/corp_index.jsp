<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>스프링 게시판</h3>
	<spring:hasBindErrors name="LoginModel" />
	<form:errors path="LoginModel" />
	<form action="login.do" method="post">
		<fieldset>
			<label for="userId">메일주소 : </label> <input type="text" id="userId"
				name="userId" class="loginInput" value="${userId}" /> <span
				class="error"><form:errors path="LoginModel.userId" /></span><br />
			<label for="userPw">비밀번호 : </label> <input type="password"
				id="userPw" name="userPw" class="loginInput" /> <span class="error"><form:errors
					path="LoginModel.userPw" /></span><br /> <br />
			<center>
				<input type="submit" value="로그인" class="submitBt" /><br /> <br />
				<a href="<%=request.getContextPath()%>/joincorpview/join.do">회원가입</a>
			</center>
		</fieldset>
	</form>

</body>
</html>