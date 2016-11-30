<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function doResize() /* 크기 자동 조절 */
	{
		container.height = iframe.document.body.scrollHeight + 5;
		container.width = iframe.document.body.scrollWidth + 5;
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty menu  }">
			<div>
				<jsp:include page="./centerleft.jsp"></jsp:include></div>

		</c:when>
		<c:when test="${menu eq 'reservation' }">
			<iframe width="97%" height="100%" src="./intro.reservation"></iframe>
		</c:when>
		<c:when test="${menu eq 'deliveryCheck' }">
			<iframe width="97%" height="100%"
				src="./myinfo.check"></iframe>
		</c:when>
		<c:when test="${menu eq 'deliveryIdCheck' }"> 
			<iframe width="97%" height="100%" src="./waybill.check"></iframe>
		</c:when>
		<c:when test="${menu eq 'checkOffice' }">
			 <iframe width="97%" height="100%" src="./corplist.office"></iframe> 
			
		</c:when>
		<c:when test="${menu eq 'qna' }">
			<iframe width="97%" height="100%" src="./list.qna"></iframe>
		</c:when>
		<c:when test="${menu eq 'join' }">
			<iframe width="97%" height="100%" src="./member_insert"></iframe>
		</c:when>
		<c:when test="${menu eq 'myinfo' }">
			<iframe width="97%" height="100%" src="./myinfointro.info"></iframe>
		</c:when>
	</c:choose>
</body>
</html>