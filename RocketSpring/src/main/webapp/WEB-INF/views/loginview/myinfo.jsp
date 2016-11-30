<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Info</title>
<script type="text/javascript">
	function PwdChange() {
		window.open('./pwdchange.info', 'pwdchange',
				'width=400,height=200,menubar=no,status=no,toolbar=no');
	}
</script>
<link rel="stylesheet" type="text/css"
	href="css/corp.css">


</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<form id="joinForm" name="modifyform" action="./update.info"
				method="post" enctype="application/x-www-form-urlencoded">
				<fieldset>
					<legend>My Info</legend>
					<p>
						<label for="name">이름 :</label><br>
						<c:out value="${sessionScope.logininfo.m_name }" />
					</p>
					<p>
						<label for="id">아이디 :</label><br>
						<c:out value="${sessionScope.logininfo.m_id }" />
					</p>

					<p>
						<label for="password">비밀번호 :</label> <input type="button"
							value="비밀번호 변경하기" onclick="PwdChange()" />
					</p>
					<p>
						<label for="address">주소 :</label> <input type="text" name="add"
							placeholder="<c:out value = "${sessionScope.logininfo.m_address }"/>">
					</p>
					<p>
						<label for="detail_address">상세 주소 :</label><input type="text"
							name="d_add"
							placeholder="<c:out value = "${sessionScope.logininfo.m_detail_address }"/>">
					</p>
					<p>
						<label for="tel">전화번호 :</label> <input type="text" name="tel"
							placeholder="<c:out value = "${sessionScope.logininfo.m_tel }"/>">
					</p>
					<p>
						<label for="m_birth">생년월일 :</label><br>
						<c:out value="${sessionScope.logininfo.m_birth }" />
					</p>
					<p>
						<label for="email">이메일 :</label> <input type="text" name="email"
							placeholder="<c:out value = "${sessionScope.logininfo.m_email }"/>">
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">정보수정</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>