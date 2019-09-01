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
					$('#quick-iframe').attr('src','https://192.168.10.169:8787/dolduck/translate')
					//'https://192.168.10.169:3000/translate-form'
					$('.quick-menu-frame').show()
					break;
				case 'twits':
					$('#quick-iframe').attr('src','https://192.168.10.169:3000/twits')
					$('.quick-menu-frame').show()
					break;
				case 'chat':
					var userStatus = $('input[name=loginstatus-role]').val()
					switch(userStatus){
					case 'user':
						$('#quick-iframe').attr('src','https://192.168.10.169:3000')
						break;
					case 'admin':
						$('#quick-iframe')
					}
					$('.quick-menu-frame').show()
					break;
				}
		})