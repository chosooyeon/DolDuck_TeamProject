<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Chart</title>
<!-- Bootstdap 4 -->
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/chart.css">
<!-- jQuery library -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="resources/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
</head>
<body>

	<h1> Melon Realtime Music Chart</h1>
	<hr><br><br><br><br><br>
	
	
	<p>검색시간 : <label class="label-search"></label><p>
	<div class="div-chart">
	<table class="table ">
		<thead>
			<tr>
				<th scope="col">Rank</th>
				<th scope="col">Thumbs</th>
				<th scope="col">Song title</th>
				<th scope="col">Singer</th>
				<th scope="col">Album</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	</div>
	
	<script type="text/javascript">
		$.ajax({
			type : 'POST',
			url : 'musicsearch.do',
			dataType : 'json',
			success : function(data){
				//console.log(data);
				// key: getTime (크롤링 수집시간), chart
				var list = data.chart;
				$('.label-search').text(data.getTime);
				$.each(list, function(key, song){
					$('tbody').append('<tr>'
									 +'<td scope="row">'+song.rank+'</td>'
									 +'<td><img src="'+song.thumb+'"></td>'
									 +'<td><a href="#">'+song.title+'</td>'
									 +'<td>'+song.singer+'</td>'
									 +'<td>'+song.album+'</td>'
									 +'</tr>'
					);
				}); 	
			},
			error : function(){
				console.log('ajax 통신에러');
				alert('ajax 통신에러');
			}
		});
	</script>
	
</body>

</html>