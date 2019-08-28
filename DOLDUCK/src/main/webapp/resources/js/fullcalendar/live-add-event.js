	//일정추가
	var addLiveInfoBtn = document.getElementById('btn-addLiveInfo')

	addLiveInfoBtn.addEventListener('click', function(){
		var caster = $('input[name=live_caster]').val(),
			title = $('input[name=live_title]').val(),
			start_date = $('input[name=live_start_date]').val(),
			start_hour = handleTimeFormat('hour',document.getElementsByName('live_start_hour')[0].value),
			start_min = handleTimeFormat('minute',document.getElementsByName('live_start_min')[0].value),
			date = `${start_date} ${start_hour}:${start_min}`
		
		$.ajax({
			type : 'POST',
			url : 'addevent.do',
			data : {
					caster : caster,
					title : title,
					start_date : start_date,
					start_hour : start_hour,
					start_min : start_min
			},
			beforeSend : function(xhr){
				xhr.setRequestHeader(header, token)
			},success : function(data){
				switch(data){
				case 'succeed':
					$('.modal-body').toggle()
					alert('저장되었습니다!')
					location.href='live-schedule.do'
					break;
				case 'failed':
					alert('일정추가에 실패하였습니다! 새로고침 후 다시 시도해주세요!')
					break;	
				}
			}, error : function(e){
				console.log(e)
			}
		})
		
	})
	
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