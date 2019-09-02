<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a.dolduck{ text-decoration:none}
a:hover, a:focus { animation-duration: 3s; animation-name: rainbowLink; animation-iteration-count: infinite; }
@keyframes rainbowLink {
   0% { color: #ff2a2a; }
   15% { color: #ff7a2a; }
   30% { color: #ffc52a }
   45% { color: #43ff2a; }
   60% { color: #2a89ff; }
   75% { color: #202082; }
   90% { color: #6b2aff; }
   100% { color: #e82aff; }
  }
 p { text-align: center;}
</style>
</head>
<body>
	<img src="resources/images/error.png" style="margin-left:auto; margin-right:auto; display:block; width:400px; height: 400px;">
	<c:choose>
		<c:when test="${kind } eq 'Throwable'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq 'Exception'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '400'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '404'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '403'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '405'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '500'">
			<h1 align="center">${kind } Error</h1>
		</c:when>
		<c:when test="${kind } eq '503'">
			<h1 align="center">Error</h1>
		</c:when>
		<c:otherwise>
			<h1 align="center">Error</h1>
			<p>	<a class="dolduck" href="home.do">!!!DolDuck 사이트로 돌아가기!!!</a></p>
		</c:otherwise>
	</c:choose>
</body>
</html>