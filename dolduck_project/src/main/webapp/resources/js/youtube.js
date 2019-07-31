 /**
  * google API key : AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18
  * 
  * @returns
  */


  $(document).ready(function(){

        var tag = $('.player');
        tag.src = 'https://www.youtube.com/iframe_api';


        $.ajax({
            type : "GET",
            dataType : "JSON",
            url : "https://www.googleapis.com/youtube/v3/playlistItems?playlistId=PLmxVF8ick5cS8ywQrE-4l6871ZfRxSDj_&part=snippet&maxResults=20&key=AIzaSyC_cXlKb2F8jHoGVBXDekF92FFrzh78c18",

            success : function(jsonData){
                for(var i=0 ; i<jsonData.items.length ; i++){
                    var items = jsonData.items[i];
                    console.log('title : ' + items.snippet.title + '\n' +
                    'videoId : https://youtube.be/' +items.snippet.resourceId.videoId + '\n' +
                    'Thumbnail : ' + items.snippet.thumbnails.high.url);

                    $('#getVideo').append('<div class="div-iframe-player">'
	                    				+'<iframe id="player" type="text/html" width="350" height="263" '
	                    				+'src="http://www.youtube.com/embed/'+ items.snippet.resourceId.videoId +'?enablejsapi=1&origin=http://example.com" '
	                    				+'frameborder="0" allowfullscreen="allowfullscreen" mozallowfullscreen="mozallowfullscreen" '
	                    				+'msallowfullscreen="msallowfullscreen" oallowfullscreen="oallowfullscreen" webkitallowfullscreen="webkitallowfullscreen"></iframe><br> '
	                    				+'<a class="a-player-title"href="https://www.youtube.com/watch?v='+items.snippet.resourceId.videoId+'">'+items.snippet.title+'</a><br/>'
	                    				+'videoId : '+items.snippet.resourceId.videoId+'<br/>'
	                    				+'publishedAt : '+ items.snippet.publishedAt +'<br/>'
	                    				+'</div>'
                    );    
                }
            },
            error : function(err){
                console.log("유튜브 요청 에러 : " + err);
            }
        });
       });