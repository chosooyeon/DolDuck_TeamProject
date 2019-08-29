
$(document).ready(function(){
   var voteChart, start = 0, end = 100

   $('tbody').children().remove();
   item = 'star-idol';
   voteChart = voteCrawling(item);
   paginationOfList(voteChart, start, end, item)
})

   $(document).on('click', '.girl-group', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'girl-group';
      voteChart = voteCrawling(item);
      
      paginationOfList(voteChart, start, end, item)
   });

   $(document).on('click', '.girl-idol', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'girl-idol';
      voteChart = voteCrawling(item);
      
      paginationOfList(voteChart, start, end, item)
   });
   
   $(document).on('click', '.new-idol', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'new-idol';
      voteChart = voteCrawling(item);
      paginationOfList(voteChart, start, end, item)
   });
   
   $(document).on('click', '.star-idol', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'star-idol';
      voteChart = voteCrawling(item);
      
      paginationOfList(voteChart, start, end, item)
   });
   
   $(document).on('click', '.boy-group', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'boy-group';
      voteChart = voteCrawling(item);   

      paginationOfList(voteChart, start, end, item)
   });
   
   $(document).on('click', '.boy-idol', function(){
      $('tbody').children().remove();
      start = 0, end = 100, item = 'boy-idol'
      voteChart = voteCrawling(item);   

      paginationOfList(voteChart, start, end, item)
   });


function paginationOfList(voteChart, start, end, item){
   // 오름차순 정렬
   voteChart.sort(function(a,b){
      return b["voteNumber"] - a["voteNumber"];
   });
   
   /*switch(item){
   case 'star-idol':
	   appendBody(start, end, item)
	   break;
   case 'girl-group':
	   appendBody(start, end, item)
	   break;
   case 'girl-idol':
	   appendBody(start, end, item)
	   break;
   case 'new-idol':
	   appendBody(start, end, item)
	   break;
   case 'boy-group':
	   appendBody(start, end, item)
	   break;
   case 'boy-idol':
	   appendBody(start, end, item)
	   break;
   }*/
   if(item == 'girl-group'){
	   appendBody(start, end, voteChart)
   }else if(item == 'girl-idol'){
	   appendBody(start, end, voteChart)
   }else if(item == 'new-idol'){
	   appendBody(start, end, voteChart)
   }else if(item == 'star-idol'){
	   appendBody(start, end, voteChart)
   }else if(item == 'boy-group'){
	   appendBody(start, end, voteChart)
   }else if(item == 'boy-idol'){
	   appendBody(start, end, voteChart)
   }
}

function voteCrawling(item){
   var list;
   $.ajax({
      type : 'POST',
      url : 'vote-crawling.do?item='+item,
      dataType : 'json',
      async : false,
      success : function(data){
         list = data.starChart;
      },
      error : function(){
         console.log('ajax 통신에러')
         alert('ajax 통신에러 (vote_crawling)')
      }
   });
   return list
}

function appendBody(start, end, voteChart){
	for(var i=start ; i<end ; i++){
		var star = voteChart[i];
		$('tbody').append(`
				  <tr id="tbody-${item}">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:${star.voteNumber}%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="line-height: 8.5em;text-align: center;font-weight: bold;">${star.voteNumber} 표</td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','${item}')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      <td><a id="kakao-link-btn" href="javascript:sendLink()" style="line-height: 8em;"> 
						<img src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png" style="width:25px; float:center;" />
						</a>
					  </td>
			      </tr>`);
	}
}

// pick 버튼 클릭시 VoteDto에 starname, item 저장 + 로그인 체크
function voteClickPickBtn(starname, item){
   $.ajax({
      type : 'POST',
      url : 'vote-pick.do?starname='+starname+'&item='+item,
      dataType : 'json',
      async : false,
      success : function(data){
         if(data.loginState == "null"){
            // 로그인상태가 아닐경우
            alert('로그인이 필요한 서비스입니다.');
            location.href="login.do";
         }else{
            // 로그인상태일경우 투표수 선택하는 팝업창 띄우기
            votePopup("vote-popup.do");
         }
      },
      error : function(){
         console.log('ajax 통신에러')
         alert('ajax 통신에러 (votelike)')
      }
   });
}

// 로그인상태일경우 투표수 선택하는 팝업창 띄우기
function votePopup(popUrl){
   var popOption = "width=500, height=500, status=no, toolbar=no;";
   window.open(popUrl,"",popOption);
}