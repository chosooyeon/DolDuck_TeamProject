//public class TwitterClient3 extends SBMSLog implements TwittweClientImpl{
//      
//      
//       public TwitterClient3() {
//             super();
//            System. out.println("TwitterClient" );
//      }
//      
//      Twitter twitter;
//      RequestToken requestToken = null ;
//      AccessToken accessToken = null ;
//      
//       final String CONSUMER_KEY = "발급 받은 consumer key";
//       final String CONSUMER_SECRET = "발급 받은 consumer secret" ;
//      
//      
//       /**
//       * Twitter 계정으로 Sign in
//       * @return
//       */
//       public RequestToken getRequestToken() {
//             twitter = new TwitterFactory().getInstance();
//             twitter.setOAuthConsumer(CONSUMER_KEY , CONSUMER_SECRET );
//
//             requestToken = null ;
//             try {
//                   requestToken = twitter .getOAuthRequestToken();
//            } catch (TwitterException te) {
//                  te.printStackTrace();
//            }
//
//            System. out.println("1. TwitterClient.getRequestToken: " );
//            System. out.println("1.1 Token: " +requestToken .getToken() + " ");
//            System. out.println("1.2 TokenSecret: "+requestToken.getTokenSecret() + " ");
//            System. out.println("1.3 getAuthorizationURL: " + requestToken.getAuthorizationURL());
//             return requestToken ;
//      }
//      
//       /**
//       * AccessToken 얻기
//       * @param oauthToken
//       * @param oauth_verifier
//       * @param requestToken
//       * @param request 필요한 경우에 따라 request 의 session 의것으로 사용 한다.
//       * @return
//       */
//       public AccessToken getAccessToken(String oauthToken, String oauth_verifier, RequestToken requestToken , HttpServletRequest request)      {
//            
//             twitter = new TwitterFactory().getInstance();
//            com.test.java.social.twitter.Twitter<String> twitterDTO = new com.test.java.social.twitter.Twitter<String>();
//            
//            twitterDTO.setCONSUMER_KEY( CONSUMER_KEY);
//            twitterDTO.setCONSUMER_SECRET( CONSUMER_SECRET);
//            
//             twitter.setOAuthConsumer(CONSUMER_KEY , CONSUMER_SECRET );
//            System. out.println("TwitterClient.getAccessToken: " );
//            
//             if(strIsNull(oauthToken)){
//                   logger.info("get token ::" + requestToken.getToken());
//                   if(requestToken.getToken().equals(oauthToken)) {
//                         try {
//                              System. out.print("2. requestToken: " );
//                              System. out.println("2.1 getToken :" + requestToken.getToken() + " " );
//                              System. out.println("2.2 TokenSecret :" + requestToken.getTokenSecret());
//                              
//                               accessToken = twitter.getOAuthAccessToken(requestToken , oauth_verifier);
//                               twitter.setOAuthAccessToken(accessToken );
//                              
//                               this.storeAccessToken(twitter .verifyCredentials().getId(), accessToken , request);
//                        } catch(TwitterException te) {
//                              te.printStackTrace();
//                        }
//                  } else {
//                        System. out.println("oauth_token error" );        
//                  }
//            }
//                  
//             return accessToken ;
//      }
//      
//       /**
//       * AccessToken 저장
//       *
//       * AccessToken 을 취득한 이후는 RequestToken 는 필요치 않습니다. 다음부터는 consumer key/secret 와 AccessToken 만으로 사용자계정에 접근 가능합니다.
//       * @param userId
//       * @param accessToken
//       */
//       public void storeAccessToken(long userId , AccessToken accessToken, HttpServletRequest request){
//             //TODO :: SAVE
//             try {
//                  request.getSession().setAttribute( "SESSION_ACCESS_TOKEN", accessToken);
//            } catch (Exception e) {
//                  e.printStackTrace();
//            }
//      }
//      
//       /**
//       * 저장된 AccessToken 인스턴스 얻기
//       * @param token
//       * @param tokenSecret
//       * @return
//       * @throws Exception
//       */
//       public AccessToken getAccessToken(String token, String tokenSecret) throws Exception {
//             try {
//                   twitter = new TwitterFactory().getInstance();
//                   twitter.setOAuthConsumer(CONSUMER_KEY , CONSUMER_SECRET);
//                   accessToken = new AccessToken(token, tokenSecret);
//                   twitter.setOAuthAccessToken(accessToken );
//            } catch (Exception e) {
//                  e.printStackTrace();
//            }
//            
//             return accessToken ;
//      }
//
//       /**
//       *
//       */
//       public void printStatuses() {
//            ResponseList<Status> statuses;
//            Paging page = new Paging();
//            page.count(20);
//            page.setPage(1);
//
//             try {
//                  statuses = twitter.getHomeTimeline(page);
//                   for (Status status : statuses) {
//                         // status.getId()
//                         // System.out.println(status.getUser().getScreenName() + ":" + status.getText());
//                         // status.getUser().getScreenName()
//                         // status.getUser().getURL()
//                         // status.getText()
//                         // status.getCreatedAt()
//                         // status.getUser().getProfileImageURL()
//                         // status.getSource()
//                  }
//            } catch (TwitterException te) {
//                   //te.printStackTrace();
//            }
//      }
//      
//       /**
//       * tweet update
//       * @param message
//       */
//       public void update(String message) {
//            Status status = null;
//             try {
//                   //status = twitter.updateStatus("http://ischooldev.sigongmedia.com/sbms/user/editor/EditorPage.do Please enter your text it is... ㄷㅈㄱㅂㅁㅇas  d");
//                   //status = twitter.updateStatus("죄송합니다. 이 글은 아직 한국어로 지원되지 않습니다.");
//                  System. out.println(message);
//                  status = twitter.updateStatus(message);
//                  
//            } catch (TwitterException e) {
//                  e.printStackTrace();
//            }
//      }
//      
//       /**
//       * 친구목록
//       * @throws TwitterException
//       */
//       public void friendsIds() throws TwitterException{
//            IDs ids = twitter.getFriendsIDs(10);
//             long[] id_name = ids.getIDs();
//             for (int i = 0; i < id_name.length; i++) {
//                  System. out.println(twitter .showUser(id_name[i]).getName());
//                  System. out.println(id_name[i]);
//            }
//      }
//}
//
//
//출처: https://mycup.tistory.com/151?category=88562 [한글창제의 기쁨]