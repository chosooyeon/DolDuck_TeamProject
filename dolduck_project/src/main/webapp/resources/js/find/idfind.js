
function idfind(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	console.log(`token: ${token} / header : ${header}`)
		
		var name = $('#name').val();
		var email = $('#email').val();

		if(name == null || name == ""){
			alert('이름을 확인해주세요')
		}else if(email==null || email == ""){
			alert('이메일을 입력해주세요')
		}else{
			
			$.ajax({
				type : "post",
				url : "idSearch.do",	
				data : "name=" + name + "&email=" + email,
				beforeSend: function( xhr ) {
		            xhr.setRequestHeader(header, token);
				},
				success : function(data){
					var idSearch = data.idSearch
					var id = data.id
					if(idSearch == true){
						$('.result').text(id);
					}else{
						alert('이름 또는 이메일을 확인해주세요');
					}
				},
				error: function(){
					alert('아이디 찾기 통신실패');
				}
			});
		}
		
	}