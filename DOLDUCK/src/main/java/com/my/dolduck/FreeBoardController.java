package com.my.dolduck;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD

=======
>>>>>>> d87e43679dd5e258f3649c35140451187c5404dc
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.dolduck.model.biz.FreeboardBiz;
import com.my.dolduck.model.biz.FreeboardCommentBiz;
import com.my.dolduck.model.dto.FreeboardCommentDto;
import com.my.dolduck.model.dto.FreeboardDto;
import com.my.dolduck.model.dto.MemberDto;

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

	// 게시글 목록
	@RequestMapping("free_list.do")
	public String freeboard_list(Model model) {

		model.addAttribute("list", biz.free_list());

		return "board/free_list";
	}

	@RequestMapping("free_insertform.do")
	public String insertform(Model model, Authentication auth) {
		MemberDto dto = (MemberDto) auth.getPrincipal();
		String M_id = dto.getUsername();
		model.addAttribute("member_id", M_id);

		return "board/free_insert";
	}

	// 게시글 입력
	@RequestMapping("free_insert.do")
	public String insert(@ModelAttribute FreeboardDto dto, MultipartHttpServletRequest mtfRequest,
			Authentication auth) {

		MemberDto Mdto = (MemberDto) auth.getPrincipal();
		String member_id = Mdto.getUsername();
		dto.setFreeboard_id(member_id);

		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String path = mtfRequest.getSession().getServletContext().getRealPath("resources/uploadImage");
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			String class_img_path = path + "/" + originFileName; // 경로
			System.out.println("경로 " + class_img_path);
			String feeboard_file = originFileName; // 파일 이름
			dto.setFreeboard_file(feeboard_file);
			System.out.println(feeboard_file);
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			int res = 0;
			try {
				if(mf.getSize() == 0) {
					System.out.println("없음");
				}else {
					mf.transferTo(new File(class_img_path)); // 파일 집어넣는다					
				}

				res = biz.free_insert(dto);
				if (res > 0) {
					System.out.println("성공");
					return "redirect:free_list.do";
				}

			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		System.out.println("실패");
		return "redirect:free_insert.do";

	}

	// 게시글 자세히보기 & 댓글 리스트
	@RequestMapping("free_detail.do")
	public String selectOne(Model model, int freeboard_num, FreeboardDto dto, Authentication auth) {

		MemberDto Mdto = (MemberDto) auth.getPrincipal();
		String member_id = Mdto.getUsername();
		dto.setFreeboard_id(member_id);

		System.out.println("나중에 지우기");
		System.out.println("선택된 메소드 : selectOne");
		System.out.println("선택된 게시글 번호 : " + freeboard_num);

		// 게시글
		FreeboardDto Fdto = biz.free_detail(freeboard_num);
		// 댓글
		List<FreeboardCommentDto> list = bizComm.freeboard_comment_list(freeboard_num);

		// 게시글
		model.addAttribute("one", Fdto);
		// 댓글
		model.addAttribute("commList", list);

		return "board/free_detail";

	}

	@RequestMapping("free_update.do")
	public String update(Model model, int freeboard_num) {
		System.err.println("free_update.do : 수정하기 ");
		System.out.println(freeboard_num);	
		model.addAttribute("one", biz.free_detail(freeboard_num));
		System.err.println("통과!!!!");
		return "board/free_update";
	}

	// 게시글 수정
	@RequestMapping("free_updateform.do")
	public String updateform(@ModelAttribute FreeboardDto dto, MultipartHttpServletRequest mtfRequest,
			Authentication auth) {
		MemberDto Mdto = (MemberDto) auth.getPrincipal();
		String member_id = Mdto.getUsername();
		dto.setFreeboard_id(member_id);

		System.err.println("free_updateform : 수정하기 ");
		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String path = mtfRequest.getSession().getServletContext().getRealPath("resources/uploadImage");
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			String class_img_path = path + "/" + originFileName; // 경로

			System.out.println("경로 " + class_img_path);

			String feeboard_file = originFileName; // 파일 이름
			dto.setFreeboard_file(feeboard_file);

			System.out.println(feeboard_file);
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);

			int res = 0;
			try {
				
				if(mf.getSize() == 0) {
					System.out.println("없음");
				}else {
					mf.transferTo(new File(class_img_path)); // 파일 집어넣는다					
				}
				res = biz.free_update(dto);
				if (res > 0) {
					System.out.println("성공");
					return "redirect:free_detail.do?freeboard_num=" + dto.getFreeboard_num();
				}

			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return "redirect:free_update.do";

	}

	// 게시글 삭제
	@RequestMapping("free_delete.do")
	public String delete(@RequestParam("num") int num) {
		System.out.println(num);
		int res = biz.free_delete(num);
		if (res > 0) {
			return "redirect:free_list.do";
		}
		return "redirect:free_list.do";
	}

	// 게시글 입력 + 로그인체크
	@RequestMapping("/free_insert_login.do")
	@ResponseBody
	public JSONObject insertLogin(Principal principal) {
		JSONObject loginChk = new JSONObject();
		if (principal == null) {
			loginChk.put("loginState", "null");
		}
		return loginChk;
	}

	// 게시글 입력 + 로그인체크
	@RequestMapping("/free_detail_login.do")
	@ResponseBody
	public JSONObject detailLogin(Principal principal) {
		JSONObject loginChk = new JSONObject();
		if (principal == null) {
			loginChk.put("loginState", "null");
		}
		return loginChk;
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
	public Map<String, Object> free_comment_update(int comm_num, String comm_content) {
		System.out.println("게시판번호" + comm_num);
		System.out.println("댓글내용" + comm_content);
		Boolean updatechk = false;
		Map<String, Object> map = new HashMap<String, Object>();

		FreeboardCommentDto dto = new FreeboardCommentDto();
		dto.setFreeboard_comment_content(comm_content);
		dto.setFreeboard_comment_num(comm_num);

		int res = bizComm.freeboard_comment_update(dto);
		System.out.println(res);

		if (res > 0) {
			updatechk = true;
			map.put("content", comm_content);
			map.put("updatechk", updatechk);
		} else {
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

	// =====대댓글 입력
	@RequestMapping("freeboard_co_comment_insert")
	public String freeboard_co_comment_insert(@ModelAttribute FreeboardCommentDto dto) {
		int res = bizComm.freeboard_co_comment_insert(dto);

		if (res > 0) {
			return "redirect:free_detail.do?freeboard_num=" + dto.getFreeboard_num();
		}
		return "redirect:free_detail.do?freeboard_num=" + dto.getFreeboard_num();
	}

	// =====Search
	@RequestMapping("find.do")
	public String find_list(String Searchtext, Model model) {

		System.out.println("text= " + Searchtext);
		model.addAttribute("list", biz.find_list(Searchtext));
		System.out.println("biz.find_list(Searchtext)= " + biz.find_list(Searchtext));

		return "board/find_list";
	}
	

}
