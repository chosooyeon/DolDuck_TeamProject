<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>D.Live OnAir</title>
<link rel="stylesheet" type="text/css" href="resources/styles/live.css">
<link rel="stylesheet" type="text/css" href="resources/styles/broadcast.css">
</head>
<body>
    <!-- Header -->
    <%@include file="../header.jsp" %>
    
    <!-- Tab Menu -->
    <div id="main" class="container nav-tab-menu" style="margin-top:8em;">
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
    </div>

   	<!-- content body -->
    <div class="container onair-body">
        <div class="row">
            <div class="col-lg-6" style="position: relative;">
                <div class="channel-description form-inline">
                    <div id="channel-icon"></div>
                    <div id="channel-name-area"><a id="channel-name" href="#">Channel Name</a></div>
                    <div id="channel-follow">
                        <span><i class="fal fa-star"></i></span>
                        <!-- Status in following:  <i class="fas fa-star"></i> -->
                        <span>팔로우</span></div>
                </div>
            </div>
            
    	</div>
        <!-- Channel Logo's Title -->

		
        <div class="form-inline">
            <!-- live-booth -->
            <div class="live-booth">
                <!-- Video  -->
                <div class="channel-video-area">
                    <video id="video" autoplay></video>
                </div> 
                <!-- Live Stream Title -->
                <div class="channel-onair-info">
                    <div id="info-title">
                        <span id="onair-title">Live Stream Title on this</span>
                    </div>
                    <!-- Number of visitors -->
                    <div id="info-numOf-visitor">
                        <span><h4>526</h4></span>
                        <span>명 접속중</span>
                    </div>
                    
                </div>
            </div>
            <!-- Chatroom -->
            <div class="pull-right chatbox">
                <div class="chatroom-top">
                    <h4>채팅</h4>
                    <h5>실시간 채팅</h5>    
                </div>
                <div class="chatroom">
                        <div id="msgDiv">
                            <ul id="messages"></ul>
                        </div>
                </div>
                <div class="chatroom-form">
                    <form action="">
                        <input type="text" id="msg" autocomplete="off" onKeyDown="onChatSubmit()">
                </form>
                </div>
            </div>
        </div>
    </div>

    
    <!-- Footer -->
    <%@include file="/WEB-INF/views/footer.jsp" %>
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <!--  <script src="/socket.io/socket.io.js"></script> -->
    <script src="https://192.168.10.169:5571/socket.io/socket.io.js" type="text/javascript"></script>
    <script src="" type="text/javascript"></script>
    <script src="resources/js/broadcast/js/user.js" type="text/javascript"></script>
    <script src="./js/caster.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="resources/js/utils/live.js"></script>
</body>
</html>