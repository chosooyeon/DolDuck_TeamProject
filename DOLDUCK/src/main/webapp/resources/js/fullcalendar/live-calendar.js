	//console.log(`token: ${token} / header: ${header}`)

	var _events = getEventList()
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
            	console.log('Id: ' + info.event.id)
            	console.log('Event: ' + info.event.title);
            	console.log('Date : ' + info.event.start + ' ~ ' + info.event.end)
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
		cooridnate = {
			posiX = e.clientX,
			posiY = e.clientY	
		}
		console.log(`(x,y) =>  (${coordinate.posiX} , ${coordinate.posiY})`)
	}
	
	
	function popOverEventDetail(Info){
		
		var top = (coordinate.posiX/window.width)*100,
			left = (coordinate.posiY/winodw.height)*100
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	