<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>어깨동무 게시판</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./qnacss/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>게시판 검색 결과</h1>
			<p class="allPost">
				검색 글: &nbsp; <strong><c:out value="${searchlistcount}" /></strong>개
			</p>
			<table class="boardTable">
				<caption>게시판 검색</caption>
				<c:choose>
					<c:when test="${searchlistcount>0}">
						<thead>
							<tr>
								<th scope="col" class="bbsNumber">번호</th>
								<th scope="col" class="bbsTitle">제목</th>
								<th scope="col" class="bbsAuthor">글쓴이</th>
								<th scope="col" class="bbsDate">등록일</th>
								<th scope="col" class="bbsHit">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="search" items="${searchBoardlist }">
								<tr>
									<td><c:out value="${search.q_id}" /> </td>
									<td>
										<c:if test="${!empty search.tab}">
											<c:forEach var="j" begin="0" end="${search.tab*2}" step="1">
												&nbsp;					
											</c:forEach>
										</c:if> 
										 <a href="./BoardDetailService.qdo?q_id=<c:out value="${search.q_id}" />"><c:out value="${search.q_title}" /></a>
									</td>
									<td><c:out value="${search.m_id}" /></td>
									<td><c:out value="${search.regdate}" /></td>
									<td><c:out value="${search.hit}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</c:when>
				</c:choose>
			</table>
			
			<div align="center">
				<table id="boardTableNe" class="boardTableNe">
					<tbody>
					<c:if test="${searchlistcount==0}">
					
					<tr>
							<td colspan="4"></td>
							<td>검색된 글이 없습니다</td>
						</tr>
						</c:if>
						<tr>
							<td colspan="5">
								<c:choose>
									<c:when test="${page <= 1}">
										 [이전]&nbsp;
									</c:when> 
									<c:otherwise>
										<a href="./BoardSearchListService.qdo?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
	 								</c:otherwise>
								</c:choose>
								<c:forEach var="start" begin="${startpage}" end="${endpage}" step="1">
									<c:choose>
										<c:when test="${start eq page}">
											[<c:out value="${start}" />]
										</c:when>
										<c:otherwise>
								 			<a href="./BoardSearchListService.qdo?page=<c:out value="${start}" />">[<c:out value="${start}" />]</a>&nbsp; 
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${page >= maxpage}">
											[다음]
									</c:when>
									<c:otherwise>
										<a href="./BoardSearchListService.qdo?page=<c:out value="${page+1}" />">[다음]</a> 
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
			
					</tbody>
				</table>
				<div class="btnJoinAreb">
					<button type="button" value="button" onclick="location.href='./BoardList.qdo'" class="btnOk">
						목록</button>
				</div>
				
			</div>
			
		</section>
	</div>
</body>
</html>