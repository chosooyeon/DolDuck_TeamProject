
$(function(){
	$(document).on('click','#co_comment_btn',function(){
		var comm_num = $(this).siblings('input[name=comm_num]').val()
		var comm_reg = $(this).siblings('input[name=comm_reg]').val()

		console.log('대댓글을 달아보자')
		var ele = `<tr>
					<td>
                           댓글번호 : ${comm_num}
                    </td>
                    <td colspan="1">
						<input type="text" name="co-comment-content" >
                  	</td>
                  	<td>
                     	<input type="text" name="co-comment-id" >
                  	</td>
                  	<td>
                     	댓글작성시간 : ${comm_reg}
                  	</td>
                       <td id=reply_reply_btn>
                           <input type="button" id="co-comment-btn" value="작성" onclick="co_comment_run(${comm_num});">
                        </td>
                        <td>
                           <input type="button" id="co-comment-cancle-btn" value="취소">
                        </td>
                     </tr>`
		$(this).parent().parent().after(ele);		
	})
})



// ==========댓글=======================================================================================================
$(function(){
	$(document).on('click', '#comment_edit_btn', function(){
		
		var comm_num = $(this).siblings('input[name=comm-num]').val()
		var comm_content = $(this).siblings('input[name=comm-content]').val()
		
// console.log(comm_num ,'/', comm_content)
		$(this).parent().siblings(`#comment_content${comm_num}`)
		.html(
			`<input type="text" name="edited-comm-content" value="${comm_content}">`	
		)
		$(this).text('저장')
		$(this).attr('onclick', `comment_edit_do(${comm_num})`)
		$(this).parent().siblings("#delete_btn").html(`<input type="button" name="edited-comm-cancle" 
		 value="취소" onclick="history.go();">`)
	});
})


function comment_edit_do(num){
	var edited_comm_content = document.getElementsByName("edited-comm-content")[0].value;
	
		alert(edited_comm_content);
	
//		var token = $("input[name='_csrf']").val()
//	    var header = $("input[name='_csrf_header']").val()
//	    alert(token);
//	    
	if(edited_comm_content != null){
//		alert(">>"+header);
		$.ajax({ 
			url:"freeboard_comment_update.do",
			type:"post",
			data:"comm_num="+num+"&comm_content="+edited_comm_content,
//			beforeSend: function( xhr ) {
//	            xhr.setRequestHeader(header, token);
//	            console.log("X-CSRF TOKEN : " , token)
//	       },
			success:function(msg){
				alert(msg.updatechk);
				$(`#comment_content${num}`).text('덧글내용 : ' + msg.content);
//				$(`#comment_content${num}`).val('덧글내용 : '+ edited_comm_content);
				document.getElementById(`comment_content${num}`).value=msg.content;
				$(`#comment_content${num}`).siblings('#edit_btn').children('#comment_edit_btn').text('수정')
			},error:function( req, error){
			    alert(" req: " + req + "/error:"+error);
			    console.log("req : ",req)
			}
		});
	}	
}
