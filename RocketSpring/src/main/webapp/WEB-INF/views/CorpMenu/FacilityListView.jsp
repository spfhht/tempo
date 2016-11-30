<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

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
		<section id="titlename" class="qnaBoard">
			<h1>시설물 목록</h1>

<!-- <p class="allPost">
				전체 글: &nbsp; <strong><c:out value="${listcount}" /> </strong>개
			</p> -->

			
			
			<table class="boardTable">
				<caption>게시판 리스트</caption>
				<c:choose>
					<c:when test="${listcount>0}">

						<thead>
							<tr>
								<th scope="col" class="bbsNumber">아이디</th>
								<th scope="col" class="bbsTitle">이름</th>
								<th scope="col" class="bbsAuthor">주소</th>

							</tr>
						</thead>
						<c:forEach var="list" items="${list}" varStatus="status">
							<tbody>
								<tr>
									<td><a
										href="./ListFacility2.facility?f_id=<c:out value="${list.f_id}" />">
											<c:out value="${list.f_id}" />
									</a>
									<td><c:out value="${list.f_name}" /></td>
									<td><c:out value="${list.f_address}" /></td>

								</tr>
							</tbody>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>

			<div align="center">
				<table id="boardTableNe" class="boardTableNe">
					<tbody>
						<c:if test="${searchlistcount==0}">
							<tr>
								<td colspan="4"></td>
								<td>등록된 글이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<td colspan="5"><c:choose>
									<c:when test="${page <= 1}"> [이전]&nbsp; </c:when>
									<c:otherwise>
										<a href="./BoardList.do?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
</c:otherwise>
								</c:choose> <c:forEach var="start" begin="${startpage}" end="${endpage}"
									step="1">
									<c:choose>
										<c:when test="${start eq page}"> [<c:out
												value="${start}" />] </c:when>
										<c:otherwise>
											<a href="./BoardList.do?page=<c:out value="${start}" />">[<c:out
													value="${start}" />]
											</a>&nbsp;
</c:otherwise>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${page >= maxpage}">[다음]</c:when>
									<c:otherwise>
										<a href="./BoardList.do?page=<c:out value="${page+1}" />">[다음]</a>
									</c:otherwise>
								</c:choose></td>
					</tbody>
				</table>


				<section class="search">
					<form name="search" action="./ListFacility3.facility" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label> <select name="keyfield"
								class="b_search">
								<option value="all" selected="selected">전체 검색</option>
								<option value="f_id"
									<c:if test="${'f_id' == keyfield}">selected="selected"</c:if>>
									아이디</option>
								<option value="f_name"
									<c:if test="${'f_name' == keyfield}">selected="selected"</c:if>>
									시설물 이름</option>

							</select> <input type="search" id="keyword" name="keyword"
								 placeholder="검색어 입력해주세요">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>


			</div>
		</section>

	</div>
</body>
</html>