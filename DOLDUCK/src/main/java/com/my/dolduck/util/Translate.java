package com.my.dolduck.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translate{
	public String Translate(String inputQuery) {
	     String apikey = "011d25e929be6730ed92d7c8676be734";//애플리케이션 클라이언트 아이디값
	     System.out.println(inputQuery);
	     try 
	        {
	            String inputQueryEncoded = URLEncoder.encode(inputQuery, "UTF-8");//번역될 문장
	            System.out.println(inputQuery);
	            String postParams = "src_lang=kr&target_lang=en&query="+inputQueryEncoded; 
	            
	            String apiURL = "https://kapi.kakao.com/v1/translation/translate?"+postParams;
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	             
	            String userCredentials = apikey;
	            String basicAuth = "KakaoAK "+new String(userCredentials.getBytes());
	
	            con.setRequestProperty("Authorization", basicAuth); //
	            con.setUseCaches(false);
	            con.setDoInput(true);
	            con.setDoOutput(true);
	             
	            int responseCode = con.getResponseCode(); //
	            BufferedReader br;
	            if(responseCode==200) 
	            { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream())); 
	            } 
	            else 
	            {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer res = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) 
	            {
	            	res.append(inputLine);
	            }
	            br.close();
	            System.out.println("sd>>  "+res.toString());
	            System.out.println("res : "+res);
	            
	            char[] charRes = res.toString().toCharArray();
	            String outputQuery = "";
	            for(int i=22; i<(charRes.length-4); i++) {
	            	System.out.println(charRes[i]);
	            	outputQuery = outputQuery + charRes[i];
	            }
	            System.out.println("outputQuery:"+outputQuery);
	            return outputQuery;
	        } 
	        catch (Exception e) 
	        {
	        	System.out.println("Translate.java에서 오류 발생" );
	            System.out.println(e);
	        }
	     return "";
	}
}