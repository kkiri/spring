package kr.co.sboard.service;

import kr.co.sboard.vo.MemberVO;
import kr.co.sboard.vo.TermsVO;

public interface MemberService {

	public void login();
	public TermsVO terms();
	public void register(MemberVO vo);
	
	
	
}