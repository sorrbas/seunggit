 package com.traveler.web.user.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.traveler.web.user.mapper.UserMapper;
import com.traveler.web.user.model.UserVO;
import com.traveler.web.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userserivce;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// 회원가입페이지 이동
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public void signUpGET() {
		logger.info("회원가입 페이지 이동");
	}
	
	// 로그인페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("로그인 페이지 이동");
	}
	
	// 회원가입
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpPOST(UserVO vo)throws Exception{
		logger.info("signUp");
		
		// 회원가입 서비스 실행
		userserivce.insertUser(vo);
		
		logger.info("signUp service 성공");
		return "redirect:/";
	}
	
	// 아이디 중복 검사
	@RequestMapping(value = "/userIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public String userIdCheckPOST(String id)throws Exception{
		logger.info("userIdCheck() 진입");
		
		int result = userserivce.idCheck(id);
		
		logger.info("결과값 = " + result);
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, UserVO vo, RedirectAttributes rttr)throws Exception {
		System.out.println("login 메서드 진입");
		System.out.println("전달된 데이터: " + vo);
		
		HttpSession session = request.getSession();		
		UserVO lvo = userserivce.userLogin(vo);
		System.out.println("sessiion = " + session);
		System.out.println("lvo = " + lvo);
		if(lvo == null) {
			int result = 0;
//			rttr.addAttribute("result", result);
			rttr.addFlashAttribute("result", result);
			session.setAttribute("login", "false");
			return "redirect:/";
		}
		session.setAttribute("id", lvo.getId());
		session.setAttribute("login", "true");
		return "redirect:/main";
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request)throws Exception {
		System.out.println("logout 메서드 진입");

		logger.info("logoutGET 로그아웃");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "redirect:/";
	}
	
//	//로그인 2
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpServletRequest request, HttpSession session, UserVO vo)throws Exception {
//		vo.setId(request.getParameter("id"));
//		vo.setPassword(request.getParameter("password"));
//		
//		if(userserivce.userLogin(session, vo) == 1) {
//			session.setAttribute("id", request.getParameter("id"));
//		}
//	}
	
	// 이메일 인증
	@RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String emailCheckGET(String email)throws Exception{
//		logger.info("이메일 데이터 전송 확인");
//		logger.info("인증 번호 : " + email);
		System.out.println("이메일 데이터 전송 확인");
		System.out.println("인증번호 메일 : " + email);
		
		// 인증 번호 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
//		logger.info("인증번호" + checkNum);
		System.out.println("인증번호 " + checkNum);
//		
//		// 이메일 보내기
		String setForm = "kksskk1234@naver.com";
		String toMail = email;
		String title = "회원가입 인증 메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." +
						"<br><br>" +
						"인증 번호는 " + checkNum + "입니다." +
						"<br>" +
						"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setForm);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		String num = Integer.toString(checkNum);
		return num;
				
	}
	// 회원정보 보기
	@RequestMapping(value = "/userInfo.do", method = RequestMethod.GET)
	public String readUserGET(HttpSession session, Model model)throws Exception {
		String id = (String) session.getAttribute("id");
		
		UserVO vo = userserivce.readUser(id);
		System.out.println("id = " +id);
		model.addAttribute("VO", vo);
		logger.info("C:회원정보보기 GET으 VO" + vo);
		System.out.println("C: 회원정보보기 GET의 아이디 " + vo);
		return "user/userInfo";
	}
	// 회원정보 수정
	@RequestMapping(value = "/user/userUpdateForm", method = RequestMethod.GET)
	public String updateGET(HttpSession session, Model model)throws Exception {
		model.addAttribute("VO", userserivce.readUser((String)session.getAttribute("id")));
		System.out.println("업데이트 폼간다");
		
		return "user/userUpdateForm";
	}
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updatePOST(UserVO vo)throws Exception {
		logger.info("C: 회원정보 입력페이지 POST");
		System.out.println("바꿔준다");
		userserivce.updateUser(vo);
		return "redirect:/main";
	}
	// 회원정보 삭제
	@RequestMapping(value = "/user/userDeleteForm", method = RequestMethod.GET)
	public String deleteGET()throws Exception {
		System.out.println("딜리트폼 간다");
		return "user/userDeleteForm";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deletePOST(UserVO vo, HttpSession session, RedirectAttributes rttr)throws Exception {
		System.out.println("C: 회원정보 삭제 GET");
//		String id = (String) session.getAttribute("id");
		System.out.println(vo);
		UserVO user = (UserVO)session.getAttribute("vo");
		String sessionPass = user.getPassword();
		String voPass = vo.getPassword();
		if(!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/user/userDeleteForm";
		}
		userserivce.deleteUser(vo);
		session.invalidate();
		return "redirect:/";
//		userserivce.deleteUser(vo);
//		if(vo == null) {
//			System.out.println("헤헤");
//			return "user/userDeleteForm";
//		}
//		System.out.println("하하하");
//		return "redirect:/";
	}
//	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
//	public String deletePOST(UserVO vo, HttpSession session)throws Exception {
//		System.out.println("C: 회원정보 삭제 POST");
//		System.out.println("C: deleteForm전달정보" + vo);
//		userserivce.deleteUser(vo);
//		session.invalidate();
//		return "redirect:/";
//	}
	// 마이페이지
	@RequestMapping(value = "/MyTravel.do", method = RequestMethod.GET)
	public String MyTravelGET(HttpServletRequest request)throws Exception {
		
		logger.info("MyTravelGET 마이트래벌");
		
		HttpSession session = request.getSession();
		
//		session.invalidate();
		return "/MyTravel";
	}
//	@RequestMapping(value = "/userInfo.do", method = RequestMethod.GET)
//	public String userInfoGET(HttpServletRequest request)throws Exception {
//		
//		logger.info("userInfoGET 마이트래벌");
//		
//		HttpSession session = request.getSession();
//		
////		session.invalidate();
//		return "/user/userInfo";
//}
	
	// 아이디 찾기
//	@RequestMapping(value = "/searchid_form", method = RequestMethod.POST)
//	public String searchidPOST(UserVO vo, Model model)throws Exception {
//		UserVO lvo = userserivce.searchid(vo);
//		
//		if(lvo == null) {
//			model.addAttribute("check", 1);
//		} else {
//			model.addAttribute("check", 0);
//			model.addAttribute("id", lvo.getId());
//		}
//		return "redirect:/";
//	}
//	@RequestMapping(value = "/searchpw_form", method = RequestMethod.POST)
//	public String searchpwPOST(UserVO vo, Model model)throws Exception {
//		UserVO lvo = userserivce.searchpw(vo);
//		
//		if(lvo == null) {
//			model.addAttribute("check", 1);
//		} else {
//			model.addAttribute("check", 0);
//			model.addAttribute("password", lvo.getPassword());
//		}
//		return "redirect:/";
//	}
	
	// 아이디 찾기 메일
	@RequestMapping(value = "/searchid_email", method = RequestMethod.POST)
	public UserVO searchidEmailPOST(String email, UserVO vo)throws Exception {
//		UserVO id = userserivce.readUser(id);
//		String emaill = vo.getEmail("email");
		UserVO lvo = userserivce.searchid(vo);
		String setForm = "kksskk1234@naver.com";
		String toMail = email;
		String title = "회원님의 아이디 입니다.";
		String content = "회원님의 아이디는 " + lvo.getId() + " 입니다";
		System.out.println("lvo = " + lvo.getId());
		System.out.println(email);		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setForm);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return lvo;
				
	}
	

	// 비밀번호 찾기 메일	
	@RequestMapping(value = "/searchpw_email", method = RequestMethod.POST)
	public UserVO searchpwEmailPOST(String email, UserVO vo)throws Exception {
		
		UserVO lvo = userserivce.searchpw(vo);
		String setForm = "kksskk1234@naver.com";
		String toMail = email;
		String title = "회원님의 비밀번호 입니다.";
		String content = "회원님의 비밀번호는 " + lvo.getPassword() + " 입니다";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setForm);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return lvo;
				
	}
}