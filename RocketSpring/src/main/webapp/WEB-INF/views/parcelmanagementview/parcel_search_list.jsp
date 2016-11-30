<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회사 관리</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>회사 검색 결과</h1>
			
			<div id="infoArea">
				<section class="search">
					<form name="search" action="./ParcelSearchList.pdo?id=<c:out value="${id}"/>" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label>
							<select name="keyfield" class="b_search">
								<option value="all" selected="selected">전체 검색</option>
								<option value="delivery_id" <c:if test="${'delivery_id' eq keyfield}">selected="selected"</c:if>>운송장 번호</option>
								<option value="delivery_state" <c:if test="${'delivery_state' eq keyfield}">selected="selected"</c:if>>배송상태</option>
							    <option value="p_r_name" <c:if test="${'p_r_name' eq keyfield}">selected="selected"</c:if>>받는사람</option>
							</select> 
							<input type="search" id="keyword" name="keyword" required="required" placeholder="결과내 다시 검색">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div>
			
			<p class="allPost">
				검색 글: &nbsp; <strong><c:out value="${searchlistcount}" /></strong>개
			</p>
			<table class="boardTable">
				<caption>게시판 검색</caption>
				<c:choose>
					<c:when test="${searchlistcount>0}">
						<thead>
							<tr>
								<th scope="col" class="corpNumber">운송장번호</th>
								<th scope="col" class="corpName">배송상태</th>
								<th scope="col" class="corpId">받는사람</th>

							</tr>
						</thead>
						<c:forEach var="parcel" items="${searchParcellist}" varStatus="status">
							<tbody>
								<tr>
									<td><a
										href="./ParcelDetail.pdo?delivery_id=<c:out value="${parcel.delivery_id}" />"><c:out
												value="${parcel.delivery_id}" /></a></td>

									<td><c:out value="${parcel.delivery_state}" /></td>
									<td><c:out value="${parcel.p_r_name}" /></td>

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
										<a href="./ParcelSearch.pdo?page=<c:out value="${page-1}"/>&keyword=<c:out value="${keyword}"/>&keyfield=<c:out value="${keyfield}"/>&id=<c:out value="${id}"/>">[이전]</a>&nbsp;
	 								</c:otherwise>
								</c:choose>
								<c:forEach var="start" begin="${startpage}" end="${endpage}" step="1">
									<c:choose>
										<c:when test="${start eq page}">
											[<c:out value="${start}" />]
										</c:when>
										<c:otherwise>
								 			<a href="./ParcelSearch.pdo?page=<c:out value="${start}" />&keyword=<c:out value="${keyword}"/>&keyfield=<c:out value="${keyfield}"/>&id=<c:out value="${id}"/>">[<c:out value="${start}" />]</a>&nbsp; 
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${page >= maxpage}">
											[다음]
									</c:when>
									<c:otherwise>
										<a href="./ParcelSearch.pdo?page=<c:out value="${page+1}" />&keyword=<c:out value="${keyword}"/>&keyfield=<c:out value="${keyfield}"/>&id=<c:out value="${id}"/>">[다음]</a> 
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
			
					</tbody>
				</table>
				<div class="btnJoinAreb">
					<button type="button" value="button" onclick="location.href='./ParcelList.pdo?id=<c:out value="${id}"/>'" class="btnOk">
						목록</button>
				</div>
				
			</div>
			
		</section>
	</div>
</body>
</html>