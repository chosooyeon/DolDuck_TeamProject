<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! DD - Live</title>
<link rel="stylesheet" type="text/css" href="resources/styles/live.css">
<link rel="stylesheet" href="resources/js/fullcalendar/core/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/daygrid/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/timegrid/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/bootstrap/main.css">
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css' rel='stylesheet'>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet' />
<style type="text/css">

.popover-modal{
	width: 200px; height: 130px;
	border: 1px solid #ddd;
	box-shadow: 0 2px 6px rgba(0,0,0,.15);
	background-color: #fff;
	position: absolute;
	z-index: 90;
}
</style>

</head>
<body>
    <!-- Header -->
    <%@include file="../header.jsp" %>
    <!-- Slide Caresel  -->
    <div id="live-slide">
        슬라이드영역
    </div>
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
         <!-- Calendar -->
        <div class="center calendar-box">
		    <div id="calendar"></div>
       </div>
       <div class="popover-modal">
		    	<div class="popover-header">
		    		<span class="currentDate"></span>
		    		<span class="icon-x" onclick="closePopover()"><i class="far fa-times" style="color:#ccc;"></i></span>
		    	</div>
		    	<div class="popover-content">
		    		
		    	</div>
		    	<div class="popover-btns">
		    		<span><a>공유하기</a></span>
		    		<span><a> 찜하기 </a></span>
		    	</div>
		</div>
    </div>

    
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="resources/js/live.js"></script>
    <script src="resources/js/fullcalendar/core/main.js"></script>
    <script src="resources/js/fullcalendar/daygrid/main.js"></script>
    <script src="resources/js/fullcalendar/timegrid/main.js"></script>
    <script src="resources/js/fullcalendar/interaction/main.js"></script>
    <script src="resources/js/fullcalendar/bootstrap/main.js"></script>
    <script src="resources/js/fullcalendar/live-calendar.js"></script>
</body>
</html>