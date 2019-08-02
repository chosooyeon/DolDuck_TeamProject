
$(document).ready(function(){
	
	var list_length = 34;
	var start = 1, end = 10;
	$(document).on('click','.button-pagination',function(){
		if(end <= list_length/10*10){
			alert(start + ' ~ ' + end)
			start = end+1;
			end += 10;
		}else{
			if(end <= list_length){
				alert(start + ' ~ ' + end)
				start = end+1;
				end = list_length
			}else{
				$('더이상 게시글이 없습니다')	
			}
		}
	})
})

function getMusicChart(){
	$.ajax({
		type : 'POST',
		url : 'musicsearch.do',
		dataType : 'json',
		success : function(data){
			//console.log(data);
			// key: getTime (크롤링 수집시간), chart
			var list = data.chart;
			$('.label-search').text(data.getTime);
			$.each(list, function(key, song){
				$('tbody').append(`<tr>
									  <td scope="row">${song.rank}</td>
									  <td><img src="${song.thumb}"></td>
									  <td><a href="#">${song.title}</td>
									  <td>${song.singer}</td>
									  <td>${song.album}</td>
								  </tr>`);
			}); 	
		},
		error : function(){
			console.log('ajax 통신에러');
			alert('ajax 통신에러');
		}
	});
}

