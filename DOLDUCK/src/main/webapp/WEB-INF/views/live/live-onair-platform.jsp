<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! DD - Live</title>
<link rel="stylesheet" type="text/css" href="resources/styles/live.css">
</head>
<body>
    <!-- Header -->
    <%@include file="../header.jsp" %>
	<!-- Slide Caresel  -->
    <%@include file="/WEB-INF/views/live/liveroom-slide.jsp" %>
    
    <!-- Tab Menu -->
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
    </div>

   	<!-- Title & Banner -->
   	<div class="container"> 
         <div class="live-banner" > 
         	<h4>ON AIR</h4>
			<h5>생방송! 관심 아티스트와 채널을 팔로우하고, 라이브 방송을 즐겨 보세요!</h5>
         </div>
         
        <!-- Add Events Button for ADMIN -->
        <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ARTIST')">
	        <div id="area-addEvent">
	        	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#liveInfoModal">방 송 시 작</button>
	        </div> 
        </sec:authorize>
    </div>
    
   	<!-- Onair Channel list - waiting room -->
	<div class="container">
		<div class="channel-list">
	       <ul></ul>
	    </div>
	</div>

	<!-- The Modal -->
	<div class="modal-area container">
	  <div class="modal fade" id="liveInfoModal">
	    <div class="modal-dialog modal-sm modal-dialog-centered">
	      <div class="modal-content">
	      
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">라이브 방송 시작하기</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	          <form action="start-onair.do" id="liveinfo-form">
	          	<table style="width: 100%;">
					<tr><td>방 송 제 목</td></tr>
					<tr>
						<td>
							<input type="text" class="form-control" name="live_title">
						</td>
					</tr>          	
	          	</table>
	          </form>
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
		      <button type="button" class="btn btn-danger" id="btn-startlive">시 작</button>
	          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
	

    
    
    <!-- Footer -->
    <%@include file="/WEB-INF/views/footer.jsp" %>
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="resources/js/utils/live.js"></script>
</body>
</html>