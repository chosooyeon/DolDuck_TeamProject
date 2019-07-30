package com.my.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.dto.MemberDto;
import com.my.test.model.biz.MemberBiz;

@Controller
public class HomeController {
	
	@Autowired
	private MemberBiz biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/************************** 로그인 ***************************/
	@RequestMapping("loginform.do")
	public String loginform() {
		return "login";
	}
	
	@RequestMapping("login.do")
	@ResponseBody
	public Map<String, Boolean> login(String id, String pw, HttpSession session){
		System.out.println("여기 들어옴");
		/*
		 * @ResponseBody: java 객체를 response객체에 binding
		 * @RequestBody: request객체로 넘어오는 데이터를 java 객체
		 * */
		
		MemberDto dto = biz.login(id, pw);
		boolean loginChk = false;
		System.out.println(loginChk+"로그인 체크값");
		if(dto!=null) {
			session.setAttribute("login", dto);
			loginChk=true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("loginChk", loginChk);
		
		return map;
	}
	
	public String showMusicChart() {
		
		
		
		
		return "music_chart";
	}
	
	
}
