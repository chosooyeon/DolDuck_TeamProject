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
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});
</script>
<body>
<h1>글 작성</h1>

	<form action="free_insert.do" method="post">
		<table border="1">
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="freeboard_id"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="freeboard_title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="freeboard_content" id="summernote"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="button" onclick="location.href='free_list.do'" value="취소">
				 <input type="submit" value="작성" >
			</tr>
		</table>
	</form>
</body>
</html>