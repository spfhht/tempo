<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회사 중복</title>
<link href="<%=request.getContextPath()%>/css/corp.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
alert('아이디가 중복 되었습니다.');
location.replace('list.joincorp');
</script>
</head>
<body>

</body>
</html>