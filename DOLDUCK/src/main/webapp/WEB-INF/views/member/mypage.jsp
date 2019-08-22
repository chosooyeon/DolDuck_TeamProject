<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import = "org.springframework.security.core.context.SecurityContextHolder" %>
<%@page import = "org.springframework.security.core.Authentication" %>
<%@page import = "com.my.dolduck.model.dto.MemberDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/join.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div class="container join">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 join_table">
			<h1 class="text-center">마이페이지</h1>
			<form method="post" action="modified.do">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">			
					
					<table class="join_form">
					<c:choose>
							<c:when test="${empty userImage }">
								<div>
									<img id="profileImg" src="/displayFile?fileName=/lion.gif"
										style="border-radius: 0%; padding-top: 10px; height: 100px; width: 100px;">
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<img id="profileImg" src="/displayFile?fileName=${userImage }"
										style="border-radius: 0%; padding-top: 10px; height: 100px; width: 100px;">
								</div>
							</c:otherwise>
						</c:choose>
						<tr>
							<th>이름</th>
						</tr>
						<tr>
							<td><div id="member_name">${dto.member_name }</div></td>
						</tr>
						<tr>
							<th>아이디</th>
						</tr>
						<tr>
							<td><div id="member_id">${dto.member_id}</div></td>
						</tr>
						<tr>
							<th>전화번호</th>
						</tr>
						<tr>
							<td><div id="member_phone">${dto.member_phone}</div></td>
						</tr>
						<tr>
							<th>이메일</th>
						</tr>
						<tr>
							<td><div id="member_email">${dto.member_email}</div></td>
						</tr>
						<tr>
							<th>주소</th>
						</tr>
						<tr>
							<td><div id="member_addr">${dto.member_addr}</div></td>
						</tr>
						<tr>
							<th>하트수량</th>
						</tr>
						<tr>
							<td><div id="member_heart">${dto.member_heart}</div></td>
						</tr>
						<tr>
							<th>투표권</th>
						</tr>
						<tr>
							<td><div id="member_vote">${dto.member_vote}</div></td>
						</tr>
					</table>
					
					<div>
						<button id="modified" type="submit" >회원 정보 수정</button>
						<button id="delete" type="button" onclick="location.href='delete.do'">회원 탈퇴</button>
					</div>
				
 
				</form>
				
		</div>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>