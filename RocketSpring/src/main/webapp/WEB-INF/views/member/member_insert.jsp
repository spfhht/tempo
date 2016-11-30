<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="css/corp.css">
<link rel="stylesheet" href="css/jqueryui/jquery-ui.css">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="js/search.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/jquery-ui.js" charset="UTF-8"></script>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
	function idOverlapCheck() {// 아이디 중복 체크
		var tmp = document.boardform.m_id.value;
		if (!$("input[name='m_id']").val()) {
			alert("아이디을 임력하세요.");
			$("input[name='m_id']").focus();
			return false;
		}
		window.open("./idOverlapCheck.SignUp?m_id=" + tmp, "아이디 중복 확인",
				"width=250, height=50, left=50, location=1");
	}
</script>
<script type="text/javascript">
	$(function() {
		$("#m_birth").datepicker(
				{
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					weekHeader : 'Wk',
					dateFormat : 'yymmdd', //형식(2012-03-03)
					autoSize : true, //오토리사이즈(body등 상위태그의 설정에 따른다)
					changeMonth : true, //월변경가능
					changeYear : true, //년변경가능
					showMonthAfterYear : true, //년 뒤에 월 표시
					buttonImageOnly : true, //이미지표시
					yearRange : '1940:+10' //1940년부터 10년후까지(php)

				});
		$(function() { // 우편번호 조회 
			$("#ex1_button").postcodifyPopUp({
				forceDisplayPostcode5 : true
			});
		});
		$("#joinForm")
				.submit(
						function() {
							// 정규식 - 이메일 유효성 검사
							var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
							// 정규식 - 전화번호 유효성 검사
							var regPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
							// 정규식 - 패스워드 유효성 검사 (영문, 숫자 혼합하여 6~20자리 이내)
							var regpwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
							if (!$("input[name='m_name']").val()) {
								alert("이름을 임력하세요.");
								$("input[name='m_name']").focus();
								return false;
							} else if (!$("input[name='m_id']").val()) {
								alert("아이디를 입력하세요.");
								$("input[name='m_id']").focus();
								return false;
							} else if (!$("input[name='m_pwd']").val()) {
								alert("비밀번호를 입력하세요.");
								$("input[name='m_pwd']").focus();
								return false;
							} else if (!$("input[name='m_birth']").val()) {
								alert("생년월일을 입력하세요.");
								$("input[name='m_id']").focus();
								return false;
							} else if (!$("input[name='m_tel']").val()) {
								alert("전화번호를 입력하세요.");
								$("input[name='m_tel']").focus();
								return false;
							} else if ($("input[name='m_pwd']").val() != $(
									"input[name='m_pwd2']").val()) {
								alert("패스워드가 틀립니다.");
								$("input[name='m_pwd2']").focus();
								return false;
							} else if (!$("input[name='m_email']").val()) {
								alert("이메일을 입력하세요.");
								$("input[name='m_email']").focus();
								return false;
							} else if (!regEmail
									.test($("input[name='m_email']").val())) {
								alert("이메일 주소가 유효하지 않습니다");
								$("input[name='m_email']").focus();
								return false;
							} else if (!regPhone.test($("input[name='m_tel']")
									.val())) {
								alert("전화번호가 유효하지 않습니다");
								$("input[name='m_tel']").focus();
								return false;
							} else if (!regpwd.test($("input[name='m_pwd']")
									.val())) {
								alert('비밀번호를 확인하세요.₩n(영문,숫자를 혼합하여 6~20자 이내)');
								$("input[name='m_pwd']").focus();
								return false;
							}
						});
	});
</script>
</head>
<body>
	<div id="contentArea">
		<section id="titlename">
			<h1>회원관리 정보</h1>
			<p class="formSign">
				<strong class="require">필수</strong>는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="./do.SignUp" method="post" id="joinForm"
				name="boardform">
				<fieldset>
					<legend>회원관리 정보 입력</legend>
					<p>
						<label for="m_name">이름 <strong class="require">필수</strong></label>
						<input type="text" id="m_name" name="m_name" placeholder="이름" />
					</p>
					<p>
						<label for="m_id">아이디 <strong class="require">필수</strong></label>
						<input type="text" id="m_id" name="m_id" placeholder="아이디" /> <input
							type="button" value="중복 체크" onclick="idOverlapCheck();">
						<!-- <input
							type="button" value="ID중복확인" class="myButton"
							onclick="JavaScript:idchack(this.form.m_id.value)" /> -->
					</p>
					<p>
						<label for="m_pwd">암호 <strong class="require">필수</strong></label>
						<input type="password" id="m_pwd" name="m_pwd">(영문/숫자
						6~20자 이내)
					</p>
					<p>
						<label for="m_pwd">암호 확인 <strong class="require">필수</strong></label>
						<input type="password" id="m_pwd2" name="m_pwd2"
							placeholder="비밀번호 확인">
					</p>
					<p>
						<label for="m_birth">생년월일 <strong class="require">필수</strong></label>
						<input type="date" id="m_birth" name="m_birth">
					</p>
					<p>

						<label for="m_tel">전화번호 <strong class="require">필수</strong></label>
						<input type="text" id="m_tel" name="m_tel">(-)빼고입력
					</p>
					<p>
						<label for="ex1_pc5">우편번호<strong class="require">필수</strong></label>
						<input type="text" id="ex1_pc5"
							class="example_pcfull postcodify_postcode5" disabled /> <input
							type="button" value="검색" class="example_button" id="ex1_button" />
					</p>
					<p>
						<label for="m_address">도로명주소<strong class="require">필수</strong>
						</label> <input type="text" id="m_address" name="m_address"
							class="example_input postcodify_address" size="35" readonly="readonly" />
					</p>
					<p>
						<label for="m_detail_address">상세주소</label>
						<input type="text" id="m_detail_address" name="m_detail_address"
							class="example_input postcodify_details" size="35" />
					</p>
					<p>
						<label for="m_email">이메일 <strong class="require">필수</strong></label>
						<input type="text" id="m_email" name="m_email"
							placeholder="abc@abc.com">
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">회원 가입</button>
						<button type="reset" class="btnCancel">취소</button>

					</div>
				</fieldset>
			</form>
		</section>
	</div>

</body>
</html>