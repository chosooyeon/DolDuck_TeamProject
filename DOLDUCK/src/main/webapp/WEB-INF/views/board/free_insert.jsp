<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <meta name="_csrf" content="${_csrf.token}"/> --%>
<%-- <meta name="_csrf_header" content="${_csrf.headerName}"/> --%>


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
		<h1 class="text-center">글작성</h1>

		<form action="free_insert.do" method="post" enctype="multipart/form-data">
			<table class="table">
			<tr align="right">
				<td colspan="2" style="border-top: none; ">
					<button type="button" onclick="location.href='free_list.do'" >취소</button>
					<button type="submit">작성</button>
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" readonly="readonly" style="width: 100%" value="${ member_id}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="freeboard_title" style="width: 100%"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="freeboard_content" id="summernote"></textarea>
					<input multiple="multiple" type="file" name="file">
				</td>
			</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>