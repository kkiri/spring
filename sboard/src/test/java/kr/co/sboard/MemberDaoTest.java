package kr.co.sboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.MemberDao;
import kr.co.sboard.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-test-context.xml"})
public class MemberDaoTest {

	@Inject
	private MemberDao dao;
	
	
	public void loginTest() {
		MemberVO vo = new MemberVO();
		vo.setUid("abcd");
		vo.setPass("1234");
		
		MemberVO user = dao.login(vo);		
		System.out.println("테스트 결과 : "+user);
	}
	
	@Test
	public void registerTest() {		
		MemberVO vo = new MemberVO();
		vo.setUid("a123a");
		vo.setPass("1234");
		vo.setName("유관순");
		vo.setNick("유관순");
		vo.setEmail("you@naver.com");
		vo.setHp("010-2123-1093");
		vo.setRegip("0.0.0.0");
		
		dao.register(vo);
		
		System.out.println("register 테스트 완료!!!");
	}
	
}