

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.delivery.rocket.corp.facility.dto.FacilityDto"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 목록보기</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/jboard.css">
</head>
<body>

	<div id="contentsArea">
		<section id="titlename">
		<h1>시설물 목록</h1>
		<p class="formSign">시설물 전체 목록</p>
		<div id="joinForm">


			<fieldset>
				<legend>게시판 내용</legend>
			</fieldset>
		</div>
		<table class="boardTable">
			<caption>게시판 리스트</caption>
			<thead>
				<tr>
					<th scope="col" class="bbsAuthor">아이디</th>
					<th scope="col" class="bbsAuthor">이름</th>
					<th scope="col" class="bbsAuthor">주소</th>
					<th scope="col" class="bbsAuthor">전화번호</th>
					<th scope="col" class="bbsAuthor">위치</th>
					<th scope="col" class="bbsAuthor">매니저ID</th>
					<th scope="col" class="bbsAuthor">매니저이름</th>
					<th scope="col" class="bbsAuthor">시설물 종류ID</th>
					<th scope="col" class="bbsAuthor">시설물 종류명</th>

				</tr>
			</thead>
			<c:forEach var="list" items="${list}" varStatus="status">
				<tbody>
					<tr>
						<td><c:out value="${list.f_id}" /></td>
						<td><c:out value="${list.f_name}" /></td>
						<td><c:out value="${list.f_address}" /></td>
						<td><c:out value="${list.f_tel}" /></td>
						<td><c:out value="${list.f_gps}" /></td>
						<td><c:out value="${list.manager_id}" /></td>
						<td><c:out value="${list.manager_name}" /></td>
						<td><c:out value="${list.f_kind_id}" /></td>
						<td><c:out value="${list.f_kind_name}" /></td>

					</tr>
				</tbody>
			</c:forEach>
		</table>

<div class="btnJoinAreb">
					<button type="button" value="button"
						onclick='history.back(); return false;' class="btnOk">뒤로 가기</button>

				</div>


		</section>
	</div>


</body>
</html>