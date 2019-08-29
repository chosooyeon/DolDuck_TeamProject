<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="com.my.dolduck.model.dto.MemberDto"%>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	String name = "";

	if (principal != null && principal instanceof MemberDto) {
		name = ((MemberDto) principal).getUsername();
	}
%>
<!DOCTYPE html>
<html>

<head>
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
<title>Header</title>
<script type="text/javascript">
	var temp;

	function input() {
		var input = document.getElementById("input").value;
		temp = input;
	}
</script>
</head>

<body>
	<!-- Header -->
	<header class="header">
		<section
			class="header_content d-flex flex-row align-items-center justify-content-center">
			<div class="logo">
				<a href="home.do"><img id="logo" alt="logo"
					src="resources/images/logo.png"></a>
			</div>
			<div class="log_reg">
				<ul class="d-flex flex-row align-items-start justify-content-start"
					style="margin-bottom: 10px;">
					<sec:authorize access="isAnonymous()">
						<li><a href="${pageContext.request.contextPath}/login.do">Login</a></li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ARTIST')">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"><%=name%>님</a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-item:hover"><a href="logout.do">Logout</a></li>
								<li class="dropdown-item:hover"><a
									href="${pageContext.request.contextPath}/mypage.do">Mypage</a></li>
							</ul></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"><%=name%>님</a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-item:hover"><a href="logout.do">Logout</a></li>
								<li class="dropdown-item:hover"><a
									href="${pageContext.request.contextPath}/admin.do">Userpage</a></li>
							</ul></li>
					</sec:authorize>
				</ul>
			</div>

			<nav class="main_nav">
				<ul class="d-flex skfk">
					<li class="active"><a href="home.do">HOME</a></li>
					<li><a href="youtube.do">YouTube</a></li>
					<li><a href="vote.do">Vote</a></li>
					<li><a href="chart.do">Music Chart</a></li>
					<li><a href="live-home.do">LIVE</a></li>
					<li><a href="free_list.do">Board</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">Market</a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-item:hover"><a href="heartShop.do">heartShop</a></li>
							<li class="dropdown-item:hover"><a href="market_list.do">Goodies</a></li>
						</ul></li>
					<form action="find.do">
						<li class="form-group has-search"><span class="fa fa-search form-control-feedback"></span> 
							<input type="text" class="form-control" placeholder="Search"
							name="Searchtext"></li>
					</form>

				</ul>
			</nav>
			<div class="hamburger ml-auto">
				<div
					class="d-flex flex-column align-items-end justify-content-between">
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
			<div
				class="menu_container d-flex flex-column align-items-start justify-content-center">
				<div class="menu_log_reg">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<sec:authorize access="isAnonymous()">
							<li><a href="${pageContext.request.contextPath}/login.do">Login</a></li>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ARTIST')">
							<li style="color: #fff"><%=name%>님</li>
							<li><a href="logout.do">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage.do">Mypage</a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li style="color: #fff"><%=name%>님</li>
							<li><a href="logout.do">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/admin.do">Userpage</a></li>
						</sec:authorize>
					</ul>
				</div>
				<nav class="menu_nav">
					<ul
						class="d-flex flex-column align-items-start justify-content-start">
						<li><a href="home.do">HOME</a></li>
						<li><a href="youtube.do">You Tube</a></li>
						<li><a href="vote.do">Vote</a></li>
						<li><a href="chart.do">MusicChart</a></li>
						<li><a href="live-home.do">LIVE</a></li>
						<li><a href="free_list.do">Board</a></li>
						<li><a href="heartShop.do">heartShop</a></li>
						<li><a href="market_list.do">Goodies</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</section>
	<!-- Quick Menu -->
	<aside class="quick_icon">
		<ul>
			<li><a class="icon-chat-circle"><i
					class="fas fa-broadcast-tower fa-2x"
					style="color: white; z-index: 20;"></i></a> <input type="hidden"
				name="quick-menu" value="onair"></li>
			<li><a class="icon-chat-circle" href="void:0;"><i
					class="fas fa-atlas fa-2x" style="color: white; z-index: 20;"></i></a>
				<input type="hidden" name="quick-menu" value="translate"></li>
			<li><a class="icon-chat-circle" href="void:0;"><i
					class="fab fa-twitter-square fa-2x"
					style="color: white; z-index: 20;"></i></a> <input type="hidden"
				name="quick-menu" value="twits"></li>
			<li><a class="icon-chat-circle" href="void:0;"><i
					class="fas fa-comments fa-2x" style="color: white; z-index: 20;"></i></a>
				<input type="hidden" name="quick-menu" value="chat"></li>
			<li><a class="icon-chat-circle"
				onclick="$('html').animate({scrollTop : 0})"><i
					class="fas fa-arrow-up fa-2x" style="color: white; z-index: 20;"></i></a>
			</li>
		</ul>
	</aside>

	<!-- Quick Menu iFrame -->

	<div class="quick-menu-frame" style="display: none;">
		<div id="quickframe-close-btn">
			<i class="fas fa-times fa-2x"
				style="color: #fff; padding: 8px; float: right;"></i>
		</div>
		<div id="quickframe-frame-area">
			<iframe id="qucik-iframe" src=""></iframe>
		</div>
	</div>


</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/home.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
<script src="https://d3js.org/d3.v4.min.js"></script>
<script src="https://kit.fontawesome.com/c1455fa856.js"></script>


</html>