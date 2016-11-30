<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시설물 정보 입력</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<link rel="stylesheet" type="text/css" href="../css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>관리자 정보 입력</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="../doinsert.cmmdo" id="joinForm" method="post">
				<fieldset>
					<legend>관리자 정보 입력 폼 </legend>
					<p>
						<label for="name">이름 <strong class="require">필수</strong></label> <input
							type="text" name="name" required placeholder="이름">
					</p>
					<p>
						<label for="id">아아디<strong class="require">필수</strong></label> <input
							type="text" name="id" required placeholder="아이디">
					</p>
					<p>
						<label for="pwd">비밀번호<strong class="require">필수</strong></label> <input
							type="password" name="pwd" required placeholder="비밀번호">
					</p>
					<p>
						<input type="hidden" name="corp" value="${sessionScope.id}">
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">등록</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>