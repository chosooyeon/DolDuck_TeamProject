package com.my.dolduck;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dolduck.model.biz.FreeboardBiz;
import com.my.dolduck.model.biz.FreeboardCommentBiz;
import com.my.dolduck.model.dto.FreeboardCommentDto;
import com.my.dolduck.model.dto.FreeboardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FreeBoardController {

	@Autowired
	private FreeboardBiz biz;

	@Autowired
	private FreeboardCommentBiz bizComm;

	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//
//		return "home";
//	}

	// 게시글 목록
	@RequestMapping("free_list.do")
	public String freeboard_list(Model model) {

		model.addAttribute("list", biz.free_list());

		return "board/free_list";
	}

	@RequestMapping("free_insertform.do")
	public String insertform() {

		return "board/free_insert";
	}

	// 게시글 입력
	@RequestMapping("free_insert.do")
	public String insert(@ModelAttribute FreeboardDto dto) {

		int res = biz.free_insert(dto);

		if (res > 0) {
			return "board/free_list";
		}
		return "board/free_insert";
	}

	// 게시글 자세히보기 & 댓글 리스트
	@RequestMapping("free_detail.do")
	public String selectOne(Model model, int freeboard_num) {

		System.out.println("나중에 지우기");
		System.out.println("선택된 메소드 : selectOne");
		System.out.println("선택된 게시글 번호 : " + freeboard_num);

		// 게시글
		FreeboardDto dto = biz.free_detail(freeboard_num);
		// 댓글
		List<FreeboardCommentDto> list = bizComm.freeboard_comment_list(freeboard_num);

		// 게시글
		model.addAttribute("one", dto);
		// 댓글
		model.addAttribute("commList", list);

		return "board/free_detail";

	}

	@RequestMapping("free_update.do")
	public String update(Model model, int freeboard_num) {
		model.addAttribute("one", biz.free_detail(freeboard_num));

		return "board/free_update";
	}

	// 게시글 수정
	@RequestMapping("free_updateform.do")
	public String updateform(@ModelAttribute FreeboardDto dto) {
		int res = biz.free_update(dto);
		if (res > 0) {
			return "redirect:free_list.do";
		}
		return "redirect:free_list.do";

	}

	// 게시글 삭제
	@RequestMapping("free_delete.do")
	public String delete(@RequestParam("id") String id) {
		System.out.println(id);
		int res = biz.free_delete(id);
		if (res > 0) {
			return "redirect:free_list.do";
		}
		return "redirect:free_list.do";
	}

	// ====================comment=========================

	// =====댓글 입력
	@RequestMapping("freeboard_comment_insert.do")
	public String free_comment_insert(@ModelAttribute FreeboardCommentDto dto) {

		int res = bizComm.freeboard_comment_insert(dto);
		if (res > 0) {
			return "redirect:free_detail.do?freeboard_num=" + dto.getFreeboard_num();
		}
		return "redirect:free_detail.do?freeboard_num=" + dto.getFreeboard_num();
	}

	// =====댓글 수정
	@RequestMapping("freeboard_comment_update.do")
	@ResponseBody
	public Map<String,Object> free_comment_update(int comm_num,String comm_content) {
		System.out.println("게시판번호"+comm_num);
		System.out.println("댓글내용"+comm_content);
		Boolean updatechk = false;
		Map<String,Object> map = new HashMap<String, Object>();
		
		FreeboardCommentDto dto = new FreeboardCommentDto();
		dto.setFreeboard_comment_content(comm_content);
		dto.setFreeboard_comment_num(comm_num);
		
		int res = bizComm.freeboard_comment_update(dto);
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
	@RequestMapping("freeboard_comment_delete.do")
	public String free_comment_delete(@RequestParam("Comment_num") int Comment_num, int freeboard_num) {

		int res = bizComm.freeboard_comment_delete(Comment_num);
		if (res > 0) {
			return "redirect:free_detail.do?freeboard_num=" + freeboard_num;
		}
		return "redirect:free_detail.do?freeboard_num=" + freeboard_num;
	}
}
