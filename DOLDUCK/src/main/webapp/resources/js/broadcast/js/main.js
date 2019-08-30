//var socket = io.connect('https://192.168.10.169:5571')
//var startLiveBtn = document.getElementById('startLiveBtn')


var reloadBtn = document.getElementById('channel-reload')
var channelList = document.getElementById('channel-list')

var random 
var roomArr = []


$(function(){
    socket.emit('requestRoomlist')
    
    socket.on('roomlist', (rooms) => {
        console.log(rooms)
        if(rooms.length == 0){
        	$('#channel-item').html('')
            $('#channel-item').append($(`<li>`).html(`<p class="no-live-room">아직 방송중인 방이 없습니다!</p>`))
        }else{
            addRoomList(rooms)
        }
    })

})

function addRoomList(list){
    $('#channel-item').html('')
    list.forEach( item => {
        console.log(item);
        appendRoom(item)
    });
}

function appendRoom(item){
    var roomUnit = `<li class="channel-box">
    					<div>
	    			        <a href="join-onair.do?room=${item.room}">
	                        	<img src="${item.thumb}" width="228" height="128">
	                    	</a>
                    	</div>
                    	<div class="channel-info">
                    		<p><a href="void:0;">[${item.caster}] ${item.title}</a></p>
                    		<p>방송시작시간: ${item.date}</p>
                    		<p>방 번호: ${item.room}</p>
                    	</div>
                    </li>`
    $('#channel-item').append(roomUnit)
}

/*<li class="channel-box">
<div>
    <a href="join-onair.do?room=${item.room}">
    	<img src="${item.thumb}" width="228" height="128">
	</a>
</div>
<div class="channel-info">
	<div>
		<p><a href="/user/${item.room}>[${item.caster}] ${item.title}</a></p>
	</div>
	<div>
        <p>${item.date}</p>
        <p>${item.caster}</p>
	</div>
    <div>
	<!-- 접속자수 -->
    <span>
        <span>＠</span>
        <span>Test</span>
        </span>
              <!-- 좋아요 수 -->
        <span>
        <span>♥</span>
        <span>Test</span>
        </span>
    </div>
</div>
</li>`

/*startLiveBtn.addEventListener('click', () =>{
    var ran = parseInt(Math.random()*9999999999)
    location.href = 'https://localhost:5571/caster/${ran}'
})
*/

reloadBtn.addEventListener('click', ()=>{
	console.log('룸 목록 새로고침!')
    socket.emit('requestRoomlist')
})