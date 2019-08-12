package com.my.test;

import java.io.IOException;	
import java.io.UnsupportedEncodingException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.dto.MemberDto;
import com.my.test.model.biz.MemberBizImpl;
import com.my.test.service.UserAuthenticationService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserAuthenticationService user = new UserAuthenticationService();

	@Inject
	BCryptPasswordEncoder passwordEncoder; // 鍮꾨�踰덊샇 �븫�샇�솕 媛앹껜

	@Inject
	private MemberBizImpl biz;

	private String randompassword;

	// 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "login.do")
	public String loginform() {
		return "/member/login";
	}

	// 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/member/login.do")
	public String login() {
		return "/member/login";
	}

	// �븘�씠�뵒 李얘린 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "idfind.do")
	public String idfind() {
		return "/member/idfind";
	}

	// 鍮꾨�踰덊샇 李얘린 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "pwfind.do")
	public String pwfind() {
		return "/member/pwfind";
	}

	// 留덉씠�럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "mypage.do")
	public String mypage() {
		return "/member/mypage";
	}

	// �쉶�썝�젙蹂� �닔�젙 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "modified.do")
	public String modified() {
		return "/member/modified";
	}

	// �쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞
	@RequestMapping("register.do")
	public String userInsert(@RequestParam String user_id, @RequestParam String user_pw, @RequestParam String user_name,
			@RequestParam String user_email, @RequestParam String user_phone, @RequestParam String user_addr) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("member_id", user_id);
		System.out.println("�븫�샇�솕 �쟾 鍮꾨쾲" + user_pw);
		String encryptPassword = passwordEncoder.encode(user_pw);
		System.out.println("�븫�샇�솕 �썑 鍮꾨쾲" + encryptPassword);
		map.put("member_pw", encryptPassword);
		map.put("member_name", user_name);
		map.put("member_phone", user_phone);
		map.put("member_addr", user_addr);
		map.put("member_email", user_email);

		biz.insertUser(map);

		return "/member/login";
	}

	// 沅뚰븳�씠 �뾾�뒗 �궗�슜�옄�뿉寃� �븞�궡 �럹�씠吏� 異쒕젰
	@RequestMapping("denied")
	public String denied(Model model, Authentication auth, HttpServletRequest req) {
		AccessDeniedException ade = (AccessDeniedException) req.getAttribute(WebAttributes.ACCESS_DENIED_403);

		model.addAttribute("errMSg", ade);
		return "denied";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginform";
	}

	@RequestMapping(value = "idChk.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Boolean> idChk(String id) {
		logger.info("�븘�씠�뵒 以묐났泥댄겕");

		System.out.println(id);
		boolean idChk = false;

		Map<String, Boolean> map = new HashMap<String, Boolean>();

		if (biz.idCheck(id) == null) {
			idChk = true;
			map.put("idChk", idChk);
		} else {
			map.put("idChk", idChk);
		}

		return map;
	}

	@RequestMapping(value = "nickChk.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Boolean> nickChk(String nickname) {
		logger.info("�땳�꽕�엫 以묐났泥댄겕");
		System.out.println(nickname);
		boolean nickChk = false;

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (biz.nickCheck(nickname) == null) {
			nickChk = true;
			map.put("nickChk", nickChk);
		} else {
			map.put("nickChk", nickChk);
		}
		return map;

	}

	@RequestMapping(value = "sendEmail.do", method = RequestMethod.GET)
	@ResponseBody
	public void sendEmail(String email) throws UnsupportedEncodingException, MessagingException {
		randompassword = MakeRandom.GetRandomPassword();
		System.out.println(randompassword);

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost("smtp.gmail.com");
		mailSender.setPassword("whwhwkd%5");
		mailSender.setPort(587);
		mailSender.setUsername("ad.team555@gmail.com");
		if (mailSender.getPort() == 587) {
			Properties javaMailProperties = new Properties();
			javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
			mailSender.setJavaMailProperties(javaMailProperties);
		}

		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, false, "UTF-8");
		helper.setFrom(new InternetAddress("ad.team555@gmail.com", "Dol-Duck"));
		helper.setTo(new InternetAddress(email, ""));
		System.out.println("email:" + email);
		helper.setSubject("[DOLDuck]�씤利앸쾲�샇 test");
		helper.setText("<a><b style='color:hotpink;'>�씤利앸쾲�샇 : " + randompassword + "<a>", true);

		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			logger.error("硫붿씪諛쒖넚 �떎�뙣", ex);
		}

	}

	@ResponseBody
	@RequestMapping(value = "VerifyRecaptcha", method = RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
		VerifyRecaptcha.setSecretKey("6LfHerAUAAAAACUEUT2MZxaiydRTDktzKSogfRvS");
		String gRecaptchaResponse = request.getParameter("recaptcha");
		System.out.println(gRecaptchaResponse);
		// 0 = �꽦怨�, 1 = �떎�뙣, -1 = �삤瑜�
		try {
			if (VerifyRecaptcha.verify(gRecaptchaResponse))
				return 0;
			else
				return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@RequestMapping(value = "emailCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Boolean> email_check(String ranNumPass) {

		boolean ranChk = false;

		Map<String, Boolean> map = new HashMap<String, Boolean>();

		System.out.println(ranNumPass);
		System.out.println(randompassword);

		if (randompassword.equals(ranNumPass)) {
			ranChk = true;
			map.put("ranChk", ranChk);
		} else {
			map.put("idchk", ranChk);
		}

		return map;
	}

	@RequestMapping(value = "kakao.do", method = RequestMethod.POST)
	public String kakao(HttpServletRequest request, @RequestParam String id, @RequestParam String name) {
		boolean idChk = false;

		System.out.println("sns濡쒓렇�씤 �뱾�뼱�샂 ");

		if (biz.idCheck(id) == null) { // �븘�씠�뵒媛� �뾾�쑝硫� 媛��엯

			System.out.println("SNS濡쒓렇�씤 媛��엯");
			idChk = true;

			int res = 0;

			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", id);
			System.out.println("�븫�샇�솕 �쟾 鍮꾨쾲" + id);
			String encryptPassword = passwordEncoder.encode(id);
			System.out.println("�븫�샇�솕 �썑 鍮꾨쾲" + encryptPassword);
			map.put("member_pw", encryptPassword);
			map.put("member_name", name);
			map.put("member_phone", "�쟾�솕踰덊샇瑜� �엯�젰�빐二쇱꽭�슂");
			map.put("member_addr", "二쇱냼瑜� �엯�젰�빐二쇱꽭�슂");
			map.put("member_email", id+"@naver.com");

			res = biz.insertUser(map);

			if (res > 0) {

				System.out.println("濡쒓렇�씤�븯�윭 媛묐땲�떎!");
				String loginId = id;
				idChk = false;

				MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
				Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
						dto.getAuthorities());

				SecurityContext securityContext = SecurityContextHolder.getContext();
				securityContext.setAuthentication(authentication);
				HttpSession session = request.getSession(true);
				session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
			}

		} else { // �븘�씠�뵒媛� �엳�쑝硫� 濡쒓렇�씤
			System.out.println("濡쒓렇�씤�븯�윭 媛묐땲�떎!");
			String loginId = id;
			idChk = false;

			MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
			Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
					dto.getAuthorities());

			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);
			session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
			
		}

		return "redirect:/";

	}

	@RequestMapping(value = "facebook.do")
	public String facebook(HttpServletRequest request, @RequestParam String id) {

		return "";
	}

	@RequestMapping("test01")
	public String test012(@RequestParam String test) {

		// System.out.println("auth test 2 : " + auth);
		System.out.println(test);

		return "login";
	}

	@RequestMapping("test.do")
	public String testpage(Authentication auth) {

		// this.auth = auth;
		// Locale locale, Model model,
		logger.info("test.do �엯�옣~!");

		System.out.println("auth test 1 : " + auth);

		MemberDto dto = (MemberDto) auth.getPrincipal();
		String email = dto.getMemebr_email();

		System.out.println(email);

//		System.out.println("�쁾�쁾�쁾�쁾id�쁾�쁾�쁾="+id);
//		UserInfoDto dto = (UserInfoDto)	auth.getPrincipal();
		logger.info("welcome checkAuth! Authentication is{}.", auth);
//		logger.info("UserAuthenticationService == {}", dto);

//		model.addAttribute("auth", auth);
//		model.addAttribute("dto", dto);	

		System.out.println("�쁾�쁾�쁾�쁾�쁾�쁾�쁾�쁾" + auth.getName());
		System.out.println("" + auth.getAuthorities());

		return "test01";
	}

}
