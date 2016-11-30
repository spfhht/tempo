<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>회원 목록</h1>
		<%-- 	<div id="infoArea">
				<section class="search">
					<form name="search" action="./#" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label> <select name="keyfield"
								class="b_search">
								<option value="all" selected="selected">전체 검색</option>
								<option value="m_id"
									<c:if test="${'m_id' == keyfield}">selected="selected"</c:if>>아이디</option>
								<option value="m_name"
									<c:if test="${'m_name' == keyfield}">selected="selected"</c:if>>이름</option>
							</select> <input type="search" id="keyword" name="keyword"
								required="required" placeholder="검색어 입력해주세요">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div> --%>
			<p class="allPost">
				회원수: &nbsp; <strong><c:out value="${listcount}" /> </strong>명
			</p>
			<table class="boardTable">
				<caption>회원 리스트</caption>
				<c:choose>
					<c:when test="${listcount>0}">
						<thead>
							<tr>
								<th scope="col" class="bbsAuthor">아이디</th>
								<th scope="col" class="bbsAuthor">이름</th>
								<th scope="col" class="bbsAuthor">삭제</th>
							</tr>
						</thead>
						<c:forEach var="member" items="${memberList}" varStatus="status">
							<tbody>
								<tr>
									<td><a href="./DetailList.AmmDo?m_id=<c:out value="${member.m_id}" />">
										<c:out value="${member.m_id}" /></a></td>

									<td><c:out value="${member.m_name}" /></td>
									<td><a
										href="./MemberDelete.AmmDo?m_id=<c:out value="${member.m_id}" />">삭제</a></td>
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
										<a href="./Member.AmmDo?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
</c:otherwise>
								</c:choose> <c:forEach var="start" begin="${startpage}" end="${endpage}"
									step="1">
									<c:choose>
										<c:when test="${start eq page}"> [<c:out
												value="${start}" />] </c:when>
										<c:otherwise>
											<a href="./Member.AmmDo?page=<c:out value="${start}" />">[<c:out
													value="${start}" />]
											</a>&nbsp;
</c:otherwise>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${page >= maxpage}">[다음] </c:when>
									<c:otherwise>
										<a href="./Member.AmmDo?page=<c:out value="${page+1}" />">[다음]</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
	</div>
</body>
</html>