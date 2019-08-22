	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	console.log(`token: ${token} / header: ${header}`)

	var _events = getEventList()
	
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

	function getEventList(){
		
		var list;
		$.ajax({
			type: 'POST',
			url : 'getcalevents.do',
			dataType : 'json',
			async: false,
			beforeSend: function( xhr ) {
		         xhr.setRequestHeader(header, token);
		    },
			success : function(data){
				list = data.list;
				console.log(list)
			}, error : function(){
				alert('Error in getting Calendar Lists')
			}
		})
		return list;
	}
	
	/*  관리자용 '일정추가 버튼' */
	var btnAddevent = document.getElementById('btn-addevent')
	
	btnAddevent.addEventListener('click', function(){
		window.open('live-addpopup.do', 'Add Live Schedules', 'width=400, height=500, menubar=no, status=no, toolbar=no, top=10%, left=50%')
	})
	
	
	
	
	
	
	
	
	
	