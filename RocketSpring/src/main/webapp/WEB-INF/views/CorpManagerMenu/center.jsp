<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${empty param.menu }">
			<div class="sp-slideshow">
				<input id="button-1" type="radio" name="radio-set"
					class="sp-selector-1" checked="checked" /> <label for="button-1"
					class="button-label-1"></label> <input id="button-2" type="radio"
					name="radio-set" class="sp-selector-2" /> <label for="button-2"
					class="button-label-2"></label> <input id="button-3" type="radio"
					name="radio-set" class="sp-selector-3" /> <label for="button-3"
					class="button-label-3"></label> <input id="button-4" type="radio"
					name="radio-set" class="sp-selector-4" /> <label for="button-4"
					class="button-label-4"></label> <input id="button-5" type="radio"
					name="radio-set" class="sp-selector-5" /> <label for="button-5"
					class="button-label-5"></label> <label for="button-1"
					class="sp-arrow sp-a1"></label> <label for="button-2"
					class="sp-arrow sp-a2"></label> <label for="button-3"
					class="sp-arrow sp-a3"></label> <label for="button-4"
					class="sp-arrow sp-a4"></label> <label for="button-5"
					class="sp-arrow sp-a5"></label>
				<div class="sp-content">
					<div class="sp-parallax-bg"></div>
					<ul class="sp-slider clearfix">
						<li><img src="images/rocket_menu.png" alt="image01" /></li>
						<li><img src="images/rocket_menu.png" alt="image02" /></li>
						<li><img src="images/rocket_menu.png" alt="image03" /></li>
						<li><img src="images/rocket_menu.png" alt="image04" /></li>
						<li><img src="images/rocket_menu.png" alt="image05" /></li>
					</ul>
				</div>
				<!-- sp-content -->
			</div>
		</c:when>
		<c:when test="${menu eq 'list' }">
			<div align="left">
				<jsp:include page="./centerleft.jsp"></jsp:include>
			</div>
			<div>
				<iframe width="97%" height="600px" src="./parcellist.parcelmanagement"></iframe>
			</div>
		</c:when>
		<c:when test="${menu eq 'bring' }">
			<div align="left">
				<jsp:include page="./centerleft.jsp"></jsp:include>
			</div>
			<div>
				<iframe width="97%" height="600px" src="./bring.parcelmanagement"></iframe>
			</div>
		</c:when>			
	</c:choose>
</body>
</html>