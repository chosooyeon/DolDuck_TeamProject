<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Chart</title>
<!-- Bootstrap 4 -->
<!-- jQuery library -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h1> Melon Realtime Music Chart</h1>
	<hr><br><br><br><br><br>
	
	<table border="1">
		<thead>
			<tr>Rank</tr>
			<tr>Thumbs</tr>
			<tr>Song title</tr>
			<tr>Singer</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	
	<script type="text/javascript">
		$.ajax({
			type : 'POST',
			url : 'my.do?command=melon',
			async : true,
			dataType : "json",
			success : function(data){
				console.log(data);
			}.
			error : function(){
				console.log('ajax 통신에러');
				alert('ajax 통신에러');
				$('tbody').append(`<tr>`);
			}
		});
	</script>
	
</body>
</html>