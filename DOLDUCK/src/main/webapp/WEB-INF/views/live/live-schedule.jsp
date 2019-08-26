<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import = "org.springframework.security.core.context.SecurityContextHolder" %>
<%@page import = "org.springframework.security.core.Authentication" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/> 
<title>All About K-POP! DD - Live</title>
<link rel="stylesheet" type="text/css" href="resources/styles/live.css">
<link rel="stylesheet" href="resources/js/fullcalendar/core/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/daygrid/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/timegrid/main.css">
<link rel="stylesheet" href="resources/js/fullcalendar/bootstrap/main.css">
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css' rel='stylesheet'>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet' />
</head>
<body>
    <!-- Header -->
    <%@include file="../header.jsp" %>
    <!-- Slide Caresel  -->
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
         
         <!-- Title & Banner -->
         <div class="live-banner"> 
         	<h4>일정표</h4>
			<h5>방송 일정을 미리 확인하고, 생생한 라이브를 놓치지 마세요!</h5>
         </div>
         
        <!-- Add button for Events on calendar -->
        <!-- If the role of session(User) is 'ROLE_ARTIST', SHOW FOLLOWING 'BUTTON' -->
        <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ARTIST')">
	        <div id="area-addEvent">
	        	<button type="button" class="btn btn-warning" id="btn-addevent" data-toggle="modal" data-target="#addEventModal">일정추가</button>
	        </div> 
        </sec:authorize> 
     </div>  
     
     <!-- Calendar Area-->
     <div class="container">
        <div class="center calendar-box">
		    <div id="calendar"></div>
       </div>
     </div>
     
     
     <!-- AddEvent Modal -->
	<div class="modal-area container">
	  <div class="modal fade" id="addEventModal">
	    <div class="modal-dialog modal-sm modal-dialog-centered">
	      <div class="modal-content">
	      
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">일정  추가</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	          <form action="start-onair.do" id="liveinfo-form">
	          	<table style="width: 100%;">
	          		<tr><td>방송진행자</td></tr>
	          		<tr><td><input type="text" class="form-control" name="live_caster"  value="<sec:authentication property="principal.member_id"/>" style="width:100%;" readonly="readonly"></td></tr>
	          		<tr><td></td></tr>
					<tr><td>방 송 제 목</td></tr>
					<tr>
						<td><input type="text" class="form-control" name="live_title"  style="width:100%;"></td>
					</tr>         
					<tr><td></td></tr>
					<tr><td>방 송 일 정</td></tr> 	
					<tr>
						<td>
							<input type="date" name="live_start_date" style="width: 100%;">
						</td>
					</tr>
					<tr><td></td></tr>
					<tr><td>방 송 시 작</td></tr>
					<tr>
						<td>
							<input type="number" name="live_start_hour"  style="width:40%;">&nbsp;시&nbsp;
							<input type="number" name="live_start_min"  style="width:40%;">분 
						</td>
	          	</table>
	          </form>
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
		      <button type="button" class="btn btn-danger" id="btn-addLiveInfo">저 장</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">취 소</button>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
     

    <!-- Footer -->
    <%@include file="/WEB-INF/views/footer.jsp" %>
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="resources/js/utils/live.js"></script>
    <script src="resources/js/fullcalendar/core/main.js"></script>
    <script src="resources/js/fullcalendar/daygrid/main.js"></script>
    <script src="resources/js/fullcalendar/timegrid/main.js"></script>
    <script src="resources/js/fullcalendar/interaction/main.js"></script>
    <script src="resources/js/fullcalendar/bootstrap/main.js"></script>
    <script src="resources/js/fullcalendar/live-calendar.js"></script>
</body>
</html>