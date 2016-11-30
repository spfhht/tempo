<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>풋터 페이지</title>
<style type="text/css">
	body, h3, p{
		width:100%;
		margin:0;
		padding: 0;
	}
	p{
		margin-left: 2px;
		margin-right: 2px;
	}
	#footer-container{
		width:100%;
		height: 100%;
		display: table;
		background-color: #383e49;
	}
	
	#footer-name{
		width:20%;
		height: 30%;
		display: table-cell;
		text-align: center;
		vertical-align: middle;
	}
	
	#footer-info{
		width:27%;
		height: 20%;
		display: table-cell;
		text-align: center;
		vertical-align: middle;
	}
	
	#footer-contact{
		width:27%;
		height: 20%;
		display: table-cell;
		text-align: center;
		vertical-align: middle;
	}
	
	#footer-quick{
		width:26%;
		height: 20%;
		display: table-cell;
		text-align: center;
		vertical-align: middle;
	}
	
	div .layout{
	border-radius: 30px 30px 30px 30px;
	-moz-border-radius: 30px 30px 30px 30px;
	-webkit-border-radius: 30px 30px 30px 30px;
	background-color: #4c515d;
	color: #fff;
}

</style>
</head>
<body>
<div id = "footer-container">
	<div id="footer-name" class="layout">
		<a href="javascript:;" onclick="window.open('http://localhost/KimsRocketDelivery2/loginview/adminlogin.jsp','name','resizable=yes width=1300 height=900');return false"><span
						style="font-weight: bold; color: white;">관리자로그인</span></a>
		
	</div>
	<div id="footer-info" class="layout">
		<a href="javascript:;" onclick="window.open('http://localhost/KimsRocketDelivery2/loginview/corplogin.jsp','name','resizable=yes width=1300 height=900');return false"><span
						style="font-weight: bold; color: white;">회사로그인</span></a>
		
	</div>
	<div id="footer-contact" class="layout">
		<a href="javascript:;" onclick="window.open('http://localhost/KimsRocketDelivery2/loginview/managerlogin.jsp','name','resizable=yes width=1300 height=900');return false"><span
						style="font-weight: bold; color: white;">회사관리자로그인</span></a>
	</div>
	<div id="footer-quick" class="layout">
		<h3>오시는길</h3>
		<p> 서울시 구로구 구로중앙로 34길 33-4 경영기술개발원</p>
		<p><a></a></p>
	</div>
</div>
</body>
</html>