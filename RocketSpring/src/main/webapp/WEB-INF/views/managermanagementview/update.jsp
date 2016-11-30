<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>널 고쳐주마</title>
</head>
<body>
<h2>변경할 값을 입력해 주세요</h2>
<form action="./update.manager">
이    &nbsp;&nbsp;&nbsp; 름<input type="text" name="manager_name" value="${manager_name}"required><br>
아  이 디<input type="text" name="manager_id" value="${manager_id}" readonly="readonly"><br>
비밀번호<input type="text" name="manager_pwd" value="${manager_pwd}" required><br>
<input type="submit" value="변경">
</form>
</body>
</html>