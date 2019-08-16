package com.my.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.dto.MemberDto;
import com.my.test.model.biz.MemberBiz;
import com.my.test.util.WebScrap;
import com.my.test.vote.Star;
import com.my.test.vote.StarScrap;
import com.my.test.vote.VoteDto;

@Controller
public class VoteController {
	private int voteNumber;
	private String starName;
	private int page;
	
	@Autowired
	private MemberBiz biz;
	private StarScrap star = new StarScrap();
	VoteDto dto = new VoteDto();

	private WebScrap crawling = new WebScrap();
	
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
	public JSONObject voteLike(String starname, int page, Authentication auth) {
		System.out.println();
		this.starName = starname;
		this.page = page;
		
		dto.setStarName(starname);
		dto.setPage(page);
		
		System.out.println(" "+dto.getPage()+" "+dto.getStarName());
		
		
		

		JSONObject starChart = new JSONObject();
		starChart.put("name", starname);
		
		
		MemberDto memberdto = (MemberDto)auth.getPrincipal();
		if(memberdto == null) {
			System.out.println("로그인 필요");
			starChart.put("loginState", "null");
		}
		
//		VoteDao dao = new VoteDao();
//		if(dao.update(starname, page) != 0) {
//			dao.update(starname, page);
//		}else {
//			dao.insert(starname, page);
//		}
		
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
		if(biz.selectOneVote(page, starName) == null) {
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
}
