<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/corp.css">
</head>
<body>

	<div id="contentsArea">
		<section id="titlename">
			<h1>비밀번호 확인</h1>
			<form id="joinForm" name="deleteForm" action="./Withdrawaldo.info"
				method="post" enctype="application/x-www-form-urlencoded">
				<fieldset>
					<p>
						<label for="password">비밀번호 :</label> <input type="password"
							id="password" name="pwd" required />
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">탈퇴하기</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>

</body>
</html>