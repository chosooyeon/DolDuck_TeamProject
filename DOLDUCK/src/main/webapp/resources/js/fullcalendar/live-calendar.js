	//console.log(`token: ${token} / header: ${header}`)

	var _events = getEventList()
	var rect = {
		width : $('.container').width(),
		height : $('.container').height()
	}
	var coordinate
	
	
	document.addEventListener('DOMContentLoaded', function() {
		
        var calendarEl = document.getElementById('calendar');	
		
        var calendar = new FullCalendar.Calendar(calendarEl, {
            plugins: [ 'dayGrid', 'interaction', 'bootstrap' ],
            timeZone: 'UTC',
            themeSystem: 'Bootstrap',
            header: {
              left: 'prev,next today',
              center: 'title',
              right: 'dayGridMonth, listMonth'
            },
            eventLimit: true , 					// allow "more" link when too many events
            events : _events, 
            eventClick : function(info){
            	var eventInfo = info.event.title.split(' ')
            	var dateInfo = info.event.start.toString().split(' ')
            	
            	var item = {
            		caster : eventInfo[0],
            		title : eventInfo[1],
            		year : dateInfo[3],
            		month : dateInfo[1],
            		day : dateInfo[2],
            		date : dateInfo[0],
            		time : dateInfo[4]
            	}

            	Swal.fire({
            		  type : "info",
            		  html : `  <div id="popover_event_detail_info">
					     		<div>
					     			<div style="font-size:25px; font-weight:bold;margin-bottom:15px;">일정 상세보기</div>
					     			<div id="popover_event_caster">채  널: ${item.caster}</div>
						     		<div id="popover_event_title">타이틀: ${item.title}</div>
						     		<div id="popover_event_date" style="margin-top: 5px; font-size: 16px;">
						     			<p>방송일정: ${item.year}/${item.month}/${item.day} ${item.time}</p>
						     		</div>
					     		</div>`	
            	});
            },
            eventBackgroundColor : 'cornflowerblue',
            eventBorderColor : 'cornflowerblue',
            color: 'black'
          });

          calendar.render();
      });

	//일정 가져오기
	function getEventList(){
		
		var list;
		$.ajax({
			type: 'POST',
			url : 'getcalevents.do',
			dataType : 'json',
			async: false,
			success : function(data){
				list = data.list;
			}, error : function(){
				alert('Error in getting Calendar Lists')
			}
		})
		return list;
	}
	function handleLiveBoard(){
		$.ajax({
			type : 'POST', 
			url : '',
			dataType : 'json',
			success : function(data){
				console.log(`Success to get ${data}`)
			}, error: function(e){
				console.log(`Error: ${e}`)
			}
		})
	}
		
	function handleTimeFormat(type, data){
		
		switch(type){
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

	document.onmousemove = function(e){
		coordinate = {
			posiX : e.clientX,
			posiY : e.clientY	
		}
		//console.log(`(x,y) =>  (${coordinate.posiX} , ${coordinate.posiY})`)
	}
	
	function popOverEventDetails(info){
		
    	$('#popover_event_caster').text(info.caster)
    	$('#popover_event_title').text(info.title)
    	$('#popover_event_date').text(`날짜 : ${info.date}`)
    	$('.popOver_details').attr('style', `top:${coordinate.posiY}px; left:${coordinate.posiX}px;`)
    	$('.popOver_details').show()
	}
	
	$('#popover_close_icon').on('click', function(){
		$('.popOver_details').hide()
	})
	
	$('#event-alram-btn').on('click', function(){
		alert('서비스 준비중입니다...')
	})
	
	$('body').mousemove(function(e){
		coordinate = {
			posiX : e.clientX-80,
			posiY : e.clientY-80
		}
	})
	function popOverEventDetail(Info){
		
		var top = (coordinate.posiX/window.width)*100,
			left = (coordinate.posiY/winodw.height)*100
		
			
	}

	
	
	
	