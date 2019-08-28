
//HTTPS

try {
    var socket = io.connect('https://192.168.10.169:5571', { rejectUnauthorized: false });
} catch (error) {
    alert(`[고급]버튼 - "https://192.168.10.169:5571"로 이동하기를 눌러주세요!`)	
	//history.back()
}