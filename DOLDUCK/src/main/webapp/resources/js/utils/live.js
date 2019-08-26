//csrf Token
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var contentArea = document.getElementById('live-content')

$(document).ready(function() {
	
	$(document).on('click','.nav > li > a', function() {
		var tab = $('.nav > li > a').val()
		console.log(tab);
		
		switch(tab){
			case '홈': 
				contentArea.innerHTML('Home')
				break;
			case '일정표':
				contentArea.innerHTML('Schedule')
				break;
			case '온에어':
				contentArea.innerHTML('Onair')
				break;
			case '채널보기':
				contentArea.innerHTML('Channel')
				break;
			default : break;
		}
	})
	
})


/***********************	라이브 대기 플랫폼	************************/




