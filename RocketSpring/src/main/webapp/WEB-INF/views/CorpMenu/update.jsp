<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>널 고쳐주마</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>관리자 수정</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="../update.cmmdo" id="joinForm" method="post">
				<fieldset>
					<legend>관리자 정보 입력 폼 </legend>
					<p>
						<label for="manager_id">아아디<strong class="require">필수</strong></label> 
						<input type="text" name="manager_id" value="${param.manager_id}" readonly>
			
					</p>
					<p>
						<label for="manager_name">이름 <strong class="require">필수</strong></label> 
						<input type="text" name="manager_name" required value="${param.manager_name}">
						<input type="hidden" name="manager_name" value="${param.maganger_name }"> 
					</p>
					<p>
						<label for="manager_pwd">비밀번호<strong class="require">필수</strong></label> 
						<input type="password" name="manager_pwd" required value="${param.manager_pwd}">
						<input type="hidden" name="manager_pwd" value="${param.manager_pwd }"> 
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">수정</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>