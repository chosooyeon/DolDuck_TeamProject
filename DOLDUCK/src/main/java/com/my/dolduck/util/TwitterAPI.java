package com.my.dolduck.util;

import javax.servlet.http.HttpServletRequest;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAPI {
	private HttpServletRequest request;
	private Twitter twitter;
	RequestToken requestToken = null;
	AccessToken accessToken = null;
	String q = "";

	final String CONSUMER_KEY = "4jV9n4q6icf312qrcJITlxDBw";
	final String CONSUMER_SECRET = "7fiKbUjQI11sJlV8LvVfMqGM16qnoMhDzZp9UYBJhmFS9O1GEr";

	public TwitterAPI(HttpServletRequest req) {
		request = req;
	}

	/**
	 * RequestToken를 받기
	 * 
	 * @return
	 */
	public RequestToken getRequestToken() {
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

		requestToken = null;
		try {
			requestToken = twitter.getOAuthRequestToken();
			request.getSession().setAttribute("requestToken", requestToken);
		}
		catch (TwitterException te) {
			te.printStackTrace();
		}

		return requestToken;

	}

	/**
	 * 
	 * AccessToken 토큰 받기
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public AccessToken getAccessToken() throws Exception
	{
		String oauthToken = request.getParameter("oauth_token");
		requestToken = request.getSession() != null ? (RequestToken) request.getSession().getAttribute("requestToken")
				: null;
		if (requestToken == null) {
			throw new Exception("error requestToken == null");
		}

		if (oauthToken == null) {
			throw new Exception("error oauthToken == null");
		}

		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		if (requestToken.getToken().equals(oauthToken)) {
			try {
				accessToken = twitter.getOAuthAccessToken(requestToken);
				twitter.setOAuthAccessToken(accessToken);
				request.getSession().setAttribute("accessToken", accessToken);
			}

			catch (TwitterException te) {
				te.printStackTrace();
			}
		}
		else {
			throw new Exception("oauth_token error");
		}
		return accessToken;
	}

	/**
	 * 
	 * AccessToken으로 사용자 인증 받기
	 * 
	 * @return
	 * 
	 */
	public Twitter getTwitter() {
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		if (request.getSession() != null) {
			AccessToken accessToken = (AccessToken) request.getSession().getAttribute("accessToken");
			twitter.setOAuthAccessToken(accessToken);
		}
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

}
