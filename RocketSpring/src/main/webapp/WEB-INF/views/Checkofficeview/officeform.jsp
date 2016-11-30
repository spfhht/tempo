<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영업소 검색</title>
<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<div id="infoArea">
				<section class="search">
					<form name="search" action="./check.office" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label> <select name="keyfield"
								class="b_search">
								<option value="all" selected="selected">전체 검색</option>
								<c:forEach var="corp" items="${corpList }">
									<option value="${corp.c_id }"
										<c:if test="${corp.c_id == keyfield}"></c:if>><c:out
											value="${corp.c_name }"></c:out></option>
								</c:forEach>
							</select>
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div>
			<p class = "allpost"></p>
			<form>
				<table class="boardTable">
					<tr>
						<th scope="col" class="corpNumber">택배회사명</th>
						<th scope="col" class="corpName">관리자명</th>
						<th scope="col" class="corpId">영업소명</th>
						<th scope="col" class="corpId">주소</th>
						<th scope="col" class="corpId">전화번호</th>
						<th scope="col" class="corpId">위 치</th>
					</tr>
					<c:forEach var="list" items="${check}">
						<tbody>
							<tr>
								<td><a
									href="./detail.office?c_id=<c:out value="${list.c_id}" />&f_id=<c:out value="${list.f_id}" />"><c:out
											value="${list.c_name}" /></a></td>
								<td><c:out value="${list.manager_name}" /></td>
								<td><c:out value="${list.f_name}" /></td>
								<td><c:out value="${list.f_address}" /></td>
								<td><c:out value="${list.f_tel}" /></td>
								<td><c:out value="${list.f_gps}" /></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</form>
		</section>
	</div>
</body>
</html>