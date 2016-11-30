<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>김정은의 로켓배송</title>
<body>
	<c:choose>
		<c:when test="${success eq 'true' }">
			<script type="text/javascript">
				alert('회원가입에 성공하였습니다.');
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('회원가입에 실패하였습니다.');
			</script>
			<button type="button" value="button"
				onclick='history.back(); return false;' class="btnOk">뒤로 가기</button>
		</c:otherwise>
	</c:choose>
</body>
</html>