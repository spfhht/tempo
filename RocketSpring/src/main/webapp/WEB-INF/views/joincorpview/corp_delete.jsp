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
			<h1>회사 삭제</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form id="joinForm" name="deleteForm" action="./CorpDeleteService.corpdo?c_num=${param.c_num}"  method="post">
				<fieldset>
					<legend>회원 삭제</legend>
					<p>
						<label for="realdel">옆의 글씨를 따라치세요<strong class="require">필수</strong></label>
						<input type="text" id="realdel" name="realdel" required placeholder="delete" size="12" />
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">삭제</button>
						<button type="reset" class="btnCancel">취소</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>