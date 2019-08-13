
var contentArea = document.getElementById('live-content')

//csrf Token
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ready(function() {
	
	$('.nav > li > a').on('click', function() {
		var tab = $('.nav > li > a').val()

		switch(tab){
			case '홈': 
				handleLiveBoard()
				break;
			case '일정표':
				break;
			case '온에어':
				break;
			case '채널보기':
				break;
			default : break;
		}
		
	})
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