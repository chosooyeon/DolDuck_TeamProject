function sendEmail(){


		var id = $('#id').val();
		var email = $('#email').val();
		
		if(id == null || id == ""){
			alert('아이디를 확인해주세요')
		}else if(email==null || email == ""){
			alert('이메일을 입력해주세요')
		}else{
			$.ajax({
				type:"post",
				url:"pwSearch.do",
				data:"id=" + id + "&email=" + email,
				success:function(data){
					var pwSearch = data.pwSearch
					var pw = data.pw
					if(pwSearch == true){
						$(function(){
							$('#checkModal').html(`
							<!-- Modal -->
								<div class="modal-dialog">
									<div class="modal-content">
										<!-- header -->
										<div class="modal-header">
											<!-- header title -->
											<h4 class="modal-title">[DOLDuck]비밀번호 변경</h4>
										</div>
										<!-- body -->
										<div class="modal-body">비밀번호가 변경되었습니다! 이메일을 확인해주세요</div>
										<!-- Footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
										</div>
									</div>
								</div>`);
							$('#checkModal').modal("show");
						})
					}else{
						alert('아이디 또는 이메일을 확인해주세요');
					}
				},
				error: function(){
					alert('아이디 또는 이메일을 확인해주세요');
				}
			});
		}
		
	}