package kr.co.sboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;
import kr.co.sboard.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	
	@RequestMapping(value="/list")
	public String list(Model model, HttpSession sess, String pg) {
		
		MemberVO member = (MemberVO) sess.getAttribute("member");
		

		//Limit�� start���
		int start = service.getLimitStart(pg);
		
		// ��������ȣ ���
		int total = service.getTotalCount();
	    int pageEnd = service.getPageEnd(total);
		
	    // ī���͹�ȣ ���
	    int count = service.getPageCountStart(total, start);
	    
	    //������ �׷� ���
	    int[] groupStartEnd = service.getPageGroupStartEnd(pg, pageEnd);
	    
	    List<BoardVO> list = service.list(start);
	    
		model.addAttribute("member");
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("groupStartEnd", groupStartEnd);
//		model.addAttribute("page", list);
		
		
		
		
		return "/list";
	}
	
	@RequestMapping(value="/view")
	public String view(String seq, Model model) {
		BoardVO vo = service.view(seq);
		model.addAttribute("view", vo);
		
		FileVO file = service.fileView(seq);
		model.addAttribute("filewView",file);
		return "/view";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVO vo, HttpServletRequest req, HttpSession sess) {
		
		
		MemberVO member = (MemberVO) sess.getAttribute("member");
		
		vo.setCate("notice");
		vo.setRegip(req.getRemoteAddr());
		vo.setUid(member.getUid());
		
		MultipartFile file = vo.getFname();
		FileVO fvo = service.fileUpload(req, file);
		
//		vo.setFile();
		
		int parent = service.write(vo);
		
		// ���Ͼ��ε� ���� ���̺� ����
		fvo.setParent(parent);
		service.fileWrite(fvo);
		
		return "redirect:/list";
	}
	
}
