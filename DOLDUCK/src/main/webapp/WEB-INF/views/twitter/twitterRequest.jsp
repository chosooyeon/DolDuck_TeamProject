<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="twitter4j.auth.*, java.util.*, twitter4j.*"%>
<%@ page import="com.my.dolduck.util.*"%>
<%
// RequestToken 받기
TwitterAPI tw = new TwitterAPI(request);
RequestToken token = tw.getRequestToken();
%>
 
<!-- callback URL로 이동 -->
<script>
location.href = "<%=token.getAuthorizationURL()%>";
</script>
