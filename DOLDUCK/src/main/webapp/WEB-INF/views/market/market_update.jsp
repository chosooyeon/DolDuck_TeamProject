<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Insert title here</title>
</head>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script>
(function($){
	$(document).ready(function() {
		$('#summernote').summernote({
		    	placeholder: 'content',
		        minHeight: 370,
		        maxHeight: null,
		        focus: true, 
		        lang : 'ko-KR'
		  });
		});
	
})(jQuery);
</script>
<body>
<%@ include file="../header.jsp" %>

	<div class="container freeboard">
	<div class="center">
	<h1 class="text-center">수정 하기</h1>

	<form action="market_updateform.do" method="post" >
		<input type="hidden" name="market_id" value="${one.market_id }">
		<table class="table">
			<tr align="right">
				<td colspan="4" style="border-top: none; ">
					<button type="button" onclick="location.href='market_list.do'">취소</button>
					<button type="submit">작성</button>
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${one.market_id }</td>
				<th>작성일</th>
				<td>${one.market_regdate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="market_title" value=${one.market_title } style="width: 100%" ></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea id="summernote"rows="10" cols="60" name="market_content">${one.market_content }</textarea></td>
			</tr> 
		</table>
	</form>
	</div>
	</div>
</body>
</html>