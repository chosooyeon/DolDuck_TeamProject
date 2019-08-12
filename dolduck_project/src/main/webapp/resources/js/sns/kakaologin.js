

// 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('97eb7d02c879e76c46e49f5c9af2b2be');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function getKakaotalkUserProfile(){
         // 이름과 아이디를 요청합니다.
          Kakao.API.request({
              url: '/v1/user/me',
              success: function(res) {
                 console.log("이름 : " + res.properties.nickname);
                 console.log("아이디 : " + res.id);
                 console.log("이메일 : " + res.kaccount_email);
                
                 var kakaoid = res.id;
                 var kakaoname = res.properties.nickname;
                 
                 alert(kakaoid);
                 alert(kakaoname);
                 document.write('<form action="kakao.do" id="sub_form" method="post">'+
                             '<input type="hidden" name="command" value="kakao">'+
                             '<input type="hidden" name="id" value="'+kakaoid+'">'+
                             '<input type="hidden" name="name" value="'+kakaoname+'">'+
                             '</form>');
                 
                 document.getElementById("sub_form").submit();
              },
              fail: function(error) {
            	  alert(error);
                 console.log(error);
              }
           });
        },
      fail: function(err) {
    	  alert(err);
         alert(JSON.stringify(err));
      }
    });
    