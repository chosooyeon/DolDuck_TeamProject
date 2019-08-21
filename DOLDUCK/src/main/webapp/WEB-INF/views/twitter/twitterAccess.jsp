<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="twitter4j.auth.*, java.util.*, twitter4j.*"%>
<%@ page import="com.my.dolduck.util.*"%>

<%
	// requestToken 받기
	try {
		TwitterAPI tw = new TwitterAPI(request);
		tw.getAccessToken(); //accessToken 반환가능 , 다른 용도?
		response.sendRedirect("/member/twitter.do");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>


