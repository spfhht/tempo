<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>택배 예약</title>
<link rel="stylesheet" type="text/css" href="css/corp.css">
</head>
<body>
	<div id="contentArea">
		<section id="titlename">
			<h1>택배 예약</h1>


			<form action="./selectfac.reservation" method="get" id="joinForm"
				enctype="application/x-www-form-urlencoded" name="boardform">
				<fieldset>
					<p>
						<label for="sender_name">보내는 분 이름 : </label> <input type="text"
							name="sender_name"
							value="<c:out value = "${sessionScope.logininfo.m_name }"/>">
					</p>
					<p>
						<label for="sender_address">보내는 분 주소 : </label> <input type="text"
							name="sender_address"
							value="<c:out value = "${sessionScope.logininfo.m_address }"/>">
					</p>
					<p>
						<label for="sender_detail_address">보내는 분 상세 주소 : </label> <input
							type="text" name="sender_detail_address"
							value="<c:out value = "${sessionScope.logininfo.m_detail_address }"/>">
					</p>

					<p>
						<label for="sender_tel">보내는 분 연락처 : </label> <input type="text"
							name="sender_tel" value="<c:out value = "${sessionScope.logininfo.m_tel }"/>">
					</p>
					<p>
						<label for="receiver_name">받는 분 이름 : </label> <input type="text"
							name="receiver_name">
					</p>
					<p>
						<label for="receiver_address">받는 분 주소 : </label> <input
							type="text" name="receiver_address">
					</p>
					<p>
						<label for="receiver_tel">받는 분 연락처 : </label> <input type="text"
							name="receiver_tel">
					</p>
					<p>

						<label for="p_kind_list">수화물 종류</label><br>
						<c:forEach var="parcel_kind" items="${p_kind_List }">
							<input type="radio" name="p_kind_list"
								value="${parcel_kind.p_kind_id }" />
							<c:out value="${parcel_kind.p_kind_name }" />&nbsp
						</c:forEach>
					</p>
					<p>
						<label for="is_fragile">깨지기 쉬운가요? </label> <br><input type="radio"
							name="is_fragile" value="1" />예&nbsp <input type="radio"
							name="is_fragile" value="0">아니오
					</p>
					<div class="btnJoinArea">

						<button type="submit" class="btnOk">다음</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>