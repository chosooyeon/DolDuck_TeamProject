

// 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('d5efd0d4dfbcf87c0796b4975bee99b1');
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
                 
                 $('input[name=id]').attr('value',kakaoid);
                 $('input[name=name]').attr('value',kakaoname);
                 
                 document.write('<form action="logincontroller.do" id="sub_form" method="post">'+
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
    