<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>test</title>
</head>
<body>
<form action="translate.do">
<table>
	<tr>
		<td>translate</td>
		<td><input name="inputQuery"></td>
		<td><input type="submit" value="translate"></td>
	</tr>
</table>
</form>
<span style="color:red;">${outputQuery }</span>
</body>
</html>
