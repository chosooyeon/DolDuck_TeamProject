package com.my.dolduck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dolduck.model.biz.MarketBiz;
import com.my.dolduck.model.biz.MarketCommentBiz;
import com.my.dolduck.model.dto.MarketCommentDto;
import com.my.dolduck.model.dto.MarketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MarketController {

	@Autowired
	private MarketBiz biz;

	@Autowired
	private MarketCommentBiz bizComm;

	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

	// 게시글 목록
	@RequestMapping("/market_list.do")
	public String market_list(Model model) {

		model.addAttribute("list", biz.market_list());

		return "market/market_list";
	}

	@RequestMapping("/market_insertform.do")
	public String insertform() {

		return "market/market_insert";
	}

	// 게시글 입력
	@RequestMapping("/market_insert.do")
	public String insert(@ModelAttribute MarketDto dto) {

		int res = biz.market_insert(dto);

		if (res > 0) {
			return "redirect:market_list.do";
		} else {
			return "redirect:market_insert.do";
		}
		
	}

	// 게시글 자세히보기 & 댓글 리스트
	@RequestMapping("/market_detail.do")
	public String selectOne(Model model, int market_num) {

		System.out.println("선택된 메소드 : selectOne");
		System.out.println("선택된 게시글 번호 : " + market_num);

		// 게시글
		MarketDto dto = biz.market_detail(market_num);
		// 댓글
		List<MarketCommentDto> list = bizComm.market_comment_list(market_num);

		// 게시글
		model.addAttribute("one", dto);
		// 댓글
		model.addAttribute("commList", list);

		return "market/market_detail";

	}

	@RequestMapping("/market_update.do")
	public String update(Model model, int market_num) {
		model.addAttribute("one", biz.market_detail(market_num));

		return "market/market_update";
	}

	// 게시글 수정
	@RequestMapping("/market_updateform.do")
	public String updateform(@ModelAttribute MarketDto dto) {
		int res = biz.market_update(dto);
		if (res > 0) {
			return "redirect:market_list.do";
		}
		return "redirect:market_list.do";

	}

	// 게시글 삭제
	@RequestMapping("/market_delete.do")
	public String delete(@RequestParam("id") String id) {
		System.out.println(id);
		int res = biz.market_delete(id);
		if (res > 0) {
			return "redirect:market_list.do";
		}
		return "redirect:market_list.do";
	}

	// ====================comment=========================

	// =====댓글 입력
	@RequestMapping("/market_comment_insert.do")
	public String market_comment_insert(@ModelAttribute MarketCommentDto dto) {

		int res = bizComm.market_comment_insert(dto);
		if (res > 0) {
			return "redirect:market_detail.do?market_num=" + dto.getMarket_num();
		}
		return "redirect:market_detail.do?market_num=" + dto.getMarket_num();
	}

	// =====댓글 수정
	@RequestMapping("/market_comment_update.do")
	@ResponseBody
	public Map<String,Object> market_comment_update(int comm_num,String comm_content) {
		System.out.println("게시판번호"+comm_num);
		System.out.println("댓글내용"+comm_content);
		Boolean updatechk = false;
		Map<String,Object> map = new HashMap<String, Object>();
		
		MarketCommentDto dto = new MarketCommentDto();
		dto.setMarket_comment_content(comm_content);
		dto.setMarket_comment_num(comm_num);
		
		int res = bizComm.market_comment_update(dto);
		System.out.println(res);
		
		if (res > 0) {
			updatechk=true;
			map.put("content", comm_content);
			map.put("updatechk", updatechk);
		}else {
			map.put("updatechk", updatechk);
		}
		System.out.println(updatechk);
		return map;
	}

	// =====댓글 삭제
	@RequestMapping("/market_comment_delete.do")
	public String market_comment_delete(@RequestParam("Comment_num") int Comment_num, int market_num) {

		int res = bizComm.market_comment_delete(Comment_num);
		if (res > 0) {
			return "redirect:market_detail.do?market_num=" + market_num;
		}
		return "redirect:market_detail.do?market_num=" + market_num;
	}
}
