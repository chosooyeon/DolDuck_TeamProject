<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="twitter4j.auth.*, java.util.*, twitter4j.*"%>
<%@ page import="com.my.dolduck.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<%@include file="../header.jsp"%>
	<%
// TwitterClient 생성
TwitterAPI tw = new TwitterAPI(request);
Twitter twitter = tw.getTwitter(); //(1)인증을 마치고 Twitter객체 가져옴
ResponseList<Status> statuseshome;   //(2)
Paging paging = new Paging();
paging.count(20);
paging.setPage(1);  

statuseshome = twitter.getHomeTimeline(paging); //(3)글목록 가져오기
%>
	<br /><%=twitter.getScreenName()%>(<%=twitter.getId()%>) : 
	<%//=twitter.getUserTimeline()%><br />
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>이전글</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>답변하기</th>
		</tr>
		<%
for (Status status : statuseshome) {
       System.out.println(status);
%>
		<tr>
			<td><%=status.getId()%></td>
			<td><%=status.getInReplyToStatusId()%></td>
			<td><%=status.getText()%> <% if (status.getMediaEntities().length>0) { %>
				<br /> <img src="<%=status.getMediaEntities()[0].getMediaURL() %>" />
				<% } %></td>
			<td><%=status.getUser().getScreenName()%>(<%=status.getUser().getName()%>)</td>
			<td><%=status.getCreatedAt()%></td>
			<td>
				<% if (twitter.getId()==status.getUser().getId()){%>  <% } else { %>
				<a
				href="stepWin.jsp?ids=<%=status.getId()%>&screenName=<%=status.getUser().getScreenName()%>"
				onClick="window.open(this.href, 'stepWin', 'resizable=1, scrollbars=1, width=600,height=650'); return false;">[답글작성]</a>
				<% }%>
			</td>
		</tr>
		<%
}

%>
	</table>
	<div class="container twitter">
		<h1>Twitter</h1>

	</div>
</body>
</html>