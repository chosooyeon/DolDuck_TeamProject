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
						<tr>
							<th scope="col">No</th>
							<th scope="col">Name</th>
							<th scope="col">Id</th>
							<th scope="col">Phone</th>
							<th scope="col">Email</th>
							<th scope="col">Addr</th>
							<th scope="col">Heart</th>
							<th scope="col">Vote</th>
							<th scope="col">Enabled</th>
							<th scope="col">Authority</th>
							<th scope="col">Regdate</th>
						</tr>
						<c:choose>
							<c:when test="${empty list}">
								<tr>
									<td colspan="12" align="center">회원정보 없음</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${list}" var="dto">
								<c:if test="${dto.member_role eq 'ROLE_USER' || dto.member_role eq 'ROLE_ARTIST'}">
									<tr>
										<td scope="col" id="seq">${dto.member_seq }</td>
										<td scope="col">${dto.member_name }</td>
										<td scope="col">${dto.member_id }</td>
										<td scope="col">${dto.member_phone }</td>
										<td scope="col">${dto.member_email }</td>
										<td scope="col">${dto.member_addr }</td>
										<td scope="col">${dto.member_heart }</td>
										<td scope="col">${dto.member_vote }</td>
									<c:if test="${dto.member_role eq 'ROLE_USER' || dto.member_role eq 'ROLE_ARTIST'}">
									
									<c:if test="${dto.member_role eq 'ROLE_USER'}">
										<td scope="col"><select name="item">
												<option>${dto.member_role }</option>
												<option>ROLE_ARTIST</option>
										</select>
										</td>
									</c:if>
									<c:if test="${dto.member_role eq 'ROLE_ARTIST'}">
										<td scope="col"><select name="item">
												<option>${dto.member_role }</option>
												<option>ROLE_USER</option>
										</select>
										</td>
									</c:if>
									</c:if>
									
										<td scope="col">${dto.member_enabled }</td>
										<td scope="col"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${dto.member_regdate }" /></td>
										<td scope="col"><button id="upgrade">등급 변경하기</button></td>
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