<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" id="pw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="로그인" onclick="login();"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>