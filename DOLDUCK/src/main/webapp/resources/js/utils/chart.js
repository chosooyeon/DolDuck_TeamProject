
	var chartlist
	var start = 0, end = 30
	
	//Default
	chartlist = getMusicChart('melon')
	paginationOfList(chartlist, start, end)

	$(document).on('click', '.button-channel', function(){
		var site = $(this).children().val()
			start = 0, end = 30
		$('tbody').html('')
		
		chartlist = getMusicChart(site)
		paginationOfList(chartlist, start, end)		
		
	}).on('click', '.button-pagination', function(){
		
		if(end > 100){   
	         end = 100
	         $('.button-pagination').attr('disabled', 'disabled');
	      }
	      start = end
	      end += 20
	      paginationOfList(chartlist, start, end)   
	})


function getMusicChart(site){

	var list;

	$.ajax({
      type : 'POST',
      url : 'musicsearch.do',
      data : { 'site' : site },
      dataType : 'json',
      async : false ,
      success : function(data){
         $('.label-search').text(data.getTime);
         list = data.chart;
      },
      error : function(){
         console.log('ajax 통신에러')
         alert('네트워크 오류! 새로고침 후 다시 이용해주세요!')
      }
   });
   
   return list
}

function paginationOfList(chart, start, end){
   for(var i=start ; i<end ; i++){
      var song = chart[i]
      $('tbody').append(`<tr>
              <td scope="row">${song.rank}</td>
              <td><img class="chart-thumbnail" src="${song.thumb}"></td>
              <td><a href="#">${song.title}</td>₩
              <td>${song.singer}</td>
              <td>${song.album}</td>
              <td><i class="far fa-share-alt" style="color: #ccc;"></i></td>
              </tr>`
      );
   }
}
