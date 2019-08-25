//var socket = io.connect()

var startLiveBtn = document.getElementById('startLiveBtn')
var channelList = document.getElementById('channel-list')

var random 
var roomArr = []

socket.emit('requestRoomlist')

socket.on('roomlist', (rooms) => {
    console.log('rooms: ', rooms)
    addRoomList(rooms)
})

function addRoomList(data){
    for(var i=0 ; i<data.length ; i++){
        var item = data[i]
        appendRoom(item)
    }
}

function appendRoom(item){
    var roomUnit = `<li class="channel-box">
                    <a href="/caster/${item.room}">
                        <img src="${item.thumb}" width="228" height="128">
                    </a>
                    <p><a href="/caster/${item.room}>Test</a></p>
                    <div class="channel-info">
                        <div>
                            <span>${item.date}</span>
                            <span>&nbsp;|&nbsp;</span>
                            <span>${item.caster}</span>
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
    $('ul').append(roomUnit)
}

startLiveBtn.addEventListener('click', ()=>{ 
    random = parseInt(Math.random()*999999999999)
    location.href = `/caster/${random}` 
})