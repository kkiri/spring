package kr.co.sboard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sboard.service.MemberService;
import kr.co.sboard.vo.MemberVO;
import kr.co.sboard.vo.TermsVO;

@Controller
public class MemberController {

	@Inject
	private MemberService service;
	
	@RequestMapping("/member/login")
	public String login() {
		return "/member/login";
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
