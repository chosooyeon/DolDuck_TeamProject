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


/*********************** 라이브 대기 홈 ************************/

$(document).on('click', '.video-item-thumb', function(){
	var video_seq = $(this).children('input[name=video_seq]').val()
	console.log(video_seq)
	
	//location.href = `live-detail.do?video_seq=${video_seq}`
})


/*********************** 라이브 대기 플랫폼	************************/

$(document).on('click', '.toggle-start-live', function(){
	$('input[name=startingTime]').val(getTime())
	$('input[name=room_number]').val(parseInt(Math.random()*9999999999))
})


function getTime(){
	
	var date = new Date()
	var now = date.getFullYear() + '-' 
			+ handleTimeFormat('month',date.getMonth()+1) + '-'
			+ date.getDate() + ' '
			+ handleTimeFormat('hour',date.getHours()) + ':'
			+ handleTimeFormat('minute',date.getMinutes()) 
	return now
}


function handleTimeFormat(type, data){
		
		switch(type){
		case 'month':
				if(data<10){
					return '0'+data
				}else{
					return data
				}
		case 'hour':
				if(data >24){
					return '00'
				}else if(data >= 0 && data <10){
					return '0'+data
				}else{
					return data
				}
				break;
		case 'minute':
				if(data > 60){
					return '00'
				}else if(data >= 0 && data <10){
					return '0'+data
				}else{
					return data
				}
				break;
		}
}