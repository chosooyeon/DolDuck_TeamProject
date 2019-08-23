package com.my.dolduck;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dolduck.model.biz.BroadcastBiz;
import com.my.dolduck.model.dto.BroadcastDto;

@Controller
public class LiveController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BroadcastBiz b_biz;
	
	
	/************************** Live 게시판 ***************************/
	
	//홈
	@RequestMapping("live-home.do")
	public String liveBoard() {
		return "live/live-home";
	}
	
	//일정표
	@RequestMapping("live-schedule.do")
	public String liveSchedule() {
		return "live/live-schedule";
	}
	
	//일정(event) 가져오기 
	@RequestMapping("getcalevents.do")
	@ResponseBody
	public JSONObject getCalendarEvents() {
		
		List<BroadcastDto> list = b_biz.selectList();
		
		JSONObject events = new JSONObject();
		JSONArray eventArr = new JSONArray();
		
		for(BroadcastDto dto : list) {
			JSONObject event = new JSONObject();
			String[] DateTime = dto.getBroadcast_date().split(" ");
			
			event.put("id", dto.getBroadcast_seq());
			event.put("title", dto.getBroadcast_caster() + "-" + dto.getBroadcast_title());
			event.put("start", DateTime[0]);
			event.put("end", DateTime[0]);
			event.put("allDay", false);
			
			eventArr.add(event);
		}
		events.put("list", eventArr);
		
		
		return events;
	}
	
	//일정 추가(+)
	@RequestMapping( value = "addevent.do", method={RequestMethod.POST})
	public String addEvent() {
		return "";
	}
	
	//일정 삭제(-)
	@RequestMapping("deleteEvent.do")
	public String deleteEvent() {
		return "";
	}
	
	//온에어 - 대기실
	@RequestMapping("live-onair.do")
	public String liveOnair() {
		return "live/live-onair-platform";
	}
	
	//온에어- 입장(Caster)
	@RequestMapping("start-onair.do")
	public String startLive(@RequestParam String live_title) {
		System.err.println("title: " + live_title);
		return "live/live-onair-caster";
	}
	
	//온에어 - 입장(User)
	@RequestMapping("join-onair.do")
	public String joinLive() {
		return "";
	}
	
	//채널보기
	@RequestMapping("live-channel.do")
	public String liveChannel() {
		return "live/live-channel";
	}
	
	
	

}
