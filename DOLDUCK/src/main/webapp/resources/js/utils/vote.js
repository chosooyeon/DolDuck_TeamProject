
$(document).ready(function(){
	var voteChart, start = 0, end = 100

	$('tbody').children().remove();
	item = 'girl-group';
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
	if(item == 'girl-group'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i];
			$('tbody').append(`<tr id="tbody-girl-group">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','girl-group')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
	}else if(item == 'girl-idol'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i]
			$('tbody').append(`<tr id="tbody-girl-idol">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','girl-idol')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
	}else if(item == 'new-idol'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i]
			$('tbody').append(`<tr id="tbody-new-idol">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','new-idol')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
	}else if(item == 'star-idol'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i]
			$('tbody').append(`<tr id="tbody-star-idol">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','star-idol')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
	}else if(item == 'boy-group'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i]
			$('tbody').append(`<tr id="tbody-boy-group">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					 <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','boy-group')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
	}else if(item == 'boy-idol'){
		for(var i=start ; i<end ; i++){
			var star = voteChart[i]
			$('tbody').append(`<tr id="tbody-boy-idol">
					  <td scope="row" style="line-height:8.5em; text-align: center; font-weight: bold;">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td>
					  	<div class="progress" style="margin-top: 36px;height: 50px;">
					  		<div class="progress-bar" style="width:40%; background-color:#c0aded;"></div>
					  	</div>
					  </td>
					  <td style="text-align: center;"><button onclick="voteClickPickBtn('${star.name}','boy-idol')"style="width: 60px; height: 60px; border-radius: 5em; border: none; margin-top: 30px; background-color: #f2ecf5;" >pick</button></td>
				      </tr>`);
		}
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
			$('.current-time').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('ajax 통신에러 (vote_crawling)')
		}
	});
	return list
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
	var popOption = "width=1000, height=300, status=no;";
	window.open(popUrl,"",popOption);
}

// 보유투표권수 체크
function voteNumberChk(){
	$.ajax({
		type : 'POST',
		url : 'vote-numberchk.do?voteNumber='+$('#voteNum').val(),
		data : 'json',
		async : false,
		success : function(data){
			if(data.voteNeed == "need"){
				alert('투표권이 부족합니다');
				location.href="heartShop.do";
			}else{
				alert('저장성공');
				votePopup('vote-result.do');
			}
			window.close();
		},
		error : function(){
			alert('ajax 통신에러 (votenumber)')
		}
	});
};
