function freeInsertLogin(){
   $.ajax({
      type : 'POST',
      url : 'free_insert_login.do',
      dataType : 'json',
      async : false,
      success : function(data){
         if(data.loginState == "null"){
            // 로그인상태가 아닐경우
            alert('로그인이 필요한 서비스입니다.');
            location.href="login.do";
         }else{
            // 로그인상태일경우
            location.href='free_insertform.do'
         }
      },
      error : function(){
         console.log('ajax 통신에러')
         alert('ajax 통신에러 (freeboardlogin)')
      }
   });
}

function freeDetailLogin(freeboard_num){
   $.ajax({
      type : 'POST',
      url : 'free_detail_login.do?',
      dataType : 'json',
      async : false,
      success : function(data){
         if(data.loginState == "null"){
            // 로그인상태가 아닐경우
            alert('로그인이 필요한 서비스입니다.');
            location.href="login.do";
         }else{
            // 로그인상태일경우
            location.href='free_detail.do?freeboard_num='+freeboard_num
         }
      },
      error : function(){
         console.log('ajax 통신에러')
         alert('ajax 통신에러 (freeboardlogin)')
      }
   });
}