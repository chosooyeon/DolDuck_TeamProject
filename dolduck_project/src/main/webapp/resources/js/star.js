var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
	
$(document).ready(function(){
	var starChart,
	start = 0, end = 30

	$(document).on('click', '.girl-group', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 0
		starChart = getStarChart(page);
		// page번호 추가
		
		paginationOfList(starChart, start, end, page)
		
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
	
	$(document).on('click', '.girl-star', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 1
		starChart = getStarChart(page);	
		// page번호 추가
		paginationOfList(starChart, start, end, page)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
	
	$(document).on('click', '.new-star', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 2
		starChart = getStarChart(page);	
		// page번호 추가
		paginationOfList(starChart, start, end, page)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
	
	$(document).on('click', '.star-star', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 3
		starChart = getStarChart(page);	
		// page번호 추가
		paginationOfList(starChart, start, end, page)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
	
	$(document).on('click', '.boy-group', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 4
		starChart = getStarChart(page);	
		// page번호 추가
		paginationOfList(starChart, start, end, page)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
	
	$(document).on('click', '.boy-star', function(){
		$('tbody').children().remove();
		start = 0, end = 30, page = 5
		starChart = getStarChart(page);	
		// page번호 추가
		paginationOfList(starChart, start, end, page)
		$(document).on('click', '.abc', function(){
			if(end > 100){
				end = 100
				$('.abc').attr('disabled', 'disabled');
			}
			start = end
			end += 20
			paginationOfList(starChart, start, end, page)
	  	});
	});
})

function paginationOfList(starChart, start, end, page){
	if(page == 0){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-girl-group">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a onclick="voteSetName('${star.name}',0)">pick11</a></td>
				      </tr>`);
		}
	}else if(page == 1){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-girl-star">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a href="#">pick</td>
				      </tr>`);
		}
	}else if(page == 2){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-new-star">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a href="#">pick</td>
				      </tr>`);
		}
	}else if(page == 3){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-star-star">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a href="#">pick</td>
				      </tr>`);
		}
	}else if(page == 4){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-boy-group">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a href="#">pick</td>
				      </tr>`);
		}
	}else if(page == 5){
		for(var i=start ; i<end ; i++){
			var star = starChart[i]
			$('tbody').append(`<tr id="tbody-boy-star">
					  <td scope="row">${star.name}</td>
					  <td><img class="star-thumbnail" src="${star.img}"></td>
					  <td><a onclick="votePopup('votepopup.do')">pick222222</td>
				      </tr>`);
		}
	}
}


function getStarChart(page){
	var list;
	
	$.ajax({
		type : 'POST',
		url : 'votesearch.do?page='+page,
		dataType : 'json',
		async : false,
		beforeSend: function( xhr ) {
            xhr.setRequestHeader(header, token);
       },
		success : function(data){
			$('.label-test').text(data.getTime);
			list = data.starChart;
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('ajax 통신에러 (votesearch)')
		}
	});
	return list
}

function voteSetName(starname, page){
// window.open("votepopup.do","","width=1000, height=300, status=no;");
		
	$.ajax({
		type : 'POST',
		url : 'votelike.do?starname='+starname+'&page='+page,
		dataType : 'json',
		async : false,
		beforeSend: function( xhr ) {
            xhr.setRequestHeader(header, token);
       },
		success : function(data){
//			if(data.loginState == "null"){
//				alert(data.loginState);
//				loginN();
//			}
			alert(data.name);
			votePopup("votepopup.do");
		},
		error : function(){
			console.log('ajax 통신에러')
			alert('ajax 통신에러 (votelike)')
		}
	});
}

function votePopup(popUrl){
	// var popUrl = "votepopup.do";
	var popOption = "width=1000, height=300, status=no;";
	alert(popUrl);
	window.open(popUrl,"",popOption);
}

function voteChk(){
	// 로그인, 보유투표권수 체크
	// 보유투표권수 db update
}

function voteSetNum(){
	alert('투표수:'+$('#voteNum').val());
	// 보유투표권수 체크
	$.ajax({
		type : 'POST',
		url : 'votenumber.do?voteNumber='+$('#voteNum').val(),
		data : 'json',
		async : false,
		beforeSend: function( xhr ) {
            xhr.setRequestHeader(header, token);
       },
		success : function(data){
			alert('234:'+$('#voteNum').val());
			voteSaveToDB(data);
			// voteResultPage(data);
			window.close();
		},
		error : function(){
			alert('ajax 통신에러 (votenumber)')
		}
	});
};


function voteSaveToDB(data){
	
	$.ajax({
		type : 'POST',
		url : 'votesave.do',
		data : 'json',
		async : false,
		beforeSend: function( xhr ) {
            xhr.setRequestHeader(header, token);
       },
		success : function(){
			alert('저장성공');
			votePopup('voteresult.do');
		},
		error : function(){
			alert('ajax 통신에러 (voteSaveToDB');
		}
	});
}

//function loginN(){
//	
//}