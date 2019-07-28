<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Socket.io Chat</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font: 13px Helvetica, Arial; }
        form { background: #000; padding: 3px; position: fixed; bottom: 0; width: 100%; }
        form input { border: 0; padding: 10px; width: 88%; margin-right: .5%; }
        form button { width: 9%; background: rgb(130, 224, 255); border: none; padding: 10px; }
        #messages { list-style-type: none; margin: 0; padding: 0; }
        #messages li { padding: 5px 10px; }
        #messages li:nth-child(odd) { background: #eee; }
        .div-button-send{ border: 1px solid red;  overflow-y : hidden;}
        .div-chat-box{ overflow-y: auto; }
    </style>
</head>
<body>
    <div class="div-chat-box">
    <ul id="messages"></ul>
    </div>
    <form action="">
        <input id="m" autocomplete="off"/><button>Send</button>
    </form>
    <script src="http://localhost:3000/socket.io/socket.io.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.js"></script>
    <script>
        $(document).ready(function(){
            var socket = io("http://localhost:3000");

            $('form').submit(function(e){
                e.preventDefault();
                socket.emit('chat message', $('#m').val());
                $('#m').val('');
                return false;
            });
            
            socket.on('data', function(data){
            	console.log(data);
            	$('#messages').append($('<li>').text('[' + data.clientIp + ']- ' + data.chatMessage));
            });
        });
    </script>
</body>
</html>


