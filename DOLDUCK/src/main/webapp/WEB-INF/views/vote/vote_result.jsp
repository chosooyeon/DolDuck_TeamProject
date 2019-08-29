<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td><h1>${starName} 에게 ${voteNumber} 표 투표하였습니다.</h1></td>
	</tr>
	<tr>
		<td><input type="button" onclick="location.href=vote.do; javascript:window.close();">닫기</td>
	</tr>
</table>
</body>
</html>