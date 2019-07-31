<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>DOL-Duck</title>
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

</head>
<body>

<section class="super_container">
	
	<!-- Header -->
	<header class="header">
		<section class="header_content d-flex flex-row align-items-center justify-content-center">
			<div class="logo"><a href="#">DOL-Duck</a></div>
			<div class="log_reg">
				<ul class="d-flex flex-row align-items-start justify-content-start">
					<li><a href="#">Login</a></li>
					<li><a href="#">Register</a></li>
				</ul>
			</div>
			
			<nav class="main_nav">
				<ul class="d-flex flex-row align-items-start justify-content-start">
					<li class="active"><a href="index.html">HOME</a></li>
					<li><a href="#">You Tube</a></li>
					<li><a href="#">Vote</a></li>
					<li><a href="chart.do">Music Chart</a></li>
					<li><a href="#">LIVE</a></li>
					<li><a href="#">Board</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Market</a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-item:hover" ><a href="#">Hartship</a></li>
							<li class="dropdown-item:hover" ><a href="#">goodship</a></li>
						</ul>
					</li>
					<li class="form-group has-search">
						<span class="fa fa-search form-control-feedback"></span> 
						<input type="text" class="form-control" placeholder="Search">
					</li>
				</ul>
			</nav>
			<div class="hamburger ml-auto">
				<div class="d-flex flex-column align-items-end justify-content-between">
					<div></div>
					<div></div>
					<div></div>
				</div>
			</div>
		</section>
	</header>

	<!-- Menu -->

	<section class="menu">
		<div>
			<div class="menu_overlay"></div>
			<div class="menu_container d-flex flex-column align-items-start justify-content-center">
				<div class="menu_log_reg">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a href="#">Login</a></li>
						<li><a href="#">Register</a></li>
					</ul>
				</div>
				<nav class="menu_nav">
					<ul class="d-flex flex-column align-items-start justify-content-start">
						<li><a href="#">HOME</a></li>
						<li><a href="#">You Tube</a></li>
						<li><a href="#">Vote</a></li>
						<li><a href="#">Music Chart</a></li>
						<li><a href="#">LIVE</a></li>
						<li><a href="#">Board</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</section>

	<!-- Home -->
	

	<section class="home">
		<div class="home_video">
		<!-- video -->
				<div class="embed-responsive embed-responsive-16by9">
				<!-- resources/videos/index.mp4 -->
					<iframe class="embed-responsive-item" src=""></iframe>
				</div>
		</div>  
	</section>
	
	<!-- vote -->
	<section class="vote">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
				<!-- ranking -->
					<p class="ranking">DOL RANKING CHART</p>
				</div>
			</div>
			<div class="row row-lg-eq-height">
				<div class="col-md-12">
						<a href="#" class="item">
                    		<div class="thum" style="background-image:url(resources/images/2.jpg)"></div>
	                    	<div class="txt-container">
		                    	<p class="date">빅</p>
		                        <p class="bbsTit">뱅</p>
	                    	</div>
	                    	<div class="etc">
		                        <p class="reply"><i class="far fa-comment-alt"></i>549</p>
		                        <p class="favorites"><i class="fas fa-heart"></i>&nbsp;21,838</p>
		                    </div>
                   			 <p class="rankNum">1</p>
	                    </a>\
						<a href="#" class="item">
                    		<div class="thum" style="background-image:url(resources/images/3.jpg)"></div>
	                    		<div class="txt-container">
		                      		<p class="date">big</p>
		                        	<p class="bbsTit">bang</p>
	                    	</div>
	                    	<div class="etc">
		                        <p class="reply"><i class="far fa-comment-alt"></i>549</p>
		                        <p class="favorites"><i class="fas fa-heart"></i>&nbsp;21,838</p>
		                    </div>
                   		 <p class="rankNum">2</p>
	                    </a>
						<a href="#" class="item">
                    		<div class="thum" style="background-image:url(resources/images/4.jpg)"></div>
	                    		<div class="txt-container">
		                      		<p class="date">big</p>
		                        	<p class="bbsTit">bang</p>
	                    	</div>
	                    	<div class="etc">
		                        <p class="reply"><i class="far fa-comment-alt"></i>549</p>
		                        <p class="favorites"><i class="fas fa-heart"></i>&nbsp;21,838</p>
		                    </div>
                    <p class="rankNum">3</p>
	                    </a>
						<a href="#" class="item">
                    		<div class="thum" style="background-image:url(resources/images/5.jpg)"></div>
	                    		<div class="txt-container">
		                      		<p class="date">big</p>
		                        	<p class="bbsTit">bang</p>
	                    		</div>
	                    	<div class="etc">
		                        <p class="reply"><i class="far fa-comment-alt"></i>549</p>
		                        <p class="favorites"><i class="fas fa-heart"></i>&nbsp;21,838</p>
		                    </div>
                    <p class="rankNum">4</p>
	                    </a>
					<a href="#" class="item">
                    		<div class="thum" style="background-image:url(resources/images/1.jpg)"></div>
	                    		<div class="txt-container">
		                      		<p class="date">big</p>
		                        	<p class="bbsTit">bang</p>
	                    		</div>
	                    	<div class="etc">
		                        <p class="reply"><i class="far fa-comment-alt"></i>549</p>
		                        <p class="favorites"><i class="fas fa-heart"></i>&nbsp;21,838</p>
		                    </div>
                    <p class="rankNum">5</p>
	                    </a>
				</div>
				<div class="vote_button"><a href="#">Vote Now</a></div>
				
					
				
			</div>
		</div>
		
	</section>
<svg width="700" height="320"></svg>

	<!-- Extra -->

	<div class="extra">
		<div class="extra_container">
			<div class="background_image" style="background-image:url(images/extra.jpg)"></div>
			<div class="container">
				<div class="row">
					<div class="col-lg-9">
						<div class="extra_content d-flex flex-column align-items-start justify-content-center">
							<div class="extra_title"><h1>Get your tickets now!</h1></div>
							<div class="extra_text">
								<p>In vitae nisi aliquam, scelerisque leo a, volutpat sem. Vivamus rutrum dui fermentum eros hendrerit, id lobortis leo volutpat. Maecenas sollicitudin est in libero pretium interdum</p>
							</div>
							<div class="extra_button"><a href="#">Buy Now</a></div>
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>
	
	<!-- 1:1 Contect Chat Center (Fixed Navigator) -->
	<div class="div-button-chat" onclick="gotoChat()">
		<div class="icon-chat-ball"><i class="fas fa-comment-dots"></i></div>	
		<div class="icon-chat-circle"></div>
	</div>
	
	<div class="div-modal-chat">
		<div class="modal-top">
			<div id="modal-title">고객센터</div>
			<span></span>
		</div>
		<a href="#" class="button-modal-close" onclick="closeChat()">X</a>
		<iframe src="http://localhost:3000/"></iframe>
	</div>

	<!-- Footer -->

	<footer class="footer">
		<div class="footer_container d-flex flex-xl-row flex-column align-items-start justify-content-start">
			<div class="newsletter_container">
				<div class="newsletter_title"><h2>Subscribe to our newsletter</h2></div>
				<form action="#" id="newsletter_form" class="newsletter_form">
					<input type="email" class="newsletter_input" placeholder="Your E-mail" required="required">
					<button class="newsletter_button">Subscribe</button>
				</form>
			</div>
			<div class="footer_lists d-flex flex-sm-row  flex-column align-items-start justify-content-start ml-xl-auto">

				<!-- Useful Links -->
				<div class="footer_list">
					<div class="footer_list_title">Useful Links</div>
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="about.html">About us</a></li>
						<li><a href="#">Testimonials</a></li>
						<li><a href="#">Music</a></li>
						<li><a href="blog.html">News</a></li>
					</ul>
				</div>

				<!-- Mixtape -->
				<div class="footer_list">
					<div class="footer_list_title">Mixtape</div>
					<ul>
						<li><a href="#">Music</a></li>
						<li><a href="#">PR & Marketing</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">About us</a></li>
						<li><a href="#">Testimonials</a></li>
					</ul>
				</div>

				<!-- Connect -->
				<div class="footer_list">
					<div class="footer_list_title">Connect</div>
					<ul>
						<li><a href="#">Returns</a></li>
						<li><a href="#">Shippings</a></li>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Social Media</a></li>
						<li><a href="#">Soundcloud</a></li>
					</ul>
				</div>

			</div>
		</div>
		<div class="copyright_bar">
			<span><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</span>
		</div>
	</footer>
</section>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/home.js"></script>
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
<script src="resources/plugins/jPlayer/jquery.jplayer.min.js"></script>
<script src="resources/plugins/jPlayer/jplayer.playlist.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/d3.min.js"></script>
<script src="https://kit.fontawesome.com/c1455fa856.js"></script>
</body>
</html>