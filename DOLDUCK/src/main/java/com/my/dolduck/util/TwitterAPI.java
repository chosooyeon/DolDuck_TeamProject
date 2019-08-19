package com.my.dolduck.util;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAPI {

	private String consumer_key;

	public void setConsumer_key(String consumer_key) {
		this.consumer_key = consumer_key;
	}

	private String consumer_secret;

	public void setConsumer_secret(String consumer_secret) {
		this.consumer_secret = consumer_secret;
	}

	public RequestToken requestToken = null;
	public AccessToken accessToken = null;
	public Twitter twitter = null;

	public TwitterAPI() {
		twitter = new TwitterFactory().getInstance();
	}

	// 인증 요청 토큰 생성
	public void getRequestToken() throws Exception {
		twitter.setOAuthConsumer(this.consumer_key, this.consumer_secret);
		requestToken = twitter.getOAuthRequestToken();
	}

	// 인증된 토큰 생성
	public void getAccessToken(String request_token, String request_tokensecret, String oauth_verifier)
			throws Exception {
		try {
			twitter.setOAuthConsumer(this.consumer_key, this.consumer_secret);
			accessToken = twitter.getOAuthAccessToken(new RequestToken(request_token, request_tokensecret),
					oauth_verifier);
		} catch (TwitterException te) {
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + te);
		}

		twitter.setOAuthAccessToken(accessToken);

		System.out.println(twitter.verifyCredentials().getId()); // 사용자 아이디
		System.out.println("???????????????token : " + accessToken.getToken());
		System.out.println("???????????????tokenSecret : " + accessToken.getTokenSecret());
	}

	// 재인증 처리
	public void SignIn(String access_token, String access_tokensecret) throws Exception {
		twitter.setOAuthConsumer(this.consumer_key, this.consumer_secret);

		System.out.println("???????????????access_token : " + access_token);
		System.out.println("???????????????access_tokensecret : " + access_tokensecret);

		twitter.setOAuthAccessToken(new AccessToken(access_token, access_tokensecret));
		// 사용자 아이디
		System.out.println("??????????????????" + twitter.verifyCredentials().getId());
	}

}