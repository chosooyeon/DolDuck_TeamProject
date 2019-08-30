try {
	//맥북
    //var socket = io.connect('https://192.168.10.107:5571', { rejectUnauthorized: false })
	
	var socket = io.connect('https://192.168.10.169:5571', { rejectUnauthorized: false });
} catch (error) {
    console.log('Socket.io Exception : ', error)
    location.href = 'https://192.168.10.169:5571/IoException'
    
    //맥북	
    //location.href = 'https://192.168.10.107:5571/IoException'
}