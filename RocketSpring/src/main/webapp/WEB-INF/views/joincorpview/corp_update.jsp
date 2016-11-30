<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회사 관리</title>
<link href="<%=request.getContextPath()%>/css/corp.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1> <c:out value="${joinCorpDto.c_id}"/> 회사 정보 수정</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="modify.joincorp" method="post" id="joinForm"
				name="modifyform">

				<input type="hidden" name="c_num" value="<c:out value="${joinCorpDto.c_num}"/>" />
				<input type="hidden" name="c_id" value="<c:out value="${joinCorpDto.c_id}"/>" />
				<input type="hidden" name="join_date" value="<c:out value="${joinCorpDto.join_date}"/>" />
				
				<fieldset>
					<legend>회사정보 수정</legend>
					
					<p>
						<label for="c_name">이름 </label> <input type="text" id="c_name"
							name="c_name" value="<c:out value="${joinCorpDto.c_name}"/>" />
					</p>
					<p>
						<label for="c_pwd">비밀번호 <strong class="require">필수</strong></label>
						<input type="password" id="c_pwd" name="c_pwd" required
							placeholder="비밀번호 입력" size="12">
					</p>
					<p>
						<label for="c_tel">전화번호 </label> <input type="text" id="c_tel"
							name="c_tel" value="<c:out value="${joinCorpDto.c_tel}"/>" />
					</p>
					<p>
						<label for="c_address">주소 </label> <input type="text" id="c_address"
							name="c_address" value="<c:out value="${joinCorpDto.c_address}"/>" />
					</p>
					
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">수정</button>
						<button type="reset" class="btnCancel">취소</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>