<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="twitter4j.Twitter"%>
<%@ page import="twitter4j.TwitterFactory"%>
<%@ page import="twitter4j.*"%>
<%@ page import="twitter4j.auth.RequestToken"%>
<%@ page import="twitter4j.Twitter"%>
<!DOCTYPE html>
<html>
<head>
<title>트위터 Example</title>
<meta charset="UTF-8">
</head>
<body>
<%
String consumerKey ="4jV9n4q6icf312qrcJITlxDBw";
String consumerSecret ="7fiKbUjQI11sJlV8LvVfMqGM16qnoMhDzZp9UYBJhmFS9O1GEr";
Twitter twitter = new TwitterFactory().getInstance();
//twitter로 접근한다.
twitter.setOAuthConsumer(consumerKey, consumerSecret);

//성공시 requestToken에 해당정보를 담겨져온다. 
RequestToken requestToken =  twitter.getOAuthRequestToken();   

//requestToken 을 반드시 세션에 담아주어야 한다. 
request.getSession().setAttribute("requestToken", requestToken);

requestToken.getAuthorizationURL();  //접속할 url값이 넘어온다.
requestToken.getToken(); //token값을 가져온다.
requestToken.getTokenSecret(); //token Secret값을 가져온다.

%>
<%-- requestToken: <%=requestToken%><br/>
getAuthorizationURL: <%=requestToken.getAuthorizationURL()%><br/>
getToken: <%=requestToken.getToken()%><br/>
getTokenSecret(): <%=requestToken.getTokenSecret()%><br/> --%>

<a href="<%=requestToken.getAuthorizationURL()%>"><img height="50" width="235" src="${pageContext.request.contextPath}/resources/images/twitter.PNG"/></a>
</body>
</html>