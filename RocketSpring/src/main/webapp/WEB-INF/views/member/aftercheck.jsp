<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>아이디 중복 체크</title>
<body>
	<c:choose>
		<c:when test="${success eq 'true' }">
			<script type="text/javascript">
				document.write("사용가능한 아이디입니다.");
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				document.write("이미 사용중인 아이디입니다.");
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>