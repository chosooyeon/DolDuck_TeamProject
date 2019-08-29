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
            <video autoplay loop muted="muted">
            	<source src="resources/videos/index.mp4" type="video/mp4">
            </video>
      </div>  
   </section>
   
   <!-- vote -->
   <section class="vote">
      <div class="container">
         <div class="row">
               <div class="col-lg-12 vote-banner" style="background-image: url('resources/images/vote-top-banner.png');margin-bottom: 55px;"></div>
            <div class="col-lg-6 offset-lg-3">
            <!-- ranking -->
               <p class="ranking">DOL RANKING CHART</p>
            </div>
         </div>
         <div class="row row-lg-eq-height">
            <div class="col-md-12">
                  <a href="" class="home-vote-star-idol">
                             <p class="rankNum">1</p>
                       </a>
                  <a href="#" class="home-vote-girl-group">
                  		<p class="rankNum">2</p>                          
                  </a>
                  <a href="#" class="home-vote-girl-idol">
                    <p class="rankNum">3</p>
                       </a>
                  <a href="#" class="home-vote-boy-group">
                    <p class="rankNum">4</p>
                       </a>
               <a href="#" class="home-vote-boy-idol">
                    <p class="rankNum">5</p>
                       </a>
                 <a href="#" class="home-vote-new-idol">
                    <p class="rankNum">6</p>
                       </a>
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
		<!-- Extra -->
		<section class="extra">
			<div class="extra_container">
				<div class="background_image"
					style="background-image: url(images/extra.jpg)"></div>
				<div class="container">
					<div class="row">
						<div class="col-lg-9">
							<div
								class="extra_content d-flex flex-column align-items-start justify-content-center">
								<div class="extra_title">
									<h1>Get your tickets now!</h1>
								</div>
								<div class="extra_text">
									<p>In vitae nisi aliquam, scelerisque leo a, volutpat sem.
										Vivamus rutrum dui fermentum eros hendrerit, id lobortis leo
										volutpat. Maecenas sollicitudin est in libero pretium interdum</p>
								</div>
								<div class="extra_button">
									<a href="#">Buy Now</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Footer  -->
	</section>
	<%@include file="footer.jsp"%>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/home.js"></script>
	<script type="text/javascript" src="resources/js/home_vote.js"></script>
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
	<script src="resources/js/utils/youtube.js"></script>
</body>
</html>