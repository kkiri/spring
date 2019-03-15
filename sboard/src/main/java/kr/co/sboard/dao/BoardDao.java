package kr.co.sboard.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Repository
public class BoardDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public List<BoardVO> list(int start) {
		return mybatis.selectList("ns.mapper.sql_board.SELECT_LIST", start);
	}
	
	public int getTotalCount() {
		return mybatis.selectOne("ns.mapper.sql_board.SELECT_LIST_COUNT");
	}

	public int write(BoardVO vo) {
		mybatis.insert("ns.mapper.sql_board.INSERT_BOARD", vo);
		return vo.getSeq();
	}
	
	public void fileWrite(FileVO vo) {
		mybatis.insert("ns.mapper.sql_board.INSERT_FILE", vo);
	}
	
	public FileVO fileView(String seq) {
		
		return mybatis.selectOne("ns.mapper.sql_board.SELECT_FILEVIEW", seq);
	}
	
	public BoardVO view(String seq) {
		return mybatis.selectOne("ns.mapper.sql_board.SELECT_VIEW", seq);
	}

	public void modify() {
		
	}

	public void delete(String seq) {
		mybatis.delete("ns.mapper.sql_board.DELETE_BOARD", seq);
	}
	
}
