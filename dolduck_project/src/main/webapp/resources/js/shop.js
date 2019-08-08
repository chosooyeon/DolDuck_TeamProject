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
		$('.modal').modal()
		
	}).on('click', '.btn-purchase', function(){
		console.log(`${kindOf} ${price}원 결제해주세요~~`)
		
		IMP.request_pay({
			amount : amount,
			buyer_name : '돌덕',
			name : '결제테스트'
		}, function(response) {						//결제 후 호출되는 callback함수
			
			if ( response.success ) { 				// Payment Successed
				console.log(response);
			} else {								// Payment Failed
				alert('결제실패 : ' + response.error_msg);
			}
		})
	})
})

