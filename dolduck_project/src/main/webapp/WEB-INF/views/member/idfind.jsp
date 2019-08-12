<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/find/idfind.js"></script>
</head>
<body>
<%@include file="../header.jsp" %>

<div class="container login">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 login_table">
		<h1 class="text-center login_text">아이디 찾기</h1>

<form action="${pageContext.request.contextPath}/idfind.do" method="post">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}">
		<table>
	
			<tr>
				<th>NAME</th>
				<td><input class="form-control login" type="text" id="name" name="name" ></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input class="form-control login" type="password" id="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="1"><input class="login_button" type="submit" value="아이디 찾기" ></td>
			</tr>
		</table>
			<span style="color:red;">${id }로 로그인 해주세요!</span>
		<table>
			<tr>
				<td colspan="1"><input class="goto_login" type="button" value="로그인하러가기" ></td>
			</tr>
			<tr>
				<td colspan="1"><input class="find_pw" type="button" value="비밀번호 찾기" onclick="location.href='${pageContext.request.contextPath}/findpw.do'"></td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</div>
</body>
</html>