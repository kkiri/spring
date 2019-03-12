package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping(value="/list")
	public String list() {
		return "/list";
	}
	@RequestMapping(value="/write")
	public String write() {
		return "/write";
	}
	@RequestMapping(value="/view")
	public String view() {
		return "/view";
	}
	
}
