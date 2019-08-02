<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>

<style>
body {
	background: #f8f8f8;
	padding: 60px 0;
}

#login-form>div {
	margin: 15px 0;
}
</style>

<title>회원가입</title>

</head>

<body>
	<div class="container">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">환영합니다!</div>
				</div>
				<div class="panel-body">
					<form action="insertUser.do" id="login-form" method="post">
						<div>
							<input type="email" class="form-control id" name="id"
								placeholder="Email" oninput="checkId()" id="checkaa" autofocus>
						</div>
						<div>
							<input type="password" class="form-control pass" name="pw"
								placeholder="Password" oninput="checkPwd()">
						</div>
						<div>
							<input type="password" class="form-control pass" name="pwConfirm"
								placeholder="Confirm Password" id="repwd" oninput="checkPwd()">
						</div>
						<div>
							<input type="text" class="form-control nickname" name="nickName"
								id="nickname" placeholder="Your Nickname" oninput="checkNick()"
								autofocus>
						</div>
						<div>
							<button type="submit"
								class="form-control btn btn-primary signupbtn"
								disabled="disabled">회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		//아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정

		var idCheck = 0;
		var nickCheck = 0;
		var pwdCheck = 0;
		//아이디 체크하여 가입버튼 비활성화, 중복확인.
		function checkId() {
			var inputed = $('.id').val();
			console.log(inputed);
			$.ajax({
				data : {
					id : inputed
				},
				url : "checkId.do",
				success : function(data) {
					if (inputed == "" && data == '0') {
						$(".signupbtn").prop("disabled", true);
						$(".signupbtn").css("background-color", "#aaaaaa");
						$("#checkaa").css("background-color", "#FFCECE");
						idCheck = 0;
					} else if (data == '0') {
						$("#checkaa").css("background-color", "#B0F6AC");
						idCheck = 1;
						if (idCheck == 1 && pwdCheck == 1) {
							$(".signupbtn").prop("disabled", false);
							$(".signupbtn").css("background-color", "#4CAF50");
						}
					} else if (data == '1') {
						$(".signupbtn").prop("disabled", true);
						$(".signupbtn").css("background-color", "#aaaaaa");
						$("#checkaa").css("background-color", "#FFCECE");
						idCheck = 0;
					}
				}
			});
		}
		//재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.

		function checkPwd() {
			var inputed = $('.pass').val();
			var reinputed = $('#repwd').val();
			console.log(inputed);
			console.log(reinputed);
			if (reinputed == ""
					&& (inputed != reinputed || inputed == reinputed)) {
				$(".signupbtn").prop("disabled", true);
				$(".signupbtn").css("background-color", "#aaaaaa");
				$("#repwd").css("background-color", "#FFCECE");
			}

			else if (inputed == reinputed) {
				$("#repwd").css("background-color", "#B0F6AC");
				pwdCheck = 1;
				if (idCheck == 1 && pwdCheck == 1) {
					$(".signupbtn").prop("disabled", false);
					$(".signupbtn").css("background-color", "#4CAF50");
				}

			} else if (inputed != reinputed) {
				pwdCheck = 0;
				$(".signupbtn").prop("disabled", true);
				$(".signupbtn").css("background-color", "#aaaaaa");
				$("#repwd").css("background-color", "#FFCECE");
			}
		}
		//닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
		function checkNick() {
			var nickname = $("#nickname").val();
			console.log(nickname);
			$.ajax({
				data : {
					nickName : nickname
				},

				url : "checkNickName.do",
				success : function(data) {
					if (nickname == "" && data == '0') {
						$(".signupbtn").prop("disabled", true);
						$(".signupbtn").css("background-color", "#aaaaaa");
						$("#nickname").css("background-color", "#FFCECE");
						nickCheck = 0;

					} else if (data == '0') {
						$("#nickname").css("background-color", "#B0F6AC");
						nickCheck = 1;
						if (idCheck == 1 && pwdCheck == 1) {
							$(".signupbtn").prop("disabled", false);
							$(".signupbtn").css("background-color", "#4CAF50");
						}

					} else if (data == '1') {
						$(".signupbtn").prop("disabled", true);
						$(".signupbtn").css("background-color", "#aaaaaa");
						$("#nickname").css("background-color", "#FFCECE");
						nickCheck = 0;
					}
				}
			});
		}
	</script>
</body>
</html>
