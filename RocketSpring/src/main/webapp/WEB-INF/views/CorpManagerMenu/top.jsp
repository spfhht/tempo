<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon"
	href="icon/rocket_icon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="css/common.css" />
<link rel="stylesheet" type="text/css"
	href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="css/bar.css" />

<style>
.ui-tabs-vertical {
	width: 55em;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .2em .1em .2em .2em;
	float: left;
	width: 12em;
}

.ui-tabs-vertical .ui-tabs-nav li {
	clear: left;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical .ui-tabs-nav li a {
	display: block;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 40em;
}
</style>
</head>
<body>
	<!-- gnb -->
	<div class="gnb_area">
		<div id="topMenu" align="left">
			<ul>
				<li class="topMenuLi"><a
					href="./corpmanagermain"
					title="로켓배송 메인화면으로 가기"><img
						src="images/logo.jpg" alt="로켓배송 사이트 로고" /></a></li>
			</ul>
			<div class="gnb_contents">
				<ul>
					<li class="topMenuLi"><a class="menuLink">수화물 관리</a>
						<ul class="submenu">
							<li><a href="./corpmanagermain?menu=list"
								class="submenuLink longLink">&nbsp&nbsp&nbsp목록&nbsp&nbsp&nbsp</a></li>
							<li><a href="./corpmanagermain?menu=bring"
								class="submenuLink longLink">&nbsp&nbsp가져오기&nbsp&nbsp&nbsp</a></li>
						</ul></li>
				</ul>
				<div>
					<hr align="left" size="3" width="100%" color="#87cefa" />
				</div>
				<!-- gnb -->
				<!-- center img -->
			</div>
		</div>
		<!-- sp-slideshow -->
	</div>
</body>
</html>