<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
</head>
<body>
	<%@include file="../header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 admin">
				<button class="accordion">
					<h1 class="text-center">회원관리</h1>
				</button>
				<div class="panel">
					<table class="table">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
					<col width="70">
						<tr>
							<th>No</th>
							<th>Name</th>
							<th>Id</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Addr</th>
							<th>Heart</th>
							<th>Vote</th>
							<th>Enabled</th>
							<th>Authority</th>
							<th>Regdate</th>
						</tr>
						<c:choose>
							<c:when test="${empty list}">
								<tr>
									<td colspan="12" align="center">회원정보 없음</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${list}" var="dto" varStatus="status">
								<c:if test="${dto.member_role eq 'ROLE_USER' || dto.member_role eq 'ROLE_ARTIST'}">
									<tr id="a${status.count }">
										<td class="seq">${dto.member_seq }</td>
										<td>${dto.member_name }</td>
										<td>${dto.member_id }</td>
										<td>${dto.member_phone }</td>
										<td>${dto.member_email }</td>
										<td>${dto.member_addr }</td>
										<td>${dto.member_heart }</td>
										<td>${dto.member_vote }</td>
									<c:if test="${dto.member_role eq 'ROLE_USER' || dto.member_role eq 'ROLE_ARTIST'}">
									
									<c:if test="${dto.member_role eq 'ROLE_USER'}">
										<td><select name="item">
												<option>${dto.member_role }</option>
												<option>ROLE_ARTIST</option>
										</select>
										</td>
									</c:if>
									<c:if test="${dto.member_role eq 'ROLE_ARTIST'}">
										<td><select name="item">
												<option>${dto.member_role }</option>
												<option>ROLE_USER</option>
										</select>
										</td>
									</c:if>
									</c:if>
									
										<td>${dto.member_enabled }</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.member_regdate }" /></td>
										<td><button id="upgrade">등급 변경하기</button></td>
									</tr>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</table>
					<button class="button-pagination">더 보기</button>
				</div>
			</div>
		</div>
	</div>


	<script src="resources/js/admin.js" type="text/javascript"></script>
</body>
</html>