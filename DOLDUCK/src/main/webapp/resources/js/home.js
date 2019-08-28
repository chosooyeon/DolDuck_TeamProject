$(document).on('click', '#quickframe-close-btn', function(){
		$('.quick-menu-frame').hide()
})
$(document).on('click', ".icon-chat-circle", function(){
		var type = $(this).siblings('input[name=quick-menu]').val()
		
		switch(type){
		case 'onair':
			location.href = 'live-onair.do'
			break;
		case 'translate':
			$('#qucik-iframe').attr('src','')
			$('.quick-menu-frame').show()
			break;
		case 'twits':
			$('#qucik-iframe').attr('src','https://192.168.10.169:3000/twits')
			$('.quick-menu-frame').show()
			break;
		case 'chat':
			$('#qucik-iframe').attr('src','https://192.168.10.169:3000')
			$('.quick-menu-frame').show()
			break;
		}
	})
