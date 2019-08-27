
window.onload = function(){
	var url = loaction.href

	Kakao.init('a9ef9a318deb5784906e6e394fb3c4e1');
	
	// // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
	function sendLink() {
		Kakao.Link.sendDefault({
			objectType: 'feed',
			content: {
				title: '${title}',
				description: '${festival_location}',
				imageUrl: '${festival_imgsrc}',
				link: {
					mobileWebUrl: url,
					webUrl: url
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
						mobileWebUrl: '${festival_url}',
						webUrl: '${festival_url}'
					}
				}
				
				]
		});
	}
}
