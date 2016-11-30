
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어깨동무 게시판</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./qnacss/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>답변 글 등록</h1>
			<p class="formSign">
				<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="./BoardReplyService.qdo" method="post" id="joinForm"
				name="boardform" enctype="multipart/form-data">
				<input type="hidden" name="q_id" value="<c:out value="${qnaDTO.q_id}"/>" />
				<input type="hidden" name="reply_id" value="<c:out value="${qnaDTO.reply_id}"/>" /> 
				<input type="hidden" name="tab" value="<c:out value="${qnaDTO.tab}"/>" /> 
				<input type="hidden" name="sort" value="<c:out value="${qnaDTO.sort}"/>" />
				<input type="hidden" name="c_id" value="<c:out value="${c_id}"/>" />
				<fieldset>
					<legend>답변 글 </legend>
					<p>
						<label for="m_id">글쓴이 <strong class="require">필수</strong></label>
						<c:choose>
						<c:when test="${!empty(sessionScope.logininfo.m_group) }">
						<input type="text" id="m_id" name="m_id" value="<c:out value="${sessionScope.logininfo.m_id}" />" disabled="disabled" />
						<input type="hidden" id="m_id" name="m_id" value="<c:out value="${sessionScope.logininfo.m_id}" />" />
						</c:when>
						<c:otherwise>
						<input type="text" id="m_id" name="m_id" required placeholder="김정은" />
						</c:otherwise>
						</c:choose>
					</p>
					<p>
						<label for="q_title">제목</label>
						<input type="text" id="q_title"	name="q_title" value="[답변]<c:out value="${qnaDTO.q_title}"/>">
					</p>
					<p>
						<label for="q_content">내용</label>
						<textarea name="q_content" cols="74" rows="15"></textarea>
					</p>
					<p>
						<label for="q_file">파일 수정</label> <input type="file"
							id="q_file" name="q_file" />
					</p>
					<p>
						<label for="q_pwd">비밀번호 <strong class="require">필수</strong></label>
						<c:choose>
						<c:when test="${!empty(sessionScope.logininfo.m_group) }">
						<input type="password" id="q_pwd" name="q_pwd" value="<c:out value="${sessionScope.logininfo.m_pwd}" />" disabled="disabled" />
						<input type="hidden" id="q_pwd" name="q_pwd" value="<c:out value="${sessionScope.logininfo.m_pwd}" />" size="12" />
						</c:when>
						<c:otherwise>
						<input type="password" id="q_pwd" name="q_pwd" required placeholder="비밀번호입력" size="12" />
						</c:otherwise>
						</c:choose>
					</p>
					<div class="btnJoinArea">
						<button type="submit" class="btnOk">글 쓰기</button>
						<button type="reset" class="btnCancel">취소</button>
						<button type="button" value="button"
							onclick="location.href='./list.qna'" class="btnOk">목록</button>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>
