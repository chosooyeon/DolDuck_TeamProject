<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/> 
<title>Insert title here</title>
</head>

<body>
<!-- header -->
<%@include file="../header.jsp" %>


	<div class="container market">
	
		
		<h1> Market </h1>
		<ul class="nav nav-tabs market_ul">
			<li class="nav-item">
				<a class="nav-link market_link" href="heartShop.do">HeartShop</a>
			</li>
			<li class="nav-item">
				<a class="nav-link market_link" href="market_list.do">Goodies</a>
			</li>

		</ul>
	
		<div class="col-md-12 market_border">
			<div class="Goodies">
			
			</div>
		</div>
		
	
	</div>


</body>
</html>