<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
<style type="text/css">
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

#logo {
	margin: 3%;
}

#container {
	width: 45%;
	height: 45%;
	margin: 3% auto;
}

#outer {
	display: table;
	width: 100%;
	height: 100%;
	opacity: 0.95;
	visibility: visible;
}

#inner {
	display: table-cell;
	vertical-align: middle;
	border-bottom: 1px solid #ddd;
	color: #282828;
	font-size: 30px;
	padding: 0 0 9px 0;
	margin-bottom: 30px;
	font-weight: bold;
}

#login-columns {
	width: 700px;
	margin: 0 auto;
}

#logo {
	width: 350px;
	margin: 4% auto;
}

.auth-block {
	background: #FBFBFB;
	background: -moz-linear-gradient(top, #FBFBFB 92%, #EFEFEF 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(92%, #FBFBFB),
		color-stop(100%, #EFEFEF));
	background: linear-gradient(top, #FBFBFB 92%, #EFEFEF 100%);
	-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	padding: 29px 29px 25px 29px;
}

.login-top {
	border-bottom: 1px solid #ddd;
	color: #282828;
	font-size: 30px;
	padding: 0 0 9px 0;
	margin-bottom: 30px;
	font-weight: bold;
}

.auth-block .form-text, .form-textarea {
	width: 100%;
	height: 32px;
	font-weight: normal;
	padding: 0 10px;
	margin: 0 0 10px 0;
	line-height: 32px;
	font-size: 20px;
	border: 1px solid #CFCFCF;
	-webkit-box-shadow: 0 4px 5px -5px rgba(0, 0, 0, 0.3) inset;
	-moz-box-shadow: 0 4px 5px -5px rgba(0, 0, 0, 0.3) inset;
	box-shadow: 0 4px 5px -5px rgba(0, 0, 0, 0.3) inset;
	-moz-border-radius: 3px;
	border-radius: 3px;
	background: white;
	color: #aaa;
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.auth-block .form-signup {
	color: #6D6D6D;
	font-size: 11px;
	padding: 0;
}

.auth-block  input[type=text]:focus, .auth-block  input[type=password]:focus
	{
	background: #fff;
	outline: none;
	border: 1px solid #4d8dff;
	-webkit-box-shadow: 0 0 3px rgba(0, 116, 239, 0.5), 0 4px 5px -5px
		rgba(0, 0, 0, 0.3) inset;
	-moz-box-shadow: 0 0 3px rgba(0, 116, 239, 0.5), 0 4px 5px -5px
		rgba(0, 0, 0, 0.3) inset;
	box-shadow: 0 0 3px rgba(0, 116, 239, 0.5), 0 4px 5px -5px
		rgba(0, 0, 0, 0.3) inset
}

.alt-checkbox-label {
	display: inline-block;
	position: relative;
	font-size: 20px;
	color: #666;
	padding-left: 3px;
	line-height: 16px;
}

.auth-forgot {
	position: relative;
	float: right;
	color: #6d6d6d;
	font-size: 20px;
}

.form-button-default {
	background: #5cb6e7;
	background: -moz-linear-gradient(top, #5cb6e7, #317cd7);
	background: -webkit-linear-gradient(top, #5cb6e7, #317cd7);
	background: linear-gradient(top, #5cb6e7, #317cd7);
	border-color: #0c67a5;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3);
	color: white;
	height: 35px;
	padding: 0 15px;
	margin: 11px 0 0 0;
	font-size: 20px;
	font-weight: bold;
	-moz-border-radius: 3px;
	border-radius: 3px;
	border: 1px solid #0c67a5;
	display: inline-block;
	width: 100%;
	-webkit-user-select: none;
	-moz-user-select: none;
	white-space: nowrap;
	cursor: pointer;
}

.form-button-default:hover {
	background: #2bb3ed;
	background: -moz-linear-gradient(top, #2bb3ed, #247cdf);
	background: -webkit-linear-gradient(top, #2bb3ed, #247cdf);
	background: linear-gradient(top, #2bb3ed, #247cdf);
}

.form-button-default:active {
	-webkit-box-shadow: inset 0 1px 5px rgba(0, 0, 0, 0.3), 0 1px 0
		rgba(255, 255, 255, 0.4);
	box-shadow: inset 0 1px 5px rgba(0, 0, 0, 0.3), 0 1px 0
		rgba(255, 255, 255, 0.4)
}
</style>
<script type="text/javascript" src="script/manage.js"></script>
<script src="/js/jquery/jquery-1.11.3.min.js"></script>
</head>







<body onload="focus()">
	<div id="logo">
		<img src="images/logo.jpg" style="width: 292px; height: 104px;">
	</div>

	<div id="container">
		<div id="outer">
			<div id="inner">
				<div id="login-columns">
					<!-- 로그인 위젯 -->
					<div class="auth-block corner-all" style="height: 400px;">
						<div class="login-top" style="height: 60px;">Admin Log In</div>

						<c:choose>
							<c:when test="${(sessionScope.logininfo.m_group == 0)}">
								<c:redirect
									url="./adminMenu/main"></c:redirect>
							</c:when>
							<c:otherwise>

								<form id="account-signup" action="./do.login" method="post"
									name="loginform">
									<fieldset>
										<input type="text" name="id" id="id" title="eid"
											class="form-text id" style="height: 62px;" placeholder="ID">
										<input type="password" name="pwd" id="pwd" title="epass"
											class="form-text" style="height: 62px;"
											placeholder="Password"> <input type="hidden"
											name="m_group" value="0"> <input type="submit"
											class="login form-button-default right" style="height: 52px"
											value="LOGIN" onclick="return loginCheck()">
									</fieldset>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>