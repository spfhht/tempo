<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>김정은의 로켓배송!!</title>
<c:choose>
	<c:when test="${empty flag }">
		<link rel="shortcut icon" href="icon/rocket_icon.ico"
			type="image/x-icon" />

		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/bar.css" />
	</c:when>
	<c:otherwise>
		<link rel="shortcut icon" href="icon/rocket_icon.ico"
			type="image/x-icon" />

		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/bar.css" />
	</c:otherwise>
</c:choose>
</head>
<body>
	<!-- gnb -->
	<div class="gnb_area">
		<div class="gnb_contents">
			<div id="topMenu" align="left">
				<ul>
					<li class="topMenuLi"><a href="http://localhost/KimsRocketDelivery2/main/main.jsp"
						title="로켓배송 메인화면으로 가기"><img src="../images/logo.jpg"
							alt="로켓배송 사이트 로고" /></a></li>
				</ul>
				<ul>
					<li class="topMenuLi"><a class="menuLink" href="http://localhost/KimsRocketDelivery2/main/main.jsp?menu=reservation">택배예약</a></li>

					<li class="topMenuLi"><a class="menuLink">택배조회</a>
						<ul class="submenu">
							<li><a href="http://localhost/KimsRocketDelivery2/main/main.jsp?menu=deliveryIdCheck"
								class="submenuLink longLink">운송장번호로 조회</a></li>
							<c:choose>
								<c:when test="${empty sessionScope.id }">
									<li><a href="http://localhost/KimsRocketDelivery2/loginview/userlogin.jsp"
										class="submenuLink longLink">개인 택배 조회</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="http://localhost/KimsRocketDelivery2/main/main.jsp?menu=deliveryCheck" class="submenuLink longLink">개인 택배 조회</a></li>
								</c:otherwise>
							</c:choose>
						</ul></li>

					<li class="topMenuLi"><a class="menuLink"
						href="http://localhost/KimsRocketDelivery2/main/main.jsp?menu=checkOffice">영업소 조회</a>
					<li class="topMenuLi"><a class="menuLink"
						href="http://localhost/KimsRocketDelivery2/main/main.jsp?menu=qna">QNA</a>
				</ul>
				<div>
					<hr align="center" size="1" width="100%" color="#0000FF" />
				</div>
				<!-- gnb -->
			</div>
		</div>
	</div>

</body>
</html>