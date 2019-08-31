 /**
  * google API key : AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18
  * 
  * @returns
  */

  $(document).ready(function(){
	  	var random = parseInt(Math.random()*6)+1
	  	var playlist 
	  	console.log(random)
	  	
	  	switch(random){
	  	case 1:
	  		playlist = 'PLK8rVA0_KzOc-Trk-kz1sQijhADYXLY6C'
	  		break;
	  	case 2:
	  		playlist = 'PLoE9F5MjfXCCvYGvHR0iJOeeaMEvBv191';
	  		break;
	  	case 3:
	  		playlist = 'PLQv1U2oSD8oB_M-Pk8gVuDB8MA65a9UBm';
	  		break;
	  	case 4:
	  		playlist = 'PLHhwBCdvOkY_xmNMDkl4i6pZO69wxnO_4';
	  		break;
	  	case 5:
	  		playlist = 'PLmxVF8ick5cQIHKYYsuOKWOOMUaJxyJP1';
	  		break;
	  	case 6:
	  		playlist = 'PLID4CZACkMJTQGYm6R0Gc4yk_CKZIZKdv';
	  		break;
	  	default : 
	  		playlist = 'PLI2cIPYd2LzznFwSKJqY0QdgYw-nT4-qh';
	  		break;
	  	}
	    getVideoList(playlist);
      
    });
  
  
  function getVideoList(value){
	  
	    $('#getVideo').html('');
  		$.ajax({
            type : "GET",
            dataType : "JSON",
            url : "https://www.googleapis.com/youtube/v3/playlistItems?playlistId="+ value +"&part=snippet&maxResults=6&key=AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18",
            success : function(jsonData){
                for(var i=0 ; i<jsonData.items.length  ; i++){
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
  	