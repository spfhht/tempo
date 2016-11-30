<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:scriptlet>pageContext.setAttribute("bLine", "\n");</jsp:scriptlet>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>게시판</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./qnacss/jboard.css">






<!-- 폼 수정을 위해 주석처리(06/08) -->
<!-- <style type="text/css">
			* {
				padding: 0;
				margin: 0;
				color: #333;
			}

			ul {
				list-style: none;
			}

			#container {
				padding: 30px 20px;
			}

			h1 {
				font-size: large;
				border-left: 10px solid #7BAEB5;
				border-bottom: 1px solid #7BAEB5;
				padding: 10px;
				width: auto;
			}

			#comment_write {
				padding: 20px 15px;
				border-bottom: 1px solid #7BAEB5;
			}

			#comment_write label {
				display: inline-block;
				width: 80px;
				font-size: 14px;
				font-weight: bold;
				margin-bottom: 10px;
			}

			#comment_write input[type='text'], #comment_write textarea {
				border: 1px solid #ccc;
				vertical-align: middle;
				padding: 3px 10px;
				font-size: 12px;
				line-height: 150%;
			}

			#comment_write textarea {
				width: 380px;
				height: 90px
			}

			.comment_item {
				font-size: 13px;
				color: #333;
				padding: 15px;
				border-bottom: 1px dotted #ccc;
				line-height: 150%;
			}

			.comment_item .writer {
				color: #555;
				line-height: 200%;
			}

			.comment_item .writer input {
				vertical-align: middle;
			}

			.comment_item .writer .name {
				color: #222;
				font-weight: bold;
				font-size: 14px;
			}
		</style> -->





<!-- jQuery Framework 참조하기 -->
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>

<!-- 사용자 스크립트 블록 -->
<script type="text/javascript">
	/** 새로운 글을 화면에 추가하기 위한 함수
	 *  - num: 글 번호
	 *  - writer : 작성자 이름
	 *  - contnet : 덧글 내용
	 *  - datetime : 작성일시 */
	function addNewItem(num, writer, content, datetime) {
		// 새로운 글이 추가될 li태그 객체
		var new_li = $("<li>");
		new_li.attr("data-num", num);
		new_li.addClass("comment_item");

		// 작성자 정보가 지정될 <p>태그
		var writer_p = $("<p>");
		writer_p.addClass("writer");

		// 작성자 정보의 이름
		var name_span = $("<span>");
		name_span.addClass("name");
		name_span.html(writer + "님");

		// 작성일시
		var date_span = $("<span>");
		date_span.html(" / " + datetime + " ");

		// 삭제하기 버튼
		var del_input = $("<input>");
		del_input.attr({
			"type" : "button",
			"value" : "삭제하기"
		});
		del_input.addClass("delete_btn");

		// 내용
		var content_p = $("<p>");
		content_p.html(content);

		// 조립하기
		writer_p.append(name_span).append(date_span).append(del_input);
		new_li.append(writer_p).append(content_p);
		$("#comment_list").append(new_li);
	}

	$(function() {
		/** 기본 덧글 목록 불러오기 */
		$.get("../ajax/comment/comment_list.xml", {}, function(data) {
			// 읽어들인 XML에서 "item"태그를 찾아 반복처리
			$(data).find("item").each(function() {
				var num = $(this).find("num").text();
				var writer = $(this).find("writer").text();
				var content = $(this).find("content").text();
				var datetime = $(this).find("datetime").text();
				addNewItem(num, writer, content, datetime);
			});
		}).fail(function() {
			alert("덧글 목록을 불러오는데 실패하였습니다. 잠시후에 다시 시도해 주세요.");
		});

		/** 덧글 내용 저장 이벤트 */
		$("#comment_form").submit(function() {
			// 작성자 이름에 대한 입력여부 검사
			if (!$("#user_name").val()) {
				alert("이름을 입력하세요.");
				$("#user_name").focus();
				return false;
			}

			// 내용에 대한 입력여부 검사
			if (!$("#comment").val()) {
				alert("내용을 입력하세요.");
				$("#comment").focus();
				return false;
			}

			/** 덧글쓰기 성공을 가정한 XML파일 */
			var url = "../ajax/comment/comment_write_ok.xml";
			/** 덧글쓰기 실패를 가정한 XML파일 */
			var url = "../ajax/comment/comment_write_fail.xml";
			/** 덧글쓰기에 대한 PHP예시 */
			//var url = "ajax/comment/comment_write.php";
			/** 덧글쓰기에 대한 JSP예시 */
			var url = "../ajax/comment/comment_write.jsp";

			/** 글 저장을 위한 Post 방식의 Ajax 연동 처리 */
			$.post(url, $(this).serialize(), function(xml) {
				// XML에서 "result"태그의 값을 추출해서 식으로 변환 --> true or false
				var result = eval($(xml).find("result").text());

				// 결과가 저장 실패를 의미한다면 에러 메시지 출력 후, 처리 중단.
				if (!result) {
					alert($(xml).find("message").text());
					return false;
				}

				// 위의 if문을 지나친다면 저장 성공이므로, 저장된 결과를 추출
				var num = $(xml).find("num").text();
				var writer = $(xml).find("writer").text();
				var content = $(xml).find("content").text();
				var datetime = $(xml).find("datetime").text();

				// 저장 결과를 새로운 목록으로 출력하기 위해서 함수 호출
				addNewItem(num, writer, content, datetime);
			}).fail(function() {
				alert("덧글 작성에 실패했습니다. 잠시 후에 다시 시도해 주세요.");
			});

			return false;
		});

		/** 삭제 버튼 클릭시에 항목 삭제하도록 "미리" 지정 */
		$(document).on("click", ".delete_btn", function() {
			if (confirm("정말 선택하신 항목을 삭제하시겠습니까?")) {

				// 덧글 삭제 성공을 가정한 XML파일
				var url = "../ajax/comment/comment_delete_ok.xml";
				// 덧글 삭제 실패를 가정한 XML파일
				var url = "../ajax/comment/comment_delete_fail.xml";
				// 덧글 삭제를 가정한 PHP파일
				//var url = "ajax/comment/comment_delete.php";
				// 덧글 삭제를 가정한 JSP파일
				var url = "../ajax/comment/comment_delete.jsp";

				// 글번호 얻기
				var num = $(this).parent("li").attr("data-num");
				// 삭제 제거 대상 --> 클릭된 버튼을 기준으로 "comment_item"이라는 클래스를 갖는 상위 요소
				var target = $(this).parents(".comment_item");

				/** 글 번호를 통하여 삭제를 요청함 */
				$.post(url, {
					"num" : num
				}, function(xml) {
					// XML에서 "result"태그의 값을 추출해 식으로 변환 --> true, false
					var result = eval($(xml).find("result").text());
					// 결과 메시지
					var message = $(xml).find("message").text();

					// 메시지 출력
					alert(message);

					// 삭제 성공을 의미할 경우, 삭제 대상 요소를 화면에서 제거
					if (result) {
						target.remove();
					}
				}).fail(function() {
					alert("덧글 삭제에 실패했습니다. 잠시 후에 다시 시도해 주세요.");
				});
			}
		});
	});
</script>








</head>
<body>
	<div id="contentsArea">
		<section id="titlename">
			<h1>게시판 내용</h1>
			<p class="formSign">게시판의 글 내용 입니다</p>
			<div id="joinForm">
				<input type="hidden" name="q_id" value="<c:out value="${qnaDTO.q_id }" />">
				<fieldset>
					<legend>게시판 내용</legend>
					<p>
						<label for="c_name">택배회사 </label> <br />
						<c:out value="${qnaDTO.c_name }" />
					</p>
					<p>
						<label for="q_title">제목 </label> <br />
						<c:out value="${qnaDTO.q_title }" />
					</p>
					<p>
						<label for="m_id">글쓴이 </label> <br />
						<c:out value="${qnaDTO.m_id }" />
					</p>
					<p>
						<label for="regdate">등록일 </label> <br />
						<c:out value="${qnaDTO.regdate }" />
					</p>
					<p style="height: 300">
						<label for="q_content">내용</label> <br /> ${fn:replace(qnaDTO.q_content, bLine, "<br>")}
						<!--  ${qnaCommand.q_content} -->
					</p>
					<c:choose>
						<c:when test="${!empty qnaDTO.q_file}">
							<p>
								<label for="q_file">파일 첨부</label><br />
								<c:out value="${qnaDTO.q_file}" />
								&nbsp;&nbsp;&nbsp; <a href="./upload/<c:out value="${qnaDTO.q_file}"/>">파일 내용보기</a> <input type="hidden" name="old_file"
									value="<c:out value="${qnaDTO.q_file}"/>" /> &nbsp;&nbsp;&nbsp; <a href="./download.qna?q_file=<c:out value="${qnaDTO.q_file}" />">파일 다운로드</a><br>
							</p>
						</c:when>
						<c:otherwise>
							<p>
								<label for="old_file">파일 첨부</label><br /> 첨부 파일이 없습니다.
							</p>
						</c:otherwise>
					</c:choose>


					<div id="container">
						<h1>덧글 다시라우</h1>
						<div id="comment_write">
							<form id="comment_form" action="./reply2.qna">
								<div>
								<input type="hidden" name="q_id" value="<c:out value="${qnaDTO.q_id }" />">
									<label for="m_id">작성자</label> <input type="text" name="m_id" id="m_id" /> <input type="submit" value="저장하기" />
								</div>
								<div>
									<label for="comment">덧글 내용</label>
									<textarea name="reply_content" id="reply_content"></textarea>
								</div>
							</form>
						</div>
				

							<!-- <ul id="comment_list"> -->

							<%-- <c:forEach var="reply" items="${qnaCommand2}" varStatus="l">
		   <td>
		   ${reply.reply_name }
		   </td>
		   <td>
		   ${reply.reply_content }
		   </td>
		   <td>
		   ${reply.reply_date }
		   </td>
		   </c:forEach>      --%>

					<%-- <div id="container">
								<div id="comment_write">
									<c:forEach var="reply" items="${qnaCommand2}" varStatus="loop">
											<c:out value="   ${reply.reply_name }" />
											<c:out value="   ${reply.reply_content }" />
											<c:out value="    ${reply.reply_date }" />
									</c:forEach>
								</div>
							<!-- 여기에 동적 생성 요소가 들어가게 됩니다. -->
							<!-- 	</ul> --> --%>
						
							<div id="container">
							<ul id="comment_list">
							<c:forEach var="reply" items="${qnaDTO2}" >
				<li>${reply.reply_name } &nbsp;&nbsp;&nbsp; ${reply.reply_content } &nbsp;&nbsp;&nbsp; ${reply.reply_date } 
					<input type="button" value="삭제하라우" onclick="alert('공사중이래요')"></li>
				</c:forEach>
			</ul>
			</div>			
					</div>
      </div>
					<div class="btnJoinArea">
						<a href="./replymove.qna?q_id=<c:out value="${qnaDTO.q_id}"/>&c_id=<c:out value="${ qnaDTO.c_id}" />">
							<button type="button" class="btnOk">답변</button>
						</a> <a href="./modify.qna?q_id=<c:out value="${qnaDTO.q_id}"/>&m_id=<c:out value="${qnaDTO.m_id }" />">
							<button type="button" class="btnOk">수정</button>
						</a> <a href="./delete.qna?q_id=<c:out value="${qnaDTO.q_id}"/>&m_group=<c:out value="${sessionScope.logininfo.m_group}" />&q_pwd=<c:out value="${qnaDTO.q_pwd}" />">
							<button type="button" class="btnOk">삭제</button>
						</a>
						<button type="button" value="button" onclick="location.href='./list.qna'" class="btnOk">목록</button>
					</div>
				</fieldset>
			</div>
		</section>
	</div>
</body>
</html>