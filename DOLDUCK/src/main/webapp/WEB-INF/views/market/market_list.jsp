<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container market">


		<h1>Market</h1>
		<ul class="nav nav-tabs market_ul">
			<li class="nav-item"><a class="nav-link market_link"
				href="heartShop.do">HeartShop</a></li>
			<li class="nav-item"><a class="nav-link market_link"
				href="market_list.do">Goodies</a></li>
		</ul>
		<div class="col-md-12 market_border">
					<button type="button" id="btn-board"
						onclick="location.href='market_insertform.do'">글작성</button>
					<c:choose>
						<c:when test="${empty list }">
							<div class="not_board">
								<h3>---- 등록 된 게시글이 없습니다 ----</h3>
							</div>
						</c:when>
						<c:otherwise>
							<table class="table">
								<col width="70">
								<col width="400">
								<col width="150">
								<col width="150">
								<col width="50">
								<tr align="center">
									<th>글번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
								<c:forEach items="${list }" var="dto">
									<tr align="center">
										<td>${dto.market_num }</td>
										<td align="left"><a
											href="market_detail.do?market_num=${dto.market_num}">${dto.market_title }</a></td>
										<td>${dto.market_id }</td>
										<td>${dto.market_regdate }</td>
										<td>0</td>
									</tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
				</div>


</div>

</body>
</html>