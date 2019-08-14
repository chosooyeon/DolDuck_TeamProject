var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}

function roleUpdate(role) {
	if(role == 'ROLE_ARTIST'){
		role = 'ROLE_ARTIST'
			alert(role);
	}else if(role == 'ROLE_USER'){
		role = 'ROLE_USER'
			alert(role);
	}
	return role;
}
/*

$.ajax({
   type : 'post' ,
   url : 'update-grade.do',
   data : '보낼 데이터' (예시 -> { name : '한지수' , age : 27} ),
   dataType : '받을 데이터의 타입'  (예시 ->'text'),
   success : function(data){
      alert(data)
   //성공했을때 동작
   },error: function(){
      alert('네트워크 오류')
   // 실패했을때 동작
   }
})






*/