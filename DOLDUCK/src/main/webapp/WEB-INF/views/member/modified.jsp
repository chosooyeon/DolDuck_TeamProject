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
<%@include file="../header.jsp" %>
<div class="container modified">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 modified_table">
			<h1 class="text-center">마이페이지</h1>
			<form method="post" action="${pageContext.request.contextPath}/modifiedfied.do">
              <input type="hidden" name="${member_id}" >			
					
					
					<table class="modified_form">
					<sec:authorize access="isAuthenticated()">
						<tr>
							<th>이름</th>
						</tr>
						<tr>
								<sec:authentication property="principal.username" var="member_name" />
								<td><div id="member_name"><%=name %></div></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<th>아이디</th>
						</tr>
						<tr>
								<sec:authentication property="principal.member_id" var="member_id" />
								<td><div id="member_id">${member_id}</div></td>
						</tr>
						<tr>
						</tr>
						</sec:authorize>
						<tr>
							<th>비밀번호</th>
						</tr>
						<tr>	
							
							<td>
								<input class="form-control" type="password" class="text" name="user_pw" placeholder="비밀번호" onchange="pass_check()" required />
								<div id="pass_check"></div>
								<input class="form-control" type="password" class="text" name="user_pw02" placeholder="비밀번호 확인" onchange="pass_confirm()" required />
								<div id="pass_confirm"></div>
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
						</tr>
						<tr>
							<td>
								<input class="form-control" type="text" class="text" name="user_phone" placeholder="전화번호" required />
							</td>
						</tr>
						<tr>
							<th>이메일</th>
						</tr>
						<tr>
							<td>
								<input class="form-control" type="email" class="text" name="user_email" placeholder="이메일" required/>
								<input type="button" id="btn_sendemail" value="인증번호발송" onclick="sendEmail()"/><p></p>
							</td>
						</tr>
						<tr>
							<td>
								<input class="form-control" type="text" class="text" name="ranNum" placeholder="이메일 인증번호" required/>
								<input type="button" id="ranChk" value="인증번호확인" onclick="ranNumChk()"/>
								<div id="confirm"></div>
								<div id="emailChkConfirm"></div>
							</td>
						</tr>
						<tr>
							<th>주소</th>
						</tr>
						<tr>
							<td>
								<input class="form-control" type="text" name="user_addr" id="addr" placeholder="주소" readonly="readonly"> 
								<input type="button" id="set_addr" class="e1" onclick="setAddr()" value="주소입력"> 
								<input class="form-control" type="text" id="detail_addr" name="detail_addr" placeholder="상세주소" > 
								<input type="hidden" id="zonecode" name="zonecode" value="" />
							</td>
						</tr>
						<tr>
							<td colspan="2" >
								<input id="modified_up" type="submit" value="수정 완료"/>
								<input id="modified_cancle" type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/mypage.do'" >
							</td>
						</tr>
					</table>
				
 
				</form>

		</div>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>