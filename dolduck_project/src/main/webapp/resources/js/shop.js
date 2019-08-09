$(function(){
	
	var kindOf, amount, price
	
	$(document).on('click', '.btn-buy-item', function(){
		kindOf = $(this).children('input[name=kindof]').val()
		amount = $(this).children('input[name=item-amount]').val()
		price = $(this).children('input[name=item-price]').val()
		
		if(kindOf == 'heart'){
			$('#selected-item').html(`<img class="heart_size"src="resources/images/heart.png" style="width:25px; margin:0;">`)
			$('.modal-body #total-price').html(`<b>${price}</b>&nbsp; 원`)
		}else if(kindOf == 'vote'){
			$('#selected-item').html(`<img src="https://www.bestidol.co.kr/assets/image/icon/store/store-item-vote.png"> 투표권 `)
			$('.modal-body #total-price').html(`<img class="heart_size"src="resources/images/heart.png" style="width:25px; margin:0;">&nbsp;<b>${price}</b>`)
		}
		$('#total-amount').text(amount)
		$('.modal-body #total-price b').text(`${price}`)
		$('.modal').modal('show')
		
	}).on('click', '.btn-purchase', function(){
		
		if(kindOf == 'heart'){
			var IMP = window.IMP; 
			IMP.init('imp70049115'); 
			IMP.request_pay({
				amount : price,
				buyer_name : '돌덕',
				name : `[돌덕]${kindOf}`,
			}, function(response) {						//결제 후 호출되는 callback함수
				if ( response.success ) { 				// Payment Successed
					console.log(response);
					ajaxPurchase('buy-heart.do', amount, price)
				} else {								// Payment Failed
					alert('결제실패 : ' + response.error_msg);
				}
			})
		}else if(kindOf == 'vote'){
			console.log('하트로 티켓을 구매하기')
			ajaxPurchase('buy-vote.do', amount, price)
		}
		
		$('.modal').modal('hide')
	})
	
	
	
})


function ajaxPurchase(comm, amount, price){
	$.ajax({
		type : 'post',
		url : comm,
		data: {
			'price' : price,
			'amount' : amount
		},
		success : function(data){
			
		},error : function(err){
			console.log(err)
			alert('[err] 네트워크오류! - ', err)
		}
	})
}