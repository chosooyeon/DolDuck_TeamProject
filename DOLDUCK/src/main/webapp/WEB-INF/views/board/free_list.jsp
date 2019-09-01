<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>All About K-POP! DolDuck - 자유게시판</title>
<style>
.freeboard-top-banner{
	background-image: url('');
	background-repeat: no-repeat;
	background-size: cover;
	height: auto;
	width: 100%;
}
</style>
</head>
<body>
<%@ include file="../header.jsp" %>

	<div class="container freeboard">
	<div><img class="freeboard-top-banner" src="resources/images/banner-freeboard.png"></div>
	<button type="button" id="btn-board" onclick="freeInsertLogin()">글작성</button>
	
	<c:choose>
		<c:when test="${empty list }">
			<h3>첫게시물 주인공은 너야너!!!</h3>
		<div class="not_board">
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

						<td>${dto.freeboard_num }</td>		
						<td align="left"><a href="javascript:void(0)" onclick="freeDetailLogin(${dto.freeboard_num})">${dto.freeboard_title }</a></td>



						<td>${dto.freeboard_id }</td>
						<td>${dto.freeboard_regdate }</td>
						<td>0</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="resources/js/freeboard.js"></script>
<script src="resources/js/freeboard_login.js" type="text/javascript"></script>
</body>
</html>