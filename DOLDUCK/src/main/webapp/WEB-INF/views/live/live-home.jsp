<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! DD - Live</title>
<link rel="stylesheet" type="text/css" href="resources/styles/live.css">
</head>
<body>
    <!-- Header -->
    <%@include file="/WEB-INF/views/header.jsp" %>
    <!-- Slide Caresel  -->
    <div id="live-slide" class="container-field">
       <div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="3"></li>
    <li data-target="#demo" data-slide-to="4"></li>
  </ul>

  <!-- 슬라이드 이미지 -->
  <div class="carousel-inner live-main">
	    <div class="carousel-item active">
	      <img class="slide_img" src="http://www.bloter.net/wp-content/uploads/2019/05/BTS-World-800x450.jpg" alt="BTS">
	    </div>
	    <div class="carousel-item">
	      <img class="slide_img" src="https://www.sbs.com.au/popasia/sites/sbs.com.au.popasia/files/styles/full/public/wannaonegaon.jpg?itok=lRwEQOlZ&mtime=1546474382" alt="WannaOne">
	    </div>
	    <div class="carousel-item">
	      <img class="slide_img" src="https://6.viki.io/image/ff72f69842af4bb484e01c6a61216bdb.jpeg?s=900x600&e=t" alt="SevenTeen">
	    </div>
	    <div class="carousel-item">
	      <img class="slide_img" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8FXS6mI1pBs5P-2KPWrHBB2BSibYpplL9SUiCccHXrfcwjdr4" alt="AB6IX">
	    </div>
	    <div class="carousel-item">
	      <img class="slide_img" src="https://www.harpersbazaararabia.com/sites/default/files/styles/ful_scr_img/public/images/2019/04/09/Untitled-design-%281%29_1.png?itok=IFwZlu7Z" alt="BLACKPINK">
	    </div>
	    <div class="carousel-item">
	      <img class="slide_img" src="https://kprofiles.com/wp-content/uploads/2016/05/twice-feature.jpg" alt="TwICE">
	    </div>
  </div>

  <!-- Left and right controls -->
	<div class="btn-slide">
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
	</div>
</div>
   </div>
   <!-- 슬라이드 영역끝 -->
    <%@include file="/WEB-INF/views/live/liveroom-slide.jsp" %>
    <div id="main" class="container nav-tab-menu">
        <!-- Tab Menu -->
    	<div class="col-lg-12 offset-lg-4 "> 
            <nav class="nav">
               <ul class="nav nav-tabs">
                  <li class="nav-item" id="nav-link-home"><a class="nav-link" href="live-home.do">&nbsp;&nbsp;홈&nbsp;&nbsp;</a></li>
                  <li class="nav-item" id="nav-link-schedule"><a class="nav-link" href="live-schedule.do">일정표</a></li>
                  <li class="nav-item" id="nav-link-onair"><a class="nav-link" href="live-onair.do">온에어</a></li>
                  <li class="nav-item" id="nav-link-channel"><a class="nav-link" href="live-channel.do">채널보기</a></li>
               </ul>
            </nav>
         </div>
         <!-- Content -->
         <div class="center live-content">
        </div>

    </div>

    <!-- Footer -->
    <%@include file="/WEB-INF/views/footer.jsp" %>
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="resources/js/utils/live.js"></script>
</body>
</html>