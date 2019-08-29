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

import com.my.dolduck.model.biz.VoteBiz;
import com.my.dolduck.model.dto.VoteCrawlingDto;
import com.my.dolduck.model.dto.VoteDto;
import com.my.dolduck.util.WebScrap;

@Controller
public class VoteController {

   @Autowired
   private VoteBiz biz;
   private WebScrap crawling = new WebScrap();
   VoteDto dto = new VoteDto();

   /************************* Vote 게시판 ************************************/
   @RequestMapping("vote.do")
   public String vote() {
      return "vote/vote_main";
   }

   @RequestMapping("vote-crawling.do")
   @ResponseBody
   public JSONObject voteCrawling(String item) {
      System.out.println();
      System.out.println("item:"+item);
      List<VoteCrawlingDto> list = new ArrayList<VoteCrawlingDto>();

      list = crawling.getVoteChart(item);
      // JSON타입으로 파싱
      JSONObject starChart = new JSONObject();
      JSONArray starArr = new JSONArray();

      for (VoteCrawlingDto starOne : list) {
         JSONObject star = new JSONObject();

         star.put("name", starOne.getName());
         star.put("img", starOne.getImg());
         star.put("voteNumber", biz.selectVoteNumber(starOne.getName()));
         
         starArr.add(star);
      }
      // real time 얻기
      long time = System.currentTimeMillis();
      SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      String str = dayTime.format(new Date(time));
      starChart.put("getTime", str);
      starChart.put("starChart", starArr);
      System.out.println("starChart:" + starChart);
      return starChart;
   }

   // pick 버튼 클릭시 VoteDto에 starname, item 저장 + 로그인 체크
   @RequestMapping("vote-pick.do")
   @ResponseBody
   public JSONObject votePick(String starname, String item, Principal principal) {
      dto.setStarName(starname);
      dto.setItem(item);

      JSONObject loginChk = new JSONObject();
      if (principal == null) {
         loginChk.put("loginState", "null");
      }
      return loginChk;
   }

   // 로그인상태일경우 투표수 선택하는 팝업창 띄우기
   @RequestMapping("vote-popup.do")
   public String votePopup() {
      return "vote/vote_popup";
   }

   @RequestMapping("vote-numberchk.do")
   @ResponseBody
   public JSONObject voteNumberChk(int voteNumber) {
      JSONObject voteNumberChk = new JSONObject();
      dto.setVoteNumber(voteNumber);

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String member_id = userDetails.getUsername();

      if (biz.selectMemberVote(member_id) < voteNumber) {
         // 보유투표권수 < 투표수 이면 부족메세지출력
         voteNumberChk.put("voteNeed", "need");
      } else {
         biz.updateMemberVote(member_id, voteNumber);
      }

      return voteNumberChk;
   }

   // 투표 성공시 결과창 출력
   @RequestMapping("vote-result.do")
   @ResponseBody
   public void voteResult(Model model) {
      System.out.println(dto.getStarName() + dto.getItem() + dto.getVoteNumber());
      model.addAttribute("starName", dto.getStarName());
      model.addAttribute("voteNumber", dto.getVoteNumber());

      // 투표한후보가 0표이상 가지고있을시 update, 아닐시 insert
      if (biz.selectOneVote(dto.getItem(), dto.getStarName()) == null) {
         biz.insertVote(new VoteDto(dto.getItem(), dto.getStarName(), dto.getVoteNumber()));
         System.out.println("insert");
      } else if (biz.selectOneVote(dto.getItem(), dto.getStarName()) != null) {
         biz.updateVote(new VoteDto(dto.getItem(), dto.getStarName(), dto.getVoteNumber()));
         System.out.println("update");
      }
   }
}
