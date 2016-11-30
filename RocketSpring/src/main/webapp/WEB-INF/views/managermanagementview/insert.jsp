<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입창</title>
</head>
<body>
<form action="./insert.manager" method="post">
<table>
<tr>
<td>

<h2>새로 등록할 매니저의 정보를 입력하세요</h2>
</tr>
<tr>
<td>이    &nbsp;&nbsp;&nbsp; 름:&nbsp;<input type="text" name="name" required><br></td>
</tr>
<tr>
<td>아  이 디:&nbsp;<input type="text" name="id" required><br></td>
<tr>
<td>비밀번호:<input type="text" name="pwd" required><br></td>
<tr>
<td>&nbsp;<input type="hidden" name="corp" value="${sessionScope.id}">
<input type="submit" value="등록"></td>

</table>
</form>
</body>
</html>