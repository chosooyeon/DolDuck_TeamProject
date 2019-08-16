<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import = "org.springframework.security.core.context.SecurityContextHolder" %>
<%@page import = "org.springframework.security.core.Authentication" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/register.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div class="container join">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 join_table">
			<h1 class="text-center">마이페이지</h1>
			<form method="post" action="${pageContext.request.contextPath}/modified.do">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">			
					
					
					<table class="join_form">
					<sec:authorize access="isAuthenticated()">
						<tr>
							<th>이름</th>
						</tr>
						<tr>
                    		<sec:authentication property="principal.username" var="member_name" />
							<td><div id="member_name"><%=name %></div></td>
						</tr>
						<tr>
							<th>아이디</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_id" var="member_id" />
							<td><div id="member_id">${member_id}</div></td>
						</tr>
						<tr>
							<th>전화번호</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_phone" var="member_phone" />
							<td><div id="member_phone">${member_phone}</div></td>
						</tr>
						<tr>
							<th>이메일</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_email" var="member_email" />
							<td><div id="member_email">${member_email}</div></td>
						</tr>
						<tr>
							<th>주소</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_addr" var="member_addr" />
							<td><div id="member_addr">${member_addr}</div></td>
						</tr>
						<tr>
							<th>하트수량</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_heart" var="member_heart" />
							<td><div id="member_heart">${member_heart}</div></td>
						</tr>
						<tr>
							<th>투표권</th>
						</tr>
						<tr>
							<sec:authentication property="principal.member_vote" var="member_vote" />
							<td><div id="member_vote">${member_vote}</div></td>
						</tr>
						</sec:authorize>
					</table>
					
					<div>
						<button id="modified" type="submit" value="회원 정보 수정" ></button>
					</div>
				
 
				</form>
				
		</div>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>