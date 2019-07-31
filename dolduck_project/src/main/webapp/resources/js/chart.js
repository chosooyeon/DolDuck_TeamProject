
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