package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public abstract Long register(BoardVO board);
	
	public abstract BoardVO get(Long bno);
	
	public abstract int modify(BoardVO board);
	
	public abstract int remove(Long bno);
	
	public abstract List<BoardVO> getList();
	
	public abstract List<BoardVO> getList(Criteria cri);
	
	public abstract int getTotal(Criteria cri);
}
