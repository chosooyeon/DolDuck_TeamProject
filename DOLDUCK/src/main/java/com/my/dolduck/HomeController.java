package com.my.dolduck;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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

import com.my.dolduck.model.dto.BroadcastDto;
import com.my.dolduck.model.dto.MemberDto;
import com.my.dolduck.model.biz.BroadcastBiz;
import com.my.dolduck.model.biz.MemberBiz;
import com.my.dolduck.util.Music;
import com.my.dolduck.util.WebScrap;
import com.my.dolduck.model.dto.VoteCrawlingDto;
import com.my.dolduck.util.VoteCrawling;
import com.my.dolduck.model.dao.VoteDao;
import com.my.dolduck.model.dto.VoteDto;

@Controller
public class HomeController {

	private int voteNumber;
	private String starName;
	private int page;
	
	@Autowired
	private MemberBiz biz;
	
	@Autowired
	private BroadcastBiz b_biz;
	
	VoteDto dto = new VoteDto();
	private WebScrap crawling = new WebScrap();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String home(Locale locale, Model model) {
		System.out.println(" ");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping("admin.do")
	public String selectList(Model model) {
		model.addAttribute("list",biz.selectList());
		return "admin/admin";
	}
	
	/************************** 濡쒓렇�븘�썐 ***************************/
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:home.do";
	}
	
	/************************** Music Chart 寃뚯떆�뙋 ***************************/
	@RequestMapping("chart.do")
	public String showMusicChart() {
		return "board/music_chart";
	}
	
	
	@RequestMapping(value = "musicsearch.do", method = {RequestMethod.POST})
	public @ResponseBody JSONObject getChart(String site) {
		
		List<Music> list = new ArrayList<Music>();

		switch(site) {
		case "melon": 
			list = crawling.getMelonChart();
			break;
		case "bugs":
			list = crawling.getBugsChart();
			break;
		case "genie":
			list = crawling.getGenieChart();
			break;
		}
		//硫쒕줎李⑦듃 �겕濡ㅻ쭅�빐�꽌 List濡� return 
				
		//JSON���엯�쑝濡� �뙆�떛
		JSONObject chart = new JSONObject();
		JSONArray songArr = new JSONArray();
		
		for(Music musicOne : list) {
			JSONObject song = new JSONObject();
			
			song.put("rank", musicOne.getRank());
			song.put("thumb", musicOne.getThumb());
			song.put("title", musicOne.getTitle());
			song.put("singer", musicOne.getSinger());
			song.put("album", musicOne.getAlbum());
			songArr.add(song);
		}
		chart.put("chart", songArr);
		
		////Realtime �떆媛꾩뼸湲�
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		chart.put("getTime", str);
		
		return chart;
	}

	
	/************************** Youtube 寃뚯떆�뙋 ***************************/
	@RequestMapping("youtube.do")
	public String showYoutubeBoard() {
		return "board/youtube";
	}
	
	/************************** Live 寃뚯떆�뙋 ***************************/
	@RequestMapping("live-home.do")
	public String liveBoard() {
		return "live/live-home";
	}
	
	@RequestMapping("live-schedule.do")
	public String liveSchedule() {
		return "live/live-schedule";
	}
	
	@RequestMapping("live-onair.do")
	public String liveOnair() {
		return "live/live-onair";
	}
	
	@RequestMapping("live-channel.do")
	public String liveChannel() {
		return "live/live-channel";
	}
	
	@RequestMapping("/getcalevents.do")
	@ResponseBody
	public JSONObject getCalendarEvents() {
		
		List<BroadcastDto> list = b_biz.selectList();
		
		JSONObject events = new JSONObject();
		JSONArray eventArr = new JSONArray();
		
		for(BroadcastDto dto : list) {
			JSONObject event = new JSONObject();
			String[] DateTime = dto.getBroadcast_date().split(" ");
			
			event.put("id", dto.getBroadcast_seq());
			event.put("title", "["+DateTime[1]+"] " + dto.getBroadcast_caster());
			event.put("start", DateTime[0]);

			eventArr.add(event);
		}
		events.put("list", eventArr);
		
		return events;
	}
	
	@RequestMapping("live-addpopup.do")
	public String popupLiveSchedule() {
		return "live/live-add-schedule";
	}
	
	@RequestMapping( value = "addevent.do", method={RequestMethod.POST})
	public String addEvent(String caster, String live_date, String live_time) {
		return "";
	}
	
	/************************* market ************************************/
	@RequestMapping("heartShop.do")
	public String heartShop() {
		return "market/heartShop";
	}
	
	@RequestMapping("Goodies.do")
	public String Goodies() {
		return "market/Goodies";
	}

	@RequestMapping("buy-heart.do")
	@ResponseBody
	public String payHeart(@RequestParam int amount, @RequestParam int price, Authentication auth) {
		
		MemberDto dto = (MemberDto)auth.getPrincipal();
		String userId = dto.getUsername();
		String result = "";
		
		int res = biz.purchaseHeart(amount, userId);
		if(res>0) {
			result = "succeed";
		}else {
			result = "failed";
		}
		return result;
	}
	
	@RequestMapping("buy-vote.do")
	@ResponseBody
	public String payVote(@RequestParam int amount, @RequestParam  int price, Authentication auth) {
		
		MemberDto dto = (MemberDto)auth.getPrincipal();
		String userId = dto.getUsername();
		String result;
		
		int res = biz.purchaseVote(amount, userId);
		System.out.println(userId + "�떂�씠 " + amount + "媛쒖쓽 �닾�몴沅뚯쓣 �궛�떎~");
		System.err.println("Controller Result => " + res);
		if(res>0) {
			result = "succeed";
		}else {
			result = "failed";
		}
		return result;
	}
	
}
