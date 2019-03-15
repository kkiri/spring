package kr.co.sboard.service;

import kr.co.sboard.vo.MemberVO;
import kr.co.sboard.vo.TermsVO;

public interface MemberService {

	public MemberVO login(MemberVO vo);
	public TermsVO terms();
	public void register(MemberVO vo);
	
	
	
}