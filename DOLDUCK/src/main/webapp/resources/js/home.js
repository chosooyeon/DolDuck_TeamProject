$(document).on('click', '#quickframe-close-btn', function(){
		$('.quick-menu-frame').hide()
	}).on('click', ".icon-chat-circle", function(){
		var type = $(this).siblings('input[name=quick-menu]').val()
		console.log(type)
		
		switch(type){
		case 'onair':
			location.href = 'live-onair.do'
			break;
		case 'translate':
			
			$('.quick-menu-frame').show()
			break;
		case 'twits':
			$('#qucik-iframe').attr('src','http://192.168.10.169:8787/dolduck/twits.do')
			$('.quick-menu-frame').show()
			break;
		case 'chat':
			$('#qucik-iframe').attr('src','http://192.168.10.169:8787/dolduck/chat.do')
			$('.quick-menu-frame').show()
			break;
		}
	})
