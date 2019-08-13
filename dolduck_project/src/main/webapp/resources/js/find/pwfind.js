function pwfind(){
		
		var id = $('#id').val();
		var email = $('#email').val();
		
		if(id == null || id == ""){
			alert('아이디를 확인해주세요')
		}else if(email==null || email == ""){
			alert('이메일을 입력해주세요')
		}else{
			
			$.ajax({
				type : "post",
				url : "pwSearch.do",	
				data : "id=" + id + "&email=" + email,
				success : function(data){
					if(data == true){
						alert(data);
						$('#result').text(data);
					}else{
						alert('아이디 또는 이메일을 확인해주세요');
					}
				},
				error: function(){
					alert('비밀번호 찾기 통신실패');
				}
			});
		}
		
	}