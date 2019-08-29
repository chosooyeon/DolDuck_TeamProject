// 보유투표권수 체크
function voteNumberChk(){
	if($('#voteNum').val() == ""){
		alert('1표이상부터 투표 가능합니다');
	}else{
   $.ajax({
      type : 'POST',
      url : 'vote-numberchk.do?voteNumber='+$('#voteNum').val(),
      data : 'json',
      async : false,
      success : function(data){
         if(data.voteNeed == "need"){
            alert('투표권이 부족합니다');
            location.href="heartShop.do";
         }else{
            alert('투표완료');
            window.location.href='vote-result.do';
            window.opener.location.reload();
         }
         window.close();
      },
      error : function(){
         alert('ajax 통신에러 (votenumber)')
      }
   });
	}
};