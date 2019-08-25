<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="resources/js/market.js"></script>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>

	<div class="container freeboard">
		<div class="center">
	<h1 class="text-center">상세 보기</h1>

	<table class="table">
		<tr>
			<th>글쓴이</th>
			<td>${one.market_id }</td>
			<th>작성일</th>
			<td>${one.market_regdate }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${one.market_title }</td>
		</tr>
		<tr>
			<th height="200">내용</th>
			<td colspan="3">${one.market_content }</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
			<input type="button" onclick="location.href='market_list.do'" value="취소">
			<input type="button" value="수정" onclick="location.href='market_update.do?market_num=${one.market_num }'">
			<input type="button" value="삭제" onclick="location.href='market_delete.do?id=${one.market_id }'">
		</tr>
	</table>
	<br>
	<table class="table">
		<c:forEach items="${commList }" var="comm">
	<tr>
		<td>
			댓글번호 : ${comm.market_comment_num }
		</td>
		<td id="comment_content${comm.market_comment_num }">
			댓글내용 : ${comm.market_comment_content } 
		</td>
		<td>	
			댓글작성자 : ${comm.market_id }
		</td>
		<td>	
			댓글작성시간 : ${comm.market_comment_regdate }
		</td>
		<td id="edit_btn">
			<input type="hidden" name="comm-num" value="${comm.market_comment_num }">	
			<input type="hidden" name="comm-content" value="${comm.market_comment_content}">
			<button type="button" id="comment_edit_btn">수정</button>
		</td>
		<td id="reply_btn">
			<input type="hidden" name="comm_num" value="${comm.market_comment_num }">
			<button type="button" id="reply_btn">댓글</button>
		</td>
		<td id="delete_btn">
			<button type="button" id="comment_delete_btn" onclick="location.href='market_comment_delete.do?Comment_num=${comm.market_comment_num }&market_num=${one.market_num }'">삭제</button>
		</td>
	</tr>
		</c:forEach>
	</table>
	<br>
	댓글쓰기
	<form action="market_comment_insert.do" method="post">
		<input type="hidden" name="market_num" value="${one.market_num }">
	<table class="comment_tadle">
		<tr>
			<td id="comment_textarea">
				<textarea rows="3"cols="60" name="market_comment_content" style="resize: none;border-style: solid;"></textarea>
			</td>
			<td id="comment_input_id">
				<input type="hidden" name="market_id">	
			</td>
		<tr>
			<td id="comment_submit">
				<input type="submit" value="작성">
			</td>
	</tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>