<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/utils/vote_popup.js" type="text/javascript"></script>
</head>
<body>
	<table>
		<tr>
			<td>투표수</td>
			<td><input id="voteNum" type="number" min="1" max="100"></td>
			<td><input type="button" value="투표하기" onclick="voteNumberChk()"></td>
		</tr>
	</table>
</body>
</html>