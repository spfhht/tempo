<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회사 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>수화물 가져오기</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form id="joinForm" name="bringForm" action="./bring.parcelmanagement"  method="post">
				<fieldset>
					<legend>수화물 가져오기</legend>
					<p>
						<label for="realdel">가져오실 수화물의 운송장 번호를 입력하세요<strong class="require">필수</strong></label>
						<input type="text" id="delivery_id" name="delivery_id" size="12" />
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">가져오기</button>
						<button type="reset" class="btnCancel">취소</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>