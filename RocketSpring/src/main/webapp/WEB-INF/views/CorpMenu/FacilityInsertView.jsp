
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시설물 정보 입력</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>시설물 정보 입력</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="InsertFacility.facility" id="joinForm" method="post">
				<fieldset>
					<legend>시설물 정보 입력 폼</legend>
					<p>
						<label for="f_id">ID <strong class="require">필수</strong></label> <input
							type="text" id="f_id" name="f_id" required placeholder="아이디">
					</p>
					<p>
						<label for="f_name">시설물 이름 <strong class="require">필수</strong></label>
						<input type="text" id="f_name" name="f_name" required
							placeholder="시설물 이름">
					</p>
					<p>
						<label for="f_address">시설물 주소 <strong class="require">필수</strong></label>
						<input type="text" id="f_address" name="f_address" required
							placeholder="시설물 주소">
					</p>
					<p>
						<label for="f_tel">시설물 전화번호 <strong class="require">필수</strong></label>
						<input type="text" id="f_tel" name="f_tel" required
							placeholder="시설물 전화번호">
					</p>
					<p>
						<label for="f_gps">시설물 위치 <strong class="require">필수</strong></label>
						<input type="text" id="f_gps" name="f_gps" required
							placeholder="시설물 위치">
					</p>
					<p>
						<label for="manager_id">관리자 ID <strong class="require">필수</strong></label>
						<input type="text" id="manager_id" name="manager_id" required
							placeholder="관리자 ID">
					</p>
					<p class="radiocheck">
						<label for="f_kind_id">시설물 종류 <strong class="require">필수</strong></label>
						1. 집하장 <input type="radio" id="factory" name="f_kind_id" value="1">
						2. 차량 <input type="radio" id="car" name="f_kind_id" value="2">
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">입력 하기</button>
						<button type="button" value="button"
							onclick='history.back(); return false;' class="btnOk">뒤로가기</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>