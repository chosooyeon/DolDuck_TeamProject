var app = require('express')();
var http = require('http').createServer(app);
var io = require('socket.io').listen(http);
var fs = require('fs');

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

app.get('/chat', (req, res) => {
    res.sendFile(__dirname + '/chatroom.html');
});

io.sockets.on('connection', (socket) => {
    var socketId = socket.id;
    var clientIp = socket.request.connection.remoteAddress; 
    var addr = socket.handshake.address;         //접속한 클라이트의 ip 추적
    console.log('addr : ' + addr + '/ clientIp : ' + clientIp);
    console.log('New Connection from ' + addr.address+ ": " + clientIp.port);
    
    socket.on('chat message', (msg) => {
        console.log('['+clientIp+']message  :' + msg);
        io.emit('data', {"chatMessage" : msg, "clientIp" : clientIp });
    });
});

http.listen(3000, function(){
    console.log('listening on port : 3000');
});