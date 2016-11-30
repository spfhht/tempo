<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 정보</title>
<link rel="stylesheet" type="text/css" href="./css/corp.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="corpList">
			<h1>회사 택배 정보</h1>
			<div id="infoArea">
				<section class="search">
					<form name="search"
						action="./parcellist.parcelmanagement?manager_id=<c:out value="${parcel.manager_id}"/>"
						method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label>
							<select id="type" name="type" class="b_search">
								<option value="delivery_id">수화물 번호</option>
								<option value="delivery_state">배송 상태</option>
								<option value="p_r_name">받는 사람</option>
							</select>
							<input type="text" id="keyword" name="keyword"
								required="required" placeholder="검색어를 입력하세요"
								value="<%if (request.getParameter("keyword") != null) {
				out.print(request.getParameter("keyword"));
			} else {
				out.print("");
			}%>">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div>




			<p class="allPost">
				전체 택배: &nbsp; <strong><c:out value="${totalNum}" /> </strong>개
			</p>
			<table class="boardTable">
				<c:choose>
					<c:when test="${totalNum>0}">
						<thead>
							<tr>
								<th scope="col" class="corpNumber">운송장번호</th>
								<th scope="col" class="corpName">배송상태</th>
								<th scope="col" class="corpId">받는사람</th>

							</tr>
						</thead>
						<c:forEach var="parcel" items="${parcelList}" varStatus="status">
							<tbody>
								<tr>
									<td><a
										href="./getdetail.parcelmanagement?delivery_id=<c:out value="${parcel.delivery_id}" />&id=<c:out value="${id}"/>"><c:out
												value="${parcel.delivery_id}" /></a></td>

									<td><c:out value="${parcel.delivery_state}" /></td>
									<td><c:out value="${parcel.p_r_name}" /></td>

								</tr>

							</tbody>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>

			<div align="center">${pageHtml}</div>
			<div id="infoArea">
				<section class="insert">
					<form name="join" action="bring.parcelmanagement" method="get">
						<fieldset>
							<legend>수화물 가져오기</legend>
							<button type="submit">수화물 가져오기</button>
						</fieldset>
					</form>
				</section>
			</div>
		</section>
	</div>
</body>
</html>