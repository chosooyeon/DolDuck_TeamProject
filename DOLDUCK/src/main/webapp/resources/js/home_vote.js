$('.home-vote-star-idol').ready(function(){
	var voteChart = voteCrawling('star-idol')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-star-idol').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});

$('.home-vote-girl-group').ready(function(){
	var voteChart = voteCrawling('girl-group')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-girl-group').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});

$('.home-vote-girl-idol').ready(function(){
	var voteChart = voteCrawling('girl-idol')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-girl-idol').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});

$('.home-vote-boy-group').ready(function(){
	var voteChart = voteCrawling('boy-group')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-boy-group').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});

$('.home-vote-boy-idol').ready(function(){
	var voteChart = voteCrawling('boy-idol')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-boy-idol').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});

$('.home-vote-new-idol').ready(function(){
	var voteChart = voteCrawling('new-idol')
	voteChart.sort(function(a,b){
		return b["voteNumber"] - a["voteNumber"]
	})
	var star = voteChart[0];
	$('.home-vote-new-idol').append(`<img class="thum" src="${star.img}">
	<div class="txt-container">
		<p class="bbsTit">${star.name}</p>
	</div>
	<div class="etc">
		<p class="favorites">
			<i class="fas fa-heart"></i>&nbsp;${star.voteNumber}
		</p>
	</div>`);
});


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