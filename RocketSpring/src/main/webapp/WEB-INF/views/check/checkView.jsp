<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description"
	content="The Overflowing church website's main page" />
<meta name="author" content="unikys@gmail.com" />
<link rel="shortcut icon" href="icon/rocket_icon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/bar.css" />

<title>운송장 번호로 택배 조회</title>
</head>
<body>
	<div class="wrap depth2_default">
		<div class="utill_area">
			<section>
				<h1>택배 조회</h1>
				<table border="1" style="border-collapse: collapse">
					<tr>
						<td align=center>운송장 번호</td>
						<td align=center>보내는 사람 이름</td>
						<td align=center>보내는 사람 주소</td>
						<td align=center>받는 사람 이름</td>
						<td align=center>받는 사람 주소</td>
						<td align=center>보낸 날짜</td>
						<td align=center>받는 날짜</td>
					</tr>
					<tr>
						<td align=center><c:out value="${check.delivery_id }" /></td>
						<td align=center><c:out value="${check.p_s_name }" /></td>
						<td align=center><c:out value="${check.p_s_address }" /></td>
						<td align=center><c:out value="${check.p_r_name }" /></td>
						<td align=center><c:out value="${check.p_r_address }" /></td>
						<td align=center><c:out value="${check.p_s_date }" /></td>
						<td align=center><c:out value="${check.p_r_date }" /></td>
					</tr>
				</table>
				<br />
				<table border="1" style="border-collapse: collapse">
					<tr>
						<td align=center>배송 진행 상황</td>
					</tr>
					<c:choose>
						<c:when test="${check.delivery_state eq '예약대기' }">
							<tr>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">예약
										대기</span></td>
								<td align=center>예약 완료</td>
								<td align=center>수령 완료</td>
								<td align=center>배송 대기</td>
								<td align=center>배송중</td>
								<td align=center>배송 완료</td>
							</tr>
						</c:when>
						<c:when test="${check.delivery_state eq '예약완료' }">
							<tr>
								<td align=center>예약 대기</td>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">예약
										완료</span></td>
								<td align=center>수령 완료</td>
								<td align=center>배송 대기</td>
								<td align=center>배송중</td>
								<td align=center>배송 완료</td>
							</tr>
						</c:when>
						<c:when test="${check.delivery_state eq '수령완료' }">
							<tr>
								<td align=center>예약 대기</td>
								<td align=center>예약 완료</td>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">수령
										완료</span></td>
								<td align=center>배송 대기</td>
								<td align=center>배송중</td>
								<td align=center>배송 완료</td>
							</tr>
						</c:when>
						<c:when test="${check.delivery_state eq'배송대기' }">
							<tr>
								<td align=center>예약 대기</td>
								<td align=center>예약 완료</td>
								<td align=center>수령 완료</td>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">배송
										대기</span></td>
								<td align=center>배송중</td>
								<td align=center>배송 완료</td>
							</tr>
						</c:when>
						<c:when test="${check.delivery_state eq '배송중' }">
							<tr>
								<td align=center>예약 대기</td>
								<td align=center>예약 완료</td>
								<td align=center>수령 완료</td>
								<td align=center>배송 대기</td>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">배송중</span></td>
								<td align=center>배송 완료</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td align=center>예약 대기</td>
								<td align=center>예약 완료</td>
								<td align=center>수령 완료</td>
								<td align=center>배송 대기</td>
								<td align=center>배송중</td>
								<td align=center><span
									style="color: red; border-top: 5px solid red; border-right: 5px solid red; border-bottom: 5px solid red; border-left: 5px solid red;">배송
										완료</span></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
				<br />
				<table border="1" style="border-collapse: collapse">
					<tr>
						<td align=center>위치 정보</td>
					</tr>
					<tr>
						<td align=center>${check.f_gps }</td>
					</tr>
				</table>
			</section>
			<br /> <a href="./return.check">돌아가기</a>
		</div>
	</div>
</body>
</html>