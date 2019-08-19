<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Mixtape template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="resources/styles/responsive.css">
<title>Add Live Schedules</title>
</head>
<body>
	
	<div class="container">
		<h2>라이브방송 일정 등록</h2>
		<form action="addevent.do">
			<table>
				<tr>
					<td>방송인</td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" name="caster"></td>
				</tr>
				<tr>
					<td>날 짜</td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" name="live-date"></td>
				</tr>
				<tr>
					<td>시 간</td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" name="live-time"></td>
				</tr>
			</table>	
			<button type="button" class="btn btn-warning">&nbsp;등&nbsp;&nbsp;&nbsp;&nbsp;록&nbsp;</button>
			<button class="btn btn-secondary">&nbsp;취&nbsp;&nbsp;&nbsp;&nbsp;소&nbsp;</button>
		</form>	
	</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/styles/bootstrap-4.1.2/popper.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/plugins/greensock/TweenMax.min.js"></script>
<script src="resources/plugins/greensock/TimelineMax.min.js"></script>
<script src="resources/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="resources/plugins/greensock/animation.gsap.min.js"></script>
<script src="resources/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="resources/plugins/easing/easing.js"></script>
<script src="resources/plugins/progressbar/progressbar.min.js"></script>
<script src="resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="resources/plugins/jPlayer/jquery.jplayer.min.js"></script>
<script src="resources/plugins/jPlayer/jplayer.playlist.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script src="https://kit.fontawesome.com/c1455fa856.js"></script>
</body>
</html>