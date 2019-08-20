<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>All About K-POP! DD - Star</title>
<!-- Bootstdap 4 -->
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/chart.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<!-- jQuery library -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/js/vote.js?ver=1" type="text/javascript"></script>
<style type="text/css">
.star-thumbnail{
	width : 100px; height: 100px;
	background: salmon;
	border-radius : 5em;
	color: white;
	font-weight: bold;
	font-size : 15px;
	cursor : pointer;
	margin : 10px;
	display: inline-block;
	text-align: center;
}
</style>
</head>
<body>
	<!-- Header -->
	 <%@include file="../header.jsp" %>

	<h1> BoyGroup Chart</h1>
	<hr><br><br><br><br><br>
	
	<div class="div-star">
		<div class="div-button">
			<div class="girl-group">여자 그룹</div>
		</div>
		<div class="div-button">
			<div class="girl-idol">여자 아이돌</div>
		</div>
		<div class="div-button">
			 <div class="new-idol">신인 스타</div>
		</div>
		<div class="div-button">
			<div class="star-idol">별별 스타</div>
		</div>		
		<div class="div-button">
			<div class="boy-group">남자 그룹</div>
		</div>
		<div class="div-button">
			<div class="boy-idol">남자 아이돌</div>
		</div>
	</div>
	<div class="container">
		<div class="center votechart-board">
			<p>검색시간 : <label class="current-time"></label><p>
			<table class="table">
				<thead>
					<tr id="">
						<th scope="col">Star</th>
						<th scope="col">Img</th>
						<th scope="col">투표하기</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
			<button class="button-pagination">더 보기</button>	
		</div>
	</div>
</body>
</html>