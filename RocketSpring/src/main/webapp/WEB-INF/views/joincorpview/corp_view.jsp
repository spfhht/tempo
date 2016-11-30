<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사 상세 정보</title>
<link href="<%=request.getContextPath()%>/css/corp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
	function moveAction(where){
		switch (where) {
		case 1:
			if(confirm("회사를 삭제하시겠습니까?")){
				location.href ="delete.joincorp?c_id=${joinCorpDto.c_id}";
			}
			break;

		case 2:
			if(confirm("회사정보를 수정하시겠습니까?")){
				location.href = "modify.joincorp?c_id=${joinCorpDto.c_id}";
			}
			break;
			
		case 3:
			location.href = "list.joincorp";			
			break;
		
		
		}
	}
</script>

</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>회사 정보</h1>
			<p class="formSign">회사의 상세 정보 입니다.</p>
			<div id="joinForm"> 
				<input type="hidden" name="num" value="<c:out value="${joinCorpDto.c_num }" />">
					<fieldset>
						<legend>회사 정보</legend>
						<p>
							<label for="name">회사 이름 </label> <br />
							<c:out value="${joinCorpDto.c_name }" />
						</p>
						<p>
							<label for="subject">회사 아이디</label> <br />
							<c:out value="${joinCorpDto.c_id }" />
						</p>
						<p>
							<label for="content">회사 주소</label> <br />
							<c:out value="${joinCorpDto.c_address}" />
						</p>
						<p>
							<label for="content">회사 전화번호</label> <br />
							<c:out value="${joinCorpDto.c_tel}" />
						</p>
						<p>
							<label for="content">회사 가입일</label> <br />
							<c:out value="${joinCorpDto.join_date}" />
						</p>
						
						
						<div class="btnJoinArea">
							<a href="modify.joincorp?c_id=${joinCorpDto.c_id}">
								<button type="button" class="btnOk" onclick="moveAction(2)">수정</button>
							</a> 
							<a href="delete.joincorp?c_id=${joinCorpDto.c_id}">
								<button type="button" class="btnOk" onclick="moveAction(1)">삭제</button>
							</a>
							<a href="list.joincorp">
								<button type="button" class="btnOk" onclick="moveAction(3)">목록</button>
							</a>
					</div>
				</fieldset>			
			</div>
		</section>
	</div>
</body>
</html>