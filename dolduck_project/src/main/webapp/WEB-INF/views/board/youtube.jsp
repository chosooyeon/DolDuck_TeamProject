<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Youtube API Test</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mixtape template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="resources/styles/responsive.css">
<style type="text/css">
body{ color : black; }
.button-channel{
	width : 100px; height: 100px;
	background: salmon;
	border-radius : 2em;
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
<title>All About K-POP! DD - Youtube 영상보기</title></head>
<body>
<!-- Header -->
<%@include file="../header.jsp" %>

	<div id="getVideo"></div>
	<div class="container">
		<div class="row">
		<div class="col-md-5 div-channel">
			<div class="button-channel">뮤직뱅크
				<!-- KBS 뮤직뱅크직캠 -->
				<input type="hidden" class="videoId" name="musicbank" value="PLK8rVA0_KzOc-Trk-kz1sQijhADYXLY6C" >
			</div>
			<div class="button-channel">인기가요
				<!-- SBS 인기가요 안방1열 직캠 -->
				<input type="hidden" class="videoId" name="ingigayo" value="PLzJT711y0gzKU38jpQ2DftF-QBX9iELp5">
			</div>
			<div class="button-channel">쇼!음악중심
				<!-- MBC 예능연구소 직캠-->
				<input type="hidden" class="videoId" name="showjung" value="PLoE9F5MjfXCCvYGvHR0iJOeeaMEvBv191">
			</div>
			<div class="button-channel">M카운트다운
				<!--  M2 직캠  -->
				<input type="hidden" class="videoId" name="mcount" value="PLQv1U2oSD8oB_M-Pk8gVuDB8MA65a9UBm">
			</div>
			<div class="button-channel">쇼챔피언
				<!-- 쇼챔 TWO캠 -->
				<input type="hidden" class="videoId" name="showchamp" value="PLHhwBCdvOkY_xmNMDkl4i6pZO69wxnO_4">
			</div>
			<div class="button-channel">딩고뮤직
				<!-- 100초 ZIP -->
				<!-- 이슬라이브 : PLmxVF8ick5cS8ywQrE-4l6871ZfRxSDj_ -->
				<input type="hidden" class="videoId" name="dingo" value="PLmxVF8ick5cQIHKYYsuOKWOOMUaJxyJP1">
			</div>
			<div class="button-channel">1theK
				<!-- NewRelase MV -->
				<input type="hidden" class="videoId" name="1thek" value="PLID4CZACkMJTQGYm6R0Gc4yk_CKZIZKdv">
			</div>
		</div>
		</div>
	</div>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/styles/bootstrap-4.1.2/popper.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/js/youtube.js"></script>
</body>
</html>