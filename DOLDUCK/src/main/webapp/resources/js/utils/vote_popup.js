// 보유투표권수 체크
function voteNumberChk(){
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
				alert('저장성공');
				votePopup('vote-result.do');
			}
			window.close();
		},
		error : function(){
			alert('ajax 통신에러 (votenumber)')
		}
	});
};
