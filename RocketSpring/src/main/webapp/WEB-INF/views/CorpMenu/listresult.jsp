<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>내 똘마니들</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<link rel="stylesheet" type="text/css" href="./css/jboard.css">

</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>회사 관리자 목록</h1>


			<table class="boardTable">
				<thead>
					<tr>
						<th scope="col" class="bbsNumber">아이디</th>
						<th scope="col" class="bbsTitle">이름</th>
						<th scope="col" class="bbsAuthor">수정</th>
						<th scope="col" class="bbsAuthor">삭제</th>

					</tr>
				</thead>
				<c:forEach var="listvalue" items="${listvalue}">
					<tbody>
						<tr>

							<td align="left"><c:out value="${listvalue.manager_id}"></c:out></td>
							<td align="left"><c:out value="${listvalue.manager_name}"></c:out></td>
							<td align="left"><input type="button" value="수정"
								onclick="location.href='./CorpMenu/update.jsp?manager_id=${listvalue.manager_id}&manager_name=${listvalue.manager_name}&manager_pwd=${listvalue.manager_pwd}' "></td>

							<td align="left"><input type="button" value="삭제"
								onclick="location.href='./delete.cmmdo?manager_id=${listvalue.manager_id}' "></td>


						</tr>
					</tbody>
				</c:forEach>
			</table>
			<br />

		</section>
	</div>
</body>
</html>