<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Youtube API Test</title>
    <!-- Latest compiled and minified CSS -->
   <link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="resources/styles/responsive.css">
</head>
<title>All About K-POP! DD - Youtube 영상보기</title></head>
<body>
<!-- Header -->
<%@include file="../header.jsp" %>

	<!-- <div class="container">
		<div class="row">
		<div class="col-md-5 div-channel">
			<div class="button-channel">뮤직뱅크</div>
			<div class="button-channel">인기가요</div>
			<div class="button-channel">쇼!음악중심</div>
			<div class="button-channel">M카운트다운</div>
			<div class="button-channel">딩고뮤직</div>
		</div>
		</div>
	</div> -->
	<div id="getVideo"></div>
	
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="resources/js/youtube.js" type="text/javascript"></script>
</body>
</html>