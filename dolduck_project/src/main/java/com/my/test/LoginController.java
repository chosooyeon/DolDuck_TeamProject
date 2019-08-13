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
	BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화

	@Inject
	private MemberBizImpl biz;

	private String randompassword;

	//로그인 페이지로 이동
	@RequestMapping(value = "login.do")
	public String loginform() {
		return "/member/login";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/member/login.do")
	public String login() {
		return "/member/login";
	}

	// 아이디 찾기 페이지로 이동
	@RequestMapping(value = "idfind.do")
	public String idfind() {
		return "/member/idfind";
	}

	// 비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "pwfind.do")
	public String pwfind() {
		return "/member/pwfind";
	}

	// 마이 페이지로 이동
	@RequestMapping(value = "mypage.do")
	public String mypage() {
		return "/member/mypage";
	}

	// 수정 페이지로 이동
	@RequestMapping(value = "modified.do")
	public String modified() {
		return "/member/modified";
	}
	
	@RequestMapping(value = "role_update.do", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String,Boolean> roleUpdate(String role){
		Boolean rolechk = false;
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		int res = 0;
		
		
		//biz.update
		
		return map;
		
		
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping("join.do")
	public String Join() {
		return "/member/Join";
	}

	// 회원가입 페이지로 이동
	@RequestMapping("register.do")
	public String userInsert(@RequestParam String user_id, @RequestParam String user_pw, @RequestParam String user_name,
			@RequestParam String user_email, @RequestParam String user_phone, @RequestParam String user_addr) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("member_id", user_id);
		System.out.println("회원 비밀번호" + user_pw);
		String encryptPassword = passwordEncoder.encode(user_pw);
		System.out.println("비밀번호 암호화" + encryptPassword);
		map.put("member_pw", encryptPassword);
		map.put("member_name", user_name);
		map.put("member_phone", user_phone);
		map.put("member_addr", user_addr);
		map.put("member_email", user_email);

		biz.insertUser(map);

		return "/member/login";
	}

	// 에러페이지로 이동
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
		logger.info("아이디 체크");

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

	@RequestMapping(value = "idSearch.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> idSearch(String name, String email) {
		System.out.println(name);
		boolean idSearch = false;

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (biz.idSearch(name, email) == null) {
			idSearch = true;
			map.put("idSearch", idSearch);
		} else {
			map.put("idSearch", idSearch);
		}
		return map;

	}
	
	@RequestMapping(value = "pwSearch.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> pwSearch(String id, String email) {
		System.out.println(id);
		boolean pwSearch = false;

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (biz.pwSearch(id, email) == null) {
			pwSearch = true;
			map.put("pwSearch", pwSearch);
		} else {
			map.put("pwSearch", pwSearch);
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
		helper.setSubject("[DOLDuck]회원가입");
		helper.setText("<a><b style='color:hotpink;'>인증번호 : " + randompassword + "<a>", true);

		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			logger.error("인증실패", ex);
		}

	}

	@ResponseBody
	@RequestMapping(value = "VerifyRecaptcha", method = RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
		VerifyRecaptcha.setSecretKey("6LfHerAUAAAAACUEUT2MZxaiydRTDktzKSogfRvS");
		String gRecaptchaResponse = request.getParameter("recaptcha");
		System.out.println(gRecaptchaResponse);
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

		System.out.println("sns로그인 ");

		if (biz.idCheck(id) == null) { 

			System.out.println("SNS로그인");
			idChk = true;

			int res = 0;

			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", id);
			System.out.println("아이디" + id);
			String encryptPassword = passwordEncoder.encode(id);
			System.out.println("비밀번호 암호화" + encryptPassword);
			map.put("member_pw", encryptPassword);
			map.put("member_name", name);
			map.put("member_phone", "핸드폰 번호를 입력해주세요");
			map.put("member_addr", "주소를 입력해주세요");
			map.put("member_email", id+"@naver.com");

			res = biz.insertUser(map);

			if (res > 0) {
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

		} else { // 아이디가 있으면 로그인
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

	@RequestMapping(value = "naver.do")
	public String naver(HttpSession session) {
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
		logger.info("test.do");

      System.out.println("auth test 1 : " + auth);

      MemberDto dto = (MemberDto) auth.getPrincipal();
      String email = dto.getMember_email();
		System.out.println(email);
		logger.info("welcome checkAuth! Authentication is{}.", auth);

		System.out.println("이름 가져오기" + auth.getName());
		System.out.println("" + auth.getAuthorities());

      return "test01";
   }

}