 /**
  * google API key : AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18
  * 
  * @returns
  */

  $(document).ready(function(){
	  	//youtube게시판 초기화 -> 1theK Channel
	    var init = getVideoList("PLID4CZACkMJTQGYm6R0Gc4yk_CKZIZKdv");
	    init;
      	$(document).on('click', '.button-channel', function(){
      		var videoId = $(this).children('.videoId').val();
      		getVideoList(videoId);
      	});
    });
  	
  function getVideoList(value){
	  
	    $('#getVideo').html('');
  		$.ajax({
            type : "GET",
            dataType : "JSON",
            url : "https://www.googleapis.com/youtube/v3/playlistItems?playlistId="+ value +"&part=snippet&maxResults=20&key=AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18",
            success : function(jsonData){
                for(var i=0 ; i<jsonData.items.length ; i++){
                    var items = jsonData.items[i];
                    
                    $('#getVideo').append(`<div class="div-iframe-player">
                    		<div><iframe id="player" type="text/html" width="350" height="263" 
            				src="http://www.youtube.com/embed/${items.snippet.resourceId.videoId}?enablejsapi=1&origin=http://example.com"
            				frameborder="0" allowfullscreen="allowfullscreen" mozallowfullscreen="mozallowfullscreen"
            				msallowfullscreen="msallowfullscreen" oallowfullscreen="oallowfullscreen" webkitallowfullscreen="webkitallowfullscreen"></iframe></div>
            				<div class="div-player-content">
            				<a class="a-player-title"href="https://www.youtube.com/watch?v=${items.snippet.resourceId.videoId}">${items.snippet.title}</a><br/>
            				videoId : ${items.snippet.resourceId.videoId}<br/>
            				publishedAt : ${items.snippet.publishedAt}<br/><div>
            				</div>`); 
                }
            },
            error : function(err){
                console.log("유튜브 요청 에러 : " + err);
            }
        });
  	}
  	