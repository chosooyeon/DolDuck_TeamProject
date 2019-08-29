var url = 'https://192.168.10.169:8443/vote.do'

	$(function(){
	
	Kakao.init('a9ef9a318deb5784906e6e394fb3c4e1');
	
	// // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
	function sendLink() {
		alert('공유하기')
		Kakao.Link.sendDefault({
			objectType: 'feed',
			content: {
				title: '(돌덕) 마감임박!',
				description: '${festival_location}',
				imageUrl: '${festival_imgsrc}',
				link: {
					mobileWebUrl: 'https://192.168.10.169:8443/vote.do',
					webUrl: 'https://192.168.10.169:8443/vote.do'
				}
			},
			social: {
				likeCount: 286,
				commentCount: 45,
				sharedCount: 845
			},
			buttons: [
				{
					title: '웹으로 보기',
					link: {
						mobileWebUrl: 'https://192.168.10.169:8443/vote.do',
						webUrl: 'https://192.168.10.169:8443/vote.do'
					}
				}
				
				]
		});
	}
	
})

