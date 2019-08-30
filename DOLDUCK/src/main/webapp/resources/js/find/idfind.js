
function idfind(){
		
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
				success : function(data){
					var idSearch = data.idSearch
					var id = data.id
					if(idSearch == true){
						$(function(){
							$('#checkModal').html(`
							<!-- Modal -->
								<div class="modal-dialog">
									<div class="modal-content">
										<!-- header -->
										<div class="modal-header">
											<!-- header title -->
											<h4 class="modal-title">[DOLDuck]아이디 찾기</h4>
										</div>
										<!-- body -->
										<div class="modal-body">${name} 님의 아이디는 <strong>${id }</strong>입니다.</div>
										<!-- Footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
										</div>
									</div>
								</div>`);
							$('#checkModal').modal("show");
						})
					}else{
						alert('이름 또는 이메일을 확인해주세요');
					}
				},
				error: function(){
					alert('이름 또는 이메일을 확인해주세요');
				}
			});
		}
		
	}