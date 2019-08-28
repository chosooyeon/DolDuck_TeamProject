<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style type="text/css">
#twitter {
	margin-left: 135px;
}
</style>
</head>
<body>
	<%-- <%@include file="/WEB-INF/views/header.jsp"%> --%>
	<div id="twitter">
		<!-- 
		<a class="twitter-timeline" href="https://twitter.com/MnetKR?ref_src=twsrc%5Etfw">Tweets by
			MnetKR</a> -->
			<!-- 	<a class="twitter-timeline" href="https://twitter.com/MnetKR?ref_src=twsrc%5Etfw"> -->
		<a href="https://twitter.com/intent/tweet?button_hashtag=LoveTwitter&ref_src=twsrc%5Etfw" class="twitter-hashtag-button" data-show-count="false">
				Tweets HashTag
		</a>
		<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
	</div>
</body>
<%-- <%@include file="../footer.jsp"%> --%>
</html>