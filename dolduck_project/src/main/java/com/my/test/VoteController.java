package com.my.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.vote.Star;
import com.my.test.vote.StarScrap0;
import com.my.test.vote.StarScrap1;
import com.my.test.vote.StarScrap2;
import com.my.test.vote.StarScrap3;
import com.my.test.vote.StarScrap4;
import com.my.test.vote.StarScrap5;

@Controller
public class VoteController {

	private StarScrap0 star0 = new StarScrap0();
	private StarScrap1 star1 = new StarScrap1();
	private StarScrap2 star2 = new StarScrap2();
	private StarScrap3 star3 = new StarScrap3();
	private StarScrap4 star4 = new StarScrap4();
	private StarScrap5 star5 = new StarScrap5();

	@RequestMapping("vote.do")
	public String showStarChart() {
		return "vote/star";
	}
	
	@RequestMapping("votesearch0.do")
	@ResponseBody
	public JSONObject getStar0() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star0.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star0 = new JSONObject();
			
			star0.put("name", starOne.getName());
			star0.put("img", starOne.getImg());
			
			starArr.add(star0);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
	
	@RequestMapping("votesearch1.do")
	@ResponseBody
	public JSONObject getStar1() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star1.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star1 = new JSONObject();
			
			star1.put("name", starOne.getName());
			star1.put("img", starOne.getImg());
			
			starArr.add(star1);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
	
	@RequestMapping("votesearch2.do")
	@ResponseBody
	public JSONObject getStar2() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star2.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star2 = new JSONObject();
			
			star2.put("name", starOne.getName());
			star2.put("img", starOne.getImg());
			
			starArr.add(star2);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
	
	@RequestMapping("votesearch3.do")
	@ResponseBody
	public JSONObject getStar3() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star3.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star = new JSONObject();
			
			star.put("name", starOne.getName());
			star.put("img", starOne.getImg());
			
			starArr.add(star);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
	
	@RequestMapping("votesearch4.do")
	@ResponseBody
	public JSONObject getStar4() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star4.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star = new JSONObject();
			
			star.put("name", starOne.getName());
			star.put("img", starOne.getImg());
			
			starArr.add(star);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
	
	@RequestMapping("votesearch5.do")
	@ResponseBody
	public JSONObject getStar5() {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star5.getStarChart();
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(Star starOne : list) {
			JSONObject star = new JSONObject();
			
			star.put("name", starOne.getName());
			star.put("img", starOne.getImg());
			
			starArr.add(star);
		}
	////Realtime 시간얻기
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = dayTime.format(new Date(time));
			starChart.put("getTime", str);
		starChart.put("starChart", starArr);
		System.out.println("starChart:"+starChart);
		return starChart;
	}
}
