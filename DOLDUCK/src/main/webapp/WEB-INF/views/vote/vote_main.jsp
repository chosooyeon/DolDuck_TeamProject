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
   	  <div class="vote-banner" style="background-image: url('resources/images/vote-top-banner.png'); background-repeat: no-repeat; background-size:contain; widht: 100%; min-height:210px; height: auto;"></div>
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
         <table class="table">
               <col width="10%">
               <col width="10%">
               <col width="55%">
               <col width="10%">
               <col width="10%">
               <col width="5%">
            <thead>
               <tr align="center">
                  <th colspan="2">아이돌</th>
                  <th>결과 그래프</th>
                  <th>투표값</th>
                  <th>투표하기</th>
                  <th>공유</th>
               </tr>
            </thead>
            <tbody></tbody>
         </table>
      </div>

   </div>
         </div>
</body>

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="resources/js/utils/vote.js?ver=1" type="text/javascript"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- <script src="resources/js/utils/kakaoshare.js" type="text/javascript"></script> -->
<script type="text/javascript">
var url = 'https://192.168.10.169:8443/dolduck/vote.do'

Kakao.init('4a03c6de35fa570bcbf9f88ff1c10994');

$(document).on('click', '.kakao-link-btn', function(){
	var data = { 
		artist :  $(this).parent().siblings().eq(0).text(),
		thumb : $(this).parent().siblings().eq(1).children().eq(0).attr('src'),
		vote : $(this).parent().siblings().eq(2).children().eq(0).children('input[name=star_got_vote]').val()
	}
	sendLink(data)
})

function sendLink(data) {
	Kakao.Link.sendDefault({
		objectType: 'feed',
		content: {
			title: '(DD)당신의 아이돌에게 투표하세요!',
			description: data.artist + '님은 지금  ♥' + data.vote +'♥표를 얻었습니다!\n｡゜゜(｣｡≧⊿≦)｣마감이 얼마남지 않았어요!｡゜゜(｣｡≧⊿≦)｣\n서둘러 투표를 통해 당신의 아이돌을 센터로 만들어주세요♥ ',
			imageUrl: data.thumb,
			link: {
				mobileWebUrl: 'http://192.168.10.169:8787/dolduck/vote.do',
				webUrl:  'http://192.168.10.169:8787/dolduck/vote.do'
			}
		},
		social: {
			likeCount: 286,
			commentCount: 45,
			sharedCount: 845
		},
		buttons: [{
					title: '웹으로 보기',
					link: {
						mobileWebUrl:  'http://192.168.10.169:8787/dolduck/vote.do',
						webUrl:  'http://192.168.10.169:8787/dolduck/vote.do'
						}
				  }
		 	     ]
	});
}
</script>
</html>