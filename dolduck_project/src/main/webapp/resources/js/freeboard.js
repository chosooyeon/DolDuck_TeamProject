$(function(){
	$(document).on('click', '#comment_edit_btn', function(){
		
		var comm_num = $(this).siblings('input[name=comm-num]').val()
		var comm_content = $(this).siblings('input[name=comm-content]').val()
		
//		console.log(comm_num ,'/', comm_content)
		$(this).parent().siblings(`#comment_content${comm_num}`)
		.html(
			`<input type="text" name="edited-comm-content" value="${comm_content}">`	
		)
		$(this).text('저장')
		$(this).attr('onclick', `comment_edit_do(${comm_num})`)
	});

})


function comment_edit_do(num){
	var edited_comm_content = document.getElementsByName("edited-comm-content")[0].value;
	alert(edited_comm_content);
	var token = $("meta[name='_csrf']").attr("content");
	   var header = $("meta[name='_csrf_header']").attr("content");

	if(edited_comm_content != null){
		$.ajax({ 
			url:"freeboard_comment_update.do",
			type:"post",
			data:"comm_num="+num+"&comm_content="+edited_comm_content,
			beforeSend: function( xhr ) {
	            xhr.setRequestHeader(header, token);
	       },
			success:function(msg){
				alert(msg.updatechk);
				$(`#comment_content${num}`).text('덧글내용 : ' + msg.content);
				$(`#comment_content${num}`).siblings('#edit_btn').children('#comment_edit_btn').text('수정')
			},error:function(){
				alert("통신실패");
			}
		});
	}	
}
