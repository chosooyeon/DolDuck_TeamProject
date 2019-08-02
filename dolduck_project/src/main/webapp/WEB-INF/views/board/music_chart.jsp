<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! DD - 실시간 음원차트 순위</title>
<!-- Bootstdap 4 -->
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/chart.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<!-- jQuery library -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/js/chart.js" type="text/javascript"></script>
</head>
<body>
	
	<!-- Header -->
	 <%@include file="../header.jsp" %>

	<h1> Melon Realtime Music Chart</h1>
	<hr><br><br><br><br><br>
	
	
	<p>검색시간 : <label class="label-search"></label><p>
	<div class="container">
		<div class="center musicchart-board">	
			<div class="button-pagination">더 보기</div>	
			<table class="table ">
				<thead>
					<tr>
						<th scope="col">Rank</th>
						<th scope="col">Thumbs</th>
						<th scope="col">Song title</th>
						<th scope="col">Singer</th>
						<th scope="col">Album</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		
	</div>
</body>

</html>