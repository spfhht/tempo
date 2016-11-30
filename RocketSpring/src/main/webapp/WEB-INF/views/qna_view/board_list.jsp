<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
<!--  <link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon"> -->
<link rel="stylesheet" type="text/css"
	href="./qnacss/jboard.css">
<link rel="./media/css/jquery.dataTables_themeroller.css">
<style type="text/css" title="currentStyle">
@import
"./media/css/jquery.dataTables.min.css"
</style>
<script src="./js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="./media/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#example').dataTable();
	});
</script>
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>무엇이든 물어보라우</h1>
			<div id="infoArea">
				<c:choose>
					<c:when test="${!(sessionScope.logininfo.m_group eq '2') }">
						<section class="search">
							<form name="search" action="./list.qna" method="post">
								<fieldset>
									<legend>검색</legend>
									<label for="keyword"></label> <select name="c_id"
										class="b_search">
										<option value="all" selected="selected">전체글 보기</option>
										<c:forEach var="corp" items="${corpList}">
											<option value="${corp.c_id}"
												<c:if test="${corp.c_id == c_id}"></c:if>><c:out
													value="${corp.c_name}"></c:out></option>
										</c:forEach>
									</select>
									<button type="submit">택배사 별 조회</button>
								</fieldset>
							</form>
						</section>
					</c:when>
				</c:choose>
			</div>
			<p class="allPost">
				전체 글: &nbsp; <strong><c:out value="${listcount}" /> </strong>개
			</p>
			<table class="boardTable" id="example">
				<caption>게시판 리스트</caption>
				<c:choose>
					<c:when test="${listcount>0}">
						<thead>
							<tr>
								<th scope="col" class="bbsNumber">번호</th>
								<th scope="col" class="bbsC_name">택배회사</th>
								<th scope="col" class="bbsTitle">제목</th>
								<th scope="col" class="bbsAuthor">글쓴이</th>
								<th scope="col" class="bbsDate">등록일</th>
								<th scope="col" class="bbsHit">조회수</th>
								<c:choose>
									<c:when test="${sessionScope.logininfo.m_group eq '0' }">
										<th scope="col" class="bbsDelete">삭제</th>
									</c:when>
								</c:choose>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="board" items="${boardList}" varStatus="status">
								<tr>
									<td><c:out value="${board.q_id}" /></td>
									<td>[<c:out value="${board.c_name}" />]
									</td>
									<td><c:if test="${!empty board.tab}">
											<c:forEach var="j" begin="0" end="${board.tab*2}" step="1">
												&nbsp;
											</c:forEach>
										</c:if> <a
										href="./detail.qna?q_id=<c:out value="${board.q_id}" />&c_id=<c:out value="${ board.c_id}" />"><c:out
												value="${board.q_title}" /></a></td>
									<td><c:out value="${board.m_id}" /></td>
									<td><c:out value="${board.regdate}" /></td>
									<td><c:out value="${board.hit}" /></td>
									<c:choose>
										<c:when test="${sessionScope.logininfo.m_group eq '0'}">
											<td><a
												href="./delete.qna?q_id=<c:out value="${board.q_id}" />&m_group=<c:out value="${sessionScope.logininfo.m_group}" />&q_pwd=<c:out value="${board.q_pwd}" />">삭제</a></td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</c:when>
				</c:choose>
			</table>

			<div class="btnJoinAreb">
				<button type="button" value="button" onclick="location.href='./corpList.qna'" class="btnOk">글쓰기</button>
			</div>

		</section>
	</div>
</body>
</html>