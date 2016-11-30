<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<h1>개인 택배 조회</h1>
	<table class="boardTable">
		<thead>
			<tr>
				<th scope="col" class="corpNumber">운송장번호</th>
				<th scope="col" class="corpName">보내는사람</th>
				<th scope="col" class="corpId">보내는주소</th>
				<th scope="col" class="corpId">받는사람</th>
				<th scope="col" class="corpId">받는주소</th>
				<th scope="col" class="corpId">수화물종류</th>
				<th scope="col" class="corpId">배송상태</th>
				<th scope="col" class="corpId">보낸날짜</th>
				<th scope="col" class="corpId">받는날짜</th>

			</tr>
		</thead>
		<c:forEach var="list" items="${check}" varStatus="status">
			<tr>
				<td align=center><a
					href="./view.check?delivery_id=${list.delivery_id }"><c:out
							value="${list.delivery_id }" /></a></td>
				<td align=center><c:out value="${list.p_s_name}" /></td>
				<td align=center><c:out value="${list.p_s_address}" /></td>
				<td align=center><c:out value="${list.p_r_name}" /></td>
				<td align=center><c:out value="${list.p_r_address}" /></td>
				<td align=center><c:out value="${list.p_kind_name}" /></td>
				<td align=center><c:out value="${list.delivery_state}" /></td>
				<td align=center><c:out value="${list.p_s_date}" /></td>
				<td align=center><c:out value="${list.p_r_date}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
</body>
</html>