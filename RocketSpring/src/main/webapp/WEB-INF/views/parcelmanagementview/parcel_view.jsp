<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수화물 상세 정보</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>수화물 정보</h1>
			<p class="formSign">수화물의 상세 정보 입니다.</p>
			<div id="joinForm"> 
				
					<fieldset>
						<legend>회사 정보</legend>
						<p>
							<label for="name">운송장번호</label> <br />
							<c:out value="${delivery_id }" />
						</p>
						<p>
							<label for="subject">배송상태</label> <br />
							<c:out value="${pacelList.delivery_state }" />
						</p>
						<p>
							<label for="content">위치</label> <br />
							<c:out value="${pacelList.f_gps}" />
						</p>
						<p>
							<label for="content">수화물 종류</label> <br />
							<c:out value="${pacelList.p_kind_name}" />
						</p>
						<p>
							<label for="content">보내는사람</label> <br />
							<c:out value="${pacelList.p_s_name}" />
						</p>
						<p>
							<label for="content">보내는사람 주소</label> <br />
							<c:out value="${pacelList.p_s_address}" />
						</p>
						<p>
							<label for="content">받는사람</label> <br />
							<c:out value="${pacelList.p_r_name}" />
						</p>
						<p>
							<label for="content">받는주소</label> <br />
							<c:out value="${pacelList.p_r_address}" />
						</p>																	
						<div class="btnJoinArea">
							<a href="./updatedelstate.parcelmanagement?delivery_id=<c:out value="${delivery_id }" />&manager_id=<c:out value="${manager_id}"/>">
								<button type="button" class="btnOk">배송상태수정</button>
							</a> 
							<a href="./parcellist.parcelmanagement?manager_id=<c:out value="${manager_id}"/>">
								<button type="button" class="btnOk">목록보기</button>
							</a>
					</div>
				</fieldset>			
			</div>
		</section>
	</div>
</body>
</html>