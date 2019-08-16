package com.my.test.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class initalize {
	public Twitter twitter;  
	  
	public initalize() {  
	  
	ConfigurationBuilder cb = new ConfigurationBuilder();  
	try {  
		cb.setDebugEnabled(true)
	    .setOAuthConsumerKey("4jV9n4q6icf312qrcJITlxDBw")
	    .setOAuthConsumerSecret("7fiKbUjQI11sJlV8LvVfMqGM16qnoMhDzZp9UYBJhmFS9O1GEr");
	} catch(Exception e) {  
	e.printStackTrace();  
	}  
	  
	TwitterFactory tf = new TwitterFactory(cb.build());  
	AccessToken acToken = new AccessToken("892909769953902592-6DV7wS9TqUXpTJ0rUR583v8LoVTXL50", "BoXF7KvfArIoRCG0yKrUGInh5dacN43iDSaKAaRYXKXaN");   
	  
	twitter = tf.getInstance(acToken);  
	}  

}
