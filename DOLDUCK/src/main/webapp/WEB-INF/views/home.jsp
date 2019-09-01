<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>All About K-POP! - DolDuck</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mixtape template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link
	href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="resources/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css"
	href="resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css"
	href="resources/styles/responsive.css">

</head>
<body>

	<!-- Header  -->
	<%@include file="header.jsp"%>
	<section class="super_container">
   <!-- Home -->
   <section class="home">
      <div class="home_video">
      <!-- 
      video 속성      
      controls: 재생,시간,.. 컨트롤 화면 
      autoplay: 자동 재생
      loop: 무한반복
      muted:음소거
      -->   
      		<img alt="" src="resources/images/kangdaniel-image.GIF" style="width:100%;">
      		<!-- 강다니엘 뮤직비디오 -->
            <!-- <video autoplay loop muted="muted">
            	<source src="resources/videos/kang.mp4" type="video/mp4">
            </video> -->
      </div>  
   </section>
   
   <!-- vote -->
   <section class="vote">
      <div class="container">
         <div class="row">
               <div class="col-lg-12 vote-banner" style="background-image: url('resources/images/banner-home-01.png');margin-bottom: 55px; cursor: pointer;" onclick="location.href='vote.do';"></div>
            <div class="col-lg-6 offset-lg-3">
            <!-- ranking -->
               <p class="ranking">DOL RANKING CHART</p>
            </div>
         </div>
         <div class="row">
            <div class="col-md-12">
                <a href="vote.do" class="home-ranking home-vote-star-idol"></a>
                <a href="vote.do" class="home-ranking home-vote-girl-group"></a>
                <a href="vote.do" class="home-ranking home-vote-girl-idol"></a>
                <a href="vote.do" class="home-ranking home-vote-boy-group"></a>
               	<a href="vote.do" class="home-ranking home-vote-boy-idol"></a>
                <a href="vote.do" class="home-ranking home-vote-new-idol"></a>
  			</div>

				<div class="vote_button"><a href="vote.do">Vote Now</a></div>
			</div>
		</div>
		
	</section>
				 	<!-- 그래프 -->
	<svg width="1170" height="502"></svg>

		<!-- youtube -->
		<section class="channel">
			<div class="container">
				
					<div class="col-lg-6 offset-lg-3">
						<!-- youtube -->
						<p class="dol_now">나의 DOL은 지금</p>
					</div>
				
				
					<div class="channel_button">
						<a href="youtube.do">Channel More</a>
					</div>
					<!-- 채널 영상 넣기 -->
					<div id="getVideo"></div>			
			</div>
		</section>

<!-- 		<div class="div-modal-chat">
			<div class="modal-top">
				<div id="modal-title">고객센터</div>
				<span></span>
			</div>
			<a href="#" class="button-modal-close" onclick="closeChat()">X</a>
			<iframe class="iframe-chat" src="http://192.168.10.169:3000/"></iframe>
		</div> -->

		<!-- Footer  -->
	</section>
	<%@include file="footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="resources/js/home.js"></script>
	<script src="resources/js/home_vote.js"></script>
	<script src="resources/js/jquery-3.2.1.min.js"></script>
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
	<script src="resources/js/custom.js"></script>
	<script src="resources/js/d3.min.js"></script>
	<script src="https://kit.fontawesome.com/c1455fa856.js"></script>
</body>
</html>