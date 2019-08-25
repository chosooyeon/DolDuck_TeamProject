<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>

	<div class="container freeboard">
		<div class="center">
	<h1 class="text-center">처돌이</h1>
	<button type="button" id="btn-board" onclick="location.href='market_insertform.do'">글작성</button>
	<c:choose>
		<c:when test="${empty list }">
			<h3>게시글이 없습니다....</h3>
			<input type="button" value="글작성" onclick="location.href='market_insertform.do'">
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
						<td align="left"><a href="market_detail.do?market_num=${dto.market_num}">${dto.market_title }</a></td>
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