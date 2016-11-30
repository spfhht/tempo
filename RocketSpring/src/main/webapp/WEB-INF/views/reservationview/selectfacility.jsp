<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>집하장 선택</title>
<link rel="stylesheet" type="text/css"
	href="css/corp.css">

</head>
<body>
	<div id="contentArea">

		<section id="titlename" class="corpList">
			<c:choose>
				<c:when test="${empty facList }">
					<div id="infoArea">
						<section class="search">
							<form name="search"
								action="./facsearch.reservation" method="get">
								<fieldset>
									<input type="hidden" name="sender_name"
										value="${param.sender_name }"> <input type="hidden"
										name="sender_address" value="${param.sender_address }">
									<input type="hidden" name="sender_detail_address"
										value="${param.sender_detail_address }"> <input
										type="hidden" name="sender_tel" value="${param.sender_tel }">
									<input type="hidden" name="receiver_name"
										value="${param.receiver_name }"> <input type="hidden"
										name="receiver_address" value="${param.receiver_address }">
									<input type="hidden" name="receiver_tel"
										value="${param.receiver_tel }"> <input type="hidden"
										name="p_kind_list" value="${param.p_kind_list }"> <input
										type="hidden" name="is_fragile" value="${param.is_fragile }">

									<legend>검색</legend>
									<label for="keyword"></label> <input type="search" id="keyword"
										name="keyword" placeholder="ex)구로">
									<button type="submit">검색</button>
								</fieldset>
							</form>
						</section>
					</div>
				</c:when>
				<c:otherwise>
					<div id="infoArea">
						<section class="search">
							<form name="search"
								action="./facsearch.reservation" method="get">
								<fieldset>
									<input type="hidden" name="sender_name"
										value="${param.sender_name }"> <input type="hidden"
										name="sender_address" value="${param.sender_address }">
									<input type="hidden" name="sender_detail_address"
										value="${param.sender_detail_address }"> <input
										type="hidden" name="sender_tel" value="${param.sender_tel }">
									<input type="hidden" name="receiver_name"
										value="${param.receiver_name }"> <input type="hidden"
										name="receiver_address" value="${param.receiver_address }">
									<input type="hidden" name="receiver_tel"
										value="${param.receiver_tel }"> <input type="hidden"
										name="p_kind_list" value="${param.p_kind_list }"> <input
										type="hidden" name="is_fragile" value="${param.is_fragile }">

									<legend>검색</legend>
									<label for="keyword"></label> <input type="search" id="keyword"
										name="keyword" placeholder="ex)구로">
									<button type="submit">검색</button>
								</fieldset>
							</form>
						</section>
					</div>
					<form action="./do.reservation" method="get"
						enctype="application/x-www-form-urlencoded">
						<input type="hidden" name="sender_name"
							value="${sender_name }"> <input type="hidden"
							name="sender_address" value="${sender_address }"> <input
							type="hidden" name="sender_detail_address"
							value="${sender_detail_address }"> <input
							type="hidden" name="sender_tel" value="${sender_tel }">
						<input type="hidden" name="receiver_name"
							value="${receiver_name }"> <input type="hidden"
							name="receiver_address" value="${receiver_address }">
						<input type="hidden" name="receiver_tel"
							value="${receiver_tel }"> <input type="hidden"
							name="p_kind_list" value="${p_kind_list }"> <input
							type="hidden" name="is_fragile" value="${is_fragile }">
							



						<table class="boardTable">
							<thead>
								<tr>
									<th scope="col" class="corpNumber">선택</th>
									<th scope="col" class="corpName">이름</th>
									<th scope="col" class="corpId">주소</th>
									<th scope="col" class="corpId">전화번호</th>
									<th scope="col" class="corpId">관리자이름</th>
									<th scope="col" class="corpId">분류</th>
									<th scope="col" class="corpId">위치</th>

								</tr>
							</thead>
							<c:forEach var="fac" items="${facList}">
								<tr>
									<td><input type="radio" name="fac" value="${fac.f_id }" /></td>
									<td><c:out value="${fac.f_name }"></c:out></td>
									<td><c:out value="${fac.f_address }"></c:out></td>
									<td><c:out value="${fac.f_tel }"></c:out></td>
									<td><c:out value="${fac.manager_name }"></c:out></td>
									<td><c:out value="${fac.f_kind_name }"></c:out></td>
									<td><c:out value="${fac.f_gps }"></c:out></td>
								</tr>
							</c:forEach>
						</table>

						<input type="submit" value="택배예약" />


					</form>
				</c:otherwise>
			</c:choose>
		</section>
	</div>

</body>
</html>