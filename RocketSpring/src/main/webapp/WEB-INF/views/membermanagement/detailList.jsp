<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로켓배송 회원정보</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>일반회원 상세정보</h1>
			<p class="formSign">상세 회원정보</p>
			<div id="joinForm">
				<input type="hidden" name="m_id"
					value="<c:out value="${command.m_id }" />">
				<fieldset>
					<legend>회원 정보</legend>
					<p>
						<label for="m_id">아이디 : </label><br/>
						<c:out value="${command.m_id }" />
					</p>
					<p>
						<label for="m_name">이름 : </label><br/>
						<c:out value="${command.m_name }" />
					</p>
					<p>
						<label for="m_tel">전화번호 : </label><br/>
						<c:out value="${command.m_tel}" />
					</p>
					<p>
						<label for="m_address">주소 : </label><br/>
						<c:out value="${command.m_address }" />
					</p>
					<p>
						<label for="m_detail_address">상세주소 : </label><br/>
						<c:out value="${command.m_detail_address }" />
					</p>
					<p>
						<label for="m_birth"> 생년월일 : </label><br/>
						<c:out value="${command.m_birth }" />
					</p>
					<p>
						<label for="m_email">이메일 : </label><br/>
						<c:out value="${command.m_email }" />
					</p>
					<div class="btnJoinArea">
						<button type="button" value="button"
							onclick="location.href='./Member.AmmDo?page=1'" class="btnOk">목록</button>
					</div>
				</fieldset>
			</div>
		</section>
	</div>
</body>
</html>