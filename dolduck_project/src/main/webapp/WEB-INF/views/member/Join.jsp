<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/register.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<h1 class="text-center">회원 가입</h1>
	<div class="row">
		<div class="col-xs-3 col-sm-3"></div>
		<div class="col-xs-6 col-sm-6">

			<form method="post"
				action="${pageContext.request.contextPath}/register.do">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token }">

				<header>
					<h3>회원가입</h3>
				</header>
				<table>
					<tr>
						<th>이름</th>
						<td><input type="text" class="text" name="user_name"
							placeholder="이름" required /></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" class="text" name="user_id"
							placeholder="아이디" required />
							<div id="id_confirm"></div> <input type="button" class="idChk"
							id="btn_idcheck" value="중복확인" onclick="id_check()" />
							<p></p>
							<p class="result">
								<span class="msg">아이디를 확인해 주십시오.</span>
							</p></td>

					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" class="text" name="user_pw"
							placeholder="비밀번호" onchange="pass_check()" required />
							<div id="pass_check"></div> <input type="password" class="text"
							name="user_pw02" placeholder="비밀번호 확인" onchange="pass_confirm()"
							required />
							<div id="pass_confirm"></div></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" class="text" name="user_phone"
							placeholder="전화번호" required /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="user_addr" id="addr" placeholder="주소"
							style="width: 60%; height: 30px; float: left;"
							readonly="readonly"> <input type="button" id="set_addr"
							class="e1" onclick="setAddr()" value="주소입력"> <input
							type="text" id="detail_addr" name="detail_addr"
							placeholder="상세주소" style="width: 98%; height: 30px;"> <input
							type="hidden" id="zonecode" name="zonecode" value="" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" class="text" name="user_email"
							placeholder="이메일" required /> <input type="button"
							id="btn_sendemail" value="인증번호발송" onclick="sendEmail()" />
							<p></p></td>
					</tr>
					<tr>
						<th>이메일 인증번호</th>
						<td><input type="text" class="text" name="ranNum"
							placeholder="인증번호" required /> <input type="button" id="ranChk"
							value="인증번호확인" onclick="ranNumChk()" />
							<div id="confirm"></div>
							<div id="emailChkConfirm"></div></td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="example1" style="margin-left: 18em;"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="회원가입"
							style="margin-left: 10em;" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<!-- Contact Section -->
	<div id="contact">
		<div class="container">
			<div class="col-md-8">
				<div class="row">
					<div class="section-title">
						<h2>Get In Touch</h2>
						<p>Please fill out the form below to send us an email and we
							will get back to you as soon as possible.</p>
					</div>
					<form name="sentMessage" id="contactForm" novalidate>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" id="name" class="form-control"
										placeholder="Name" required="required">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="email" id="email" class="form-control"
										placeholder="Email" required="required">
									<p class="help-block text-danger"></p>
								</div>
							</div>
						</div>
						<div class="form-group">
							<textarea name="message" id="message" class="form-control"
								rows="4" placeholder="Message" required></textarea>
							<p class="help-block text-danger"></p>
						</div>
						<div id="success"></div>
						<button type="submit" class="btn btn-custom btn-lg">Send
							Message</button>
					</form>
				</div>
			</div>
			<div class="col-md-3 col-md-offset-1 contact-info">
				<div class="contact-item">
					<h3>Contact Info</h3>
					<p>
						<span><i class="fa fa-map-marker"></i> Address</span>4321
						California St,<br> San Francisco, CA 12345
					</p>
				</div>
				<div class="contact-item">
					<p>
						<span><i class="fa fa-phone"></i> Phone</span> +1 123 456 1234
					</p>
				</div>
				<div class="contact-item">
					<p>
						<span><i class="fa fa-envelope-o"></i> Email</span>
						info@company.com
					</p>
				</div>
			</div>
			<div class="col-md-12">
				<div class="row">
					<div class="social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="fa fa-youtube"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>