<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="twitter4j.Twitter"%>
<%@ page import="twitter4j.TwitterFactory"%>
<%@ page import="twitter4j.auth.RequestToken"%>
<%@ page import="twitter4j.auth.AccessToken"%>
<%@ page import="twitter4j.Status"%>
<%@ page import="twitter4j.User"%>
<%@ page import="java.util.List"%>
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
twitter.setOAuthConsumer(consumerKey, consumerSecret); //저장된 consumerKey, consumerSecret
AccessToken accessToken = null;

accessToken = (AccessToken)request.getSession().getAttribute("accessToken");           
System.out.println(accessToken);

if(accessToken==null){
  String oauth_verifier = request.getParameter("oauth_verifier");
 System.out.println("oauth_verifier: "+oauth_verifier);

 RequestToken requestToken = (RequestToken)request.getSession().getAttribute("requestToken");           
 System.out.println("requestToken: "+requestToken); 
 if(requestToken!=null){
  accessToken = twitter.getOAuthAccessToken(requestToken, oauth_verifier);            
  twitter.setOAuthAccessToken(accessToken);
  request.getSession().setAttribute("accessToken", accessToken);
 }else{
  System.out.println("requestToken값이 없습니다.");
 }
}

if(accessToken!=null){
 twitter.setOAuthAccessToken(accessToken);
 System.out.println(accessToken); 
 System.out.println(accessToken.getUserId());    //트위터의 사용자 아이디
 System.out.println(accessToken.getScreenName()); //트워터에 표시되는 사용자명  
 
 //twitter.updateStatus("테스트 트위 등록 합니다.");
 List<Status> statuses = twitter.getHomeTimeline();
 System.out.println("Showing home timeline.");
 for (Status status : statuses) {
   System.out.println(status.getUser().getName() + ":" + status.getText());
 }
}else{
 System.out.println("accessToken 값이 없습니다.");
}
%>
accessToken: <%=accessToken%><br/>
<%if(accessToken!=null){%>
 getUserId: <%=accessToken.getUserId()%><br/>
 getScreenName: <%=accessToken.getScreenName()%><br/>
<%}%>
<input type="button" value="back" onclick="location.href='twiter_login.jsp'"/><br/>
</body>
</html>

