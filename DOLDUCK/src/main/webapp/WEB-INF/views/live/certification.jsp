<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <!-- Header -->
	 <%@include file="../header.jsp" %>
	 
	 <button type="button" class="btn btn-danger" id="gobackBtn">전 페이지로 이동하기</button>
	 <script type="text/javascript">
	 	var backBtn = document.getElementById('gobackBtn')
	 	backBtn.addEventListener('click', function(){
	 		history.back()
	 	})
	 
	 </script>
	 
</body>
</html>