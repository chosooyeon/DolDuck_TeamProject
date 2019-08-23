//csrf Token
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

//buttons
var contentArea = document.getElementById('live-content')
var startLiveBtn = document.getElementById('btn-startlive')

$(document).ready(function() {
	
	$('.nav > li > a').on('click', function() {
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

startLiveBtn.addEventListener('click', function(){
	$('#liveinfo-form').submit()
	//$('#liveInfoModal').hide()	
})

function handleLiveBoard(){
	$.ajax({
		type : 'POST', 
		url : '',
		dataType : 'json',
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token)
		}, success : function(data){
			console.log(`Success to get ${data}`)
		}, error: function(e){
			console.log(`Error: ${e}`)
		}
	})
}

