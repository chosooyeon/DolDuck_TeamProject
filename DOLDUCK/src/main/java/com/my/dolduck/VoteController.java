package com.my.dolduck;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dolduck.model.biz.MemberBiz;
import com.my.dolduck.util.WebScrap;
import com.my.dolduck.model.dto.VoteCrawlingDto;
import com.my.dolduck.util.VoteCrawling;
import com.my.dolduck.model.dto.VoteDto;

@Controller
public class VoteController {
	private int voteNumber;
	private String starName;
	private int page;
	
	@Autowired
	private MemberBiz biz;
	private VoteCrawling voteCrawling = new VoteCrawling();
	VoteDto dto = new VoteDto();
	
	/************************* Vote 게시판 ************************************/
	@RequestMapping("vote.do")
	public String vote() {
		return "vote/vote";
	}
	
	@RequestMapping("voteCrawling.do")
	@ResponseBody
	public JSONObject voteCrawling(int page) {
		System.out.println();
		List<VoteCrawlingDto> list = new ArrayList<VoteCrawlingDto>();
		
		list = voteCrawling.getVoteChart(page);
		
		//JSON타입으로 파싱
		JSONObject starChart = new JSONObject();
		JSONArray starArr = new JSONArray();

		for(VoteCrawlingDto starOne : list) {
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
	public JSONObject voteLike(String starname, int page, Principal principal) {
		System.out.println();
		this.starName = starname;
		this.page = page;
		
		dto.setStarName(starname);
		dto.setPage(page);
		
		System.out.println(" "+dto.getPage()+" "+dto.getStarName());
		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		UserDetails userDetails = (UserDetails)principal;
		System.out.println("principal:"+principal);
//		UserDetails userDetails = (UserDetails)principal;
//		String username = userDetails.getUsername();
		
		JSONObject starChart = new JSONObject();
		starChart.put("name", starname);
		
//		System.out.println("userDetails:"+userDetails);
		
		if(principal == null) {
			starChart.put("loginState", "null");			
		}
		
		System.out.println("loginState:"+starChart.get("loginState"));
		
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
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String member_id = userDetails.getUsername();
		
		if(biz.selectMemberVote(member_id) < voteNumber) {
			//보유투표권수<투표수 이면 부족메세지출력
			obj.put("voteNeed", "need");
		}else {
			biz.updateMemberVote(member_id, voteNumber);
		}
		
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
