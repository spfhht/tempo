<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="./img/favicon.ico"
	type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="./qnacss/jboard.css">
</head>
<body>
	<div id="contentArea">
		<section id="titlename">
			<h1>게시판 글 쓰기</h1>
			<p class="formSign">
				<strong class="require">필수</strong>는 반드시 입력하여야 하는 항목입니다.
			</p>
			<form action="./write.qna" method="post" id="joinForm" name="qnaform"
				enctype="multipart/form-data">
				<fieldset>
					<legend>게시판 글쓰기</legend>
					<c:choose>
						<c:when test="${!(sessionScope.logininfo.m_group eq '2') }">
							<p>
								<label for="delevery">택배회사 <strong class="required">필수</strong></label>
								<select name="c_id" class="b_search" style="margin-top: 8px;"
									autofocus="autofocus" required="required">
									
									<c:forEach var="corp" items="${corpList}">
										<option value="${corp.c_id}"
											<c:if test="${corp.c_id == keyfield}">selected="selected"</c:if>><c:out
												value="${corp.c_name}"></c:out></option>
									</c:forEach>
								</select>
							</p>
						</c:when>
					</c:choose>
					<p>
						<label for="q_id">작성자 <strong class="require">필수</strong></label>
						<c:choose>
							<c:when test="${sessionScope.logininfo.m_group eq '1' }">
								<input type="text" id="m_id" name="m_id"
									value="<c:out value="${sessionScope.logininfo.m_id}" />"
									disabled="disabled" />
								<input type="hidden" id="m_id" name="m_id"
									value="<c:out value="${sessionScope.logininfo.m_id}" />" />
							</c:when>
							<c:when test="${sessionScope.logininfo.m_group eq '2' }">
								<input type="text" id="c_id" name="c_id"
									value="<c:out value="${sessionScope.logininfo.c_id}" />"
									disabled="disabled" />
								<input type="hidden" id="c_id" name="c_id"
									value="<c:out value="${sessionScope.logininfo.c_id}" />" />
							</c:when>
							<c:otherwise>
								<input type="text" id="m_id" name="m_id" required
									placeholder="김정은" />
							</c:otherwise>
						</c:choose>
					</p>
					<p>
						<label for="password">비밀번호 <strong class="require">필수</strong></label>
						<c:choose>
							<c:when test="${sessionScope.logininfo.m_group eq '1'  }">
								<input type="password" id="q_pwd" name="q_pwd"
									value="<c:out value="${sessionScope.logininfo.m_pwd}" />"
									disabled="disabled" />
								<input type="hidden" id="q_pwd" name="q_pwd"
									value="<c:out value="${sessionScope.logininfo.m_pwd}" />" />
							</c:when>
							<c:when test="${sessionScope.logininfo.m_group eq '2' }">
								<input type="password" id="c_pwd" name="c_pwd"
									value="<c:out value="${sessionScope.logininfo.c_pwd}" />"
									disabled="disabled" />
								<input type="hidden" id="c_pwd" name="c_pwd"
									value="<c:out value="${sessionScope.logininfo.c_pwd}" />" />
							</c:when>
							<c:otherwise>
								<input type="password" id="q_pwd" name="q_pwd" required
									placeholder="" />
							</c:otherwise>
						</c:choose>

					</p>
					<p>
						<label for="subject">제목 <strong class="require">필수</strong></label>
						<input type="text" id="q_title" name="q_title" required="required"
							placeholder="글의 제목을 입력하라우" />
					</p>
					<p>
						<label for="q_content">내용 <strong class="require">필수</strong></label>
						<textarea id="q_content" name="q_content" cols="74" rows="15"
							required placeholder="글의 내용을 입력하라우"></textarea>
					</p>
					<p>
						<label for="q_file">파일첨부 </label> <input type="file" id="q_file"
							name="q_file" placeholder="파일첨부" />
					</p>
					<div class="btnJoinArea">
						 <button type="submit" class="btnOk">글 등록</button> 
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