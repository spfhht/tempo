<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 상태 변경 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>배송 상태 변경 페이지</h1>
			<p class="formSign">배송 상태 변경 페이지</p>
			<form id="joinForm"
				action="./updatedelstate.parcelmanagement?manager_id=<c:out value="${manager_id}"/>&delivery_id=<c:out value="${delivery_id }" />"
				method="post">

				<input type="hidden" name="delivery_id"
					value="<c:out value="${delivery_id }" />">

				<input type="hidden" name="id"
					value="<c:out value="${manager_id }" />">

				<fieldset>
					<legend>배송 상태 변경</legend>
					<p>
						<label for="name">운송장번호</label>
						<br />
						<c:out value="${delivery_id }" />
					</p>
					<p>
						<label for="del_state_id">배송상태</label>
						<br /> <select name="del_state_id">
							<option value="0" selected>예약 대기</option>
							<option value="1">예약 완료</option>
							<option value="2">수령 완료</option>
							<option value="3">배송 대기</option>
							<option value="4">배송중</option>
							<option value="5">배송 완료</option>
						</select> 현재 상태 :
						<c:out value="${parcelList.delivery_state }" />
					</p>
					<p>
						<label for="content">위치</label>
						<br />
						<c:out value="${parcelList.f_gps}" />
					</p>
					<p>
						<label for="content">수화물 종류</label>
						<br />
						<c:out value="${parcelList.p_kind_name}" />
					</p>
					<p>
						<label for="content">보내는사람</label>
						<br />
						<c:out value="${parcelList.p_s_name}" />
					</p>
					<p>
						<label for="content">보내는사람 주소</label>
						<br />
						<c:out value="${parcelList.p_s_address}" />
					</p>
					<p>
						<label for="content">받는사람</label>
						<br />
						<c:out value="${parcelList.p_r_name}" />
					</p>
					<p>
						<label for="content">받는주소</label>
						<br />
						<c:out value="${parcelList.p_r_address}" />
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">배송 상태 수정 완료</button>
						<button type="reset" class="btnOk">취소</button>
						<button type="button" value="button"
							onclick="location.href='./parcellist.parcelmanagement?manager_id=<c:out value="${manager_id}"/>'"
							class="btnOk">목록</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>