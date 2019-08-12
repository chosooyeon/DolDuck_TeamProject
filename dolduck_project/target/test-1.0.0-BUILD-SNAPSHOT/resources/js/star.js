$(document).ready(function(){
	var starChart,
	start = 0, end = 30

	$(document).on('click', '.girl-group', function(){
		$('tbody').children().remove();
		starChart = getStarChart0();
		start = 0, end = 30
		paginationOfList0(starChart, start, end)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList0(starChart, start, end)
	  	});
	});
	
	$(document).on('click', '.girl-star', function(){
		$('tbody').children().remove();
		starChart = getStarChart1();
		start = 0, end = 30
		paginationOfList1(starChart, start, end)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList1(starChart, start, end)
	  	});
	});
	
	$(document).on('click', '.new-star', function(){
		$('tbody').children().remove();
		starChart = getStarChart2();
		start = 0, end = 30
		paginationOfList2(starChart, start, end)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList2(starChart, start, end)
	  	});
	});
	
	$(document).on('click', '.star-star', function(){
		$('tbody').children().remove();
		starChart = getStarChart3();
		start = 0, end = 30
		paginationOfList3(starChart, start, end)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList3(starChart, start, end)
	  	});
	});
	
	$(document).on('click', '.boy-group', function(){
		$('tbody').children().remove();
		starChart = getStarChart4();
		start = 0, end = 30
		paginationOfList4(starChart, start, end)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList4(starChart, start, end)
	  	});
	});
	
	$(document).on('click', '.boy-star', function(){
		$('tbody').children().remove();
		starChart = getStarChart5();
		start = 0, end = 30
		paginationOfList5(starChart, start, end)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList5(starChart, start, end)
	  	});
	});
})

function getStarChart0(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch0.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function getStarChart1(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch1.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function getStarChart2(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch2.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function getStarChart3(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch3.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function getStarChart4(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch4.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function getStarChart5(){
	var list;
	$.ajax({
		type : 'POST',
		url : 'votesearch5.do',
		dataType : 'json',
		async : false,
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('네트워크 오류!2 새로고침 후 다시 이용해주세요!')
		}
	});
	
	return list
}

function paginationOfList0(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-girl-group">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="">pick</td>
			      </tr>`);
	}
}

function paginationOfList1(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-girl-star">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="#">pick</td>
			      </tr>`);
	}
}

function paginationOfList2(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-new-star">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="#">pick</td>
			      </tr>`);
	}
}

function paginationOfList3(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-star-star">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="#">pick</td>
			      </tr>`);
	}
}

function paginationOfList4(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-boy-group">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="#">pick</td>
			      </tr>`);
	}
}

function paginationOfList5(starChart, start, end){
	for(var i=start ; i<end ; i++){
		var star = starChart[i]
		$('tbody').append(`<tr id="tbody-boy-star">
				  <td scope="row">${star.name}</td>
				  <td><img class="star-thumbnail" src="${star.img}"></td>
				  <td><a href="#">pick</td>
			      </tr>`);
	}
}