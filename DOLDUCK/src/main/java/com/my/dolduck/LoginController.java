package com.my.dolduck;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.dolduck.model.biz.MemberBizImpl;
import com.my.dolduck.model.dto.MemberDto;
import com.my.dolduck.model.dto.SelectDto;
import com.my.dolduck.service.UserAuthenticationService;
import com.my.dolduck.util.initalize;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

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
	
	//로그인 체크
	@RequestMapping("login-status.do")
	@ResponseBody
	public String loginStatus(Principal principal) {
		
		if(principal == null){
			return "false";
		}else {
			return "true";
		}
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "login.do")
	public String loginform() {
		return "member/member_login";
	}

	// 아이디 찾기 페이지로 이동
	@RequestMapping(value = "idfind.do")
	public String idfind() {
		return "member/member_idfind";
	}

	// 비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "pwfind.do")
	public String pwfind() {
		return "member/member_pwfind";
	}

	// 마이 페이지로 이동
	@RequestMapping(value = "mypage.do")
	public String mypage(Model model, Authentication auth) {
		MemberDto memberdto = (MemberDto) auth.getPrincipal();
		String member_id = memberdto.getUsername();

		System.err.println(member_id);
		SelectDto dto = biz.selectId(member_id);
		model.addAttribute("dto", dto);
		return "member/member_mypage";
	}

	// 수정 페이지로 이동
	@RequestMapping(value = "modified.do")
	public String modified(Model model, Authentication auth) {
		MemberDto memberdto = (MemberDto) auth.getPrincipal();
		String member_id = memberdto.getUsername();

		System.err.println(member_id);
		SelectDto dto = biz.selectId(member_id);
		model.addAttribute("dto", dto);

		return "member/member_modified";
	}

	// 회원 탈퇴
	@RequestMapping(value = "delete.do")
	public String delete() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;

		int res = biz.deleteMember(userDetails.getUsername());
		System.out.println(res);

		return "home";
	}

	/* @RequestMapping(value = "role_update.do", method = {RequestMethod.POST}) */
	@PostMapping("role_update.do")

	@ResponseBody
	public Map<String, Boolean> roleUpdate(String role) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		return map;

	}

	// 회원가입 페이지로 이동
	@RequestMapping("join.do")
	public String Join() {
		return "member/member_join";
	}

	// 업데이트 페이지로 이동
	@RequestMapping("modifiedfied.do")
	public String updateMember(@RequestParam String user_id, @RequestParam String user_pw,
			@RequestParam String user_email, @RequestParam String user_phone, @RequestParam String user_addr,
			MultipartHttpServletRequest mtfRequest) {
		System.out.println(user_id + user_pw + user_email + user_phone + user_addr);

		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String path = mtfRequest.getSession().getServletContext().getRealPath("resources/uploadImage");
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			String member_img_path = path + "/" + originFileName; // 경로
			System.out.println("경로 " + member_img_path);
			String member_img = originFileName; // 파일 이름

			System.out.println("1");
			Map<String, String> map = new HashMap<String, String>();
			String encryptPassword = passwordEncoder.encode(user_pw);
			map.put("member_pw", encryptPassword);
			map.put("member_phone", user_phone);
			map.put("member_addr", user_addr);
			map.put("member_email", user_email);
			map.put("member_id", user_id);
			map.put("member_img", member_img);

			System.out.println(member_img);
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			int res = 0;
			try {
				mf.transferTo(new File(member_img_path)); // 파일 집어넣는다
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			res = biz.updateMember(map);
			if (res > 0) {
				System.out.println("2");
				return "redirect:mypage.do";
			} else {
				System.out.println("3");
				return "modified.do";
			}
		}
		return "";

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

		return "member/member_login";
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
	public Map<String, Object> idSearch(String name, String email) {
		System.out.println(name);
		boolean idSearch = false;

		Map<String, Object> map = new HashMap<String, Object>();
		if (biz.idSearch(name, email) != null) {
			idSearch = true;
			map.put("idSearch", idSearch);
			map.put("id", biz.idSearch(name, email).getMember_id());
		} else {
			map.put("idSearch", idSearch);
		}
		System.err.println(idSearch);
		return map;

	}

	@RequestMapping(value = "pwSearch.do", method = RequestMethod.POST)
	@ResponseBody
	public void pwSearch(String id, String email) throws UnsupportedEncodingException, MessagingException {
		System.out.println(id);
		boolean pwSearch = false;

		if (biz.pwSearch(id, email) != null) {
			pwSearch = true;

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
			helper.setSubject("[DOLDuck]비밀번호 변경 메일입니다.");
			helper.setText("<a><b style='color:hotpink;'>비밀번호 : " + randompassword + "<a>", true);

			String pw = passwordEncoder.encode(randompassword);
			biz.changePw(pw, id);

			try {
				mailSender.send(msg);
			} catch (MailException ex) {
				logger.error("인증실패", ex);
			}
		} else {
			logger.error("pwSearch", pwSearch);
		}

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
			map.put("member_email", id + "@naver.com");

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

	@RequestMapping(value = "callback.do")
	public String naverlogin(HttpServletRequest request) throws Exception {
		return "member/callback";
	}

	@RequestMapping(value = "naver.do")
	public String naver(HttpServletRequest request, HttpSession session) throws Exception {

		boolean idChk = false;

		String _token = (String) session.getAttribute("access_token");
		String header = "Bearer " + _token; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				System.err.println("정상");
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				System.err.println("비정상");
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());

			JSONParser parser = new JSONParser();

			JSONObject result = (JSONObject) parser.parse(response.toString());

			String id = (String) ((JSONObject) result.get("response")).get("id");
			String name = (String) ((JSONObject) result.get("response")).get("name");

			if (biz.idCheck(id) == null) {
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
				map.put("member_email", id + "@naver.com");

				res = biz.insertUser(map);
				if (res > 0) {
					String loginId = id;
					idChk = false;
					System.err.println("등록~");
					MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
					Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
							dto.getAuthorities());

					SecurityContext securityContext = SecurityContextHolder.getContext();
					securityContext.setAuthentication(authentication);
					session = request.getSession(true);
					session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
				}
			} else { // 아이디가 있으면 로그인
				System.err.println("로그인~");
				String loginId = id;
				idChk = false;
				MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
				Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
						dto.getAuthorities());

				SecurityContext securityContext = SecurityContextHolder.getContext();
				securityContext.setAuthentication(authentication);
				session = request.getSession(true);
				session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/";
	}

	// 트위터 로그인
	@RequestMapping(value = "twitter.do")
	public String twitter() {
		return "twitter/twitter_login";
	}

	// 트위터 로그인
	@RequestMapping("twitterlogin.do")
	public String Twitter(HttpServletRequest request, HttpSession session) throws Throwable {
		boolean idChk = false;
		int res = 0;

		String consumerKey = "4jV9n4q6icf312qrcJITlxDBw";
		String consumerSecret = "7fiKbUjQI11sJlV8LvVfMqGM16qnoMhDzZp9UYBJhmFS9O1GEr";
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret); // 저장된 consumerKey, consumerSecret
		AccessToken accessToken = null;

		accessToken = (AccessToken) request.getSession().getAttribute("accessToken");
		System.out.println(accessToken);

		if (accessToken == null) {
			String oauth_verifier = request.getParameter("oauth_verifier");
			System.out.println("oauth_verifier: " + oauth_verifier);

			RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
			System.out.println("requestToken: " + requestToken);
			if (requestToken != null) {
				accessToken = twitter.getOAuthAccessToken(requestToken, oauth_verifier);
				twitter.setOAuthAccessToken(accessToken);
				request.getSession().setAttribute("accessToken", accessToken);
			} else {
				System.out.println("requestToken값이 없습니다.");
			}
		}

		if (accessToken != null) {
			twitter.setOAuthAccessToken(accessToken);
			System.out.println(accessToken);
			System.out.println(accessToken.getUserId()); // 트위터의 사용자 아이디
			System.out.println(accessToken.getScreenName()); // 트워터에 표시되는 사용자명

			String id = accessToken.getUserId() + "";

			if (biz.idCheck(id) == null) {
				String loginId = id;
				idChk = true;

				Map<String, String> map = new HashMap<String, String>();
				map.put("member_id", id);
				System.out.println("아이디" + id);
				String encryptPassword = passwordEncoder.encode(id);
				System.out.println("비밀번호 암호화" + encryptPassword);

				map.put("member_pw", encryptPassword);
				map.put("member_name", id);
				map.put("member_phone", "핸드폰 번호를 입력해주세요");
				map.put("member_addr", "주소를 입력해주세요");
				map.put("member_email", id + "@naver.com");

				res = biz.insertUser(map);

				if (res > 0) {
					System.err.println("등록~");
					MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
					Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
							dto.getAuthorities());

					SecurityContext securityContext = SecurityContextHolder.getContext();
					securityContext.setAuthentication(authentication);
					session = request.getSession(true);
					session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

				}
			} else { // 아이디가 있으면 로그인
				System.err.println("로그인~");
				String loginId = id;
				idChk = false;
				MemberDto dto = (MemberDto) user.loadUserByUsername(loginId);
				Authentication authentication = new UsernamePasswordAuthenticationToken(dto, dto.getPassword(),
						dto.getAuthorities());

				SecurityContext securityContext = SecurityContextHolder.getContext();
				securityContext.setAuthentication(authentication);
				session = request.getSession(true);
				session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
			}
			// twitter.updateStatus("테스트 트위 등록 합니다.");
//			 List<Status> statuses = twitter.getHomeTimeline();
//			 System.out.println("Showing home timeline.");
//			 for (Status status : statuses) {
//			   System.out.println(status.getUser().getName() + ":" + status.getText());
//			 }
		} else {
			System.out.println("accessToken 값이 없습니다.");
		}
		return "redirect:/";

	}

	// 트위터 크롤링링
	@RequestMapping("twits.do")
		public String twits() {
			return "twitter/twits";
		}

	// 트위터 크롤링
	@RequestMapping("twitsCrawling.do")
	public void twitsCrawling() throws IOException, TwitterException {
		Twitter twitter = new initalize().twitter;

		// 강다니엘 검색해서 가져오기
		Query query = new Query("강다니엘");
		QueryResult result = null;

		result = twitter.search(query);
		for (Status status : result.getTweets()) {
			System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText() + "|||"
					+ status.getRetweetCount() + "\r\n");
		}

		// 트윗 가져오기
		List<Status> statuses;

		Paging page = new Paging();
		page.count(20);
		page.setPage(1);

		try {
			statuses = twitter.getHomeTimeline(page);
		} catch (TwitterException e) {
		}

		for (Status status : result.getTweets()) {
			status.getId();
			status.getUser().getName();
			status.getUser().getScreenName();
			status.getUser().getURL();
			status.getText();
			status.getCreatedAt();
			status.getUser().getProfileImageURL();
			status.getSource();
		}

		// 트윗 작성하기
		// twitter.updateStatus(텍스트, 리플라이할 트윗의 id);
		Status status = null;
		try {
			status = twitter.updateStatus("입력한 텍스트");
		} catch (TwitterException e) {
		}
	}

}
