package com.my.test;

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

import com.my.test.dto.MemberDto;
import com.my.test.model.biz.MemberBiz;
import com.my.test.util.Music;
import com.my.test.util.WebScrap;
import com.my.test.vote.Star;
import com.my.test.vote.StarScrap;
import com.my.test.vote.VoteDao;
import com.my.test.vote.VoteDto;

@Controller
public class HomeController {
	private int voteNumber;
	private String starName;
	private int page;
	
	@Autowired
	private MemberBiz biz;
	private StarScrap star = new StarScrap();
	VoteDto dto = new VoteDto();

	private WebScrap crawling = new WebScrap();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String home(Locale locale, Model model) {
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
	
	/************************** 로그아웃 ***************************/
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:home.do";
	}
	
	/************************** Music Chart 게시판 ***************************/
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
		//멜론차트 크롤링해서 List로 return 
				
		//JSON타입으로 파싱
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
		
		////Realtime 시간얻기
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		chart.put("getTime", str);
		
		return chart;
	}

	
	/************************** Youtube 게시판 ***************************/
	@RequestMapping("youtube.do")
	public String showYoutubeBoard() {
		return "board/youtube";
	}
	
	/************************** Youtube 게시판 ***************************/
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
		System.out.println(userId + "님이 " + amount + "개의 투표권을 산다~");
		System.err.println("Controller Result => " + res);
		if(res>0) {
			result = "succeed";
		}else {
			result = "failed";
		}
		return result;
	}

	
	
	/************************* Vote 게시판 ************************************/
	@RequestMapping("vote.do")
	public String showStarChart() {
		return "vote/star";
	}
	
	@RequestMapping("votesearch.do")
	@ResponseBody
	public JSONObject getStar(int page) {
		System.out.println();
		List<Star> list = new ArrayList<Star>();
		
		list = star.getStarChart(page);
		
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
	
	@RequestMapping("votelike.do")
	@ResponseBody
	public JSONObject voteLike(String starname, int page) {
		System.out.println();
		this.starName = starname;
		this.page = page;
		
		dto.setStarName(starname);
		dto.setPage(page);

		JSONObject starChart = new JSONObject();
		starChart.put("name", starname);
		
		VoteDao dao = new VoteDao();
		if(dao.update(starname, page) != 0) {
			dao.update(starname, page);
		}else {
			dao.insert(starname, page);
		}
		
		
		
		System.out.println("page:"+page);
		System.out.println("starname:"+starname);
		System.out.println(starChart);
		return starChart;
	}
	
	@RequestMapping("votepopup.do")
	public String votePopup() {
		return "vote/votepopup";
	}
	
	@RequestMapping("votenumber.do")
	@ResponseBody
	public JSONObject voteNumber(int voteNumber) {
		JSONObject obj = new JSONObject();
		dto.setVoteNumber(voteNumber);
		System.out.println("votenumber:"+dto.getVoteNumber());
		this.voteNumber = voteNumber;
		obj.put("voteNum", voteNumber);
		obj.put("starName", starName);
		obj.put("page", page);
		System.out.println(obj.get("starName")+"  "+obj.get("voteNum"));
		return obj;
	}
	
	@RequestMapping("voteresult.do")
	public String voteResult(Model model) {
		System.out.println(voteNumber+starName+page);
		System.out.println(dto.getStarName()+dto.getPage()+dto.getVoteNumber());
		model.addAttribute("starName", starName);
		model.addAttribute("voteNumber", voteNumber);
		System.out.println("select:"+biz.selectOneVote(page, starName));
		if(biz.selectOneVote(page, starName).getStarName() == null) {
			biz.insertVote(new VoteDto(page,starName,voteNumber));
			System.out.println("insert");
		} else if(biz.selectOneVote(page, starName).getStarName() != null){
			biz.updateVote(new VoteDto(page,starName,voteNumber));
			System.out.println("update");
		}
		return "vote/voteresult";
	}
	
	@RequestMapping("votesave.do")
	@ResponseBody
	public void voteSave() {
		System.out.println("votesave1");
	}
	
//	@RequestMapping("votesave.do")
//	@ResponseBody
//	public String voteSave(int voteNumber, String starName, int page) {
//		System.out.println("??");
//		biz.insertVote(new VoteDto(page,starName,voteNumber));
//		System.out.println("votesave1");
//		return "success";
//	}
}
