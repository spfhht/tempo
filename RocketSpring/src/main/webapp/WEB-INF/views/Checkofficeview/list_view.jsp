<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>거래처 상세정보</h1>
			<p class="formSign">거래처 정보 입니다.</p>
			<div id="joinForm"> 
			
					<fieldset>
						<legend>거래처 정보</legend>
						<p>
							<label for="name">택배회사 : </label> <br />
							<c:out value="${view.c_name}"  />
						</p>
						<p>
							<label for="manager_name">관리자 : </label> <br />
							<c:out value="${view.manager_name}"  />
						</p>
						<p>
							<label for="f_name">영업소명 : </label> <br />
							<c:out value="${view.f_name}"/>
						</p>
						<p>
							<label for="f_address">주 소 : </label> <br />
							<c:out value="${view.f_address}"  />
						</p>
						<p>
							<label for="f_tel">전화번호 : </label> <br />
							<c:out value="${view.f_tel}"  />
						</p>
						<p>
							<label for="f_gps">위 치 : </label> <br />
							<c:out value="${view.f_gps}"  />
						</p>

								
						<div class="btnJoinArea">
							<button type="button" value="button" onclick="location.href='./corplist.office'" class="btnOk">뒤로가기</button>
					</div>
				</fieldset>			
			</div>
		</section>
	</div>
</body>
</html>