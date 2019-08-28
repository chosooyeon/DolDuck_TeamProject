<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! DD - Star</title>
<!-- Bootstdap 4 -->
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/chart.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="resources/styles/vote.css">


</head>
<body>
   <!-- Header -->
    <%@include file="../header.jsp" %>

   <div class="container vote_board">
      <div class="center">   
   <div class="div-star">
            <ul class="vote-button">
            	<li class="star-idol">별별 스타</li>
               <li class="girl-group">여자 그룹</li>
               <li class="girl-idol">여자 아이돌</li>
               <li class="boy-group">남자 그룹</li>
               <li class="boy-idol">남자 아이돌</li>
               <li class="new-idol">신인 스타</li>
            </ul>
         </div>

      <div class="center votechart-board">
         <p>검색시간 : <label class="current-time"></label><p>
         <table class="table">
               <col width="10%">
               <col width="10%">
               <col width="55%">
               <col width="10%">
               <col width="10%">
            <thead>
               <tr align="center">
                  <th>Star</th>
                  <th>Img</th>
                  <th>그래프</th>
                  <th>투표값</th>
                  <th>투표하기</th>
               </tr>
            </thead>
            <tbody></tbody>
         </table>
      </div>

   </div>
         </div>
</body>

<!-- jQuery library -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/js/utils/vote.js?ver=1" type="text/javascript"></script>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="resources/js/utils/kakaoshare.js" type="text/javascript"></script>

</html>