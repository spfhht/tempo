
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>시설물 정보 삭제</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="DeleteFacility.facility" id="joinForm" method="post">
				<fieldset>
					<legend>시설물 정보 삭제 폼</legend>
					<p>
						<label for="f_id">삭제할 시설물 ID <strong class="require">필수</strong></label>
						<input type="text" id="f_id" name="f_id" required
							placeholder="아이디">
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">삭제 하기</button>
						<button type="button" value="button"
							onclick='history.back(); return false;' class="btnOk">뒤로
							가기</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>