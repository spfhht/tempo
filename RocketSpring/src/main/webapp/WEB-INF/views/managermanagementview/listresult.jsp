<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 똘마니들</title>
</head>
<body>

	<form action="./delete.manager" method="post">
		아이디 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 이름
		<c:forEach var="listvalue" items="${listvalue}">

			<table border="1" width="350" height="100"
				style="table-layout: fixed">
				<tr>

					<td align="left"><c:out value="${listvalue.manager_id}"></c:out></td>
					<td align="left"><c:out value="${listvalue.manager_name}"></c:out></td>

					<td align="left"><input type="button" value="삭제"
						onclick="location.href='./delete.manager?manager_id=${listvalue.manager_id}' "></td>

					<td align="left"><input type="button" value="수정"
						onclick="location.href='./updatepage.manager?manager_id=${listvalue.manager_id}&manager_name=${listvalue.manager_name}&manager_pwd=${listvalue.manager_pwd}' "></td>
				</tr>


			</table>
		</c:forEach>
		<br />

	</form>
</body>
</html>