package com.my.dolduck;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dolduck.model.biz.BroadcastBiz;
import com.my.dolduck.model.dto.BroadcastDto;
import com.my.dolduck.model.dto.MemberDto;

@Controller
public class LiveController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BroadcastBiz b_biz;
	
	
	/************************** Live 게시판 ***************************/
	
	//홈
	@RequestMapping("live-home.do")
	public String liveBoard(Model model) {
		
		List<BroadcastDto> list = b_biz.selectListHavingVideo();
		
		JSONObject videos = new JSONObject();
		JSONArray videoArr = new JSONArray();
		
		for(BroadcastDto dto : list) {
			JSONObject video = new JSONObject();
			
			video.put("seq", dto.getBroadcast_seq());
			video.put("title", dto.getBroadcast_title());
			video.put("date", dto.getBroadcast_date());
			video.put("thumb", "C:\\Users\\user1\\Downloads\\"+dto.getBroadcast_content()+".jpg");
			
			videoArr.add(video);
		}
		//videos.put("list", videoArr);
		model.addAttribute("list", videoArr);
				
		//C:\Workspace_finalProject\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\DOLDUCK\resources\videos
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
			event.put("start", DateTime[0]+"T"+DateTime[1]);
			event.put("end", DateTime[0]+"T"+"23:00");
			event.put("allDay", false);
			
			eventArr.add(event);
			
		}
		events.put("list", eventArr);
		
		
		return events;
	}
	
	//일정 추가(+)
	@RequestMapping( value = "addevent.do", method={RequestMethod.POST})
	@ResponseBody
	public String addEvent(@RequestParam Map<String,Object> item) {
		String result = "";
		BroadcastDto event = new BroadcastDto();
		event.setBroadcast_caster((String) item.get("caster"));
		event.setBroadcast_title((String) item.get("title"));
		String date = (String)(item.get("start_date")+" "+item.get("start_hour")+":"+item.get("start_min"));
		event.setBroadcast_date(date);
		
		System.err.println(event.getBroadcast_caster());
		System.err.println(event.getBroadcast_title());
		System.err.println("date : " + date);
		
		int res = b_biz.insert(event);
		System.err.println("insert res : " + res);
		if(res>0) {
			result = "succeed";
		}else {
			result = "failed";
		}
		return result;
	}
	
	//일정 삭제(-)
	@RequestMapping("deleteEvent.do")
	public String deleteEvent() {
		return "";
	}
	
	//온에서 - 디테일 
	@RequestMapping("live-detail.do")
	public String liveDetail(String video_seq, Model model) {

		BroadcastDto dto = b_biz.selectOne(Integer.parseInt(video_seq));
		model.addAttribute("dto", dto);
				
		return "live/live-detail";
	}
	
	//온에어 - 대기실
	@RequestMapping("live-onair.do")
	public String liveOnair() {
		return "live/live-onair-platform";
	}
	
	//온에어- 입장(Caster)
	@RequestMapping("start-onair.do")
	public String startLive(String live_caster, String live_title, String startingTime, String room_number, Model model, Authentication auth) {
		
		MemberDto caster = (MemberDto)auth.getPrincipal();
		System.out.println("["+caster.getMember_id()+"]님이 "+startingTime+"에 "+ live_title + "으로 방송시작!\n" + " >>> 방번호 : " + room_number);
		
		BroadcastDto dto = new BroadcastDto();
		dto.setBroadcast_caster(live_caster);
		dto.setBroadcast_title(live_title);
		dto.setBroadcast_date(startingTime);
		System.err.println(dto.getBroadcast_date());
		int res = b_biz.insert(dto);
		System.err.println("라이브 시작! 일정추가하기 : " + res);

		if(res>0) {
			model.addAttribute("caster", caster);
			model.addAttribute("live", dto);
			return "live/live-onair-caster";
		}else {
			return "redirect:live-onair.do";
		}
	}
	
	//온에어 - 입장(User)
	@RequestMapping("join-onair.do")
	public String joinLive(@RequestParam String room, Model model, Authentication auth) {
		MemberDto dto = (MemberDto)auth.getPrincipal();
		model.addAttribute("dto", dto);
		
		return "live/live-onair-user";
	}
	
	//채널보기
	@RequestMapping("live-channel.do")
	public String liveChannel() {	
		
		return "live/live-channel";
	}
	
	//
	@RequestMapping("certification.do")
	public String certification() {
		return "live/certification";
	}
	
	

}
