<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./view.check" method="post">
		<br /> 운송장 번호 입력 :
		<input type="text" name="delivery_id" placeholder="예시)1234567"
			required>
		<input type="submit" value="확인">
	</form>
</body>
</html>