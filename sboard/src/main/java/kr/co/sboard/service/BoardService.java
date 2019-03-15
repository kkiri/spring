package kr.co.sboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

public interface BoardService {
	
	public List<BoardVO> list(int start);
	public int getTotalCount();
	public int getPageEnd(int total);
	public int getLimitStart(String pg);
	public int getPageCountStart(int total, int limit);
	public int[] getPageGroupStartEnd(String pg, int pageEnd);
	
	public int write(BoardVO vo);
	public void fileWrite(FileVO vo);
	public FileVO fileView(String seq);
	public FileVO fileUpload(HttpServletRequest req, MultipartFile file);
	
	public BoardVO view(String seq);
	public void modify();
	public void delete(String seq);
	
	
}
