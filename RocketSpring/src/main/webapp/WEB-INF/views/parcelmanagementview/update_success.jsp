<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('배송 상태를 변경하였습니다.');
	location.href = "getdetail.parcelmanagement?delivery_id=${delivery_id}";
</script>
</head>
<body>
<%-- 	<input type="hidden" name="delivery_id" value="${delivery_id }"> --%>
</body>
</html>