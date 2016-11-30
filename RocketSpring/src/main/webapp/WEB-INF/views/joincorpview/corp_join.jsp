<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">




<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 등록하기</title>

<link href="<%=request.getContextPath()%>/css/corp.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	
	function passwordCheck(){
		if($("c_pwd").val() != $("#c_pwdck").val()){
			alert("패스워드 입력이 일치하지 않습니다");
			$("#c_pwdck").focus();
			return false;
		}		
		return true;
	}
</script>

</head>
<body>
	<div id="contentArea">
		<section id="titlename">
			<h1>회사 등록 하기</h1>
			<p class="formSign">
				<strong class="require">필수</strong>는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="./join.joincorp" method="post" id="joinForm"
				name="boardform" onsubmit ="return passwordCheck()" >
				<fieldset>
					<legend>게시판 글쓰기</legend>
					<p>
						<label for="c_name">택배회사 이름 <strong class="require">필수</strong></label>
						<input type="text" id="c_name" name="c_name" required placeholder="택배회사 이름 입력" />
					</p>
					<p>
						<label for="c_id">택배회사 아이디 <strong class="require">필수</strong></label>
						<input type="text" id="c_id" name="c_id" required placeholder="택배회사 아이디 입력" />
					</p>
					<p>
						<label for="c_pwd">암호 <strong class="require">필수</strong></label>
						<input type="password" id="c_pwd" name="c_pwd" required placeholder="영문/숫자 4~8자 이내">
					</p>
					<p>
						<label for="c_pwdck">암호 확인 <strong class="require">필수</strong></label>
						<input type="password" id="c_pwdcl" name="c_pwdck" required placeholder="영문/숫자 4~8자 이내">
					</p>
					
					
					<p>
						<label for="c_address">택배회사 주소 <strong class="require">필수</strong></label>
						<input type="text" id="c_address" name="c_address" required placeholder="택배회사 주소 입력">
					</p>
					<p>
						
						<label for="c_tel">택배회사 전화번호 <strong class="require">필수</strong></label>
						<input type="text" id="c_tel" name="c_tel" required placeholder="택배회사 주소 입력">
					</p>
					
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">회사 등록</button>
						<button type="reset" class="btnCancel">취소</button>
						
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>