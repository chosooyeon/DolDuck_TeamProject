function sendEmail(){

	var id = $('#id').val();
	var email = $('#email').val();
	
	if(id == null || id == ""){
		alert('아이디를 확인해주세요')
	}else if(email==null || email == ""){
		alert('이메일을 입력해주세요')
	}else{
		$.ajax({
			url:"pwSearch.do",
			type:"post",
			data:"id=" + id + "&email=" + email,
			success:function(data){
				if(data.pwSearch == true){
					$(function(){
						$('#checkModal').modal("show");
		
					})
					//alert("변경된 비밀번호가 메일로 전송되었습니다!");
				}else{
					alert('이름 또는 이메일을 확인해주세요!');
				}

			},
			error:function(){
				
			}
		});
	}
	
}
