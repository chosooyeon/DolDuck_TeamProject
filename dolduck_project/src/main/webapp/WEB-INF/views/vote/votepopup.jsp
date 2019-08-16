<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/star.js" type="text/javascript"></script>
</head>
<body>
	<table>
		<tr>
			<td>투표수</td>
			<td><input id="voteNum" type="number" min="1" max="100"></td>
			<td><input type="button" value="투표하기" onclick="voteSetNum()"></td>
		</tr>
	</table>
</body>
</html>