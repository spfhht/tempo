<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 정보</title>
<link href="<%=request.getContextPath()%>/css/corp.css" rel="stylesheet"
	type="text/css" />


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>

<script type="text/javascript">
	function moveAction(where) {
		switch (where) {
		case 1:
			location.href = "join.joincorp";
			break;

		case 2:
			location.href = "list.joincorp";
			break;
		}
	}
</script>

</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="corpList">
			<h1>회사 정보</h1>
			<div id="infoArea">
				<section class="search">
					<form name="search" action="list.joincorp" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label> <select id="type" name="type">
								<option value="c_id">회사 아이디</option>
								<option value="c_name">회사 이름</option>
							</select> <input type="text" id="keyword" name="keyword"
								required="required" placeholder="검색어를 입력하세요"
								value="<%if (request.getParameter("keyword") != null) {
				out.print(request.getParameter("keyword"));
			} else {
				out.print("");
			}%>">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div>
			
			<table class="boardTable">
				<caption>택배회사 리스트</caption>


				<thead>
					<tr>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>

					</tr>
				</thead>
				<c:forEach var="corp" items="${corpList}">
					<tbody>
						<tr>
							<td><a href="view.joincorp?c_id=${corp.c_id}" /><c:out
										value="${corp.c_id}" /></a></td>
							<td><c:out value="${corp.c_name}" /></td>

						</tr>

					</tbody>
				</c:forEach>

			</table>
			
			<div align="center">${pageHtml}</div>
			<div id="infoArea">
				<section class="insert">
					<form name="join" action="join.joincorp" method="get">
						<fieldset>
							<legend>회사추가</legend>
							<button type="submit">회사추가</button>
						</fieldset>
					</form>
				</section>
			</div>
			<div id="infoArea">
				<section class="insert">
					<form name="list" action="list.joincorp" method="get">
						<fieldset>
							<legend>목록</legend>
							<button type="submit">목록</button>
						</fieldset>
					</form>
				</section>
			</div>

		</section>
	</div>
</body>
</html>