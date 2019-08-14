
	var CalEventId = 0;
	var popOver = $('.popover-modal')
	var xIndex, yIndex 

	document.addEventListener('DOMContentLoaded', function() {
		popOver.hide()
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
            plugins: [ 'dayGrid', 'timeGrid', 'interaction', 'bootstrap' ],
            timeZone: 'UTC',
            themeSystem: 'Bootstrap',
            header: {
              left: 'prev,next today',
              center: 'title',
              right: 'dayGridMonth, timeGridWeek, listMonth'
            },
            eventLimit: true, 					// allow "more" link when too many events
            events: [
            	{
            		id : ++CalEventId,
            		title : '♥',
            		start : '2019-07-08'
            	},	
				{
            		id : ++CalEventId,
            		title : 'alldayAlongWithYou',
            		start : '2019-08-16 09:00',
            	    allDay: false
            	},
				{
            		id : ++CalEventId,
            		title : '100일',
            		start : '2019-10-15'
            	}
             	
            ],
            eventClick : function(info){
            	
            	
            	console.log('Id: ' + info.event.id)
            	console.log('Event: ' + info.event.title);
            	console.log('Date : ' + info.event.start + ' ~ ' + info.event.end)
            	console.log('Location : (' + xIndex + ',' + yIndex + ')')
            	popOver.attr('style', `top:${xIndex}px; left:${yIndex}px;`)
            },
            backgroundColor : 'yellow',
            color: 'black'
          });

          calendar.render();
      });
	
	function closePopover(){
		popOver.hide() 
	}

	function mousePosition(event){
		
	}