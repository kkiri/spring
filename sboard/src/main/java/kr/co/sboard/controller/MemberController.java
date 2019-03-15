package kr.co.sboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sboard.service.MemberService;
import kr.co.sboard.vo.MemberVO;
import kr.co.sboard.vo.TermsVO;

@Controller
public class MemberController {

	@Inject
	private MemberService service;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(HttpSession sess, MemberVO vo) {
		
		MemberVO member = service.login(vo);
		
		
		if(member != null) {
			//세션지정
			sess.setAttribute("member", member);
		
			return "redirect:/list";	
		}else {
			return "redirect:/member/login?result=fail";
		}
	}
	@RequestMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/member/idCheck")
	@ResponseBody
	public Map<String, Integer> idCheck(){
	
		//서비스 요청
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", 0);
		map.put("uid", 1234);
		map.put("pass", 1234);
		map.put("hp", 01012341234);
		
		return map;
		
	}
	
	
	@RequestMapping(value="/member/register", method=RequestMethod.GET)
	public String register() {
		return "/member/register";
	}
	
	@RequestMapping(value="/member/register", method=RequestMethod.POST)
	public String register(MemberVO vo, HttpServletRequest req) {
		
		vo.setRegip(req.getRemoteAddr());
		
		service.register(vo);
		return "/member/register";
	}
	
	
	@RequestMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVO vo = service.terms();
		
		model.addAttribute(vo);
		
		return "/member/terms";
	}
	
}
