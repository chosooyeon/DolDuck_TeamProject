<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="resources/js/freeboard.js"></script>
<meta charset="UTF-8">
<%-- <meta name="_csrf" content="${_csrf.token}"/> --%>
<%-- <meta name="_csrf_header" content="${_csrf.headerName}"/> --%>

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
			<td>${one.freeboard_id }</td>
			<th>작성일</th>
			<td>${one.freeboard_regdate }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${one.freeboard_title }</td>
		</tr>
		<tr>
			<th height="200">내용</th>
			<td colspan="3">${one.freeboard_content }
				<img src="${pageContext.request.contextPath }/resources/uploadImage/${one.freeboard_file }">
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
			<input type="button" onclick="location.href='free_list.do'" value="목록">
			<input type="button" value="수정" onclick="location.href='free_update.do?freeboard_num=${one.freeboard_num }'">
			<input type="button" value="삭제" onclick="location.href='free_delete.do?id=${one.freeboard_id }'">
		</tr>
	</table>
	<br>
	<table class="table_comment">
		<c:forEach items="${commList }" var="comm">
	<tr>
				<td>	
			댓글작성자 : ${comm.freeboard_id }
		</td>
		<td id="comment_content${comm.freeboard_comment_num }">
			댓글내용 : ${comm.freeboard_comment_content } 
		</td>
<<<<<<< HEAD

		<td>
			댓글작성자 : ${comm.freeboard_id }
		</td>
		<td>
		<td>	
=======
		<td>	

>>>>>>> 44d3330ca2a6572acf7eaf1edd1e59600381d891
			댓글작성시간 : ${comm.freeboard_comment_regdate }
		</td>
		
		<td id="edit_btn">
			<input type="hidden" name="comm-num" value="${comm.freeboard_comment_num }">	
			<input type="hidden" name="comm-content" value="${comm.freeboard_comment_content}">
			<button type="button" id="comment_edit_btn">수정</button>
		</td>
		<td id="reply_btn">
			<input type="hidden" name="board_num" value="${one.freeboard_num }">
			<input type="hidden" name="comm_reg" value="${comm.freeboard_comment_regdate }">
			<input type="hidden" name="comm_num" value="${comm.freeboard_comment_num }">
			<button type="button" id="co_comment_btn">댓글</button>
		</td>
		<td id="delete_btn">
			<button type="button" id="comment_delete_btn" onclick="location.href='freeboard_comment_delete.do?Comment_num=${comm.freeboard_comment_num }&freeboard_num=${one.freeboard_num }'">삭제</button>
		</td>
	</tr>
		</c:forEach>
	</table>
	<br>
	댓글쓰기
	<form action="freeboard_comment_insert.do" method="post">
		<input type="hidden" name="freeboard_num" value="${one.freeboard_num }">
		<input type="hidden" name="freeboard_id" value="${one.freeboard_id }">
	<table class="comment_tadle">
		<tr>
			<td id="comment_textarea">
					<textarea id="comment_textarea_css" rows="2"cols="50" name="freeboard_comment_content"></textarea>	
			</td>
<<<<<<< HEAD
			<td id="comment_submit">
				
				<input type="submit" value="작성">

				<button class="comment_btn" type="submit">작성</button>

=======
			<td id="comment_submit">				
				<button class="comment_btn" type="submit">작성</button>
>>>>>>> 44d3330ca2a6572acf7eaf1edd1e59600381d891
			</td>
			</tr>
	</table>
	</form>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>