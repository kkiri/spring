package kr.co.sboard.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.MemberVO;
import kr.co.sboard.vo.TermsVO;

@Repository
public class MemberDao {
	
	@Inject
	private SqlSessionTemplate mybatis;

	public MemberVO login(MemberVO vo) {
		 return mybatis.selectOne("ns.mapper.sql_member.SELECT_MEMBER",vo);
	}

	public TermsVO terms() {		
		return mybatis.selectOne("ns.mapper.sql_member.SELECT_TERMS");
	}

	public void register(MemberVO vo) {
		mybatis.insert("ns.mapper.sql_member.INSERT_MEMBER", vo);
	}

	
}
