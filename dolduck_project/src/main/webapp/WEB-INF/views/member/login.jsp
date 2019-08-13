<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/> 

<title>Login</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<style type="text/css">
img#kakao-login-btn {
	width: 240px;
	/* padding-left: 30px; */
	height: 40px;
}
</style>
</head>
<body>

	<%@include file="../header.jsp"%>

	<div class="container login">
		<div class="row">
			<div class="col-lg-6 offset-lg-3 login_table">
				<h1 class="text-center login_text">DOL-Duck 로그인</h1>

				<span style="color: red;">${errMsg }</span>
				<form action="${pageContext.request.contextPath}/home.do"
					method="post">
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token}">
					<table>
						<tr>
							<th>ID</th>
							<td><input class="form-control login" type="text" id="id"
								name="id"></td>
						</tr>
						<tr>
							<th>PW</th>
							<td><input class="form-control login" type="password"
								id="pw" name="passwd"></td>
						</tr>
						<tr>
							<td colspan="1"><input class="login_button" type="submit"
								value="로그인"></td>
						</tr>
						<tr>
							<td colspan="1"><input class="join_button" type="button"
								value="회원가입"
								onclick="location.href='${pageContext.request.contextPath}/join.do'"></td>
						</tr>
						<tr>
							<td>&emsp;<a href="idfind.do">아이디 찾기</a>&emsp;
							</td>
							<td>/&emsp;&emsp;<a href="pwfind.do">비밀번호 찾기</a></td>
						</tr>

					</table>
					<!-- <div class="fb-login-button" data-width="" data-size="large"
						data-button-type="login_with" data-auto-logout-link="false"
						data-use-continue-as="false" scope="public_profile,email"
						onlogin="checkLoginState();" style="margin-bottom: 0.4em;"></div>
					<script src="resources/js/sns/facebooklogin.js"></script> -->
					<p></p>
					<a id="kakao-login-btn"></a>
					<script src="resources/js/sns/kakaologin.js"></script>
					<div id="kakao-logged-group"></div>
					<div id="kakao-profile"></div>
					<p></p>
					<%@ include file="./naver.jsp"%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>